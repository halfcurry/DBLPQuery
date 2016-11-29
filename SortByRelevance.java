
import java.util.*;
public class SortByRelevance implements Comparator<query1ResultRow>{

	@Override
	public int compare(query1ResultRow o1, query1ResultRow o2) {
		// TODO Auto-generated method stub
		return o2.getRelevance() - o1.getRelevance();
	}

}
