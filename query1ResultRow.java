import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class query1ResultRow extends queryResultRow {

	List<String> authors = new ArrayList<String>();
	String title;
	String pages;
	int year;
	int volume;
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


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
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

}
