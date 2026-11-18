
/**
 * Multiple
 */
 interface Father {
    void skills();
    
}

interface Mother{
    void talent();
}


class Child implements Father, Mother {

    public void skills() {
        System.out.println("Coding skills");
    }

    public void talent() {
        System.out.println("Drawing talent");
    }
}

/**
 * Multiple
 */
public class Multiple {

    public  static  void  main(String[] args)
    {
        Child c=new Child();
        c.talent();;
        c.skills();
    }
}
