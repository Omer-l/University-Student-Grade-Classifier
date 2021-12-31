/**
 * This class contains the necessary functions to calculate a grade given either points, or a
 * percentage. These are necessary for giving an overall profile and degree classification.
 * @author Omer Kacar
 * @see Profile.java
 * @see Degree.java
 */
public class Grade {
	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) 
			throw new IllegalArgumentException();
		points = p;
	}
	
	// Your additions/changes below this line
	
	//constants for grade upper limits.
	private final int firstGradeLimit = 4;
	private final int upperSecondGradeLimit = 8;
	private final int lowerSecondGradeLimit = 12;
	private final int thirdGradeLimit = 16;
	
	//Returns the classification of a grade depending on the points
	public Classification classify() {
		if(points <= firstGradeLimit)
			return Classification.First;
		else if(points <= upperSecondGradeLimit)
			return Classification.UpperSecond;
		else if(getPoints() <= lowerSecondGradeLimit)
			return Classification.LowerSecond;
		else if(points <= thirdGradeLimit)
			return Classification.Third;
		else
			return Classification.Fail;
	}
	
	//Calculates the grade, given a percentage -1 to 100
	public static Grade fromPercentage(int g) throws IllegalArgumentException {
		if(g < -1 || g > 100)
			throw new IllegalArgumentException();
		else if(g == -1)
			return new Grade(20);
		else if(g <= 29)
			return new Grade(19);
		else if(g <= 34)
			return new Grade(18);
		else if(g <= 39)
			return new Grade(17);
		else if(g <= 41)
			return new Grade(16);
		else if(g <= 44)
			return new Grade(15);
		else if(g <= 46)
			return new Grade(14);
		else if(g <= 49)
			return new Grade(13);
		else if(g <= 51)
			return new Grade(12);
		else if(g <= 54)
			return new Grade(11);
		else if(g <= 56)
			return new Grade(10);
		else if(g <= 59)
			return new Grade(9);
		else if(g <= 61)
			return new Grade(8);
		else if(g <= 64)
			return new Grade(7);
		else if(g <= 66)
			return new Grade(6);
		else if(g <= 69)
			return new Grade(5);
		else if(g <= 72)
			return new Grade(4);
		else if(g <= 75)
			return new Grade(3);
		else if(g <= 78)
			return new Grade(2);
		else
			return new Grade(1);
	}
}
