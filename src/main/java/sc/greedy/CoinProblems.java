package sc.greedy;

import java.util.ArrayList;

public class CoinProblems {

    public static int solve(int A) {
            int i = 0;
            ArrayList<Integer> denominations = new ArrayList<>();

            while(Math.pow(5,i) <= A) {
                denominations.add((int)Math.pow(5,i));
                i++;
            }
            int denominationsIdx = denominations.size()-1;
            int coins = 0;
            int temp = A;
            while(temp > 0 ) {
                if(denominations.get(denominationsIdx) > temp) {
                    denominationsIdx--;
                    continue;
                }

                int currentDenominationsValue = temp / denominations.get(denominationsIdx);
                coins += currentDenominationsValue;
                temp %= denominations.get(denominationsIdx);
                denominationsIdx--;
            }

            return coins;
        }

    public static void main(String[] args) {
        System.out.println(solve(355779795));
    }

}
