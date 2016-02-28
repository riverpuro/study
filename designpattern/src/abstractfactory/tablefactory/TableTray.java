package abstractfactory.tablefactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<td>");
        builder.append("<table width='100%' border='1'><tr>");
        builder.append(String.format("<td bgclor='#cccccc' align='center' colspan='%d'><b>%s</b></td>", tray.size(), caption));
        builder.append("</tr>\n");
        builder.append("<tr>");
        for (Item item : tray) {
            builder.append(item.makeHTML());
        }
        builder.append("</tr></table>");
        builder.append("</td>");
        return builder.toString();
    }
}
