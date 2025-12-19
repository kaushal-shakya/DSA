package sc.recursion;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(solve1(1291));
    }

    //first approach, mistakes are present
    public static int solve0(int A) {
        int sum = 0;
        if(A == 1){
            return 1;
        }//Below else block is 101% incorrect, it will make below code unreachable
//        else{
//            return 0;
//        }

        while(A != 0)
        {
            sum += A%10;
            A = A/10;
        }

        if(sum > 1 && sum < 10)
        {
            return 0;
        }else {
            return solve0(sum);
        }
    }

    //correct approach after making changes to first approach
    public static int solve1(int A) {
        int sum = 0;
        if(A == 1){
            return 1;
        }

        while(A > 10)
        {
            sum += A%10;
            A = A/10;
        }
        // If sum is not single digit between 1 and 10, check if it's a magic number otherwise return 0 because it is not a magic number
        if(sum > 1 && sum < 10)
        {
            return 0;
        }else {
            return solve1(sum);
        }
    }

    //efficient approach
//    TODO: Implement this efficient approach, using properties of 9 divisibility
//    public static int solve2(int A) {
//
//    }
}
