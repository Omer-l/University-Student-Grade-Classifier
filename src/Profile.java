import java.util.List;

public class Profile {
	// Your additions/changes below this line
	private List<Grade> grades;
	//percentages of each grade
	private double percentageOfGradesFirst; //NOT 'AndUp' because there is not a higher grade classification.
	private double percentageOfGradesUpperSecondAndUp; //percentage of grades 1-8
	private double percentageOfGradesLowerSecondAndUp; //percentage of grades 1-12
	private double percentageOfGradesThird; //this is NOT 'AndUp' since it is only used for measuring the clearness of the profile.
	private final double classifyingPercentage = 0.50; //the percentage required for the classification of a profile.
	private final double discretionPercentage = 0.251; //+ 0.001 for floating point error handling. 

	public Profile(List<Grade> g) {
		if (g == null || g.isEmpty() || fail(g))
			throw new IllegalArgumentException();
		else {
			this.grades = g;
			initialiseProfileGradePercentages(); //gets the proportion/percentage of each grade
		}
	}

	/**
	 * Evaluates a list of grades for any grade 17-20.
	 * 
	 * @param g is the list of grades
	 * @return true if at least one grade is greater than 16 and less
	 *         than or equal to 20.
	 */
	private boolean fail(List<Grade> g) {
		for (Grade grade : g)
			if (grade.classify().equals(Classification.Fail))
				return true;
		return false;
	}
	
	// Gets profile 5 or 6 depending on the given number of grades in the parameter
	private void initialiseProfileGradePercentages() {
		int[] gradeCounter = new int[4]; // for counting the occurence of each class
		double[] profilePercentages = new double[4]; //percentage of each grade
		int numberOfGradesInProfile = grades.size(); //how many grades? i.e. profile 5 has 8 grades.

		// count grades
		for (int gradeIndex = 0; gradeIndex < numberOfGradesInProfile; gradeIndex++) {
			Grade grade = this.grades.get(gradeIndex);
			Classification gradeClassification = grade.classify();

			if (gradeClassification.toString() == "First")
				gradeCounter[0]++;
			else if (gradeClassification.toString() == "UpperSecond")
				gradeCounter[1]++;
			else if (gradeClassification.toString() == "LowerSecond")
				gradeCounter[2]++;
			else if (gradeClassification.toString() == "Third")
				gradeCounter[3]++;
		}
		// calculate grade percentages overall
		this.percentageOfGradesFirst = (double) gradeCounter[0] / (double) numberOfGradesInProfile; // percentage of first class
		this.percentageOfGradesUpperSecondAndUp = ((double) gradeCounter[1] / (double) numberOfGradesInProfile) + percentageOfGradesFirst; // percentage of upper second class and up
		this.percentageOfGradesLowerSecondAndUp = ((double) gradeCounter[2] / (double) numberOfGradesInProfile)  + percentageOfGradesUpperSecondAndUp; // percentage of lower second class
		this.percentageOfGradesThird = (double) gradeCounter[3] / (double) numberOfGradesInProfile; // percentage of third class

	}

	//Classify profile depending on percentage of grades achieved within a certain range. 50% of grades 1-4 is First, 1-8 UpperSecond. 1-12 LowerSecond.
	public Classification classify() {
		if (!isClear()) //ensures discretion is required for those with too many Thirds and 50% Firsts or UpperSeconds
			return Classification.Discretion;
		else if (percentageOfGradesFirst >= classifyingPercentage)
			return Classification.First;
		else if (percentageOfGradesUpperSecondAndUp >= classifyingPercentage)
			return Classification.UpperSecond;
		else if (percentageOfGradesLowerSecondAndUp >= classifyingPercentage)
			return Classification.LowerSecond;
		else
			return Classification.Third;
	}

	//Returns false for First or UpperSecond grades that have more than 25% Third grades.
	public boolean isClear() {
		if ( (percentageOfGradesFirst >= classifyingPercentage && percentageOfGradesThird > discretionPercentage)
				|| (percentageOfGradesUpperSecondAndUp >= classifyingPercentage && percentageOfGradesThird > discretionPercentage) ) 
			return false;
		else
			return true;
	}
}
