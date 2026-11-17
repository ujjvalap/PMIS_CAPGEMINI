
// // Acess the parenet Attribute using the Super keyword

// class Car{
//     String name="Alto";
// }


// class Brand extends Car{
//     String name="Toyota";
//      public void Display()
//     {   System.out.println(name);
//         System.out.print("The car Brand is : " + super.name);
//     }
// }
// /**
//  * SuperKeyword
//  */
// public class SuperKeyword {
//   public static void main(String[] args) {
//     Brand obj=new Brand();
//     obj.Display();
//   }
    
// }




// Acess the Method using the super keyword

// class Animal{
//     void animalSound()
//     {
//         System.out.println("Animal Sound");
//     }
// }

// class Dog extends  Animal{
//     void animalSound(){
//         System.out.println("The dog say : bow bow");
//         super.animalSound();
        
    
//     }
// }

// /**
//  * SuperKeyword
//  */
// public class SuperKeyword {

//     public static void main(String[] args) {
//         Dog d=new Dog();
//         d.animalSound();
//     }
// }



class BankAccount {
    String accountHolder;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    void displayDetails() {
        System.out.println("Bank Account Holder: " + accountHolder);
    }
}

class SavingAccount extends BankAccount {

    SavingAccount(String accountHolder) {
        super(accountHolder); // Calls parent constructor
    }

    @Override
    void displayDetails() {
        super.displayDetails(); // Calls parent method
        System.out.println("Account Type: Saving Account");
    }

    void displaySavingAccount() {
        System.out.println("This is a Saving Account");
    }
}

public class SuperKeyword {
    public static void main(String[] args) {

        SavingAccount sa = new SavingAccount("Ujjwal");

        sa.displayDetails();
        sa.displaySavingAccount();
    }
}