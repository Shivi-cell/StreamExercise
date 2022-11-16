import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        TempStudent tmpStud1 = new TempStudent(
                "Jayesh1",
                201,
                new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

        TempStudent tmpStud2 = new TempStudent(
                "Khyati1",
                202,
                new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

        List<Student> studentList = tmpStudents.stream()
                .map(tmpStud -> new Student(tmpStud.name, tmpStud.age, tmpStud.address, tmpStud.mobileNumbers))
                .collect(Collectors.toList());
        System.out.println(studentList);
        System.out.println("--------------------");


        // Convert List<Student> to List<String> of student name
        System.out.println("Convert List<Student> to List<String> of student name : ");
        List<String> collect = studentList.stream().map(student -> student.getName()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("--------------------");



        // Convert List<students> to String
        System.out.println("Convert List<students> to String : ");
        String name = studentList.stream().map(student -> student.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(name);
        System.out.println("--------------------");



        // Change the case of List<String>
        System.out.println("Change the case of List<String> : ");
        List<String> nameList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
        nameList.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        System.out.println("--------------------");


        // Sort List<String>
        System.out.println("Sort List<String> : ");
        nameList.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------");

    }
}
