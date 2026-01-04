package sc.backtrack;

public class KthSymbol {
    public static void main(String[] args) {
//        System.out.println(kthGrammar(30, 434991989)); // This gives OutOfMemoryError, on local machine also
//        System.out.println(solve(30, 434991989L)); // Working on local, Still OutOfMemoryError on online compiler
//        System.out.println(solve(5, 3L));
    }



/* Approach 2 : working fine on local machine
    public static int solve(int A, Long B) {
        String s = helper("0", A-1);
        System.out.println(s);
        char c = s.charAt((int) (B-1));
        System.out.println(c);

        return c-'0';
    }

    public static String helper(String in, int A) {
        if(A == 0)
            return in;

        StringBuilder sb = new StringBuilder(in);
        String s = in.concat(convert(sb));

        return helper(s, A-1);
    }

    public static String convert(StringBuilder sb) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < sb.length(); i++) {

            if(sb.charAt(i) == '0') {
                ans.append('1');
            } else {
                ans.append('0');
            }
        }
        return ans.toString();
    }
*/

/* Approach 1 : Working fine for small B, OutOfMemoryError on local as well
    public static int kthGrammar(int A, int B) {
        int row = A;
        int column = (int) Math.pow(2, A-1);
        int[][] result = new int[row][column];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = -1;
            }
        }
        result[0][0] = 0;
        kthSymbolHelper(result, 1, A);
        return result[A-1][B-1];
    }

    private static void kthSymbolHelper(int[][] result, int idx, int A){

        if(A == idx)
            return;
        int j = 0;
        for(int i = 0; i < (int)Math.pow(2, idx-1); i++){
            if(result[idx-1][i] == 0){
                result[idx][j++] = 0;
                result[idx][j++] = 1;
            }

            if(result[idx-1][i] == 1){
                result[idx][j++] = 1;
                result[idx][j++] = 0;
            }
        }

        kthSymbolHelper(result, idx+1, A);
    }
 */
}
