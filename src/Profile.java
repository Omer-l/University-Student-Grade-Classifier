import java.util.List;

public class Profile {
	// Your additions/changes below this line
	private List<Grade> grades;
	//percentages of each grade
	private double percentageOfGradesFirst;
	private double percentageOfGradesUpperSecond;
	private double percentageOfGradesLowerSecond;
	private double percentageOfGradesThird;
	private final double classifyingPercentage = 0.50;
	private final double discretionPercentage = 0.251; //+ 0.001 for floating point error handling. 

	public Profile(List<Grade> g) {
		if (g == null || g.isEmpty() || fail(g))
			throw new IllegalArgumentException();
		else {
			this.grades = g;
			initialiseProfileGradePercentages(); //get proportion/percentage of each grade
		}
	}

	/**
	 * Evaluates a list of grades for any grade 17-20.
	 * 
	 * @param g is the list of grades
	 * @return true if at least one grade is greater than or equal to 16 and less
	 *         than or equal to 20.
	 */
	private boolean fail(List<Grade> g) {
		for (Grade grade : g)
			if (grade.classify() == Classification.Fail)
				return true;
		return false;
	}

	// Gets profile 5 or 6 depending on the given number of grades in the parameter
	private double[] getProfileGradePercentages() {
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
		profilePercentages[0] = (double) gradeCounter[0] / (double) numberOfGradesInProfile; // percentage of first class
		profilePercentages[1] = (double) gradeCounter[1] / (double) numberOfGradesInProfile; // percentage of upper second class
		profilePercentages[2] = (double) gradeCounter[2] / (double) numberOfGradesInProfile; // percentage of lower second class
		profilePercentages[3] = (double) gradeCounter[3] / (double) numberOfGradesInProfile; // percentage of third class

		return profilePercentages;
	}

	//Initialises the percentages of each grade attained by this profile.
	private void initialiseProfileGradePercentages() {
		double[] percentagesProfile = getProfileGradePercentages();
		// evaluates profile 6's grades' percentages as a decimal (i.e. 0.50)
		this.percentageOfGradesFirst = percentagesProfile[0];
		this.percentageOfGradesUpperSecond = percentagesProfile[1];
		this.percentageOfGradesLowerSecond = percentagesProfile[2];
		this.percentageOfGradesThird = percentagesProfile[3];
	}

	//Classify profile depending on number of grade classifications achieved
	public Classification classify() {
		if (!isClear()) //ensures discretion is required for those with too many Thirds and 50% Firsts or UpperSeconds
			return Classification.Discretion;
		else if (percentageOfGradesFirst >= classifyingPercentage)
			return Classification.First;
		else if (percentageOfGradesUpperSecond >= classifyingPercentage)
			return Classification.UpperSecond;
		else if (percentageOfGradesLowerSecond >= classifyingPercentage)
			return Classification.LowerSecond;
		else
			return Classification.Third;
	}

	//Returns false for First or UpperSecond grades that have more than 25% Third grades.
	public boolean isClear() {
		if ((percentageOfGradesFirst >= classifyingPercentage && percentageOfGradesThird > discretionPercentage)
				|| (percentageOfGradesUpperSecond >= classifyingPercentage
						&& percentageOfGradesThird > discretionPercentage)) 
			return false;
		else
			return true;
	}
}
