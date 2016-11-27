import java.util.List;

public abstract class query {

	boolean sortParameters;
	int queryType;
	
	public abstract void execute( queryParameters q );
	
	public abstract void sortResults();

}
