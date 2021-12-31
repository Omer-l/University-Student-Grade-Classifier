package middlesexUniversity;
import java.util.List;

/**
 * Given two profiles (Level 5 and Level 6), this class contains the necessary functions to give a 
 * degree classification for the student.
 * @author Omer Kacar     
 * @see Profile.java
 * @see Grade.java
 */
public class Degree {
	// Your additions/changes below this line
	private final int numberOfGradesYear2 = 4;
	private final int numberOfGradesYear3 = 4;
	private final Profile level5Profile;
	private final Profile level6Profile;

	public Degree(List<Grade> year2, List<Grade> year3) {
		if (year2 == null || year3 == null || year2.size() != numberOfGradesYear2 || year3.size() != numberOfGradesYear3 || fail(year2, year3))
			throw new IllegalArgumentException();
		else {
			year2.addAll(year3);
			this.level5Profile = new Profile(year2); //these instances will throw IllegalArgumentException if there is a fail grade.
			this.level6Profile = new Profile(year3);
		}
	}

	
	/**
	 * Evaluates a list of grades and for any grade 17-20, false will be returned.
	 * 
	 * @param year2 is the list of grades for year 2
	 * @param year3 is the list of grades for year 3
	 * @return true if at least one grade is greater than or equal to 16 and less
	 *         than or equal to 20.
	 */
	private boolean fail(List<Grade> year2, List<Grade> year3) {

		for (int gradeNumber = 0; gradeNumber < year2.size(); gradeNumber++) {
			Grade year2Grade = year2.get(gradeNumber);
			Grade year3Grade = year3.get(gradeNumber);

			if (year2Grade.classify().equals(Classification.Fail) || year3Grade.classify().equals(Classification.Fail))
				return true;
		}
		return false;
	}
	
	//classifies the degree depending on the class of the two profiles.
	public Classification classify() {
		Integer level5Classification = level5Profile.classify().ordinal();
		Integer level6Classification = level6Profile.classify().ordinal();
		Classification[] classificationValues = Classification.values();
		
		if(level5Classification.equals(level6Classification))
			return classificationValues[level5Classification];
		else if(level5Classification.equals(level6Classification - 1)) //level 6 is 1 higher
			return classificationValues[level6Classification];
		else if(level6Classification.equals(level5Classification - 1)) //level 5 is 1 higher
			return classificationValues[level5Classification];
		else
			return Classification.Discretion; 
	}
}
