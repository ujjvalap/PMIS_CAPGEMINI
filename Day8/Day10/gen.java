class Locker<T> {
    private T item;
    void put(T item)
    {
        this.item=item;
    }

    T get()
    {
        return  item;
    }

    
}

public class gen {
   public static void main(String[] args) {
     Locker<String> l1=new Locker();
     l1.put("Java Roadmap");
     System.out.println("This locker has : " + l1.get());
     Locker<Integer> intlLocker = new Locker();
     intlLocker.put(245);
     intlLocker.put(2455);
     System.out.println("IntLocker has: " + intlLocker.get());
   }
}
