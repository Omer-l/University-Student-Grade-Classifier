package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import university.Grade;

class GradeTest {

	@Test
	void testBelowConstructorInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new Grade(21);
		});
	}

	@Test
	void testAboveConstructorInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new Grade(0);
		});
	}
	
	@Test
	void testGetPoints() {
		int expected = 1;
		
		Grade grade = new Grade(expected);
		
		int actual = grade.getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyFirst() {
		Grade grade = new Grade(1);
		
		String expected = "First";
		String actual = grade.classify().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyUpperSecond() {
		Grade grade = new Grade(7);
		
		String expected = "UpperSecond";
		String actual = grade.classify().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyLowerSecond() {
		Grade grade = new Grade(11);
		
		String expected = "LowerSecond";
		String actual = grade.classify().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyThird() {
		Grade grade = new Grade(15);
		
		String expected = "Third";
		String actual = grade.classify().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testClassifyFail() {
		Grade grade = new Grade(18);
		
		String expected = "Fail";
		String actual = grade.classify().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testBelowRangeFromPercentage() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Grade.fromPercentage(-2);
		});
	}
	
	@Test
	void testAboveRangeFromPercentage() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Grade.fromPercentage(101);
		});
	}
	
	@Test
	void testFromPercentageForGrade20() {
		int percentageReceived = -1;
		
		int expected = 20;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade19() {
		int percentageReceived = 29;
		
		int expected = 19;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade18() {
		int percentageReceived = 34;
		
		int expected = 18;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade17() {
		int percentageReceived = 39;
		
		int expected = 17;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade16() {
		int percentageReceived = 41;
		
		int expected = 16;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade15() {
		int percentageReceived = 44;
		
		int expected = 15;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade14() {
		int percentageReceived = 46;
		
		int expected = 14;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade13() {
		int percentageReceived = 49;
		
		int expected = 13;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade12() {
		int percentageReceived = 51;
		
		int expected = 12;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade11() {
		int percentageReceived = 54;
		
		int expected = 11;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade10() {
		int percentageReceived = 56;
		
		int expected = 10;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade9() {
		int percentageReceived = 58;
		
		int expected = 9;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade8() {
		int percentageReceived = 61;
		
		int expected = 8;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade7() {
		int percentageReceived = 63;
		
		int expected = 7;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade6() {
		int percentageReceived = 66;
		
		int expected = 6;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade5() {
		int percentageReceived = 68;
		
		int expected = 5;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade4() {
		int percentageReceived = 71;
		
		int expected = 4;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade3() {
		int percentageReceived = 74;
		
		int expected = 3;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade2() {
		int percentageReceived = 77;
		
		int expected = 2;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFromPercentageForGrade1() {
		int percentageReceived = 89;
		
		int expected = 1;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
}
