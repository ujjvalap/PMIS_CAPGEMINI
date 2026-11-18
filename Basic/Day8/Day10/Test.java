class Util{
    static <T> void printTwo(T value)
    {
        System.out.println(value);
        System.out.println(value);
    }

    static <T> T firstOf(T a , T b)
    {
        return b;
    }
}

public class Test {
    public static void main(String[] args) {
        Util.printTwo(357);
        System.out.println(Util.firstOf("Hello" , "Ujjval"));
    }
}
