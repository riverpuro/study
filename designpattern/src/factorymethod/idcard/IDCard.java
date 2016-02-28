package factorymethod.idcard;

import factorymethod.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    IDCard(String owner, int serial) {
        String message = String.format("%d: %sのカードを作りますす。", serial, owner);
        System.out.println(message);
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        String message = String.format("%d: %sのカードを使います。", serial, owner);
        System.out.println(message);
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
