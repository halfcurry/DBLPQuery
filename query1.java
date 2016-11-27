import java.util.*;

public class query1 extends query {

	List<query1ResultRow> query1ResultRowList;
	query1Parameters q1Params;

	public List<query1ResultRow> getQuery1ResultRowList() {
		return query1ResultRowList;
	}

	public void setQuery1ResultRowList(List<query1ResultRow> query1ResultRowList) {
		this.query1ResultRowList = query1ResultRowList;
	}

	@Override
	public void execute( queryParameters q1Par ) {
		// TODO Auto-generated method stub
		q1Params = (query1Parameters)q1Par;
		List<String> relevantKeysResult = new ArrayList<String>();
		Iterator it = Publication.iterator();
		while( it.hasNext()){
			boolean flag1 = false;
			boolean flag2 = false;
			String key = (String)it.next();
			//System.out.println(key);
			if( q1Params.getTags() != null ){ 
				if( key.toLowerCase().indexOf( q1Params.getTags().toLowerCase()) >= 0 ){
					flag1 = true;
				}
			}
			else flag1 = true; //i.e no title tags or author tags have been entered
			if( q1Params.getStartYear() != null && q1Params.getEndYear() != null ){
				String year = key.split("/")[1];
				if( !year.equalsIgnoreCase("null") && year.length() == 4 ){
					Integer yearint = Integer.parseInt(year);
					if( yearint>= q1Params.getStartYear() && yearint <= q1Params.getEndYear()){
						flag2 = true;
					}
				}
			}
			else flag2 = true; //i.e no years have been entered
			if( flag1 && flag2 ){
				//note here that if both years and title tags had not been entered, the gui would have disallowed it
				relevantKeysResult.add(key);
			}
		}
		query1ResultRowList = new ArrayList<query1ResultRow>();
		for( String key : relevantKeysResult ){
			System.out.println(key);
			query1ResultRow q1 = new query1ResultRow();
			String[] keyArr = key.split("/");
			q1.setTitle(keyArr[0]);
			q1.setYear(keyArr[1]);
			List<String> templist = new ArrayList<String>();
			for( int i = 2; i < keyArr.length; i++ ){
				templist.add(keyArr[i]);
			}
			q1.setAuthors( templist );
			Publication publ = Publication.publMap.get(key);
			q1.setPages(publ.getPages());
			q1.setJournalTitle(publ.getJournalTitle());
			q1.setUrl(publ.getUrl());
			q1.setVolume(publ.getVolume());
			query1ResultRowList.add(q1);
		}
	}

	@Override
	public void sortResults() {
		// TODO Auto-generated method stub
		Collections.sort( query1ResultRowList );
		for( query1ResultRow q1: query1ResultRowList ){
			System.out.println( q1.getTitle() + " " + q1.getYear() + " " + q1.getAuthors() + " " +
					q1.getJournalTitle() + " " + q1.getPages() + " " + q1.getVolume() + " " + 
					q1.getUrl());
		}
	}
	
}
