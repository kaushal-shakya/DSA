package leetcode.bitmanipulation;

public class HammingWeight {

    public static void main(String[] args) {

        System.out.println(hammingWeight(3));
    }

    //Number of set bits in its binary representation (also known as the Hamming weight).
    public static int hammingWeight(int n) {
        int countOfSetBits = 0;
        for(int i = 0; i < 32; i++){
            if((n & (1 << i)) != 0)
                countOfSetBits++;
        }
        return countOfSetBits;
    }
}
