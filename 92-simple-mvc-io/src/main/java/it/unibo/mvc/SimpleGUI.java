package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My Simple GUI");

    /**
     * Constructor that sets up the gui.
     * @param controller Controller paired with the gui.
     */
    public SimpleGUI(final Controller controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton button = new JButton("Save");

        panel.setLayout(new BorderLayout());

        button.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent e) {
                    try {
                        controller.writeOnFile(textArea.getText());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, e1, "error", JOptionPane.ERROR_MESSAGE);
                    } 
                }
        });

        frame.setContentPane(panel);
        panel.add(button, BorderLayout.SOUTH);
        panel.add(textArea, BorderLayout.CENTER);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth() / 5;
        final int sh = (int) screen.getHeight() / 5;

        frame.setSize(sw, sh);
        frame.setLocationByPlatform(true);
    }

    /**
     * Displays the gui.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Main.
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
