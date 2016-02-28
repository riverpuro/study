package singleton.q2;

public class Main {
    public static void main(String... args) {
        Triple t0 = Triple.getInstance(0);
        System.out.println(String.format("triple id: %d", t0.getId()));

        Triple t1 = Triple.getInstance(1);
        System.out.println(String.format("triple id: %d", t1.getId()));

        Triple t2 = Triple.getInstance(2);
        System.out.println(String.format("triple id: %d", t2.getId()));
    }
}
