package visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> dir = new ArrayList<Entry>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator<Entry> iterator() throws FileTreatmentException {
        return dir.iterator();
    }

    @Override
    public int getSize() {
        SizeVisitor visitor = new SizeVisitor();
        Iterator<Entry> it = iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(visitor);
        }
        return visitor.getSize();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}