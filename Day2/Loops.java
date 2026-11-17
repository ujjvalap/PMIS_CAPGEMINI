//.................................................................java loops..............................................


public class Loops {

    public static void main(String[] args) {

        // For loop
        // Use when you know how many times to repeat.

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }


        // While loop
        // Condition is checked before execution.

        int i = 1;

        while (i <= 5) {
            System.out.println(i);
            i++;
        }


        // DO-While loop
        // Executes at least once

        int j = 1;

        do {
            System.out.println(j);
            j++;
        } while (j <= 5);


        // 4. Nested loop
        // Loop inside another loop.

        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }


        // 5 For Each loop
        // Mainly used with arrays/collections

        int[] numbers = {10, 20, 30, 40, 50};

        for (int number : numbers) {
            System.out.println(number);
        }


        // 6 Break
        // Stops the loop completely.

        for (int k = 1; k <= 10; k++) {

            if (k == 5) {
                break;
            }

            System.out.println(k);
        }


        // continue
        // Skips the current iteration.

        for (int k = 1; k <= 5; k++) {

            if (k == 3) {
                continue;
            }

            System.out.println(k);
        }
    }
}