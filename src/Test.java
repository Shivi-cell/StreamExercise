import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class A
{
    {
        System.out.println("Class A");
    }
}
class B extends A
{
    {
        System.out.println("Class B");
    }
}
class C extends B
{
    {
        System.out.println("Class C");
    }
}
public class Test {
    public void method(A a)
    {
        System.out.println("one");
    }
    public void method(B b)
    {
        System.out.println("Two");
    }
    /*public void method(C c)
    {
        System.out.println("Three");
    }*/
    public void method(Object o)
    {
        System.out.println("Four");
    }
    public static void main(String[] args) {
       Test t = new Test();
       t.method(new C());
       String s="how are you";
       String[] arr = s.split(" ");
       Map<String, Long> str = Stream.of(arr).collect(Collectors.toMap(st->st, st->st.toLowerCase().chars().filter(ch->(ch=='a' || ch=='e'||ch=='i' ||ch=='o'|| ch=='u')).count()));
       str.entrySet().forEach(System.out::println);
       char c[]="hello".toCharArray();


        List<Integer> myList = Arrays.asList(10,15,8,49,8,25,98,32,15);
        List<Integer> collect = myList.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        myList.stream().map(a->a+"").filter(as->as.startsWith("1")).forEach(System.out::println);
        System.out.println("finding duplicate ");
        Set<Integer> duplicate = new HashSet<>();
        myList.stream().filter(n->!duplicate.add(n)).forEach(System.out::println);

        System.out.println("finding first element ");
        myList.stream().findFirst().ifPresent(System.out::println);

        System.out.println("counting total no of the elements in the stream");
        long count = myList.stream().count();
        System.out.println(count);

        System.out.println("finding maximum");
        myList.stream().max(Integer::compareTo).ifPresent(System.out::println);




        // finding first non-repeated character in the string
        String string = "Java Hungry Blog Alive is Awesome";
        Character character = string.chars()
                .mapToObj(st -> Character.toLowerCase(Character.valueOf((char) st)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey()).findFirst().get();
        System.out.println(character);
    }
}
