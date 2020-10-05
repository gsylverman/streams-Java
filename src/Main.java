import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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
        employees.add(new Employee("Raul", 37));
        employees.add(new Employee("Daniel", 34));
        employees.add(new Employee("Gavril", 36));

        Function<Employee, String> fnc1 = (employee) -> employee.getName() + " Something else";
        Function<String, String> fnc2 = (employee) -> employee.toUpperCase();
        BiFunction<Employee, Integer, String> fnc3 = (employees, p) -> employees.getName() + " " + p;
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

        String name = "someName";
        String upper = new String(name).toUpperCase();
        String upper2 = name.toUpperCase();
    }
}



