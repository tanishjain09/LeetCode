class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int length = 1;
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                String curr = q.poll();
                char[] wordChars = curr.toCharArray();
                for(int j = 0; j < curr.length(); j++){
                    char original = wordChars[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        wordChars[j] = ch;
                        String newWord = new String(wordChars);
                        if(newWord.equals(endWord)) return length+1;
                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordChars[j] = original;
                }
            }
            length++;
        }
        return 0;
    }
}