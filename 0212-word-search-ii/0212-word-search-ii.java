class Trie{
    Trie links[] = new Trie[26];
    boolean isEnd = false;
    String word;
}
class Solution {
    int n;
    int m;
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        Trie root = buildTrie(words);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(root.links[board[i][j]-'a'] != null){
                    dfs(i, j, board, root);
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, char[][] board, Trie node){
        if(r < 0 || r >= n || c < 0 || c >= m) return;
        char ch = board[r][c];
        if(ch == '#' || node.links[ch-'a'] == null) return;
        node = node.links[ch-'a'];
        if(node.isEnd){
            res.add(node.word);
            node.isEnd = false;
        }
        board[r][c] = '#';
        dfs(r+1,c,board,node);
        dfs(r-1,c,board,node);
        dfs(r,c+1,board,node);
        dfs(r,c-1,board,node);
        board[r][c] = ch;
    }

    private Trie buildTrie(String[] words){
        Trie root = new Trie();

        for(String s : words){
            Trie node = root;
            for(char ch : s.toCharArray()){
                if(node.links[ch-'a'] == null){
                    node.links[ch-'a'] = new Trie();
                }
                node = node.links[ch-'a'];
            }
            node.isEnd = true;
            node.word =s;
        }
        return root;
    }

}