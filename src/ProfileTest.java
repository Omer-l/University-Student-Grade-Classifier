

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProfileTest {

	@Test
	void testConstructorEmptyListArgument() {
		List<Grade> emptyListOfGrades = new ArrayList<>();
		
		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(emptyListOfGrades);
		});
	}
	
	@Test
	void testConstructorNullArgument() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(null);
		});
	}

	@Test
	void testConstructorOneOrMoreFailArgument() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(1)); //grade 1
		listOfGrades.add(new Grade(1)); //grade 2
		listOfGrades.add(new Grade(14)); //grade 3
		listOfGrades.add(Grade.fromPercentage(-1)); //grade 4: 20 //FAIL
		listOfGrades.add(Grade.fromPercentage(25)); //grade 5: 19 //FAIL
		listOfGrades.add(Grade.fromPercentage(31)); //grade 6: 18 //FAIL
		listOfGrades.add(Grade.fromPercentage(37)); //grade 7: 17 //FAIL

		assertThrows(IllegalArgumentException.class, () -> { //should not add to list of grades
			listOfGrades.add(Grade.fromPercentage(-5));
		});
		
		assertThrows(IllegalArgumentException.class, () -> { //should not add to list of grades
			listOfGrades.add(new Grade(21));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			listOfGrades.add(new Grade(-1)); //grade shouldn't be added
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(listOfGrades);
		});
	}

	@Test
	void testProfileNotClearFirst() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(Grade.fromPercentage(87)); //grade 1: 1, First
		listOfGrades.add(Grade.fromPercentage(77)); //grade 2: 2, First
		listOfGrades.add(Grade.fromPercentage(40)); //grade 3: 16, Third
		listOfGrades.add(Grade.fromPercentage(42)); //grade 4: 15, Third
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.Discretion.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileNotClearUpperSecond() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(Grade.fromPercentage(68)); //grade 1: 5, UpperSecond
		listOfGrades.add(Grade.fromPercentage(65)); //grade 2: 6, UpperSecond
		listOfGrades.add(Grade.fromPercentage(63)); //grade 3: 7, UpperSecond
		listOfGrades.add(Grade.fromPercentage(60)); //grade 4: 8, UpperSecond
		listOfGrades.add(Grade.fromPercentage(58)); //grade 5: 9, UpperSecond
		listOfGrades.add(Grade.fromPercentage(48)); //grade 6: 13, Third
		listOfGrades.add(Grade.fromPercentage(45)); //grade 7: 14, Third
		listOfGrades.add(Grade.fromPercentage(43)); //grade 8: 15, Third
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.Discretion.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileClearFirst() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(1)); //grade 1, First
		listOfGrades.add(new Grade(1)); //grade 2, First
		listOfGrades.add(new Grade(1)); //grade 3, First
		listOfGrades.add(Grade.fromPercentage(74)); //grade 4: 3, First
		listOfGrades.add(Grade.fromPercentage(70)); //grade 5: 4, First
		listOfGrades.add(new Grade(10)); //grade 6, Lower Second
		listOfGrades.add(new Grade(10)); //grade 7, Lower Second
		listOfGrades.add(new Grade(15)); //grade 8, Third
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.First.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileClearUpperSecond() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(5)); //grade 1, UpperSecond
		listOfGrades.add(new Grade(6)); //grade 2, UpperSecond
		listOfGrades.add(new Grade(7)); //grade 3, UpperSecond
		listOfGrades.add(new Grade(8)); //grade 4, UpperSecond
		listOfGrades.add(new Grade(1)); //grade 5, First
		listOfGrades.add(new Grade(3)); //grade 6, First
		listOfGrades.add(new Grade(4)); //grade 7, First
		listOfGrades.add(new Grade(6)); //grade 8, UpperSecond
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.UpperSecond.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileLowerSecond() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(9)); //grade 1, Lower Second
		listOfGrades.add(Grade.fromPercentage(50)); //grade 2: 12, Lower Second
		listOfGrades.add(Grade.fromPercentage(52)); //grade 3: 11, Lower Second
		listOfGrades.add(Grade.fromPercentage(55)); //grade 4: 10, Lower Second
		listOfGrades.add(new Grade(1)); //grade 5, First
		listOfGrades.add(new Grade(15)); //grade 6, Third
		listOfGrades.add(new Grade(4)); //grade 7, First
		listOfGrades.add(new Grade(6)); //grade 8, UpperSecond
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.LowerSecond.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileThird() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(13)); //grade 1, Third
		listOfGrades.add(new Grade(14)); //grade 2, Third
		listOfGrades.add(new Grade(15)); //grade 3, Third
		listOfGrades.add(new Grade(12)); //grade 4, Lower Second
		listOfGrades.add(new Grade(1)); //grade 5, First
		listOfGrades.add(new Grade(3)); //grade 6, First
		listOfGrades.add(new Grade(14)); //grade 7, Third
		listOfGrades.add(new Grade(16)); //grade 8, Third
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.Third.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	
}
