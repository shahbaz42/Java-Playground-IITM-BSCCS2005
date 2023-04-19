# Collecting results from streams


## Collecting values from streams
- Converting collections into sequence of values - `Stream`
- Process stream as a collection?
- Stream defines a standard iterator, we can use it to  loop through values in the stream

### Examples
```java
// mystream.forEach() method
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
stream.forEach(System.out::println);
```

toArray() method returns an array containing the elements of the stream. The elements are in the same order as they appear in the stream.

```java
// mystream.toArray() method
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
Object[] objArray = stream.toArray();
```

toArray() method returns an array of Object type. If we want to return an array of a specific type, we can use the overloaded version of toArray() method and pass a IntFunction generator as an argument. The generator function takes the length of the array as an argument and returns an array of the desired type.

```java
// mystream.toArray() method
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
String[] strArray = stream.toArray(String[]::new);
```

## Storing a stream as a collection
- Converting a stream into a collection
- Use `collect()` method
- Pass appropriate `factory method` from the Collectors 


### Examples
```java
// Creating a list from a stream
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
List<String> list = stream.collect(Collectors.toList());
```

```java
// Creating a set from a stream
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
Set<String> set = stream.collect(Collectors.toSet());
```

```java
// Tree set from a stream
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
// output
[five, four, one, three, two]
```

## Stream Summaries
- `count()` method
- `min()` and `max()` methods
- `sum()` and `average()` methods

`Collectors` has methods to aggregate summaries in a single object.
- `summarizingInt()`, `summarizingLong()`, `summarizingDouble()` methods
- `summarizingInt()` method returns an object of type `IntSummaryStatistics` that contains the count, sum, min, max, and average of the elements in the stream.
- If the stream is not of integer type, we can use `mapToInt()` method to convert the stream to an integer stream. or pass a function to convert the stream elements to integers.

```java
// Using summarizingInt() method
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(String::length));
System.out.println(stats);
```

## Joining Strings
- `joining()` method
- `joining(CharSequence delimiter)` method
- `joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)` method

```java
// Using joining() method
Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
String result = stream.collect(Collectors.joining());
System.out.println(result);
```

## Converting a stream to a map
- To convert a stream of a Person to map
- Use `Collectors.toMap()` method
- Pass a function to extract the key and value from the stream elements

```java
// Using toMap() method
Stream<Person> stream = Stream.of(
    new Person("John", 20), 
    new Person("Sara", 21), 
    new Person("Jane", 21), 
    new Person("Greg", 35)
);

Map<Integer, String> map = stream.collect(
    Collectors.toMap(
        Person::getId, // key = id
        Person::getName // value = name
    )
);
System.out.println(map);

// Output
{20=John, 21=Sara, 35=Greg}
```

- If the stream contains duplicate keys, then it'll throw `IllegalStateException`.  we can use `toMap()` method with a third argument to specify how to handle the duplicate keys.
- if duplicate keys are found, the third argument is used to merge the values.
`(existingValue, newValue) -> existingVaue + ";" + newValue`

```java

```java
// Using toMap() method with a third argument
Stream<Person> stream = Stream.of(
    new Person("John", 20), 
    new Person("Sara", 21), 
    new Person("Jane", 21), 
    new Person("Gregor", 21)
    new Person("Greg", 35)
);

Map<Integer, String> map = stream.collect(
    Collectors.toMap(
        Person::getId, // key = id
        Person::getName, // value = name
        (name1, name2) -> name1 + ";" + name2 // merging function
    )
);

System.out.println(map);

// Output
{20=John, 21=Sara;Jane;Gregor, 35=Greg}
```

- To store entire object as value, we can use Function.identity() as the second argument.

```java
// Using toMap() method with Function.identity()
Stream<Person> stream = Stream.of(
    new Person("John", 20), 
    new Person("Sara", 21), 
    new Person("Greg", 35)
);

Map<Integer, Person> map = stream.collect(
    Collectors.toMap(
        Person::getId, // key = id
        Function.identity() // value = person
    )
);

System.out.println(map);

// Output
{20=Person{name='John', id=20}, 21=Person{name='Sara', id=21}, 35=Person{name='Greg', id=35}}
```

## Grouping values
- Instead of discarding values with duplicate keys, group them together.

```java
// Using groupingBy() method
Stream<Person> stream = Stream.of(
    new Person("John", 20), 
    new Person("Sara", 21), 
    new Person("Jane", 21), 
    new Person("Greg", 35)
);

Map<Integer, List<Person>> map = stream.collect(
    Collectors.groupingBy(Person::getId)
);

System.out.println(map);

// Output
{20=[Person{name='John', id=20}], 21=[Person{name='Sara', id=21}, Person{name='Jane', id=21}], 35=[Person{name='Greg', id=35}]}
```

## Partitioning values
- Partitioning is a special case of grouping.
- It groups the elements into two groups based on a predicate.
- The predicate is passed to the `partitioningBy()` method.
- The `partitioningBy()` method returns a map with two keys: `true` and `false`.

```java
// Using partitioningBy() method
Stream<Person> stream = Stream.of(
    new Person("John", 20), 
    new Person("Sara", 21), 
    new Person("Jane", 21), 
    new Person("Greg", 35)
);

Map<Boolean, List<Person>> map = stream.collect(
    Collectors.partitioningBy(p -> p.getId() > 21)
);

System.out.println(map);

// Output
{false=[Person{name='John', id=20}, Person{name='Sara', id=21}, Person{name='Jane', id=21}], true=[Person{name='Greg', id=35}]}


List<Person> list = map.get(true);
System.out.println(list);

// Output
[Person{name='Greg', id=35}]
```

