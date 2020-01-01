##Code Samples

```java
Map<Dish.Type, List<Dish>> dishesByType =
menu.stream().collect(groupingBy(Dish::getType));

{FISH=[prawns, salmon],
OTHER=[french fries, rice, season fruit, pizza],
MEAT=[pork, beef, chicken]}

```


[Immutable in Java](https://dev.to/monknomo/make-an-immutable-object---in-java-480n)

```java

import static java.util.stream.Collectors.toList;
List<String> threeHighCaloricDishNames =
menu.stream()
.filter(dish -> dish.getCalories() > 300)
.map(Dish::getName)
.limit(3)
.collect(toList());
System.out.println(threeHighCaloricDishNames);

```