public class P2559 {
    private boolean check(String word) {
        return (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u')
                && (word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u');
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] diff = new int[words.length + 1];
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            if (check(words[i])) {
                cnt++;
            }
            diff[i + 1] = cnt;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = diff[queries[i][1] + 1] - diff[queries[i][0]];
        }
        return result;
    }
}
