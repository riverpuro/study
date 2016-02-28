package command.drawer;

import command.command.Command;

import java.awt.*;

public class ColorCommand implements Command {
    private Drawable drawable;
    private Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }
}