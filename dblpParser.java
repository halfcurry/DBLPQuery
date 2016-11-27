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
	
	//purpose of making dblpParser a singleton is so that we parse only once at the beginning 
	private static dblpParser uniqueInstance;
	
	private dblpParser(){
		try{
			File inputFile = new File("dblp_medium.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			dblpQueryHandler qHandler = new dblpQueryHandler();
			saxParser.parse(inputFile, qHandler);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static dblpParser getSingletonDblpParser(){
		if( uniqueInstance == null ){
			uniqueInstance = new dblpParser();
		}
		return uniqueInstance;	
	}
}