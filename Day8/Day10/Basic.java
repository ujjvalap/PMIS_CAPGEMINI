class Pair <K, V> {

    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void setKey(K key) {
        this.key = key;
    }

    void setValue(V value) {
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    void display() {
        System.out.println("Key " + key);
        System.out.println("Value " + value);
    }
}

public class Basic {
    public static void main(String[] args) {

        Pair<String, Integer> p1 = new Pair<>("Age", 22);

        p1.display();

        System.out.println("The Vlaue is ");

        Pair<Integer, String> p2 = new Pair<>(101, "Ujjval");

        p2.display();

        p2.setValue("Java Developer");

        System.out.println("After Update ");
        p2.display();
    }
}
