package dka;

import java.util.List;
@FunctionalInterface
public interface Action<T> {
	void action(List<T> list);
}
