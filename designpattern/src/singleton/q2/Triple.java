package singleton.q2;

import java.util.ArrayList;

public class Triple {
    private static final int INSTANCE_SIZE = 3;

    private static ArrayList<Triple> triples = new ArrayList<Triple>();

    static {
        for (int i = 0; i < INSTANCE_SIZE; i++ ) {
            Triple instance = new Triple(i);
            triples.add(instance);
        }
    }

    private int id;

    private Triple(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Triple getInstance(int id) {
        if (id >= INSTANCE_SIZE) {
            throw new IllegalArgumentException("id is out of range");
        }

        return triples.get(id);
    }
}
