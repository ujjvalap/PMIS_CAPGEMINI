
    interface Father {
        void skills();
    
        
    }
    interface Mother {
    
        void Cooking();
    }
    


class Famliy implements Father, Mother{
    public  void skills()
    {
        System.out.println("Famliy Manage: ");
    }

    public  void  Cooking()
    {
        System.out.println("Cooking Skills");
    }

}

class  Test{
    public static void main(String[] args)
    {
        Famliy obj=new Famliy();
        obj.Cooking();
        obj.skills();
    }
}
