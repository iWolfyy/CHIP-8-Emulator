package emu;

import chip.Chip;

import javax.swing.*;
import java.awt.*;

public class ChipFrame extends JFrame {

    private ChipPanel panel;

    public ChipFrame(Chip c) {
        //Sets the size of the Drawing Area (64 pixels scaled by 10 = 640)
        setPreferredSize(new Dimension(640,320));
        pack(); //Calculate the window size

        // Adjust size to include window borders/title bar (Insets)
        setPreferredSize(new Dimension(640 + getInsets().left + getInsets().right,320 + getInsets().top + getInsets().top + getInsets().bottom));

        // Create the drawing panel and add it to the window
        panel = new ChipPanel(c);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Stop program when window is closed
        setTitle("Chip-8 Emulator");
        pack();
        setVisible(true); // Show the window
    }

}
