package sc.recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
    public static void main(String[] args) {

            List<int[]> moves = new ArrayList<int[]>();
            solve(1,1,2,3, moves);
            int[][] allMoves = new int[moves.size()][3];
            for(int i = 0; i < allMoves.length; i++){
                for(int j = 0; j < allMoves[i].length; j++)
                {
                    allMoves[i][j]=moves.get(0)[j];
                }
            }
        }



    public static void solve(int disk, int source, int auxiliary, int destination, List<int[]> moves) {

        // Base case: if disk = 1, directly move
        int[] move = new int[3];
        if(disk == 1){
            move = new int[]{disk, 1, 3};
            moves.add(move);
        }

        // For disk > 1:
        // 1. Move n-1 disks to auxiliary
        solve(disk-1, 1, 2, 3, moves);
        move = new int[]{disk - 1, 1, 2};
        moves.add(move);

        // 2. Move nth disk to destination
        solve(disk, 1,2,3, moves);
        move = new int[]{disk, 1, 3};
        moves.add(move);

        // 3. Move n-1 disks from auxiliary to destination
        solve(disk-1, 2, 1, 3, moves);
        move = new int[]{disk - 1, 2, 1};
        moves.add(move);
    }
}
