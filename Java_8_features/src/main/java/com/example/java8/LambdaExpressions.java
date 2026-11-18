
public class LambdaExpressions {
    @FunctionalInterface interface Greeting { void sayHello(String name); }
    @FunctionalInterface interface Calculator { int calculate(int a, int b); }

    public static void main(String[] args) {
        Greeting greeting = name -> System.out.println("Hello, " + name);
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        greeting.sayHello("Ujjwal");
        System.out.println("Addition: " + add.calculate(10, 20));
        System.out.println("Multiplication: " + multiply.calculate(10, 20));
    }
}
