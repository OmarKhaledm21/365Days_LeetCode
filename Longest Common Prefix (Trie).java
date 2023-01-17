class Solution {
    class TrieNode {
        boolean word;
        int counter;
        TrieNode[] child;


        public TrieNode() {
            counter = 1;
            word = false;
            child = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public boolean isEnd() {
            return word;
        }

        public TrieNode get(char chr) {
            int range_pos = chr - 'a';
            return child[range_pos];
        }

        public void put(char chr, TrieNode node) {
            int range_pos = chr - 'a';
            child[range_pos] = node;
        }

        public boolean containsKey(char chr) {
            int range_pos = chr - 'a';
            return child[range_pos] != null;
        }


    }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode current = root;
            int gcount = 0;
            int length = word.length();
            for (int x = 0; x < length; x++) {
                char chr = word.charAt(x);
                TrieNode node = current.get(chr);
                if (node == null) {
                    node = new TrieNode();
                    current.put(chr, node);
                } else {
                    gcount++;
                }
                current = node;
            }
            current.setWord(true);

            return gcount;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        Trie trie = new Trie();

        int x = Integer.MAX_VALUE;
        int cur = trie.insert(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            cur = trie.insert(strs[i]);
            if (cur < x) {
                x = cur;
            }
        }
         if (x == 0 || x==Integer.MAX_VALUE) {
            return "";
        }
        
        return strs[0].substring(0, x);
    }

}