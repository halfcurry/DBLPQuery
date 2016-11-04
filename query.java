import java.util.List;

public abstract class query {

	boolean sortParameters;
	queryParameters q_p;
	int queryType;
	
	public abstract void execute();
	
	public abstract void sortResults();

}
