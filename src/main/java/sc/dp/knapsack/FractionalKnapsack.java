package sc.dp.knapsack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int happiness;
    int weight;

    public Pair(int happiness, int weight) {
        this.happiness = happiness;
        this.weight = weight;
    }
}

class FractionKnapsackIntermediate {

    private BigDecimal helper(Pair[] p, int capacity) {
        BigDecimal ans = BigDecimal.ZERO;
        for (Pair item : p) {
            if(item.weight <= capacity) {
                ans = ans.add(BigDecimal.valueOf(item.happiness));
                capacity -= item.weight;
            } else {
                BigDecimal fraction = BigDecimal.valueOf(capacity)
                        .divide(BigDecimal.valueOf(item.weight), 10, RoundingMode.HALF_UP);
                ans = ans.add(BigDecimal.valueOf(item.happiness).multiply(fraction));
                break;
            }
        }
        return ans;
    }

    int solve(int[] happiness, int[] weight, int capacity)
    {
        Pair[] pair = new Pair[happiness.length];
        for (int i = 0; i < happiness.length; i++) {
            Pair p = new Pair(happiness[i], weight[i]);
            pair[i] = p;
        }

        Arrays.sort(pair, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                double o1HappinessPerWeight = (o1.happiness * 1.0 / o1.weight);
                double o2HappinessPerWeight = (o2.happiness * 1.0 / o2.weight);

                if(o1HappinessPerWeight < o2HappinessPerWeight)
                    return 1;
                else if ( o1HappinessPerWeight > o2HappinessPerWeight)
                    return -1;
                else
                    return 0;
            }
        });

        BigDecimal result = helper(pair, capacity).multiply(BigDecimal.valueOf(100));
        return result.setScale(0, RoundingMode.FLOOR).intValue();
    }
}


public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] happiness = {16,3,3,6,7,8,17,13,7};
        int[] weight = {3,10,9,18,17,17,6,16,13};
        int capacity = 11;
//        int[] happiness = {3};
//        int[] weight = {20};
//        int capacity = 17;
//        int[] happiness = {2,7};
//        int[] weight = {11,3};
//        int capacity = 7;

        FractionKnapsackIntermediate fki = new FractionKnapsackIntermediate();
        System.out.println(fki.solve(happiness, weight, capacity));
    }
}
