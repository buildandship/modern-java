package modernjavainaction.chap02;

import java.util.ArrayList;
import java.util.List;

public class PredicateGeneric {
    public static void main(String[] args) {


    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
