package abstractfactory.tablefactory;

import abstractfactory.factory.Link;

public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return String.format("<td><a href=\"%s\">%s</a></td>\n", url, caption);
    }
}