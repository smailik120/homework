package dka;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		BuilderFormatter builder = new BuilderFormatter();
		Automat<Character, String> automat = builder.getAutomat(); 
		ArrayList<Character> array = new ArrayList<Character>();
		System.out.println(automat);
		array.add('a');
		array.add('a');
		array.add('a');
		array.add(' ');
		array.add('{');
		array.add(' ');
		array.add('b');
		array.add('b');
		array.add('b');
		array.add('b');
		array.add(' ');
		array.add('b');
		array.add('b');
		array.add('b');
		array.add(' ');
		array.add('}');
		System.out.println(automat.action(array));
    }
}
