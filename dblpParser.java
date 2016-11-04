import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class dblpParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//System.out.println( "Hello!");
			File inputFile = new File("dblpsmall.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			query1Handler m = new query1Handler();
			saxParser.parse(inputFile, m);     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	public void parse( query Q )
	{
		try {
			//System.out.println( "Hello!");
			File inputFile = new File("dblpsmall.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			if( Q instanceof query1 )
			{
				query1Handler q1 = new query1Handler();
				saxParser.parse(inputFile, q1 );    
			}
			else if ( Q instanceof query2 )
			{
				query2Handler q2 = new query2Handler();
				saxParser.parse(inputFile, q2 );    
			}
			 
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}
