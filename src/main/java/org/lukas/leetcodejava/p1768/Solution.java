package org.lukas.leetcodejava.p1768;

import java.util.stream.IntStream;

public class Solution {
    public String mergeAlternatelyForLoop(String word1, String word2) {
        var result = new StringBuilder();
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
            if (i < word1.length())
                result.append(word1.charAt(i));
            if (i < word2.length())
                result.append(word2.charAt(i));
        }
        return result.toString();
    }
    
    public String mergeAlternatelyForEach(String word1, String word2) {
        var result = new StringBuilder();
        IntStream.range(0, Math.max(word1.length(), word2.length())).forEach(i -> {
            if (i < word1.length())
                result.append(word1.charAt(i));
            if (i < word2.length())
                result.append(word2.charAt(i));
        });
        return result.toString();
    }
    public String mergeAlternatelyFunctional(String word1, String word2) {
        var zipped = IntStream.range(0, Math.min(word1.length(), word2.length()))
                .mapToObj(i -> String.valueOf(word1.charAt(i)) + word2.charAt(i))
                .reduce("", String::concat);
        return zipped + (word1.length() > word2.length() ?
                word1.substring(word2.length()) :
                word2.substring(word1.length()));
    }
}
