package bridge;

public class Main {
    public static void main(String... args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello, Town."));
        CountDisplay d5 = new CountDisplay(new TextFileDisplayImpl("file.txt"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
        d4.display();
        d4.randomDisplay(5);
        d5.multiDisplay(3);

        ScaleDisplay d6 = new ScaleDisplay(new CharDisplayImpl('<', '>', '*'));
        d6.scaleDisplay(4);

        ScaleDisplay d7 = new ScaleDisplay(new CharDisplayImpl('|', '-', '#'));
        d7.scaleDisplay(6);
    }
}
