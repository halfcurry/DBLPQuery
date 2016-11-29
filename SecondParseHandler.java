import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */
public class SecondParseHandler extends DefaultHandler{
	
	/**
	 * Handler for the second parse - stores publications in publication hashmap
	 * Resolves person entities: as an author is encountered, we see if it exists in the alternatenames map.
	 * if it does, then increment value of the value in the alternatenames map ( i.e mapped to one name in
	 * the personMap)
	 * if it exists in the personMap, simply increment its value in the personMap.
	 * else, create a new entry in the personMap
	 */

	//common tags which hold for both publication and person records
	String key; 
	boolean bUrl;
	boolean bAuthors;
	boolean bTitle;
	List<String> authors;  // can be a list of authors or a list of alternate names of a person
	String tempTitle;
	String tempUrl;
	int countPubl = 0;
	int countPerson = 0;

	//explicit publication requirements
	boolean bPages;
	boolean bYear;
	boolean bVolume;
	boolean bJournalTitle;
	String tempPages;
	String tempYear;
	String tempVolume;
	String tempJournalTitle;
	Publication publ; 

	//explicit person requirements
	Person p;
	boolean insidePerson = false;


	//parsing methods
	@Override
	public void startDocument(){
		System.out.println("Started Parsing!");
	}

	@Override
	public void startElement(String uri, 
			String localName, String qName, Attributes attributes) throws SAXException
	{
		if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings")
				|| qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book") || 
				qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
				|| qName.equalsIgnoreCase("mastersthesis")) 
		{
			if (attributes.getLength()>0) {
				key = attributes.getValue("key");
				// System.out.println( "Key: " + key + "\n" + "Mdate: " + mdate );
				authors = new ArrayList<String>();
			}
		}else if (qName.equalsIgnoreCase("author")) {
			bAuthors = true;
		}else if (qName.equalsIgnoreCase("title")) {
			bTitle = true;
		}else if (qName.equalsIgnoreCase("pages")) {
			bPages = true;
		}else if (qName.equalsIgnoreCase("year")) {
			bYear = true;
		}else if (qName.equalsIgnoreCase("volume")) {
			bVolume = true;
		}else if (qName.equalsIgnoreCase("journal") || qName.equalsIgnoreCase("booktitle")) {
			bJournalTitle = true;
		}else if (qName.equalsIgnoreCase("url")) {
			bUrl = true;
		}
	}

	@Override
	public void characters(char ch[], 
			int start, int length) throws SAXException {
		if( bAuthors ){
			String author = new String( ch, start, length );
			authors.add( author );
			//System.out.println( "Author: " + author );
			bAuthors = false;
		}
		else if( bTitle ){
			tempTitle = new String( ch, start, length );
			//System.out.println( "Title: " + title );
			bTitle = false;
		}
		else if( bPages && !insidePerson ){
			tempPages = new String( ch, start, length );
			//System.out.println( "Pages: " + pages );
			bPages = false;
		}
		else if( bYear && !insidePerson ){
			tempYear = new String( ch, start, length );
			//System.out.println( "Year: " + year );
			bYear = false;
		}
		else if( bVolume && !insidePerson ){
			tempVolume = new String( ch, start, length );
			//System.out.println( "Volume: " + volume );
			bVolume = false;
		}
		else if( bJournalTitle && !insidePerson ){
			tempJournalTitle = new String( ch, start, length );
			//System.out.println( "Journal/Book Title : " + journalTitle );
			bJournalTitle = false;
		}
		else if( bUrl ){
			tempUrl = new String( ch, start, length );
			//System.out.println( "Url: " + url );
			bUrl = false;
		}
	}
	@Override
	public void endElement(String uri, 
			String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings")
				|| qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book") 
				|| qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
				|| qName.equalsIgnoreCase("mastersthesis")) {
			for( String author: authors ){
				if( Person.altnamesmatch.containsKey(author)){
					Integer i = Person.personMap.get(Person.altnamesmatch.get(author));
					i++;
					Person.personMap.put(Person.altnamesmatch.get(author), i);
				}else if( Person.personMap.containsKey(author)){
					Integer i = Person.personMap.get(author);
					i++;
					Person.personMap.put(author, i);
				}else{
					Person.personMap.put(author, 0);
				}
			}
			publ = new Publication( key, authors, tempTitle, tempPages, tempYear, tempVolume, tempJournalTitle, tempUrl );
			if( Publication.publMap.size() % 10000 == 0 ){
				System.out.println( "Publications size: " + Publication.publMap.size() );
			}
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("File ended!");
		System.out.println("Number of Publications: " + Publication.publMap.size());
		System.out.println("Number of Person Records: " + Person.personMap.size());
	}

	public void Message(String mode, SAXParseException exception) {
		System.out.println(mode + " Line: " + exception.getLineNumber()
		+ " URI: " + exception.getSystemId() + "\n" + " Message: "
		+ exception.getMessage());
	}

	public void warning(SAXParseException exception) throws SAXException {

		Message("**Parsing Warning**\n", exception);
		throw new SAXException("Warning encountered");
	}

	public void error(SAXParseException exception) throws SAXException {

		Message("**Parsing Error**\n", exception);
		throw new SAXException("Error encountered");
	}

	public void fatalError(SAXParseException exception) throws SAXException {

		Message("**Parsing Fatal Error**\n", exception);
		throw new SAXException("Fatal Error encountered");
	}
}