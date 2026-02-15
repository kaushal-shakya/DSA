package sc.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        int[] idxVisit = new int[s.length()];
        Arrays.fill(idxVisit, -1);

        for(String word : wordDict) {
            int sIdx = s.indexOf(word);
            int lIdx = sIdx + word.length();

            if(sIdx == -1)
                    return false;

            int sIdxNum = idxVisit[sIdx];
            while(sIdx < lIdx) {
                if(idxVisit[sIdx] != sIdxNum) {
                    return false;
                }
                idxVisit[sIdx] = 1;
                sIdx++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "catsandog";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
//        String s = "a";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("b"));
        String s = "bb";
        List<String> wordDict = new ArrayList<>(Arrays.asList("a","b","bbb","bbbb"));
        System.out.println(wordBreak(s,wordDict));
    }
}
