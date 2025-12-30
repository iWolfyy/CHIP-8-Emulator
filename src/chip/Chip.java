package chip;

public class Chip {

    private char[] memory;  //Main Memory
    private char[] V;       //Data Registers
    private char I;         //Address Register
    private char pc;        //Program Counter

    private char stack[];
    private int stackPointer;

    private int delay_timer;
    private int sound_timer;

    private byte[] keys;    //Key Mappings

    private byte[] display;

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
        //fetch opcode
        char opcode = (char)((memory[pc] << 8) | memory[pc + 1]);
        System.out.println(Integer.toHexString(opcode));
        //decode opcode
        switch(opcode) {
            default:
                System.out.println("Unsupported Opcode!");
                System.exit(0);

        }
            //execute opcode
    }

    public byte[] getDisplay() {
        return display;
    }

}
