

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DegreeTest {
	
	@Test
	void testInitialiseDegreeLessGrades() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1
		year2Grades.add(new Grade(1)); //grade 2
		year2Grades.add(new Grade(14)); //grade 3
		year2Grades.add(new Grade(12)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(new Grade(1)); //grade 2
		year3Grades.add(new Grade(14)); //grade 3
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, year3Grades);
		});
	}
	
	@Test
	void testInitialiseDegreeNull() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1
		year2Grades.add(new Grade(1)); //grade 2
		year2Grades.add(new Grade(1)); //grade 3
		year2Grades.add(new Grade(1)); //grade 4
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, null);
		});
	}

	@Test
	void testInitialiseDegreeFail() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1
		year2Grades.add(new Grade(1)); //grade 2
		year2Grades.add(new Grade(1)); //grade 3
		year2Grades.add(new Grade(1)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(new Grade(1)); //grade 2
		year3Grades.add(new Grade(18)); //grade 3
		year3Grades.add(new Grade(1)); //grade 4
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree Degree = new Degree(year2Grades, year3Grades);
		});
	}
	
	@Test
	void testClassifyBothProfilesSame() {
		List<Grade> year2Grades = new ArrayList<>();
		year2Grades.add(new Grade(1)); //grade 1
		year2Grades.add(new Grade(1)); //grade 2
		year2Grades.add(new Grade(1)); //grade 3
		year2Grades.add(new Grade(1)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>();
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(new Grade(1)); //grade 2
		year3Grades.add(new Grade(14)); //grade 3
		year3Grades.add(new Grade(1)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.First;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLevel6Higher() {
		List<Grade> year2Grades = new ArrayList<>(); //UpperSecond
		year2Grades.add(new Grade(5)); //grade 1
		year2Grades.add(new Grade(8)); //grade 2
		year2Grades.add(new Grade(7)); //grade 3
		year2Grades.add(new Grade(6)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>(); //First
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(new Grade(1)); //grade 2
		year3Grades.add(new Grade(14)); //grade 3
		year3Grades.add(new Grade(1)); //grade 4
		
		Degree degree = new Degree(year2Grades, year3Grades);
		
		Classification expected = Classification.First;
		Classification actual = degree.classify();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLevel5Higher() {
		List<Grade> year2Grades = new ArrayList<>(); //First
		year2Grades.add(new Grade(3)); //grade 1
		year2Grades.add(new Grade(1)); //grade 2
		year2Grades.add(new Grade(4)); //grade 3
		year2Grades.add(new Grade(1)); //grade 4
		
		
		List<Grade> year3Grades = new ArrayList<>(); //UpperSecond
		year3Grades.add(new Grade(1)); //grade 1
		year3Grades.add(new Grade(6)); //grade 2
		year3Grades.add(new Grade(14)); //grade 3
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
		
		
		List<Grade> year3Grades = new ArrayList<>(); //LowerSecond
		year3Grades.add(new Grade(13)); //grade 1
		year3Grades.add(new Grade(6)); //grade 2
		year3Grades.add(new Grade(14)); //grade 3
		year3Grades.add(new Grade(5)); //grade 4
		
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
