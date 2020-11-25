package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestLambdaType {
  
  public static void main(String[] args) {
    List list = new ArrayList<>();
    // Predicate has a boolean return
    Predicate<String> p = (String s) -> list.add(s);
    System.out.println(p.test("Praveen"));
    // Consumer has a void return
    Consumer<String> b = (String s) -> list.add(s);
    b.accept("Praveen");
    //System.out.println(""  +b.accept("Praveen"));
    
    
    // 2 Fix this
    // Object o = () -> System.out.println("Tricky example");
    Runnable o = () -> System.out.println("Tricky example");
    Object oo = (Runnable) () -> System.out.println("Tricky example");
    // We can explicitly disambiguate the call by using a cast expression
    
    
    // 3
    int portNumber = 1337;
    Runnable r = () -> System.out.println(portNumber);
    //portNumber = 31337;
    // local variables referenced from a lambda expression must be final or effectively final
    //
    
    //4
    Function<String, String> stringStringFunction = (String s) -> s.toUpperCase();
    String s = stringStringFunction.apply("Praveen");
    System.out.println(s);
    
    // 5
    List<String> str = Arrays.asList("Z","z","y","Y","a","b","A","B");
    str.sort(String::compareToIgnoreCase);
    System.out.println(str);
  }
}
