package command.drawer;

import command.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    private int radius = 6;
    private Color color;
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    public void paint(Graphics graphics) {
        history.execute();
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        Graphics graphics = getGraphics();
        graphics.setColor(color);
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}