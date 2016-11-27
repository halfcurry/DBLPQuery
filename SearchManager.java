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
			query1Parameters q1p = new query1Parameters( false, null, 2000, 2016 );
			query q1 = new query1();
			q1.execute(q1p);
			q1.sortResults();
			     
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
