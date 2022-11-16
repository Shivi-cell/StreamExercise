class Parent
{
    Parent()
    {
        System.out.println("Hello");
    }
}
public class Test2 extends Parent{
    Test2()
    {
        super();
       // this("jfsdjhcvas");
    }
    Test2(String str)
    {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
    }
}
