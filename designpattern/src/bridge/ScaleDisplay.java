package bridge;

public class ScaleDisplay extends Display {
    public ScaleDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void scaleDisplay(int count) {
        for (int i = 0; i <= count; i++) {
            open();
            for (int j = 0; j < i; j++) {
                print();
            }
            close();
        }
    }
}
