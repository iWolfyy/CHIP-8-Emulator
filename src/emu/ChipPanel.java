package emu;

import javax.swing.*;
import chip.Chip;
import java.awt.*;

public class ChipPanel extends JPanel {

    private Chip chip;

    public ChipPanel(Chip chip) {
        this.chip = chip; // Store reference to the chip to read its display array
    }

    //This Method is called by Java whenever the screen needs to refresh.
    public void paint(Graphics g){
        byte[] display = chip.getDisplay();// Get the current pixel data

        // Loop through every single pixel in the 2,048-pixel array
        for(int i = 0; display.length > i; i++){
            //If the value is 0 the pixel is 'off' (Black)
            if(display[i] == 0){
                g.setColor(Color.BLACK);
            }

            //If the value is 1 the pixel is 'on' (White)
            else{
                g.setColor(Color.WHITE);
            }

            //Convert the 1D index (i) into 2D Coordinates (x,y)
            //x is the remainder of i / 64 (The Column)
            int x = (i % 64);

            //y is how many full rows of 64 we have completed
            int y = (int)Math.floor(i / 64);

            //Draw a 10x10 block for every chip 8 pixel (and scaling it up)
            //multiply x and y by 10 so the pixels dont overlap
            g.fillRect(x * 10, y * 10, 10, 10);

        }
    }

}
