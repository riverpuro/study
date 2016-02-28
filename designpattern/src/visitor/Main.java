package visitor;

import java.util.Iterator;

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

            binDir
                    .add(new File("vi", 10000))
                    .add(new File("latex", 20000));

            rootDir.accept(new ListVisitor());

            System.out.println();
            System.out.println("Making user entries...");

            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");

            usrDir
                    .add(yuki)
                    .add(hanako)
                    .add(tomura);

            yuki
                    .add(new File("diary.html", 100))
                    .add(new File("Composite.java", 200));

            hanako
                    .add(new File("memo.tex", 300))
                    .add(new File("index.html", 350));

            tomura
                    .add(new File("game.doc", 400))
                    .add(new File("junk.mail", 500));

            System.out.println();
            System.out.println("Making user entries...");
            rootDir.accept(new ListVisitor());

            System.out.println();
            System.out.println("HTML files are:");

            FileFindVisitor ffv = new FileFindVisitor(".html");
            rootDir.accept(ffv);

            Iterator<File> it = ffv.getFoundFiles();
            while (it.hasNext()) {
                File file = it.next();
                System.out.println(file.toString());
            }
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}