

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DegreeTest {
	
	@Test
	void testInitialiseDegreeLessGrades() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(Grade.fromPercentage(82)); //grade 1: 1
		year2Grades.add(Grade.fromPercentage(89)); //grade 2: 1
		year2Grades.add(Grade.fromPercentage(45)); //grade 3: 14
		year2Grades.add(Grade.fromPercentage(51)); //grade 4: 12
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(Grade.fromPercentage(74)); //grade 1: 3
		year3Grades.add(Grade.fromPercentage(71)); //grade 2: 4
		year3Grades.add(Grade.fromPercentage(48)); //grade 3: 13
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, year3Grades);
		});
	}
	
	@Test
	void testInitialiseDegreeNullProfile() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1
		year2Grades.add(Grade.fromPercentage(76)); //grade 2: 2
		year2Grades.add(new Grade(3)); //grade 3
		year2Grades.add(new Grade(4)); //grade 4
		
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
	void testInitialiseDegreeFail() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(Grade.fromPercentage(37)); //grade 1: 17
		year2Grades.add(new Grade(3)); //grade 2
		year2Grades.add(new Grade(2)); //grade 3
		year2Grades.add(new Grade(1)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1
		
		assertThrows(IllegalArgumentException.class, () -> { 
			year3Grades.add(Grade.fromPercentage(-3));
		});
	
		assertThrows(IllegalArgumentException.class, () -> { 
			year3Grades.add(Grade.fromPercentage(104));
		});
		
		
		year3Grades.add(Grade.fromPercentage(19)); //grade 2: 19
		year3Grades.add(Grade.fromPercentage(-1)); //grade 3: 20
		year3Grades.add(Grade.fromPercentage(32)); //grade 4: 18
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, year3Grades);
		});
	}
	
	@Test
	void testClassifyBothProfilesSame() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1
		year2Grades.add(Grade.fromPercentage(68)); //grade 2: 5
		year2Grades.add(Grade.fromPercentage(63)); //grade 3: 7
		year2Grades.add(new Grade(1)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(new Grade(1)); //grade 2
		year3Grades.add(Grade.fromPercentage(43)); //grade 3: 15
		year3Grades.add(new Grade(1)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.First;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLevel6Higher() {
		List<Grade> year2Grades = new ArrayList<>(); //LowerSecond
		year2Grades.add(new Grade(14)); //grade 1
		year2Grades.add(new Grade(15)); //grade 2
		year2Grades.add(Grade.fromPercentage(40)); //grade 3: 16
		year2Grades.add(Grade.fromPercentage(48)); //grade 4: 13
		
		
		List<Grade> year3Grades = new ArrayList<>(); //Third
		year3Grades.add(Grade.fromPercentage(45)); //grade 1: 15
		year3Grades.add(Grade.fromPercentage(55)); //grade 2: 10
		year3Grades.add(Grade.fromPercentage(53)); //grade 3: 11
		year3Grades.add(Grade.fromPercentage(51)); //grade 4: 12
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.LowerSecond;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLevel5Higher() {
		List<Grade> year2Grades = new ArrayList<>(); //First
		year2Grades.add(new Grade(3)); //grade 1
		year2Grades.add(Grade.fromPercentage(58)); //grade 2: 9
		year2Grades.add(new Grade(4)); //grade 3
		year2Grades.add(new Grade(1)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>(); //UpperSecond
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(Grade.fromPercentage(60)); //grade 2: 8
		year3Grades.add(Grade.fromPercentage(48)); //grade 3: 13
		year3Grades.add(new Grade(5)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.First;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyDiscretionOver25Third() {
		List<Grade> year2Grades = new ArrayList<>(); //First but with Discretion
		year2Grades.add(new Grade(3)); //grade 1
		year2Grades.add(new Grade(15)); //grade 2
		year2Grades.add(new Grade(4)); //grade 3
		year2Grades.add(new Grade(16)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>(); //UpperSecond
		year3Grades.add(Grade.fromPercentage(55)); //grade 1: 10
		year3Grades.add(Grade.fromPercentage(66)); //grade 2: 6
		year3Grades.add(new Grade(14)); //grade 3
		year3Grades.add(new Grade(1)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.Discretion;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyDiscretionTwoGradesApart() {
		List<Grade> year2Grades = new ArrayList<>(); //First
		year2Grades.add(new Grade(3)); //grade 1
		year2Grades.add(new Grade(1)); //grade 2
		year2Grades.add(new Grade(4)); //grade 3
		year2Grades.add(new Grade(4)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>(); //LowerSecond
		year3Grades.add(new Grade(9)); //grade 1
		year3Grades.add(new Grade(12)); //grade 2
		year3Grades.add(new Grade(14)); //grade 3
		year3Grades.add(new Grade(15)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.Discretion;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
}
