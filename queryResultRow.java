/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */
public abstract class queryResultRow {
	
	protected int queryType;

	public queryResultRow() {
		// TODO Auto-generated constructor stub
		queryType = 0;
	}

	public int getQueryType() {
		return queryType;
	}

	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

}
