
public class Problem1 {
    public static void main(String[] args) {

        String str = "10,20,30,40,50";

        String[] numbers = str.split(",");

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            sum = sum + num;
        }

        System.out.println("Sum is :  " + sum);
    }
}
