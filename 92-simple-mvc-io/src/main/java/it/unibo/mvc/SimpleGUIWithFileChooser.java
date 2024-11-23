package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        final JTextField pickedFile = new JTextField("Choose File");
        pickedFile.setEditable(false);
        final JButton save = new JButton("Save");

        save.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myController.writeOnFile(myController.getCurrentFilePath());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(save, "An error has occured", "Error",0);
                }
            }
        });

        final JButton browse = new JButton("Browse");

        browse.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFileChooser fileChooser = new JFileChooser("Choose a file");
                    if(fileChooser.showSaveDialog(browse) == JFileChooser.APPROVE_OPTION) {
                        myController.setCurrentFile(fileChooser.getSelectedFile());
                        pickedFile.setText(myController.getCurrentFilePath());
                        return;
                    } else if(fileChooser.showSaveDialog(browse) == JFileChooser.CANCEL_OPTION) {
                        return;
                    } else {
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
        final int width = (int)screeDimension.getWidth()/5;
        final int height = (int)screeDimension.getHeight()/5;

        frame.setSize(width, height);
        frame.setLocationByPlatform(true);
    }

    public void display() {
        this.frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        final SimpleGUIWithFileChooser myFileChooser = new SimpleGUIWithFileChooser(new Controller());
        myFileChooser.display();
    }

}
