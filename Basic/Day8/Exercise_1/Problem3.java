
import java.util.ArrayList;

 class Problem3 {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);

        System.out.println("Original List: " + numbers);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 != 0) {
                numbers.remove(i);
                i--;
            }
        }

        System.out.println("After Removing Odd Numbers: " + numbers);
    }
}
