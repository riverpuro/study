package bridge;

import java.util.Random;

public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        open();

        Random random = new Random();
        int count = random.nextInt(times);
        for (int i = 0; i < count; i++) {
            print();
        }

        close();
    }
}
