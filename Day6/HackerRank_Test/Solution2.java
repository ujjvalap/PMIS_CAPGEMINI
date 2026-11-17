// Problem 2
 
import java.io.*;

class Result {

    public static int isSpecialNumber(int n) {

        int sum = 0;
        int original = n;

        while (n > 0) {
            int num = n % 10;
            int fact = 1;

            for (int i = 1; i <= num; i++) {
                fact = fact * i;
            }

            sum = sum + fact;
            n = n / 10;
        }

        if (sum == original) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());

        int result = Result.isSpecialNumber(n);

        System.out.println(result);

        br.close();
    }
}
