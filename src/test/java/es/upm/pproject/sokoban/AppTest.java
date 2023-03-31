package es.upm.pproject.sokoban;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import es.upm.pproject.exceptions.IllegalFileFormatException;
import es.upm.pproject.parser.Level;
import es.upm.pproject.parser.Parse;


public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
	void test1() throws IllegalFileFormatException {
		Level l = Parse.parseTxt(new File("res/test1"));
		String correct = l.toString();
		System.out.println(l.toString());
		assertEquals(l.toString(), correct);
	
	}
	
	@Test
	void test2() throws IllegalFileFormatException {
		assertThrows(IllegalFileFormatException.class, () -> Parse.parseTxt(new File("res/test2")));
	}
	@Test
	void test3() throws IllegalFileFormatException {
		assertThrows(IllegalFileFormatException.class, () -> Parse.parseTxt(new File("res/test3")));
	}
	@Test
	void test4() throws IllegalFileFormatException {
		assertThrows(IllegalFileFormatException.class, () -> Parse.parseTxt(new File("res/test4")));
	}
	@Test
	void test5() throws IllegalFileFormatException {
		assertThrows(IllegalFileFormatException.class, () -> Parse.parseTxt(new File("res/test5")));
	}
	@Test
	void test6() throws IllegalFileFormatException {
		assertThrows(IllegalFileFormatException.class, () -> Parse.parseTxt(new File("res/test6")));
	}
	@Test
	void test7() throws IllegalFileFormatException {
		assertThrows(IllegalFileFormatException.class, () -> Parse.parseTxt(new File("res/test7")));
	}

	
}
