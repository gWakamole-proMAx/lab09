package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("Simple File Chooser");

    /**
     * Constructor for SimpleGUIWithFileChoser.
     * @param controller controller to be associated with the gui
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField pickedFile = new JTextField("Choose File");
        pickedFile.setEditable(false);
        final JButton save = new JButton("Save");

        save.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnFile(controller.getCurrentFilePath());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(save, "An error has occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        final JButton browse = new JButton("Browse");

        browse.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent e) {
                    final JFileChooser fileChooser = new JFileChooser();
                    final int result = fileChooser.showSaveDialog(browse);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        controller.setCurrentFile(fileChooser.getSelectedFile());
                        pickedFile.setText(controller.getCurrentFilePath());
                    } else if (result != JFileChooser.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(browse, "An error has occured", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        final JPanel fileChoosingArea = new JPanel();
        fileChoosingArea.setLayout(new BorderLayout());

        frame.add(canvas);
        canvas.add(fileChoosingArea, BorderLayout.NORTH);
        canvas.add(save, BorderLayout.SOUTH);
        fileChoosingArea.add(pickedFile, BorderLayout.CENTER);
        fileChoosingArea.add(browse, BorderLayout.LINE_END);

        final Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screeDimension.getWidth() / 5;
        final int height = (int) screeDimension.getHeight() / 5;

        frame.setSize(width, height);
        frame.setLocationByPlatform(true);
    }

    /**
     * Displays the GUI.
     */
    public void display() {
        this.frame.setVisible(true);
    }

    /**
     * Main.
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser myFileChooser = new SimpleGUIWithFileChooser(new Controller());
        myFileChooser.display();
    }

}
