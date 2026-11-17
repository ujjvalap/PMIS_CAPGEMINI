class Employe {

    int _id;
    double Salary;
    String name;

    public Employe(int _id, double Salary, String name) {

        this._id = _id;
        this.name = name;

        if (Salary > 0) {
            this.Salary = Salary;
        } else {
            this.Salary = 0.0;
        }
    }

    // Getter for ID
    int get_id() {
        return _id;
    }

    // Getter for Salary
    double get_Salary() {
        return Salary;
    }

    // Getter for Name
    String get_Name() {
        return name;
    }

    // Setter for Salary
    void setSalary(double Salary) {

        if (Salary >= 0) {
            this.Salary = Salary;
        } else {
            System.out.println("Invalid Input: Salary cannot be negative");
        }
    }

    // Give Raise
    public void giveRaise(double percentage) {

        if (percentage > 0) {

            double raise_amount = this.Salary * (percentage / 100.0);

            this.Salary += raise_amount;

            System.out.println(name + " got a " + percentage +"% raise Raise Amount is: " + raise_amount);
        } 
        else {
            System.out.println("Raise Percentage must be positive");
        }
    }

    public static void main(String[] args) {

        Employe obj = new Employe(4, 2000.7, "Ujjval");

        System.out.println("Initial Salary is: " + obj.get_Salary());

        obj.giveRaise(45);

        System.out.println("After the raise Final Salary is: " + obj.get_Salary());
    }
}