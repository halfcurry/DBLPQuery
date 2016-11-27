import java.util.*;

public class query1Parameters extends queryParameters{

	boolean searchByName;
	String tags; //tags are the parts of the name if searchByName is true, else they are the title tags to be searched for
	Integer startYear;
	Integer endYear;
	
	/**
	 * @param searchByName
	 * @param tags
	 * @param startYear
	 * @param endYear
	 */
	public query1Parameters(boolean searchByName, String tags, Integer startYear, Integer endYear) {
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
	
	public String getTags() {
		return tags;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public Integer getStartYear() {
		return startYear;
	}
	
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	
	public Integer getEndYear() {
		return endYear;
	}
	
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}
	
	
}
