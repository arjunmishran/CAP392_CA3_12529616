// LeetCode 2114 - Maximum Number of Words Found in Sentences
// Topic: Strings
class Solution {
    public int mostWordsFound(String[] sentences) {
        int maximum = 0;
        for (String sentence : sentences) {
            int words = sentence.trim().isEmpty()
                    ? 0 : sentence.trim().split("\\s+").length;
            maximum = Math.max(maximum, words);
        }
        return maximum;
    }
}
