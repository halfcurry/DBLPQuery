import java.util.ArrayList;
import java.util.List;

public class Compare {

	static double HIGH_MATCH = 0.93; // if the firstname + middlename + lastname
										// average match exceeds this, it is an
										// identity

	static int LENGTH_GAP_ALLOWED = 2; // for example, Don vs Donne is treated
										// as same word, but not more gap

//	public static void main(String[] args) {
//
//		// get a numerical corelation (0 to 1), if the testWord matches with an
//		// array of words closely. Return the arrayIndex of any high match, else
//		// -1.
//
//		String testWord = "1234 5. 789";
//
//		List<String> testArray = new ArrayList<String>();
//
//		// FOR TESTING : use actual names instead of numbers
//
//		// testArray.add("1234 5. 789");//index = 0, same as testWord and should
//		// always match perfectly
//		testArray.add("123 45 789");
//		testArray.add("1234 56 789");
//		testArray.add("1234 6. 789");
//		testArray.add("1234 5. 6789");
//		testArray.add("1234 789");
//
//		System.out.println("Best Match at index = " + compare(testWord, testArray));
//
//	}

	public static int compare(String testWord, List<String> testArray) {

		// trim and remove duplicate spaces in both words
		testWord = testWord.trim().replaceAll("\\s+", " ");

		// the testWord is split by a single blank space
		String[] srcNameArr = testWord.split(" ");
		
		double match = 0.0;
		double avgmatch = 0.0;
		double maxavgmatch = 0.0;

		int bestIndex = -1;

		for (int i = 0; i < testArray.size(); i++) {
			String targetName = testArray.get(i);
			targetName = targetName.trim().replaceAll("\\s+", " ");

			match = 0.0;
			avgmatch = 0.0;
			for (int j = 0; j < srcNameArr.length; j++) {
				String srcName = srcNameArr[j];
				double currentMatch = getMatch(srcName, j, srcNameArr.length, targetName);
				match = match + currentMatch;
//				System.out.println(currentMatch + " match for src=" + srcName + " vs " + targetName + " for the " + j
//						+ "th target place");
			}
			avgmatch = match / (double) srcNameArr.length;

//			System.out.println(i + "th testWord avgmatch = " + avgmatch + "\n");

			if (avgmatch > maxavgmatch) {
				maxavgmatch = avgmatch;
				bestIndex = i;
			}
		}

		if (maxavgmatch > HIGH_MATCH) {
			return bestIndex;
		}

		return -1;
	}

	private static double getMatch(String srcName, int srcIndex, int srcLen, String targetName) {
		// compare what to what ? ignore what ?

		String[] targetNameArr = targetName.split(" ");

		// if targetName has a prefix just ignore it and recalculate
		if (isPrefix(targetNameArr[0])) {
			targetName = targetName.substring(0, targetNameArr[0].length() - 1);
			targetNameArr = targetName.split(" ");
		}

		int targetLen = targetNameArr.length;

		// if src is a prefix just ignore it
		if (isPrefix(srcName)) {
			return 1; // i.e. 100% match
		}

		// the obvious one
		if (srcLen == targetLen) {
				String actualTarget = targetNameArr[srcIndex];
				if (seemsSimilar(srcName, actualTarget)) {
					return getSimilarity(srcName, actualTarget);
				}
		}

		//else if unequal only compare extremities
		if (srcLen != targetLen) {
			if (srcIndex == 0) {
				String actualTarget = targetNameArr[0];
				if (seemsSimilar(srcName, actualTarget)) {
					return getSimilarity(srcName, actualTarget);
				}
			}
			if (srcIndex == srcLen - 1) {
				String actualTarget = targetNameArr[targetLen - 1];
				if (seemsSimilar(srcName, actualTarget)) {
					return getSimilarity(srcName, actualTarget);
				}
			}
		}

		// first name may be just an initial
		if (srcIndex == 0) {
			if (srcName.length() == 1 || srcName.endsWith(".")) {
				if (srcName.toLowerCase().charAt(0) == targetNameArr[0].toLowerCase().charAt(0)) {
					return 1; // i.e. 100% match
				}
			}
		}

		// middle name may be just an initial
		if (srcIndex == 1 && targetLen >= 2) {
			if (srcName.length() == 1 || (srcName.length() == 2 && srcName.endsWith("."))) {
				if (srcName.toLowerCase().charAt(0) == targetNameArr[1].toLowerCase().charAt(0)) {
					return 1; // i.e. 100% match
				}
			}
		}

		// src has middle name missed out, and target has a middle initial
		// assume it is a 100% match and ignore
		if (srcIndex == 1 && targetLen >= 2) {
			if (targetNameArr[1].length() == 1 || (targetNameArr[1].length() == 2 && targetNameArr[1].endsWith("."))) {
				return 1; // i.e. 100% match
			}
		}

		
		// target has middle name missed out, and src has a middle initial
		// assume it is a 100% match and ignore
		if (srcIndex == 1 && srcLen > targetLen) {
			if (srcName.length() == 1 || (srcName.length() == 2 && srcName.endsWith("."))) {
				return 1; // i.e. 100% match
			}
		}
		
		// there is only one single targetName, i.e. without blanks
		if (targetNameArr.length == 1 && seemsSimilar(srcName, targetName)) {
			return getSimilarity(srcName, targetName);
		}

		// the srcName is not an initial and matches target lastName
		if (srcIndex == 0 && srcName.length() > 1) {
			String actualTarget = targetNameArr[targetLen - 1];
			if (seemsSimilar(srcName, actualTarget)) {
				return getSimilarity(srcName, actualTarget);
			}
		}

		// the srcName is not an initial and matches target firstName
		if (srcIndex == targetLen && srcName.length() > 1) {
			String actualTarget = targetNameArr[0];
			if (seemsSimilar(srcName, actualTarget)) {
				return getSimilarity(srcName, actualTarget);
			}
		}

		// various other special cases may be here

		return 0;
	}

	private static double getSimilarity(String srcName, String actualTarget) {
		// http://stackoverflow.com/questions/955110/similarity-string-comparison-in-java/16018452#16018452
		double similarity = StringSimilarity.similarity(srcName, actualTarget);
//		System.out
//				.println("      similarity " + similarity + " for " + srcName + " and " + actualTarget);
		return similarity;
	}

	// just an arbitrary quick check of similarity
	private static boolean seemsSimilar(String srcName, String targetName) {
		// if lengths are more or less equal
		try {
			if (Math.abs(srcName.length() - targetName.length()) <= LENGTH_GAP_ALLOWED) {
				// and the two words either start or end with the same character
				if (srcName.toLowerCase().charAt(0) == targetName.toLowerCase().charAt(0) || srcName.toLowerCase()
						.charAt(srcName.length() - 1) == targetName.toLowerCase().charAt(targetName.length() - 1)) {
					return true;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return false;
	}

	// example only
	private static boolean isPrefix(String str) {
		if (str.equals("Dr.") || str.equals("Dr") || str.equals("Mr.") || str.equals("Mr") || str.equals("Mrs.")
				|| str.equals("Mrs")) {
			return true;
		}
		return false;
	}

}

