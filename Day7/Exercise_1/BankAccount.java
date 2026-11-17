
class UserAccount {

    private String UserName;
    private static int TotalUser = 0;

    // Constructor
    UserAccount(String UserName) {
        this.UserName = UserName;
        TotalUser++;
    }

    // Getter for username
    String getUserName() {
        return UserName;
    }

    // Getter for total users
    static int getTotalUser() {
        return TotalUser;
    }
}

class BankAccount {
    public static void main(String[] args) {

        // Display count before creating users
        System.out.println("Count of users initially: " + UserAccount.getTotalUser());

        // Create user objects
        UserAccount obj = new UserAccount("Ujjval");
        UserAccount obj1 = new UserAccount("Ravi");
        UserAccount obj2 = new UserAccount("Yash");
        UserAccount obj3 = new UserAccount("Pawan");
        UserAccount obj4 = new UserAccount("Abhi");

        // Display usernames
        System.out.println("First User Name is: " + obj.getUserName());
        System.out.println("Second User Name is: " + obj1.getUserName());
        System.out.println("Third User Name is: " + obj2.getUserName());
        System.out.println("Fourth User Name is: " + obj3.getUserName());
        System.out.println("Fifth User Name is: " + obj4.getUserName());

        // Display total count after creating users
        System.out.println("Total User Count is: " + UserAccount.getTotalUser());
    }
}
