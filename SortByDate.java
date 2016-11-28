
import java.util.*;

public class SortByDate implements Comparator<query1ResultRow>{

	@Override
	public int compare(query1ResultRow o1, query1ResultRow o2) {
		// TODO Auto-generated method stub
		if( o1.getYear().equals("null") || o2.getYear().equals("null"))
			return -1;
		Integer myYear = Integer.parseInt(o1.getYear());
		Integer otherYear = Integer.parseInt(o2.getYear());
		return otherYear - myYear;
	}

}
