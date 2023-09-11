# [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-interview-150)

## 👉 문제 이해
- trie 자료구조를 구현해야 합니다.
    
## 👉 접근 방식
### 1. map을 사용하여 tree구조를 사용합니다.
### 2. for 문을 사용합니다.

---

## ✅ 나의 코드

```java
class Trie {

    private Node root;

    public Trie() {
        this.root = new Node();     
    }
    
    public void insert(String word) {
       Node cur = this.root;

       for(char c : word.toCharArray()){
           if(!cur.children.containsKey(c)){
               cur.children.put(c,new Node());
           }
           cur = cur.children.get(c);
       }

       cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = this.root;

        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }

        if(cur.isEnd){
            return true;
        }

        return false;
    }

    
    public boolean startsWith(String prefix) {
        Node cur = this.root;
        for(int i = 0; i < prefix.length(); i++){
            if(!cur.children.containsKey(prefix.charAt(i))){
                return false;
            }
            cur = cur.children.get(prefix.charAt(i));
        }

        return true;
    }

}
 public class Node{
       public Map<Character, Node> children;
        public boolean isEnd;

        public Node(){
            this.children = new HashMap<>(26);
            this.isEnd = false;
        }
}

```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(n)`

---

## 📖 다른 풀이
### 재귀 함수 활용
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(n)`
  
```java
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (idx == word.length()-1) nodes[i].isEnd = true;
            nodes[i].insert(word, idx+1);
        }

        private boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == word.length() - 1 && node.isEnd) return true;

            return node.search(word, idx+1);

        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == prefix.length() - 1) return true;

            return node.startsWith(prefix, idx+1);
        }
    }
}

```
> 재귀귀를 활용하여 트리를 탐색하는 구조를 더 생각해봐야 할 것 같습니다.
---

## 👉 회고
- trie 자료구조를 학습할 수 있었습니다.
  ​​​
