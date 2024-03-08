package hot100.graph_theory;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-07
 */
public class ImplementTrie208 {
    class Trie {
        Trie[] next;
        // 需要一个isEnd字段，用于判断是否为单词结尾
        boolean isEnd;
        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            // 获取根节点
            Trie root = this;
            Trie curr = root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (curr.next[charArray[i]-'a'] != null) {
                    curr = curr.next[charArray[i]-'a'];
                } else {
                    Trie node = new Trie();
                    curr.next[charArray[i]-'a'] = node;
                    curr = curr.next[charArray[i]-'a'];
                }
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            // 获取根节点
            Trie root = this;
            Trie curr = root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (curr.next[charArray[i]-'a'] == null) {
                    return false;
                }
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            // 获取根节点
            Trie root = this;
            Trie curr = root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (curr.next[charArray[i]-'a'] == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
