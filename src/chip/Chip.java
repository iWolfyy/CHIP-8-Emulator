package chip;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Chip {

    private char[] memory;  //4096KB Main Memory
    private char[] V;       //16 x 8bit Data Registers
    private char I;         //Address Registers (Used for Memory Operations)
    private char pc;        //Program Counter (Stores Current Instruction Address)

    private char stack[];   //Remembers where to return after a subroutine call
    private int stackPointer; //Points to the current top of the stack

    private int delay_timer; //Used for game timing
    private int sound_timer; //Beeps when non zero

    private byte[] keys;    //Key Mappings

    private byte[] display; //Video Ram (64x32 = 2048 pixels)

    private boolean needRedraw;

    public void init() {
        memory = new char[4096];
        V = new char[16];
        I = 0x0;
        pc = 0x200;

        stack = new char[16];
        stackPointer = 0;

        delay_timer = 0;
        sound_timer = 0;

        keys = new byte[16];

        display = new byte[64 * 32];

        needRedraw = false;

    }

    public void run() {
        //fetch opcode (get the 2byte opcode from memory at the current program counter (pc)
        //We shift the first byte left by 8 bitts and combine it with the second byte
        char opcode = (char)((memory[pc] << 8) | memory[pc + 1]);
        System.out.println(Integer.toHexString(opcode));

        //Decode and Execute Opcode: Determine what the opcode means
        switch(opcode & 0xF000) {

            case 0x1000:
                break;

            case 0x2000:
                break;

            case 0x3000:
                break;

            case 0x7000:
                break;

            case 0x8000:

                switch(opcode & 0x000F) {
                    case 0x0000:
                    default:
                        System.err.println("Unsupported Opcode!");
                        System.exit(0);
                        break;

                }

                break;

                default:
                // If the code hits an instruction it doesn't know, it stops the program
                System.out.println("Unsupported Opcode!");
                System.exit(0);

        }
            //execute opcode
    }


    // Helper method to let the UI access the screen data
    public byte[] getDisplay() {
        return display;
    }

    public boolean needsRedraw() {
        return needRedraw;
    }

    public void removeDrawFlag() {
        needRedraw = false;
    }

    public void loadProgram(String file) {
        DataInputStream input = null;

        try {
             input = new DataInputStream(new FileInputStream(new File(file)));

            int offset = 0;
            while(input.available() > 0) {

                memory[0x200 + offset] = (char)(input.readByte() & 0xFF);
                offset++;
            }

        } catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch (IOException e) {}
            }
        }
    }
}
