package flyweight;

public class BigString {
    private BigChar[] bigChars;
    private boolean shared = true;

    public BigString(String string) {
        this(string, true);
    }

    public BigString(String string, boolean shared) {
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            if (shared) {
                bigChars[i] = factory.getBigChar(string.charAt(i));
            } else {
                bigChars[i] = new BigChar(string.charAt(i));
            }
        }
    }


    public void print() {
        for (BigChar bc : bigChars) {
            bc.print();
        }
    }
}
