import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class query1ResultRow extends queryResultRow implements Comparable<query1ResultRow> {

	List<String> authors = new ArrayList<String>();
	String title;
	String pages;
	String year;
	String volume;
	String journalTitle;
	String url;
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	@Override
	public int compareTo(query1ResultRow o) {
		// TODO Auto-generated method stub
		if( o.getYear().equals("null") || year.equals("null"))
			return -1;
		Integer myYear = Integer.parseInt(year);
		Integer otherYear = Integer.parseInt(o.getYear());
		return otherYear - myYear;
	}

}
