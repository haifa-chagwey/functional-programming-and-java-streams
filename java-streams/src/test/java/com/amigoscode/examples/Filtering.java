package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();
//        List<Car> list = cars.stream().filter(car -> car.getPrice() < 20_000.00).toList();
        Predicate<Car> pricePredicate = car -> car.getPrice() < 20_000.00;
        Predicate<Car> colorPredicate = car -> car.getColor().equals("Yellow");
        List<Car> carsLessThan20k = cars.stream()
                .filter(pricePredicate)
                .filter(colorPredicate)
                .toList();
        carsLessThan20k.forEach(System.out::println);
    }

    @Test
    public void takeWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " ")); // 2 4 6 8 10 12
        System.out.println();
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(n -> n % 2 == 0)
//                Take the number while the condition is met
                .forEach(n -> System.out.print(n + " ")); // 2 4 6 8
    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " ")); // 2 4 6 8 10 12
        System.out.println();
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(n -> n % 2 == 0)
//                Drop the number while the condition is met
                .forEach(n -> System.out.print(n + " ")); // 9 10 12
    }

    @Test
    public void findFirst() throws Exception {
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        filter a value that is not in the array
//        int result = Arrays.stream(numbers).filter(n -> n == 50).findFirst().orElse(-1);
        int result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(n -> n == 50)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void findAny() throws Exception {
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
//        int result = Arrays.stream(numbers).filter(n -> n == 50).findAny().orElse(-1);
        int result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(n -> n == 50)
                .findAny()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
//        int[] evenAndOneOdd = {0, 2, 4, 6, 8, 10, 11};
        // All the elements should match the predicate
//        boolean allMatch = Arrays.stream(evenAndOneOdd).allMatch(n -> n % 2 == 0);
        boolean allMatch = Stream.of(0, 2, 4, 6, 8, 10, 11).allMatch(n -> n % 2 == 0);
        System.out.println(allMatch); // false
    }

    @Test
    public void anyMatch() throws Exception {
//        int[] oddAndOneEven = {1, 3, 5, 7, 9, 11, 12};
        // At least one element in the stream matches the predicate
//        boolean anyMatch = Arrays.stream(oddAndOneEven).anyMatch(n -> n % 2 == 0);
        boolean anyMatch = Stream.of(1, 3, 5, 7, 9, 11, 12).anyMatch(n -> n % 2 == 0);
        System.out.println(anyMatch); // true
    }
}