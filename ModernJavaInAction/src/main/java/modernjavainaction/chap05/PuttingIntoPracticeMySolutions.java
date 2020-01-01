package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPracticeMySolutions {

  public static void main(String... args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
    transactions.stream()
            .filter(t->t.getYear()==2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .forEach(System.out::println);

    // Query 2: What are all the unique cities where the traders work?
    transactions.stream()
            .map(t->t.getTrader().getCity())
            .distinct()
            .forEach(System.out::println);

    // Query 3: Find all traders from Cambridge and sort them by name.
    System.out.println("Query 3: ");
    transactions.stream()
                .map(t->t.getTrader())
                .filter(t->t.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList()).forEach(System.out::println);
                //.forEach(System.out::println);

    // Query 4: Return a string of all traders' names sorted alphabetically.
    System.out.println("Query 4: ");
     List<String> names = transactions.stream()
                                      .map(t->t.getTrader().getName())
                                      .distinct()
                                      .sorted()
                                      .collect(Collectors.toList());
     names.forEach(System.out::println);


    // Query 5: Are there any trader based in Milan?

    // Query 6: Print all transactions' values from the traders living in Cambridge.

    // Query 7: What's the highest value in all the transactions?

    // Find the transaction with the smallest value

    // Here I cheat a bit by converting the found Transaction (if any) to a String
    // so that I can use a default String if no transactions are found (i.e. the Stream is empty).

  }

}
