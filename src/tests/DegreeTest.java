package tests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import university.Classification;
import university.Degree;
import university.Grade;

class DegreeTest {
	
	//Grades are fine in this method but in year 3, there is 1 less grade
	@Test
	void testConstructorLessGrades() {
		List<Grade> year2Grades = new ArrayList<>(); 
		year2Grades.add(Grade.fromPercentage(82)); //grade 1: 1, First
		year2Grades.add(Grade.fromPercentage(89)); //grade 2: 1, First
		year2Grades.add(Grade.fromPercentage(45)); //grade 3: 14, Third
		year2Grades.add(Grade.fromPercentage(51)); //grade 4: 12, Third
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(Grade.fromPercentage(74)); //grade 1: 3, First
		year3Grades.add(Grade.fromPercentage(71)); //grade 2: 4, First
		year3Grades.add(new Grade(4)); //grade 4
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, year3Grades);
		});
	}
	
	@Test
	void testConstructorNullProfile() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1, First
		year2Grades.add(Grade.fromPercentage(76)); //grade 2: 2, First
		year2Grades.add(new Grade(3)); //grade 3, First
		year2Grades.add(Grade.fromPercentage(48)); //grade 3: 13, Third
		
		assertThrows(IllegalArgumentException.class, () -> {
			year2Grades.add(new Grade(21)); //grade shouldn't be added
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			year2Grades.add(new Grade(0)); //grade shouldn't be added
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, null);
		});
	}

	@Test
	void testConstructorOneOrMoreFail() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(Grade.fromPercentage(37)); //grade 1: 17, Fail
		year2Grades.add(new Grade(3)); //grade 2, First
		year2Grades.add(new Grade(2)); //grade 3, First
		year2Grades.add(new Grade(1)); //grade 4, First
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1
		
		assertThrows(IllegalArgumentException.class, () -> {  //grade shouldn't even be added
			year3Grades.add(Grade.fromPercentage(-3));
		});
	
		assertThrows(IllegalArgumentException.class, () -> {  //grade shouldn't even be added
			year3Grades.add(Grade.fromPercentage(104));
		});
		
		
		year3Grades.add(Grade.fromPercentage(19)); //grade 2: 19, Fail
		year3Grades.add(Grade.fromPercentage(-1)); //grade 3: 20, Fail
		year3Grades.add(Grade.fromPercentage(32)); //grade 4: 18, Fail
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, year3Grades);
		});
	}
	
	@Test
	void testClassifyBothProfilesSame() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1, First
		year2Grades.add(Grade.fromPercentage(68)); //grade 2: 5, UpperSecond
		year2Grades.add(Grade.fromPercentage(63)); //grade 3: 7, UpperSecond
		year2Grades.add(new Grade(1)); //grade 4, First
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1, First
		year3Grades.add(new Grade(1)); //grade 2, First
		year3Grades.add(Grade.fromPercentage(43)); //grade 3: 15, Third
		year3Grades.add(new Grade(1)); //grade 4, First
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.First;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLevel6HigherClassificationBy1() {
		List<Grade> year2Grades = new ArrayList<>(); //LowerSecond
		year2Grades.add(new Grade(14)); //grade 1, Third
		year2Grades.add(new Grade(15)); //grade 2, Third
		year2Grades.add(Grade.fromPercentage(40)); //grade 3: 16, Third
		year2Grades.add(Grade.fromPercentage(48)); //grade 4: 13, Third
		
		
		List<Grade> year3Grades = new ArrayList<>(); //Third
		year3Grades.add(Grade.fromPercentage(45)); //grade 1: 15, Third
		year3Grades.add(Grade.fromPercentage(55)); //grade 2: 10, UpperSecond
		year3Grades.add(Grade.fromPercentage(53)); //grade 3: 11, UpperSecond
		year3Grades.add(Grade.fromPercentage(51)); //grade 4: 12, UpperSecond
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.LowerSecond;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLevel5HigherClassificationBy1() {
		List<Grade> year2Grades = new ArrayList<>(); //First
		year2Grades.add(new Grade(3)); //grade 1, First
		year2Grades.add(Grade.fromPercentage(58)); //grade 2: 9, UpperSecond
		year2Grades.add(new Grade(4)); //grade 3, First
		year2Grades.add(new Grade(1)); //grade 4, First
		
		
		List<Grade> year3Grades = new ArrayList<>(); //UpperSecond
		year3Grades.add(new Grade(1)); //grade 1, First
		year3Grades.add(Grade.fromPercentage(60)); //grade 2: 8, UpperSecond
		year3Grades.add(Grade.fromPercentage(48)); //grade 3: 13, Third
		year3Grades.add(new Grade(5)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.First;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyDiscretionOver25PercentThird() {
		List<Grade> year2Grades = new ArrayList<>(); //First but with Discretion
		year2Grades.add(new Grade(3)); //grade 1, First
		year2Grades.add(new Grade(15)); //grade 2, Third
		year2Grades.add(new Grade(4)); //grade 3, First
		year2Grades.add(new Grade(16)); //grade 4, Third
		
		
		List<Grade> year3Grades = new ArrayList<>(); //UpperSecond
		year3Grades.add(Grade.fromPercentage(55)); //grade 1: 10, LowerSecond
		year3Grades.add(Grade.fromPercentage(66)); //grade 2: 6, UpperSecond
		year3Grades.add(new Grade(14)); //grade 3, Third
		year3Grades.add(new Grade(1)); //grade 4, First
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.Discretion;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyDiscretionHigherClassificationBy2() {
		List<Grade> year2Grades = new ArrayList<>(); //First
		year2Grades.add(new Grade(3)); //grade 1, First
		year2Grades.add(new Grade(1)); //grade 2, First
		year2Grades.add(new Grade(4)); //grade 3, First
		year2Grades.add(new Grade(4)); //grade , First
		
		
		List<Grade> year3Grades = new ArrayList<>(); //LowerSecond
		year3Grades.add(new Grade(9)); //grade 1, LowerSecond
		year3Grades.add(new Grade(12)); //grade 2, LowerSecond
		year3Grades.add(new Grade(14)); //grade 3, LowerSecond
		year3Grades.add(new Grade(15)); //grade 4, LowerSecond
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.Discretion;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
}
