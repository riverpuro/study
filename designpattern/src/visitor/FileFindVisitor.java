package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private String ext;
    private ArrayList<File> foundFiles = new ArrayList<File>();

    public FileFindVisitor(String ext) {
        this.ext = ext;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(ext)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
    }

    public Iterator<File> getFoundFiles() {
        return foundFiles.iterator();
    }
}