
import java.util.*;

/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */
public class SortByDate implements Comparator<query1ResultRow>{

	@Override
	public int compare(query1ResultRow o1, query1ResultRow o2) {
		// TODO Auto-generated method stub
		if( o1.getYear() == null || o2.getYear() == null )
			return -1;
		Integer myYear = Integer.parseInt(o1.getYear());
		Integer otherYear = Integer.parseInt(o2.getYear());
		return otherYear - myYear;
	}

}
