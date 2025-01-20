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
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> personDTOFunction = person -> new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getAge()
        );
        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(personDTOFunction)
                .toList();
        dtos.forEach(System.out::println);

//        Using the map function of PersonDTO class

        Predicate<Person> personPredicate = person -> person.getAge() > 20;
//        Function<Person, PersonDTO> personDTOFunction1 = person -> PersonDTO.map(person);
        Function<Person, PersonDTO> personDTOFunction1 = PersonDTO::map;
        List<PersonDTO> dtoList = people.stream()
                .filter(personPredicate)
                .map(personDTOFunction1)
                .toList();
    }
    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        Double average= cars.stream().
//                mapToDouble gives a stream of Double this means that it provides extra methods (the map function does not have an average function)
                mapToDouble(Car::getPrice).
                average().
                orElse(0);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        int sum2 = Arrays.stream(integers).reduce(0, Integer::sum);
        int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
    }
}

