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
		Iterator it = Person.personMap.keySet().iterator();
		Integer givenCount = q2Params.getNumPublications();
		while( it.hasNext()){
			String key = (String)it.next();
			Integer count = Person.personMap.get(key);
			if( count >= givenCount && key.length() > 4 ){  
				//filter out useless authors with 4 or less lettered names
				//System.out.println(key + " " + count );
				relevantKeysResult.add(key);
			}
		}
		System.out.println("Number of results: " + relevantKeysResult.size());
		query2ResultRowList = new ArrayList<query2ResultRow>();
		for( String key : relevantKeysResult ){
			//System.out.println(key);
			query2ResultRow q2 = new query2ResultRow();
			query2ResultRowList.add(q2);
		}
	}
}
