package SomeIntro.TASK1;

import java.util.List;
import java.util.Scanner;

public class CezarCipher {
    public static void main(String[] args) {
//        for (int i = 75; i < 150; i++) {
//            System.out.println(i + " - " + (char)i);
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any word you wanna: ");
        String enterWord = scanner.nextLine();
//        System.out.println(enterWord);

        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        System.out.println("Encrypted word: " + encryptDecrypt.encrypt(enterWord, 3, false));
        System.out.println("Decrypted word: " + encryptDecrypt.decrypt(3));
    }
}

class EncryptDecrypt{
    private String word;
    private int shift;
    private boolean side;

    private String resultEncrypt;
    private String resultDecrypt;

    // boolean side == if true -> right; if false -> left;
    public String encrypt(String word, int shift, boolean side) {
        this.word = word;
        this.shift = shift;
        this.side = side;
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                if (side) {
                    result.append((char) (base + (c - base + shift) % 26));

                } else {
                    result.append((char) (base + (c - base - shift) % 26));
                }
            } else {
                result.append(c);
            }
        }
        resultEncrypt = result.toString();

        return resultEncrypt;
    }

    public String decrypt(int shift) {
        this.shift = shift;
        StringBuilder result = new StringBuilder();

        for (char c : resultEncrypt.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                if (side) {
                    result.append((char) (base + (c - base - shift) % 26));
                } else {
                    result.append((char) (base + (c - base + shift) % 26));
                }

            } else result.append(c);
        }
        resultDecrypt = result.toString();
        return resultDecrypt;
    }


}
