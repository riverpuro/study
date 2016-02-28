package composite;


public class Main {
    public static void main(String... args) {
        try {
            System.out.println("Making root entries...");

            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");

            rootDir
                    .add(binDir)
                    .add(tmpDir)
                    .add(usrDir);

            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));

            rootDir.printList();

            System.out.println("Making user entries...");

            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");

            usrDir
                    .add(yuki)
                    .add(hanako)
                    .add(tomura);

            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));

            hanako.add(new File("memo.tex", 300));

            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));

            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
