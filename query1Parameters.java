import java.util.*;

public class query1Parameters extends queryParameters{

	boolean searchByName;
	List<String> tags = new ArrayList<String>(); //tags are the parts of the name if searchByName is true, else they are the title tags to be searched for
	int startYear;
	int endYear;
	
	/**
	 * @param searchByName
	 * @param tags
	 * @param startYear
	 * @param endYear
	 */
	public query1Parameters(boolean searchByName, List<String> tags, int startYear, int endYear) {
		super();
		this.searchByName = searchByName;
		this.tags = tags;
		this.startYear = startYear;
		this.endYear = endYear;
	}

	public boolean isSearchByName() {
		return searchByName;
	}
	
	public void setSearchByName(boolean searchByName) {
		this.searchByName = searchByName;
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
