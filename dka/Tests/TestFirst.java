

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dka.Automat;
import dka.BuilderFormatter;

public class TestFirst {

	@Test
	public void test() {
		BuilderFormatter builder = new BuilderFormatter();
		Automat<Character, String> automat = builder.getAutomat(); 
		ArrayList<Character> array = new ArrayList<Character>();
		System.out.println(automat);
		array.add('a');
		array.add(' ');
		array.add('{');
		array.add(' ');
		array.add('b');
		array.add('}');
		ArrayList<Character> result = new ArrayList<Character>();
		result.add('a');
		result.add(' ');
		result.add('{');
		result.add('\n');
		result.add(' ');
		result.add(' ');
		result.add(' ');
		result.add(' ');
		result.add(' ');
		result.add('b');
		result.add('\n');
		result.add('}');
		assertEquals(result,automat.action(array));
	}
}
