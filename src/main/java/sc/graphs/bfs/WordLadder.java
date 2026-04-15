package sc.graphs.bfs;

import java.util.*;

public class WordLadder {
    class WordPair {
        String word;
        int wordNumber;

        WordPair(String word, int wordNumber) {
            this.word = word;
            this.wordNumber=wordNumber;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }

        Queue<WordPair> q = new LinkedList<>();
        q.add(new WordPair(beginWord, 1));
        int ans = 0;
        while(!q.isEmpty()) {
            WordPair wp = q.remove();
            String currentWord = wp.word;
            int currWordNumber = wp.wordNumber;
            if(currentWord.equals(endWord))
                ans = currWordNumber;

            for (int i = 0; i < currentWord.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char ch = (char)('a' + j ) ;
                    String newStr = currentWord.substring(0, i) + ch + currentWord.substring(i + 1);
                    if(set.contains(newStr)) {
                        q.add(new WordPair(newStr, currWordNumber+1));
                        set.remove(newStr);
                    }
                }
            }
        }
        return ans;
    }
}

class WordLadderMain {
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
}
