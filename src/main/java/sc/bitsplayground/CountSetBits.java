package sc.bitsplayground;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(numSetBits(45));
    }

    public static int numSetBits(int A) {
        int setbits = 0;
        for(int i = 0; i < 32; i++){
            int ans = A & (1 << i);

            if(ans != 0)
                setbits++;

        }
        return setbits;
    }
}
