class Student{
    String name;
    static String college="NIT Bhopal";

    Student(String name)
    {
        this.name=name;
    }
    void Displayname()
    {
        System.out.println("Student Name is :" + name);
        System.out.println("College Name is : "+ college);
    }
}


class Statickey{
    public static void main(String[] args)
    {
        Student obj=new Student("Ujjval");
        obj.Displayname();
       
        System.out.println(Student.college);
    }
}

