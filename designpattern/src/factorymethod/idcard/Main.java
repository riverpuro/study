package factorymethod.idcard;

import factorymethod.framework.Factory;
import factorymethod.framework.Product;

public class Main {
    public static void main(String... args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("ABC");
        Product card2 = factory.create("DEF");
        Product card3 = factory.create("GHI");
        card1.use();
        card2.use();
        card3.use();
    }
}
