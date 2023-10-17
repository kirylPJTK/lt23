package SomeIntro.TASK3;

import java.security.SecureRandom;
import java.util.Scanner;

public class PaswordGenerator {
    private static final String LOWERCASE_LATTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LATTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=<>?";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password generator: ");
        System.out.println("Input your password length");
        int passwordLength = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Use small letters (a-z) ? (yes/no)");
        boolean useLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Use upper letters (A-Z) ? (yes/no)");
        boolean useUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Use digits (0-9) ? (yes/no)");
        boolean useDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Use special signs (!,@,#,$,%,^,&,*,(,),_,-,+,=,<,>,?) ? (yes/no)");
        boolean useSigns = scanner.nextLine().equalsIgnoreCase("yes");

        String validCharacters = "";
        if (useLowercase) validCharacters += LOWERCASE_LATTERS;
        if (useUppercase) validCharacters += UPPERCASE_LATTERS;
        if (useDigits) validCharacters += DIGITS;
        if (useSigns) validCharacters += SPECIAL_CHARACTERS;

        if (validCharacters.isEmpty()) {
            System.out.println("ERROR no chosen symbols");
            return;
        }

        String generatedPassword = generatePasswod(passwordLength, validCharacters);
        System.out.println("Generated password: " + generatedPassword);

    }

    private static String generatePasswod(int length, String validCharacters) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            password.append(randomChar);
        }
        return password.toString();
    }
}
