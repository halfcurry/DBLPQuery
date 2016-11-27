
import java.util.*;

public class Publication {
	public static Map<String, Publication> publMap = new HashMap<String, Publication>();
	private static int maxNumberOfAuthors = 0;
	//private String key;

	//List<String> authors = new ArrayList<String>();
	//String title;
	String pages;
	String year;
	String volume;
	String journalTitle;
	String url;

	public Publication(String key, List<String> authors, String title, String pages, String year, String volume, String journalTitle, String url ) {
		//this.authors = authors;
		this.journalTitle = journalTitle;
		this.pages = pages;
		this.volume = volume;
		this.year = year;
		this.url = url;
		String temp = title + "/" + year + "/";
		for( String author: authors ){
			temp = temp + author + "/";
		}
		//this.title = title;
		publMap.put( temp, this);
		if (authors.size() > maxNumberOfAuthors)
			maxNumberOfAuthors = authors.size();
	}

	public static int getNumberOfPublications() {
		return publMap.size();
	}

	public static int getMaxNumberOfAuthors() {
		return maxNumberOfAuthors;
	}

//	public List<String> getAuthors() {
//		return authors;
//	}
//
//	public void setAuthors(List<String> authors) {
//		this.authors = authors;
//	}

//	public String getTitle() {
//		return title;
//	}

//	public void setTitle(String title) {
//		this.title = title;
//	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getJournalTitle() {
		return journalTitle;
	}

	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	static public Iterator iterator() {
		return publMap.keySet().iterator();
	}

}

