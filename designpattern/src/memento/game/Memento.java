package memento.game;

import java.util.ArrayList;

public class Memento {
    int money;
    ArrayList<String> fruits;

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<String>();
    }

    public int getMoney() {
        return money;
    }

    ArrayList<String> getFruits() {
        return fruits;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }
}