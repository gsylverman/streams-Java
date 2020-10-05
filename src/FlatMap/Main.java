package FlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Department> departments = new ArrayList<>();

    public static void main(String[] args) {
        Employee jane = new Employee("Jane", 26);
        Employee john = new Employee("John", 21);
        Employee jim = new Employee("Jim", 18);
        Employee jerry = new Employee("Jerry", 36);
        Employee foster = new Employee("Foster", 41);
        Employee edy = new Employee("Edy", 45);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(john);
        hr.addEmployee(jim);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(jerry);
        accounting.addEmployee(foster);
        accounting.addEmployee(edy);
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(employee -> System.out.println(employee.getName()));


        List<String> someListX = Arrays.asList("YJP", "COP", "HSA", "HJS");
        List<String> collect = someListX
                .stream()
                .peek(System.out::println)
                .sorted()
                .collect(Collectors.toList()); //we can store in a list after processing

        System.out.println(collect.size());

        List<String> someListX1 = Arrays.asList("YJP", "COP", "HSA", "HJS");
        List<String> collect1 = someListX1
                .stream()
                .peek(System.out::println)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); //we can store in a list after processing

        System.out.println(collect1.size());
    }
}
