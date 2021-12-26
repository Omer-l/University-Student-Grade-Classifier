import java.util.List;

public class Degree {
	// Your additions/changes below this line
	private final int numberOfGradesYear2 = 4;
	private final int numberOfGradesYear3 = 4;
	private final Profile level5Profile;
	private final Profile level6Profile;

	public Degree(List<Grade> year2, List<Grade> year3) {
		if (year2 == null || year3 == null || year2.size() != numberOfGradesYear2 || year3.size() != numberOfGradesYear3)
			throw new IllegalArgumentException();
		else {
			year2.addAll(year3);
			this.level5Profile = new Profile(year2); //these instances will throw IllegalArgumentException if there is a fail grade.
			this.level6Profile = new Profile(year3);
		}
	}

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
