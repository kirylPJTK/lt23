package SomeIntro.TASK1;

import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class CezarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any word you want: ");
        String enteredWord = scanner.nextLine();

        System.out.println("Enter shift value: ");
        int shift = scanner.nextInt();

        System.out.println("Enter direction (0 for left, 1 for right): ");
        boolean direction = scanner.nextInt() == 1;

        String encryptedWord = EncryptDecrypt.encrypt(enteredWord, shift, direction);
        System.out.println("Encrypted word: " + encryptedWord);

        String decryptedWord = EncryptDecrypt.decrypt(encryptedWord, shift, direction);
        System.out.println("Decrypted word: " + decryptedWord);
    }
}

class EncryptDecrypt {
    public static String encrypt(String word, int shift, boolean right) {
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int newChar = base + (right ? (c - base + shift) : (c - base - shift + 26)) % 26;
                result.append((char) newChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decrypt(String word, int shift, boolean right) {
        return encrypt(word, shift, !right);
    }
}
