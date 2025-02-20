### How to use Java Streams:
1. Start with a collection (Arrays, Sets, Lists, Maps) 

![](streams-step-1.png)   

2. Abstraction (what we want):  
we can have multiple streams  

![](streams-step-2.png)
Use of Intermediate Operators: filter, map and reduce

3 - back to concrete 
![](streams-step-3.png)

Use of Terminal Operators: collect, forEach, reduce

### Course content
1. **Getting Started With Streams:**
   - Getting started 
   - Working with Streams
2. **IntStreams and other Stream Types**
   - IntStreams  
        public static IntStream range(int startInclusive, int endExclusive)  
        public static IntStream rangeClosed(int startInclusive, int endInclusive)
3. **Min and Max**
   - Min and Max  
        Optional<T> min(Comparator<? super T> comparator)
4. **Removing Duplicates**
   - Distinct & Sets
5. **Filtering Data**
   - Filtering
        Stream<T> filter(Predicate<? super T> predicate)
        default Stream<T> takeWhile(Predicate<? super T> predicate)
        default Stream<T> dropWhile(Predicate<? super T> predicate)
        boolean allMatch(Predicate<? super T> predicate)
        boolean anyMatch(Predicate<? super T> predicate)
6. **Transformations**
   - Transformations Map & Reduce
   - Transformations with FlatMap
7. **Aggregate Functions**
   - Statistics with streams
   - Grouping Data
8. **Sorting Elements and Objects**
   - Sorting
9. **Joining Strings**
   - Joining strings
10. **Understanding Streams**
    - Understanding Streams


filter -> predicate
map    -> function