package dka;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuilderFormatter{
private Automat<Character, String> automat;
static int spaceCounter = 0;
public BuilderFormatter() {
	build();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((automat == null) ? 0 : automat.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BuilderFormatter other = (BuilderFormatter) obj;
	if (automat == null) {
		if (other.automat != null)
			return false;
	} else if (!automat.equals(other.automat))
		return false;
	return true;
}

public Automat<Character, String> getAutomat() {
		return automat;
}

public void build() {
	Set<Character> a = new HashSet<>(0);
    a.add('a');
    a.add('b');
    a.add(' ');
    a.add('f');
    a.add('{');
    a.add('}');
    Set<String> Q=new HashSet<>(0);
    Q.add("tabulation1");
    Set<String> F=new HashSet<>(0);
    String q0="tabulation1";
    Map<Pair<Character, String>, Pair<Character, String>> delta = new HashMap<>();
    Map<Pair<Character, String>, Action<Character>> action = new HashMap<>();
    int figureCuounter = 1000;
    for(int i = 1; i < figureCuounter; i++) {
    	Q.add("tabulation" + Integer.toString(i));
    }
    for(int i = 1; i < figureCuounter - 1; i++) {
    	delta.put(new Pair<Character, String>('a', "tabulation" + Integer.toString(i)), new Pair<Character,String>('a', "tabulation" + Integer.toString(i)));
    	delta.put(new Pair<Character, String>('b', "tabulation" + Integer.toString(i)), new Pair<Character,String>('b', "tabulation" + Integer.toString(i)));
    	delta.put(new Pair<Character, String>('f', "tabulation" + Integer.toString(i)), new Pair<Character,String>('f', "tabulation" + Integer.toString(i)));
    	delta.put(new Pair<Character, String>(' ', "tabulation" + Integer.toString(i)), new Pair<Character,String>(' ', "tabulation" + Integer.toString(i)));
    	delta.put(new Pair<Character, String>('\n', "tabulation" + Integer.toString(i)), new Pair<Character,String>('\n', "tabulation" + Integer.toString(i)));
        delta.put(new Pair<Character, String>('{', "tabulation" + Integer.toString(i)), new Pair<Character,String>('{', "tabulation" + Integer.toString(i+1)));
        if(i>=2) {
        	delta.put(new Pair<Character, String>('}', "tabulation" + Integer.toString(i)), new Pair<Character, String>('\n', "tabulation" + Integer.toString(i-1)));
        }
        Action<Character> act = new Action<Character>() {
			@Override
			public void action(List<Character> list) {
				spaceCounter += 4;
				list.add('\n');
				for(int j = 1; j <= spaceCounter  ; j++) {
					list.add(' ');
				}
			}
        };
        
        Action<Character> up = new Action<Character>() {
			@Override
			public void action(List<Character> list) {
				for(int j = 1; j <= spaceCounter  ; j++) {
					list.add(' ');
				}
			}
        };
        
        Action<Character> down = new Action<Character>() {
			@Override
			public void action(List<Character> list) {
				list.add('}');
				spaceCounter = spaceCounter - 4;
			}
        };
        
        action.put(new Pair<Character, String>('{', "tabulation" + Integer.toString(i)), act);
        action.put(new Pair<Character, String>('\n', "tabulation" + Integer.toString(i)), up);
        action.put(new Pair<Character, String>('}', "tabulation" + Integer.toString(i)), down);
    }
    automat = new Automat<Character, String>(delta, a, Q, q0, F, action);
}
}
