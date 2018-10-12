package dka;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import dka.Pair;
import dka.Action;
public class Automat<T, V> {
	private Map<Pair<T,V>, Pair<T,V>> delta;
	private Map<Pair<T,V>, Action<T>> action;
	private Set<T> alphabet; 
	private Set<V> q;
	private V q0;
	private Set<V> f;
	public Automat(Map<Pair<T, V>, Pair<T, V>> delta, Set<T> alphabet, Set<V> q, V q0, Set<V> f, Map<Pair<T,V>, Action<T>> action) {
		this.delta = delta;
		this.alphabet = alphabet;
		this.q = q;
		this.q0 = q0;
		this.f = f;
		this.action = action;
	}
	public Collection<T> action(Iterable<T> request) {
		List<T> answer = new ArrayList<>();
		for(T letter : request) {
			Pair<T, V> currentPair = new Pair<T, V>(letter, this.q0); 
			System.out.println(this.q0);
			if(delta.containsKey(currentPair)) {
				this.q0 = delta.get(currentPair).getSecond();
				answer.add(delta.get(currentPair).getFirst());
				if(action.get(currentPair) != null) {
					action.get(currentPair).action(answer);
				}
			}
		}
		return answer;
	}
	public Map<Pair<T, V>, Pair<T, V>> getDelta() {
		return delta;
	}
	public void setDelta(Map<Pair<T, V>, Pair<T, V>> delta) {
		this.delta = delta;
	}
	public Set<T> getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(Set<T> alphabet) {
		this.alphabet = alphabet;
	}
	public Set<V> getQ() {
		return q;
	}
	public void setQ(Set<V> q) {
		this.q = q;
	}
	public V getQ0() {
		return q0;
	}
	public void setQ0(V q0) {
		this.q0 = q0;
	}
	public Set<V> getF() {
		return f;
	}
	public void setF(Set<V> f) {
		this.f = f;
	}
}