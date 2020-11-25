package modernjavainaction.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamVsCollection {

  public static void main(String... args) {
    List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
    Stream<String> s = names.stream();
    s.forEach(System.out::println);
    // uncommenting this line will result in an IllegalStateException
    // because streams can be consumed only once
    //s.forEach(System.out::println);
    //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
    
    
    //External vs. internal iteration
    //External
    List<String> namesE = new ArrayList<>();
    for(Dish dish: Dish.menu) {//Explicitly iterates the list of menu sequentially
      namesE.add(dish.getName());// Extracts the name and adds it to an accumulator
    }
    //Internal
    List<String> namesI = Dish.menu.stream()
            .map(Dish::getName)// Parameterizes map with the getName method to extract the name of a dish
            .collect(toList());// Starts executing the pipeline of operations; no iteration
  
  
    // Stream operations
    // Stream operations that can be connected are called intermediate operations,
    // and operations that close a stream are called terminal operations.
    List<String> namesO = Dish.menu.stream() // Gets a stream from the list of dishes
            .filter(dish -> dish.getCalories() > 300) // Intermediate operation
            .map(Dish::getName) // Intermediate operation
            .limit(3) // Intermediate operation
            .collect(toList()); // Converts the Stream into a List

    //
    System.out.println("\n\n");
    Dish.menu.stream().forEach(System.out::println);
  
  
    // difference between forEach and forEachOrdered
    List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
    System.out.println("\nforEach in parallel stream");
    list.parallelStream().forEach(System.out::print);//4167523
    System.out.println("\nforEachOrdered in parallel stream");
    list.parallelStream().forEachOrdered(System.out::print);//1234567
    
  
  
  }
  
  
}
  

