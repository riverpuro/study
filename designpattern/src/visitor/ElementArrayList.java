package visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class ElementArrayList extends ArrayList<Entry> implements Element {
    @Override
    public void accept(Visitor v) {
        for (Entry entry : this) {
            ListVisitor lv = new ListVisitor();
            entry.accept(lv);
        }
    }
}