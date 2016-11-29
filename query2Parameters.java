/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */
public class query2Parameters extends queryParameters{

	/**
	 * a model class for user entered details in query1
	 */
	int numPublications;
	/**
	 * @param numPublications
	 */
	public query2Parameters(int numPublications) {
		super();
		this.numPublications = numPublications;
	}

	public int getNumPublications() {
		return numPublications;
	}

	public void setNumPublications(int numPublications) {
		this.numPublications = numPublications;
	}
	
}
