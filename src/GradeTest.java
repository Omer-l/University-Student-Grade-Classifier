
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GradeTest {

	@Test
	void testBelowInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new Grade(21);
		});
	}

	@Test
	void testAboveInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new Grade(0);
		});
	}
	
	@Test
	void testGetPoints() {
		Grade grade = new Grade(1);
		
		int expected = 1;
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
	void testGrade20() {
		int percentageReceived = -1;
		
		int expected = 20;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade19() {
		int percentageReceived = 29;
		
		int expected = 19;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade18() {
		int percentageReceived = 34;
		
		int expected = 18;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade17() {
		int percentageReceived = 39;
		
		int expected = 17;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade16() {
		int percentageReceived = 41;
		
		int expected = 16;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade15() {
		int percentageReceived = 44;
		
		int expected = 15;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade14() {
		int percentageReceived = 46;
		
		int expected = 14;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade13() {
		int percentageReceived = 49;
		
		int expected = 13;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade12() {
		int percentageReceived = 51;
		
		int expected = 12;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade11() {
		int percentageReceived = 54;
		
		int expected = 11;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade10() {
		int percentageReceived = 56;
		
		int expected = 10;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade9() {
		int percentageReceived = 58;
		
		int expected = 9;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade8() {
		int percentageReceived = 61;
		
		int expected = 8;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade7() {
		int percentageReceived = 63;
		
		int expected = 7;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade6() {
		int percentageReceived = 66;
		
		int expected = 6;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade5() {
		int percentageReceived = 68;
		
		int expected = 5;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade4() {
		int percentageReceived = 71;
		
		int expected = 4;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade3() {
		int percentageReceived = 74;
		
		int expected = 3;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade2() {
		int percentageReceived = 77;
		
		int expected = 2;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGrade1() {
		int percentageReceived = 89;
		
		int expected = 1;
		int actual = Grade.fromPercentage(percentageReceived).getPoints();
		
		assertEquals(expected, actual);
	}
}
