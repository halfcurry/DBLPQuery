import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class query2 extends query{

	List<query2ResultRow> query2ResultRowList;
	query2Parameters q2Params;
	
	public List<query2ResultRow> getQuery2ResultRowList() {
		return query2ResultRowList;
	}

	public void setQuery2ResultRowList(List<query2ResultRow> query2ResultRowList) {
		this.query2ResultRowList = query2ResultRowList;
	}

	@Override
	public void execute( queryParameters q2Par ) {
		// TODO Auto-generated method stub
		q2Params = (query2Parameters)q2Par;
		List<String> relevantKeysResult = new ArrayList<String>();
		Iterator it = Person.iterator();
		while( it.hasNext()){
			String key = (String)it.next();
			Person p = Person.personMap.get(key);
			if( p.getCount() >= q2Params.getNumPublications() && p.getName().length() > 4 ){
				System.out.println(key + " " + p.getCount());
				relevantKeysResult.add(key);
			}
			//System.out.println(key);
		}
		System.out.println("Number of results: " + relevantKeysResult.size());
//		query2ResultRowList = new ArrayList<query2ResultRow>();
//		for( String key : relevantKeysResult ){
//			//System.out.println(key);
//			query2ResultRow q2 = new query2ResultRow();
//			
//			query2ResultRowList.add(q2);
//		}
		
	}

	@Override
	public void sortResults() {
		// TODO Auto-generated method stub
		
	}

}
