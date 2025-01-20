package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {

    @Test
    public void sortingStreamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(person -> person.getFirstName())
                .sorted()
                .toList();
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingStreamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        Comparator<String> comparator = Comparator.reverseOrder();
        List<String> sorted = people.stream()
                .map(person -> person.getFirstName())
                .sorted(comparator)
                .toList();
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingStreamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
        Comparator<Person> reversed = Comparator
                .comparing(Person::getFirstName)
                .thenComparing(Person::getEmail);
//                .reversed();
        List<Person> sort = people.stream()
                .sorted(reversed)
                .toList();
        sort.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> carList = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .toList();
        carList.forEach(System.out::println);
    }

}
