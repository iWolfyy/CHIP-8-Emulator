package emu;

import chip.Chip;

public class Main {

    public static void main(String[] args) {
        //Creates a 'Chip' object which represents the internal hardware.
        Chip c = new Chip();

        //Initialize Memory, Registers and Display to their starting states. (Initializes 'Chip' Class)
        c.init();

        //c.run();

        //Creates the window (JFrame) and pass the chip to it so it can be drawn
        ChipFrame frame = new ChipFrame(c);


    }
}
