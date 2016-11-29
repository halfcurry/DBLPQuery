import java.util.*;

public class query1 extends query {

	List<query1ResultRow> query1ResultRowList;
	query1Parameters q1Params;
	boolean sortParameters;
	
	public List<query1ResultRow> getQuery1ResultRowList() {
		return query1ResultRowList;
	}

	public void setQuery1ResultRowList(List<query1ResultRow> query1ResultRowList) {
		this.query1ResultRowList = query1ResultRowList;
	}
	
	private static String join( List<String> s ){
		String ret = "";
		int i;
		for( i = 0; i < s.size() - 1; i++ ){
			ret = ret + s.get(i) + " ";
		}
		return ret + s.get(i);
	}

	@Override
	public void execute( queryParameters q1Par ) {
		// TODO Auto-generated method stub
		Map <String, String> StopWords = new HashMap<String,String>();
		StopWords.put("a", " " );
		StopWords.put("an", " " );
		StopWords.put("the", " " );
		StopWords.put("to", " " );
		StopWords.put("on", " " );
		StopWords.put("of", " " );
		StopWords.put("the", " " );
		StopWords.put("in", " " );
		StopWords.put("and", " " );
		StopWords.put("for", " " );
		StopWords.put("at", " " );
		
		q1Params = (query1Parameters)q1Par;
		Map<String, Integer> relevantKeysResult = new HashMap<String, Integer>();
		Iterator it = Publication.iterator();
		Integer counter;
		String searchname = null;
		if( q1Params.isSearchByName()){ //is search by name
			if( q1Params.getTags() != null ){
				searchname = query1.join(q1Params.getTags());
				}
		}
		while( it.hasNext()){
			Publication pub = (Publication)it.next();
			counter = 0;
			boolean stringmatched = false;
			boolean yearmatched = false;
			if( q1Params.isSearchByName()){ //is search by name
				if( q1Params.getTags() != null && searchname != null ){
					List<String> authors = pub.getAuthors();
					for( String author: authors ){
						if( author.equals(searchname) ){
							stringmatched = true;
							counter = q1Params.getTags().size();
						}
						else if( Person.altnamesmatch.get(author) != null ){
							if( searchname.equals(Person.altnamesmatch.get(author))){
								stringmatched = true;
								counter = q1Params.getTags().size();
							}
						}
					}	
				}
				else stringmatched = true;
			}
			else{  //search by title tags
				//System.out.println(key);
				if( q1Params.getTags() != null ){
					for( String tag: q1Params.getTags()){
						if( pub.getTitle().toLowerCase().indexOf(tag.toLowerCase()) >= 0 && StopWords.get(tag) == null ){
							stringmatched = true;
							counter++;
						}
					}
				}
				else stringmatched = true; //i.e no title tags or author tags have been entered
			}
			if( q1Params.getStartYear() != null && q1Params.getEndYear() != null ){
				String year = pub.getYear();
				//System.out.println(year);
				try {
					Integer yearint = Integer.parseInt(year);
					if( yearint>= q1Params.getStartYear() && yearint <= q1Params.getEndYear()){
						yearmatched = true;
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					//System.out.println("ERROX" + e.getMessage());
				}
			}
			else yearmatched = true; //i.e no years have been entered
			if( stringmatched && yearmatched ){
				relevantKeysResult.put( pub.getKey(), counter);
				//System.out.println(key);
			}
		}
		query1ResultRowList = new ArrayList<query1ResultRow>();
		Iterator iter = relevantKeysResult.keySet().iterator();
		while( iter.hasNext() ){
			String key = (String)iter.next();
			System.out.println(key);
			query1ResultRow q1 = new query1ResultRow();
			Publication publ = Publication.publMap.get(key);
			q1.setTitle(publ.getTitle());
			q1.setYear(publ.getYear());
			q1.setAuthors(publ.getAuthors());
			q1.setPages(publ.getPages());
			q1.setJournalTitle(publ.getJournalTitle());
			q1.setUrl(publ.getUrl());
			q1.setVolume(publ.getVolume());
			q1.setRelevance(relevantKeysResult.get(key));
			query1ResultRowList.add(q1);
		}
	}

	public void sortResultsByDate() {
		// TODO Auto-generated method stub
		SortByDate byDate = new SortByDate();
		Collections.sort( query1ResultRowList, byDate );
		System.out.println();
//		System.out.println("Hello " + query1ResultRowList.size() );
//		for( query1ResultRow q1: query1ResultRowList ){
//			System.out.println( q1.getRelevance() + " " + q1.getTitle() + " " + q1.getYear()
//			+ " " + q1.getAuthors() + " " + q1.getJournalTitle() + " " + q1.getPages() + " " 
//			+ q1.getVolume() + " " + q1.getUrl());	
//		}
		System.out.println("Number of results: " + query1ResultRowList.size() );
	}
	
	public void sortResultsByRelevance() {
		// TODO Auto-generated method stub
		SortByRelevance byRelevance = new SortByRelevance();
		Collections.sort( query1ResultRowList, byRelevance );
		System.out.println();
		int x = 0;
//		for( query1ResultRow q1: query1ResultRowList ){
//			x++;
//			if( x < 100 ){
//				System.out.println( q1.getRelevance() + " " + q1.getTitle() + " " + q1.getYear()
//				+ " " + q1.getAuthors() + " " + q1.getJournalTitle() + " " + q1.getPages() + " " 
//				+ q1.getVolume() + " " + q1.getUrl());
//			}	
//		}
		System.out.println("Number of Results " + query1ResultRowList.size() );
	}
	
}
