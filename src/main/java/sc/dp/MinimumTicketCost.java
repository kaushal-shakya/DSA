package sc.dp;

public class MinimumTicketCost {
    private static int helper(int start_day, int passIdx, int[] pass, int[] days, int[] costs) {
        if(start_day >= days.length) {
            return 0;
        }

        int min_cost = Integer.MAX_VALUE;
        for(int i = 0 ; i < pass.length; i++) {
            int days_that_could_be_travelled_by_ith_pass = days[start_day] + pass[i];

            int next_travel_day = start_day;
            while(next_travel_day < days.length && days[next_travel_day] < days_that_could_be_travelled_by_ith_pass) {
                next_travel_day++;
            }

            min_cost = Math.min(min_cost, costs[i] + helper(next_travel_day, i, pass, days, costs));
        }

        return min_cost;
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[] pass = {1,7,30};
        int ans = helper(0, 0, pass, days, costs);
        return ans;
    }


    public static void main(String[] args) {
//        int[] days = {1,3,7};
//        int[] costs = {1,4,20};
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};

        System.out.println(mincostTickets(days, costs));
    }
}
