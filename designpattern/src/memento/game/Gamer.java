package memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<String>();
    private Random random = new Random();

    private static String[] fruitNames = {
            "リンゴ", "ぶどう", "バナナ", "みかん"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;

        switch (dice) {
            case 1:
                money += 100;
                System.out.println("所持金が増えました。");
                break;
            case 2:
                money /= 2;
                System.out.println("所持金が半分になりました。");
                break;
            case 6:
                String f = getFruit();
                fruits.add(f);
                System.out.println("フルーツ (" + f + ") をもらいました。");
                break;
            default:
                System.out.println("何も起こりませんでした。");
        }
    }

    public Memento createMemento() {
        Memento m = new Memento(money);
        for (String fruit : fruits) {
            if (fruit.startsWith("おいしい")) {
                m.addFruit(fruit);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitNames[random.nextInt(fruitNames.length)];
    }
}