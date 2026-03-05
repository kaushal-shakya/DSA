package sc.dp.stringdp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    static List<String> se = new ArrayList<>();
    private static void helper(String s, List<String> dict, int sIdx, int eIdx) {
        if(eIdx == s.length()+1) {
            return ;
        }

        String currStr = s.substring(sIdx, eIdx);

        if(dict.contains(currStr)) {
            se.add(currStr);
            if(dict.contains(s.substring(eIdx, s.length()))) {
                se.add(s.substring(eIdx, s.length()));
                return;
            }
            helper(s, dict, eIdx, eIdx+1);
        } else {
            helper(s, dict, sIdx, eIdx+1);
        }

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        helper(s, wordDict, 0, 1);
        System.out.println(se);

        int len = 0;
        for(int i = 0; i < se.size(); i++) {
            len += se.get(i).length();
        }

        if (len == s.length())
            return true;

        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        System.out.println(wordBreak("leetcode", wordDict ));

//        wordDict.add("apple");
//        wordDict.add("pen");
//        System.out.println(wordBreak("applepenapple", wordDict ));

//        wordDict.add("a");
//        wordDict.add("b");
//        wordDict.add("bbb");
//        wordDict.add("bbbb");
//        System.out.println(wordBreak("bb", wordDict ));

//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
//        System.out.println(wordBreak("catsandog", wordDict));


//        wordDict.add("apple");
//        wordDict.add("pear");
//        wordDict.add("peach");
//        System.out.println(wordBreak("apple", wordDict ));

        wordDict.add("go");
        wordDict.add("goal");
        wordDict.add("goals");
        wordDict.add("special");
        System.out.println(wordBreak("goalspecial", wordDict ));

    }
}
