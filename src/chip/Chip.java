package chip;

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

    }

    public void run() {
        //fetch opcode (get the 2byte opcode from memory at the current program counter (pc)
        //We shift the first byte left by 8 bitts and combine it with the second byte
        char opcode = (char)((memory[pc] << 8) | memory[pc + 1]);
        System.out.println(Integer.toHexString(opcode));

        //Decode and Execute Opcode: Determine what the opcode means
        switch(opcode) {
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

}
