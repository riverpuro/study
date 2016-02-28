package abstractfactory.listfactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li>\n");
        builder.append(caption);
        builder.append("\n");
        builder.append("<ul>\n");

        for (Item item : tray) {
            builder.append(item.makeHTML());
        }

        builder.append("</ul>\n");
        builder.append("</li>\n");

        return builder.toString();
    }
}
