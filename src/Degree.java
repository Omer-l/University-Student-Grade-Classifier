import java.util.List;

public class Degree {
	// Your additions/changes below this line
	private final int numberOfGradesYear2 = 4;
	private final int numberOfGradesYear3 = 4;

	public Degree(List<Grade> year2, List<Grade> year3) {
		if (year2 == null || year3 == null || year2.size() != numberOfGradesYear2 || year3.size() != numberOfGradesYear3
				|| fail(year2, year3))
			throw new IllegalArgumentException();
	}

	/**
	 * Evaluates a list of grades for any grade 17-20.
	 * 
	 * @param year2 is the list of grades for year 2
	 * @param year3 is the list of grades for year 3
	 * @return true if at least one grade is greater than or equal to 16 and less
	 *         than or equal to 20.
	 */
	private boolean fail(List<Grade> year2, List<Grade> year3) {

		for (int gradeNumber = 0; gradeNumber < year2.size(); gradeNumber++) {
			int year2Grade = year2.get(gradeNumber).getPoints();
			int year3Grade = year3.get(gradeNumber).getPoints();

			if (16 < year2Grade && year2Grade <= 20 && 16 < year3Grade && year3Grade <= 20)
				return true;
		}
		return false;
	}

	public Classification classify() {
		return Classification.Third;
	}
}
