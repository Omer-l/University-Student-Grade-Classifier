

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProfileTest {

	@Test
	void testInitialiseProfileEmptyList() {
		List<Grade> emptyListOfGrades = new ArrayList<>();
		
		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(emptyListOfGrades);
		});
	}
	
	@Test
	void testInitialiseProfileNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(null);
		});
	}

	@Test
	void testInitialiseProfileFail() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(1)); //grade 1
		listOfGrades.add(new Grade(1)); //grade 2
		listOfGrades.add(new Grade(14)); //grade 3
		listOfGrades.add(new Grade(13)); //grade 4
		listOfGrades.add(new Grade(3)); //grade 5
		listOfGrades.add(new Grade(2)); //grade 6
		listOfGrades.add(new Grade(17)); //grade 7
		
		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(listOfGrades);
		});
	}

	@Test
	void testProfileNotClearFirst() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(1)); //grade 1
		listOfGrades.add(new Grade(1)); //grade 2
		listOfGrades.add(new Grade(16)); //grade 3
		listOfGrades.add(new Grade(14)); //grade 4
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.Discretion.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileNotClearUpperSecond() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(7)); //grade 1
		listOfGrades.add(new Grade(6)); //grade 2
		listOfGrades.add(new Grade(5)); //grade 3
		listOfGrades.add(new Grade(8)); //grade 4
		listOfGrades.add(new Grade(9)); //grade 5
		listOfGrades.add(new Grade(15)); //grade 6
		listOfGrades.add(new Grade(16)); //grade 7
		listOfGrades.add(new Grade(14)); //grade 8
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.Discretion.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileFirst() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(1)); //grade 1
		listOfGrades.add(new Grade(1)); //grade 2
		listOfGrades.add(new Grade(1)); //grade 3
		listOfGrades.add(new Grade(1)); //grade 4
		listOfGrades.add(new Grade(1)); //grade 5
		listOfGrades.add(new Grade(10)); //grade 6
		listOfGrades.add(new Grade(10)); //grade 7
		listOfGrades.add(new Grade(15)); //grade 8
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.First.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileUpperSecond() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(5)); //grade 1
		listOfGrades.add(new Grade(6)); //grade 2
		listOfGrades.add(new Grade(7)); //grade 3
		listOfGrades.add(new Grade(8)); //grade 4
		listOfGrades.add(new Grade(1)); //grade 5
		listOfGrades.add(new Grade(3)); //grade 6
		listOfGrades.add(new Grade(4)); //grade 7
		listOfGrades.add(new Grade(6)); //grade 8
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.UpperSecond.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileLowerSecond() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(9)); //grade 1
		listOfGrades.add(new Grade(10)); //grade 2
		listOfGrades.add(new Grade(11)); //grade 3
		listOfGrades.add(new Grade(12)); //grade 4
		listOfGrades.add(new Grade(1)); //grade 5
		listOfGrades.add(new Grade(3)); //grade 6
		listOfGrades.add(new Grade(4)); //grade 7
		listOfGrades.add(new Grade(6)); //grade 8
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.LowerSecond.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	@Test
	void testProfileThird() {
		List<Grade> listOfGrades = new ArrayList<>();
		listOfGrades.add(new Grade(13)); //grade 1
		listOfGrades.add(new Grade(14)); //grade 2
		listOfGrades.add(new Grade(15)); //grade 3
		listOfGrades.add(new Grade(12)); //grade 4
		listOfGrades.add(new Grade(1)); //grade 5
		listOfGrades.add(new Grade(3)); //grade 6
		listOfGrades.add(new Grade(4)); //grade 7
		listOfGrades.add(new Grade(16)); //grade 8
		
		Profile profile = new Profile(listOfGrades);
		
		String expected = Classification.Third.toString();
		String actual = profile.classify().toString();
	
		assertEquals(expected, actual);
	}

	
}
