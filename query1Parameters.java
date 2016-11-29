import java.util.*;

/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */

public class query1Parameters extends queryParameters{
	
	/**
	 * a model class for user entered details in query1
	 */

	boolean searchByName;
	List<String> tags; //tags are the parts of the name if searchByName is true, else they are the title tags to be searched for
	Integer startYear;
	Integer endYear;
	
	/**
	 * @param searchByName
	 * @param tags
	 * @param startYear
	 * @param endYear
	 */
	public query1Parameters(boolean searchByName, String tagstring, Integer startYear, Integer endYear) {
		super();
		this.searchByName = searchByName;
		tags = new ArrayList<String>();
		String[] temp = tagstring.split(" ");
		for( int i = 0; i < temp.length; i++ )tags.add(temp[i]);
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
