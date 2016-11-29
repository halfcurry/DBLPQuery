
import java.util.*;

public class Person {

	private static int maxPublCount = 0;
	private static int maxNameLength = 0;
	public static Map<String, Person> personMap = new HashMap<String, Person>();
	//private static Set tmpSet = new HashSet(500);

	public boolean temp_boolean = false;
	private String name;
	private Set nameParts;  //will help in Entity Resolution, basically is the parts of the name 
	private int count; //publication count
	private List<String> alternateNames = new ArrayList<String>();
	private int tmp;
	private Person[] coauthors;

	public Person(String n) {  //takes a name string as argument
		name = n;
		count = 0;
		personMap.put(name,this);
		if (maxNameLength < name.length())
			maxNameLength = name.length();
//		nameParts = new HashSet();
//		StringTokenizer st = new StringTokenizer(name," -");
//		while (st.hasMoreTokens()) {
//			nameParts.add(st.nextToken());
//		}
	}

	public void increment() { //increases the publication count of the person
		count++;
		if (count > maxPublCount)
			maxPublCount = count;
	}

	public String getName() {
		return name;
	}

	public Set getNameParts() {
		return nameParts;
	}

	public int getNumberOfCoauthors() {
		return (coauthors == null) ? 0 : coauthors.length;
	}

	public Person[] getCoauthors() {
		return coauthors;
	}

	public int getCount() {  //returns the number of publications of the person
		return count;
	}

	public List<String> getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(List<String> alternateNames) {
		this.alternateNames = alternateNames;
	}

	static public int getMaxPublCount() {
		return maxPublCount;
	}

	static public int getMaxNameLength() {
		return maxNameLength;
	}

	static public Iterator iterator() {
		return personMap.keySet().iterator();
	}

	static public Person searchPerson(String name) {
		return (Person) personMap.get(name);
	}

	static public int numberOfPersons() {
		return personMap.size();
	}

}
