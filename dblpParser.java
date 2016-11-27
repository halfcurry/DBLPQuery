import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/*Note: go to Run -> Run Configurations -> Arguments -> VM Arguments and enter "-Xmx3000m"
( without the quotes ). Click Apply.*/

public class dblpParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("jdk.xml.entityExpansionLimit", "0");
			//System.out.println( "Hello!");
			File inputFile = new File("dblp.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			//query2Parameters q2params = new query2Parameters( 100 );
			//query2Handler m = new query2Handler( q2params );
			//PersonQueryHandler m = new PersonQueryHandler();
			dblpQueryHandler qHandler = new dblpQueryHandler();
			saxParser.parse(inputFile, qHandler);     
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Parse( query Q )
	{
		try {
			//System.out.println( "Hello!");
			File inputFile = new File("dblp.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			if( Q instanceof query1 )
			{
				//query1Handler q1 = new query1Handler();
				//saxParser.parse(inputFile, q1 );    
			}
			else if ( Q instanceof query2 )
			{
				//query2Handler q2 = new query2Handler();
				//saxParser.parse(inputFile, q2 );    
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}