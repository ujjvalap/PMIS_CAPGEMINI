
public class Problem2 {
    public static void main(String[] args) {

        String password = "Ujjval@2005";

        int uppercase = 0;
        int lowercase = 0;
        int digits = 0;
        int special = 0;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                uppercase++;
            } else if (Character.isLowerCase(ch)) {
                lowercase++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else {
                special++;
            }
        }

        System.out.println("Uppercase letters: " + uppercase);
        System.out.println("Lowercase letters: " + lowercase);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + special);
    }
}
