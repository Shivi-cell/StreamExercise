import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        List<Student> students = Arrays.asList(student1, student2, student3);


        // Get student with exact match name "jayesh"
        System.out.println("et student with exact match name \"jayesh\"");
        Optional<Student> jayesh = students.stream().filter(student -> student.getName().equalsIgnoreCase("jayesh")).findFirst();
        System.out.println(jayesh.get());


        // Get student with matching address "1235"
        System.out.println("Get student with matching address \"1235\" ");
        Optional<Student> first = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235")).findFirst();
        System.out.println(first.isPresent() ?first.get():"Student not found");


        // Get all student having mobile numbers 3333
        System.out.println("Get all student having mobile numbers 3333.");
        List<Student> collect = students.stream()
                .filter(student -> student.getMobileNumbers()
                        .stream().anyMatch(x -> x.getNumber().equals("3333"))).collect(Collectors.toList());
        System.out.println(collect);



        // Get all student having mobile number 1233 and 1234
        System.out.println("Get all student having mobile number 1233 and 1234");
        List<Student> collect1 = students.stream().filter(student -> student.getMobileNumbers().stream().allMatch(x -> x.getNumber().equals("1233") || x.getNumber().equals("1234"))).collect(Collectors.toList());
        System.out.println(collect1);

    }
}