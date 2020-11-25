package modernjavainaction.chap05;

import static java.util.stream.Collectors.toList;
import static modernjavainaction.chap04.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import modernjavainaction.chap04.Dish;

public class Mapping{

  public static void main(String... args) {
    // map
    List<String> dishNames = menu.stream()
        .map(Dish::getName)
        .collect(toList());
    System.out.println(dishNames);

    // map
    List<String> words = Arrays.asList("Hello", "World");
    List<Integer> wordLengths = words.stream()
        .map(String::length)
        .collect(toList());
    System.out.println(wordLengths);

    // flatMap
    words.stream()
        .flatMap((String line) -> Arrays.stream(line.split("")))
        .distinct()
        .forEach(System.out::println);

    // flatMap
    List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
    List<Integer> numbers2 = Arrays.asList(6,7,8);
    List<int[]> pairs = numbers1.stream()
        .flatMap((Integer i) -> numbers2.stream()
            .map((Integer j) -> new int[]{i, j})
        )
        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
        .collect(toList());
    pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
  
    System.out.println("\n Further examples");
    // Further examples
    String[] arrayOfWords = {"Goodbye", "World"};
    Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
  
    List<Stream<String>> streamList = words.stream()
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(toList());
    //The current solution still doesn’t work! This is because you now end up with a list of
    //streams (more precisely, List<Stream<String>>).
  
  
    List<String> uniqueCharacters =
            words.stream()
                    .map(word -> word.split("")) //Converts each word into an array of its individual letters
                    .flatMap(Arrays::stream)//Flattens each generated stream into a single stream
                    .distinct()
                    .collect(toList());
    // Count unique characters from List of strings
    System.out.println(words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().count());
    System.out.println(uniqueCharacters);
    
    //
  }
}
