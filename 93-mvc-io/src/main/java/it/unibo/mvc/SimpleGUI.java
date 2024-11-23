package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("GUI");

    /**
     * constructor that sets all the components of the SimpleGUI.
     * @param myController the controller used for the functionalities
     */
    public SimpleGUI(final Controller myController) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        final JTextArea textArea = new JTextArea("Your Strings");
        textArea.setEditable(false);
        final JTextField textField = new JTextField("Here, write your strings");
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");

        printButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    myController.setString(textField.getText());
                    myController.printString(); 
                }
        });

        historyButton.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final StringBuilder historyString = new StringBuilder();
                for (final String string : myController.getHistory()) {
                    historyString.append(string).append('\n');
                }
                textArea.setText(historyString.toString());
            }
        });

        frame.add(canvas);
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.add(historyButton);
        buttonsPanel.add(printButton);

        final Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screeDimension.getWidth() / 5;
        final int heigth = (int) screeDimension.getHeight() / 5;
        frame.setSize(width, heigth);
        frame.setLocationByPlatform(true);
    }

    /**
     * Displays the GUI.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Main.
     * @param args
     */
    public static void main(final String[] args) {
        final SimpleGUI myGui = new SimpleGUI(new SimpleController());
        myGui.display();
    }
}
