package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("Simple File Chooser");
    private final Controller myController;

    public SimpleGUIWithFileChooser (final Controller controller) {
        this.myController = controller;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField fileName = new JTextField("Choose File");
        fileName.setEditable(false);
        final JButton chooseFile = new JButton("Browse");

        final JPanel fileChoosingArea = new JPanel();
        fileChoosingArea.setLayout(new BorderLayout());

        frame.add(canvas);
        canvas.add(fileChoosingArea, BorderLayout.NORTH);
        fileChoosingArea.add(fileName, BorderLayout.CENTER);
        fileChoosingArea.add(chooseFile, BorderLayout.LINE_END);

        final Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int)screeDimension.getWidth()/5;
        final int height = (int)screeDimension.getHeight()/5;

        frame.setSize(width, height);
    }

    public void display() {
        this.frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        final SimpleGUIWithFileChooser myFileChooser = new SimpleGUIWithFileChooser(new Controller());
        myFileChooser.display();
    }

}
