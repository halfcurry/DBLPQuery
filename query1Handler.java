import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class query1Handler extends DefaultHandler{
	String mdate;
	String key;
	List<query1ResultRow> query1ResultRowList= new ArrayList<query1ResultRow>();
	query1ResultRow q; 
	List<String> authors = new ArrayList<String>();
	
	boolean bAuthors;
	boolean bTitle;
	boolean bPages;
	boolean bYear;
	boolean bVolume;
	boolean bJournalTitle;
	boolean bUrl;

	   @Override
	   public void startElement(String uri, 
	      String localName, String qName, Attributes attributes) throws SAXException
	   {
	      if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings")
	    || qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book") || 
	      qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
	     || qName.equalsIgnoreCase("mastersthesis") || qName.equalsIgnoreCase("www")) {
	    	  
	         key = attributes.getValue("key");
	         mdate = attributes.getValue("mdate");
	        // System.out.println( "Key: " + key + "\n" + "Mdate: " + mdate );
	         
	         q = new query1ResultRow();
	         
	      } else if (qName.equalsIgnoreCase("author")) {
	    	  bAuthors = true;
	      } else if (qName.equalsIgnoreCase("title")) {
	    	  bTitle = true;
	      } else if (qName.equalsIgnoreCase("pages")) {
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
	   public void endElement(String uri, 
	      String localName, String qName) throws SAXException {
		    if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings")
		    || qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book") 
		    || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
		    || qName.equalsIgnoreCase("mastersthesis") || qName.equalsIgnoreCase("www")) {
	         System.out.println("");
	         q.setAuthors(authors);
	         query1ResultRowList.add( q );
	      }
	   }

	   @Override
	   public void characters(char ch[], 
	      int start, int length) throws SAXException {
		  if( bAuthors )
		  {
			  String author = new String( ch, start, length );
			  authors.add( author );
			  System.out.println( "Author: " + author );
			  bAuthors = false;
		  }
		  else if( bTitle )
		  {
			  String title = new String( ch, start, length );
			  System.out.println( "Title: " + title );
			  q.setTitle( title );
			  bTitle = false;
		  }
		  else if( bPages )
		  {
			  String pages = new String( ch, start, length );
			  System.out.println( "Pages: " + pages );
			  q.setPages(pages);
			  bPages = false;
		  }
		  else if( bYear )
		  {
			  String year = new String( ch, start, length );
			  System.out.println( "Year: " + year );
			  q.setYear(year);
			  bYear = false;
		  }
		  else if( bVolume )
		  {
			  String volume = new String( ch, start, length );
			  System.out.println( "Volume: " + volume );
			  q.setVolume(volume);
			  bVolume = false;
		  }
		  else if( bJournalTitle )
		  {
			  String journalTitle = new String( ch, start, length );
			  System.out.println( "Journal/Book Title : " + journalTitle );
			  q.setJournalTitle(journalTitle);
			  bJournalTitle = false;
		  }
		  else if( bUrl )
		  {
			  String url = new String( ch, start, length );
			  System.out.println( "Url: " + url );
			  q.setUrl(url);
			  bUrl = false;
		  }
	   }
	   
	   public void endDocument() throws SAXException {

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

