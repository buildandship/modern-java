package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static modernjavainaction.chap03.Color.GREEN;

public class ConstructorReferences {
  
  // Supplier suppose there’s a zero-argument constructor.
  // This fits the signature () -> Apple of Supplier;
  Supplier<Apple> c1 = Apple::new;
  Apple a1 = c1.get();
  
  Supplier<Apple> c2 = () -> new Apple();
  Apple a2 = c2.get();
  
  //If you have a constructor with signature Apple(Integer weight), it fits the signature of the Function interface
  Function<Integer, Apple> f1 = Apple::new;
  Apple a3 = f1.apply(110);
  
  Function<Integer, Apple> f2 = (weight) -> new Apple(weight);
  Apple a4 = f2.apply(110);
  
  //If you have a two-argument constructor, Apple (Color color, Integer weight), it fits
  //the signature of the BiFunction interface

    BiFunction<Color, Integer, Apple> bf1 = Apple::new;
    Apple a5 = bf1.apply(GREEN, 110);

/*
    BiFunction<String, Integer, Apple> bf2 =
            (color, weight) -> new Apple(color, weight);
    Apple a6 = bf2.apply(GREEN, 110);
*/

  
  List<Integer> weights = Arrays.asList(7, 3, 4, 10);
  List<Apple> apples = map(weights, Apple::new);
  public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
    List<Apple> result = new ArrayList<>();
    for(Integer i: list) {
      result.add(f.apply(i));
    }
    return result;
  }
  
  public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
  }
  
  TriFunction<Integer, Integer, Integer, RGB> colorFactory = RGB::new;
  
  class RGB{
    public RGB(int red, int green, int blue) {
    }
  }
  
   class Apple {
    
    private int weight = 0;
    private Color color;
    
    public  Apple(){
    
    }
    
    public  Apple(int weight){
      this.weight=weight;
    }
  
  
    public Apple(Color color,int weight) {
       this.weight = weight;
       this.color = color;
     }
    public Apple(int weight, Color color) {
      this.weight = weight;
      this.color = color;
    }
    
    public int getWeight() {
      return weight;
    }
    
    public void setWeight(int weight) {
      this.weight = weight;
    }
    
    public Color getColor() {
      return color;
    }
    
    public void setColor(Color color) {
      this.color = color;
    }
    
    @SuppressWarnings("boxing")
    @Override
    public String toString() {
      return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
    
  }
}
