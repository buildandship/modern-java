package modernjavainaction.chap03;

import java.util.function.Function;

public class ComposeLambdas {
/*
Composing Comparators
CHAINING COMPARATORS
  inventory.sort(comparing(Apple::getWeight)// Sorts by decreasing weight
  .reversed()//Sorts by decreasing weight
  .thenComparing(Apple::getCountry)); //Sorts further by country when two apples have same weight
  

Composing Predicates
  The Predicate interface includes three methods that let you reuse an existing
  Predicate to create more complicated ones: negate, and, and or.
  
  //
  
  Predicate<Apple> redAndHeavyAppleOrGreen =
  redApple.and(apple -> apple.getWeight() > 150)
  .or(apple -> GREEN.equals(a.getColor()));
  
Composing Functions
  The Function interface comes with two default methods for this, andThen and
  compose, which both return an instance of Function.
  
  Function<Integer, Integer> f = x -> x + 1;
  Function<Integer, Integer> g = x -> x * 2;
  Function<Integer, Integer> h = f.andThen(g);
  int result = h.apply(1); //This returns 4.

  //using compose, it would mean f(g(x)) instead of g(f(x)) using andThen

  Function<Integer, Integer> f = x -> x + 1;
  Function<Integer, Integer> g = x -> x * 2;
  Function<Integer, Integer> h = f.compose(g);
  int result = h.apply(1); // This returns 3.

*/
public static void main(String[] args) {
  Function<Integer, Integer> f = x -> x + 1;
  Function<Integer, Integer> g = x -> x * 2;
  Function<Integer, Integer> h = f.andThen(g);// g(f(x)) using andThen
  int result = h.apply(1); //This returns 4.
  System.out.println(result);
  
  //using compose, it would mean f(g(x)) instead of g(f(x)) using andThen
  
  Function<Integer, Integer> f1 = x -> x + 1;
  Function<Integer, Integer> g1 = x -> x * 2;
  Function<Integer, Integer> h1 = f1.compose(g1);//using compose, it would mean f1(g1(x))
  int result1 = h1.apply(1); // This returns 3.
  System.out.println(result1);
  
  }
}
