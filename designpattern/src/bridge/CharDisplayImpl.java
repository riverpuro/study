package bridge;

public class CharDisplayImpl extends DisplayImpl {
    private char prefix;
    private char suffix;
    private char content;

    public CharDisplayImpl(char prefix, char suffix, char content) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.content = content;
    }

    @Override
    public void rawOpen() {
        System.out.print(prefix);
    }

    @Override
    public void rawPrint() {
        System.out.print(content);
    }

    @Override
    public void rawClose() {
        System.out.println(suffix);
    }
}
