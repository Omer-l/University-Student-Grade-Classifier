package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import university.*;

/**
 * This class runs the application.
 * 
 * @author Omer Kacar
 *
 */
public class ApplicationRunner {
	private final static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		List<Grade> year2Grades = getGrades(2, 4);
		List<Grade> year3Grades = getGrades(3, 4);

		Degree degree = new Degree(year2Grades, year3Grades);
		
		//results
		System.out.print("\nDegree achieved: ");
		Classification classAchieved = degree.classify();
		
		if(classAchieved == Classification.First)
			System.out.print("First Class");
		else if(classAchieved == Classification.UpperSecond)
			System.out.print("Upper Second Class");
		else if(classAchieved == Classification.LowerSecond)
			System.out.print("Lower Second Class");
		else if(classAchieved == Classification.Third)
			System.out.print("Third Class");
		else
			System.out.print("Discretion. Staff will contact you.");
		
	}

	/**
	 * Prompts user and initialises grades for given year
	 * @param yearNumber		is the year at university
	 * @param numberOfGrades	is the number of grades student has at that year
	 * @return					an array of grades student accomplished
	 */
	public static List<Grade> getGrades(int yearNumber, int numberOfGrades) {
		List<Grade> grades = new ArrayList<>(numberOfGrades);

		for (int gradeIndex = 0; gradeIndex < 4; gradeIndex++) {
			System.out.print("Enter YEAR " + yearNumber + " grade " + (gradeIndex + 1) + " (add a % at the end if the grade is a percentage): ");
			grades.add(parseUserInput(input.nextLine()));
		}

		return grades;
	}
	
	//Gets grade, given a user input
	private static Grade parseUserInput(String userInput) {
		try {
			userInput = userInput.trim();
			
			if(userInput.charAt(userInput.length() - 1) == '%') {
				int gradeInt = Integer.parseInt(userInput.substring(0, userInput.indexOf('%')));
				return Grade.fromPercentage(gradeInt);
			} else {
				int gradeInt = Integer.parseInt(userInput);
				return new Grade(gradeInt);
			}
		} catch(Exception e) {
			ApplicationRunner.main(null);
		}
		
		return null;
	}
}
