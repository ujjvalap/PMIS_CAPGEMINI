class BankDetilas {

    String Name;
    int balnce;

    public BankDetilas(String Name, int balnce) {
        this.Name = Name;
        this.balnce = balnce;
    }

    public void Deposite(int Deposite) {
        balnce += Deposite;
        System.out.println("Deposit Amount: " + balnce);
    }

    public void Widarow_Balance(int Current_Balance) {

        if (Current_Balance > 0 && Current_Balance <= balnce) {
            balnce -= Current_Balance;
            System.out.println("Available Balance is: " + balnce);
        } 
        else {
            System.out.println("Insufficient Balance or Invalid Amount");
        }
    }

    public void Display() {
        System.out.println(
            "Account Holder Name is: " + Name +
            " Deposit Amount is: " + balnce
        );
    }
}


class Practicset {

    public static void main(String[] args) {

        BankDetilas obj = new BankDetilas("Ujjval", 90000);

        obj.Display();

        obj.Widarow_Balance(599);

        obj.Display();
    }
}