import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FirstParseHandler extends DefaultHandler{
	
	boolean bAltnames;
	List<String> altnames;
	boolean insidePerson = false;
	String key;
	
	@Override
	public void startDocument(){
		System.out.println("Started Parsing!");
	}

	@Override
	public void startElement(String uri, 
			String localName, String qName, Attributes attributes) throws SAXException
	{
		if ( qName.equalsIgnoreCase("www")) 
		{
			if (attributes.getLength()>0) {
				key = attributes.getValue("key");
				// System.out.println( "Key: " + key + "\n" + "Mdate: " + mdate );
				if( key.substring(0,9).equals("homepages")){ 
					//this is a person record
					insidePerson = true;
					//System.out.println("Inside a person record");
				}
				altnames = new ArrayList<String>();
			}	
		}
		else if (qName.equalsIgnoreCase("author")) {
			bAltnames = true;
		}
	}
		
		@Override
		public void characters(char ch[], 
				int start, int length) throws SAXException {
			if( bAltnames && insidePerson ){
				String author = new String( ch, start, length );
				altnames.add( author );
				//System.out.println( "Author: " + author );
				bAltnames = false;
			}
		}
		
		@Override
		public void endElement(String uri, 
				String localName, String qName) throws SAXException {
			if ( qName.equalsIgnoreCase("www")) {
				if( insidePerson ){
					if( altnames.size() > 0 ){
//						Person p = new Person( altnames.get(0));
						Person.personMap.put(altnames.get(0), 0);
						if( Person.personMap.size() % 10000 == 0 ){
							System.out.println( "Created new person " + Person.personMap.size());
						}
					}
					if( altnames.size() > 1 ){
						for( String name: altnames ){ 
							if( !name.equals(altnames.get(0))){
								Person.altnamesmatch.put( name, altnames.get(0));
							}
						}	
					}
					
				}
			}
		}
		
		@Override
		public void endDocument() throws SAXException {
			System.out.println("File ended!");
		}
}
