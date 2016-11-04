import java.util.*;

public class query1Parameters extends queryParameters{

	boolean searchBy;
	List<String> tags = new ArrayList<String>();
	int startYear;
	int endYear;
	
	public boolean isSearchBy() {
		return searchBy;
	}
	
	public void setSearchBy(boolean searchBy) {
		this.searchBy = searchBy;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public int getStartYear() {
		return startYear;
	}
	
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	
	public int getEndYear() {
		return endYear;
	}
	
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
	
}
