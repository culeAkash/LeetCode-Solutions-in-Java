/*
static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };
*/
//Function to insert string into TRIE.


static boolean containsKey(TrieNode node,char ch){
    return node.children[ch-'a']!=null;
}


static void put(TrieNode node,char ch,TrieNode newNode){
    node.children[ch-'a'] = newNode;
}

static void setEnd(TrieNode node){
    node.isEndOfWord = true;
}

static TrieNode get(TrieNode node,char ch){
    return node.children[ch-'a'];
}

static boolean isEnd(TrieNode node){
    return node.isEndOfWord;
}

static void insert(TrieNode root, String key) 
{
    TrieNode node = root;
    
    for(int i=0;i<key.length();i++){
        if(!containsKey(node,key.charAt(i))){
            put(node,key.charAt(i),new TrieNode());
        }
        node = get(node,key.charAt(i));
    }
    
    setEnd(node);
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    TrieNode node = root;
    
    for(int i=0;i<key.length();i++){
        if(!containsKey(node,key.charAt(i))){
            return false;
        }
        node = get(node,key.charAt(i));
    }
    
    if(isEnd(node))
        return true;
    
    return false;
}