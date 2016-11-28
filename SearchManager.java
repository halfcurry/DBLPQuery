import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SearchManager {

	public SearchManager() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("jdk.xml.entityExpansionLimit", "0");
			dblpParser d = dblpParser.getSingletonDblpParser();
			//System.out.println( "Hello!");
			query1Parameters q1p = new query1Parameters( true, "Some Security Principles and Their Application", 1970, 2010 );
			query1 q1 = new query1();
			q1.execute(q1p);
			//q1.sortResultsByDate();
			q1.sortResultsByRelevance();
//			query2Parameters q2p = new query2Parameters(400);
//			query2 q2 = new query2();
//			q2.execute(q2p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
