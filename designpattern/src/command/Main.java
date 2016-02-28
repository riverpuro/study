package command;

import command.drawer.ColorCommand;
import command.command.Command;
import command.command.MacroCommand;
import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton = new JButton("clear");
    private JButton undoButton = new JButton("undo");

    private JButton blackColorButton = new JButton("black");
    private JButton redColorButton = new JButton("red");

    public Main(String title) throws HeadlessException {
        super(title);

        initializeHistory();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas, e.getPoint());
                history.append(command);
                command.execute();
            }
        });

        clearButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);

        blackColorButton.addActionListener(this);
        redColorButton.addActionListener(this);

        Box colorBox = new Box(BoxLayout.X_AXIS);
        colorBox.add(blackColorButton);
        colorBox.add(redColorButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(colorBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            initializeHistory();
            canvas.repaint();
        }
        if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        }

        if (e.getSource() == blackColorButton) {
            history.append(new ColorCommand(canvas, Color.black));
            canvas.repaint();
        }
        if (e.getSource() == redColorButton) {
            history.append(new ColorCommand(canvas, Color.red));
            canvas.repaint();
        }
    }

    private void initializeHistory() {
        history.clear();
        history.append(new ColorCommand(canvas, Color.red));
    }

    public static void main(String... args) {
        new Main("Command Pattern Sample");
    }
}