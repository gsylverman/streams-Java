import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Main {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        employees.add(new Employee("NameX", 37));
        employees.add(new Employee("NameY", 34));
        employees.add(new Employee("NameZ", 36));

        // Lambda function with 1 input argument (FunctionalInterface)
        Function<Employee, String> fnc1 = (employee) -> employee.getName() + " Something else";
        Function<String, String> fnc2 = (employee) -> employee.toUpperCase();
        System.out.println(fnc1.andThen(fnc2).apply(employees.get(0)));

        // Lambda function with 2 input argument (FunctionalInterface)
        BiFunction<Employee, Integer, String> fnc3 = (employees, p) -> employees.getName() + " " + p;
        System.out.println(fnc3.apply(new Employee("SomeName", 27), 10));

        Predicate<Employee> predicate = employee -> employee.getAge() > 10;
        Supplier<Employee> supplier = () -> employees.get(0);

        //Streams
        List<String> someL = Arrays.asList(
                "NameY",
                "NameX",
                "NameZ"
        );

        someL
                .stream()
//                .filter(name -> name.startsWith("Z"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Stream<String> stream1 = Stream.of("A5", "B3", "J7");
        Stream<String> stream2 = Stream.of("Z5", "Y3", "F7", "J7");
        Stream<String> compoundStream = Stream.concat(stream1, stream2);
        compoundStream
                .map(String::toLowerCase)
                .peek(System.out::println)  // peek return another stream
                .distinct()
                .forEach((item -> System.out.println(item + "________az")));
    }
}



