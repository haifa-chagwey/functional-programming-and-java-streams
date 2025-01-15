package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
//        List<PersonDTO> dtos = people.stream()
//                .filter(person -> person.getAge() > 20)
//                .map(person -> {
//                    return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());})
//                    .collect(Collectors.toList());
//        dtos.forEach(System.out::println);
//        * Using lambda expression
//        Function<Person, PersonDTO> personDTOFunction = person -> new PersonDTO(
//                person.getId(),
//                person.getFirstName(),
//                person.getAge()
//        );
//        List<PersonDTO> dtos = people.stream()
//                .filter(person -> person.getAge() > 20)
//                .map(personDTOFunction)
//                .collect(Collectors.toList());

//        Or
        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(PersonDTO::map)
                .collect(Collectors.toList());
        dtos.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        Double average = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .average()
                .orElse(0);
        System.out.println(average);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
//        int sum = Arrays.stream(integers)
//                .reduce(0, (left, right) -> left + right);
        int sum = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        int sub = Arrays.stream(integers)
                .reduce(0, (left, right) -> left - right);
        System.out.println(sum);
        System.out.println(sub);
    }
}

