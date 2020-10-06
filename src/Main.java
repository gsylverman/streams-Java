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
        employees.add(new Employee("NameY", 20));
        employees.add(new Employee("NameZ", 36));

        // Lambda function with 1 input argument (FunctionalInterface)
        Function<Employee, String> fnc1 = (employee) -> employee.getName() + " Something else";
        Function<String, String> fnc2 = (employee) -> employee.toUpperCase();
        System.out.println(fnc1.andThen(fnc2).apply(employees.get(0)));

        // Lambda function with 2 input argument (FunctionalInterface)
        BiFunction<Employee, Integer, String> fnc3 = (employees, p) -> employees.getName() + " " + p;
        System.out.println(fnc3.apply(new Employee("SomeName", 27), 10));

        // Predicate
        Predicate<Employee> predicate = employee -> employee.getAge() > 20;
        usePredicate(employees, predicate);

        // Supplier
        Supplier<Employee> supplier = () -> employees.get(0);
        System.out.println(supplier.get());

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


        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        long namesBeginWithA = topNames2015
                .stream()
                .map(item -> {
                    return item.substring(0, 1).toUpperCase() + item.substring(1);
                })
                .peek(System.out::println)
                .filter(item -> item.startsWith("A"))
                .count();
        System.out.println(namesBeginWithA);

    }

    private static void usePredicate(List<Employee> employees, Predicate<Employee> predicate) {
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}



