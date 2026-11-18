import java.io.*;
class Result {

    public static int calculateSalary(int basicSalary, int allowance, int deduction) {
        return basicSalary + allowance - deduction;
    }
}

public class Solution1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int basicSalary = Integer.parseInt(bufferedReader.readLine().trim());
        int allowance = Integer.parseInt(bufferedReader.readLine().trim());
        int deduction = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.calculateSalary(basicSalary, allowance, deduction);

        System.out.println(result);

        bufferedReader.close();
    }
}
