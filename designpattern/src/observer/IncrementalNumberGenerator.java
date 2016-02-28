package observer;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int start;
    private int count;
    private int step;

    private int current;

    public IncrementalNumberGenerator(int start, int count, int step) {
        this.start = start;
        this.count = count;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return current;
    }

    @Override
    public void execute() {
        for (int i = start; i < count; i += step) {
            current = i;
            notifyObservers();
        }
    }
}
