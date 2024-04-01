import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Trie {

    static class TrieNode {
        char data;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
        // Construtor, Tempo O(1), Spaço O(1)
        TrieNode(char c) {
            this.data = c;
        }
    }

    TrieNode root = new TrieNode(' ');

    // Adiciona uma palavra na arvore, Iteração, Tempo O(s), Spaço O(s) s = tamanho da palavra
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch))
                node.children.put(ch, new TrieNode(ch));
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    // Encontra todas as palavras com o prefixo
    // Tempo O(n), Espaço O(n), n é o numero de nodes envolvidos
    List<String> autocomplete(String prefix) {
        List<String> res = new LinkedList<>();
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children.containsKey(ch))
                node = node.children.get(ch);
            else
                return res;
        }
        helper(node, res, prefix);
        return res;
    }
    // Função RECURSIVA chamada pelo autocomplete
    // Tempo O(n), Espaço O(n), n é número de ramificações
    void helper(TrieNode node, List<String> res, String prefix) {
        if (node.isEnd)
            res.add(prefix);
        for (Character ch : node.children.keySet())
            helper(node.children.get(ch), res, prefix + ch);
    }
}
