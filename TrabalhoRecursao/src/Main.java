import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trie trie = new Trie();
        String fileName = "C:\\Users\\jhonny.freitas\\Desktop\\TrabalhoRecursao\\src\\dicionario.txt";
        FileReader.readWordsFromFile(fileName, trie);
        System.out.println("Digite um prefixo a ser procurado: ");
        String prefix = scanner.nextLine().toLowerCase();
        System.out.println(trie.autocomplete(prefix));
    }
}
