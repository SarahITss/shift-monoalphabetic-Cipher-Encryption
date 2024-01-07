package informationsecurityproject;

import java.util.Scanner;

public class InformationSecurityProject {

    public static char normalChar[]
            = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static char codedChar[]
            = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
                'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
                'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the plaintext message: ");
        String plaintext = input.nextLine();
        for (int i = 0; i < plaintext.length(); i++) {
            plaintext = plaintext.toUpperCase();

        }

        System.out.print("Enter the value by which each character in the plaintext message gets shifted : ");
        int shift = input.nextInt();

        /*
        System.out.print("Enter the ciphertext message: ");
        String ciphertext = input.next();
        for (int i = 0; i < ciphertext.length(); i++) {
            ciphertext = ciphertext.toUpperCase();

        }
         */
        shiftCipherEncryption(plaintext, shift);
        //shiftCipherDecryption(ciphertext, shift);
    }

    public static void shiftCipherEncryption(String plaintext, int shift) {
        String ciphertext = "";
        char alphabet;

        for (int i = 0; i < plaintext.length(); i++) {

            plaintext = plaintext.toLowerCase();

            // Shift one character at a time
            alphabet = plaintext.charAt(i);

            // if alphabet lies between a and z 
            if (alphabet >= 'a' && alphabet <= 'z') {
                // shift alphabet
                alphabet = (char) (alphabet + shift);
                // if shift alphabet greater than 'z'
                if (alphabet > 'z') {
                    // reshift to starting position 
                    alphabet = (char) (alphabet + 'a' - 'z' - 1);
                }
                ciphertext = ciphertext + alphabet;
            }
        }

        System.out.println("The ciphrtText: " + ciphertext);

        System.out.println("ENCRYPTION- The ciphertext: " + monoalphabeticCipherEncryption(ciphertext));

        System.out.println("DECRYPTION- The plaintext: " + decrypt(ciphertext, shift));
        ;

    }

    public static void shiftCipherDecryption(String ciphertext, int shift) {
        String plaintxt = "";
        char alphabet;

        for (int i = 0; i < ciphertext.length(); i++) {

            ciphertext = ciphertext.toLowerCase();

            // Shift one character at a time
            alphabet = ciphertext.charAt(i);
            // if alphabet lies between a and z 
            if (alphabet >= 'a' && alphabet <= 'z') {
                // shift alphabet
                alphabet = (char) (alphabet - shift);

                // shift alphabet lesser than 'a'
                if (alphabet < 'a') {
                    //reshift to starting position 
                    alphabet = (char) (alphabet - 'a' + 'z' + 1);
                }
                plaintxt = plaintxt + alphabet;
            }
        }

        System.out.println("The PlainText: " + plaintxt);

    }

    public static String monoalphabeticCipherEncryption(String pciphertext) {

        // initializing an empty String
        String encryptedString = "";

        // comparing each character of the string and
        // encoding each character using the indices
        for (int i = 0; i < pciphertext.length(); i++) {
            for (int j = 0; j < 26; j++) {

                // comparing the character and
                // adding the corresponding char
                // to the encryptedString
                if (pciphertext.charAt(i) == normalChar[j]) {
                    encryptedString += codedChar[j];
                    break;
                }
            }
        }
        return encryptedString;
    }

    public static void monoalphabeticCipherDecryption(String ciphertext) {

        String dncryptedString = "";

        for (int i = 0; i < ciphertext.length(); i++) {

            for (int j = 0; j < 26; j++) {

                if (ciphertext.charAt(i) == codedChar[j]) {
                    dncryptedString += normalChar[j];
                    break;
                }
            }
        }

        System.out.println("The plainText mono: " + dncryptedString);

    }

    public static String decrypt(String ciphertext, int shift) {

        
        String dncryptedString = "";

        for (int i = 0; i < ciphertext.length(); i++) {

            for (int j = 0; j < 26; j++) {

                if (ciphertext.charAt(i) == codedChar[j]) {
                    dncryptedString += normalChar[j];
                    break;
                }
            }
        }

        //System.out.println("The plainText mono: " + dncryptedString);
        String plaintxt = "";
        char alphabet;


        for (int i = 0; i < ciphertext.length(); i++) {

            ciphertext = ciphertext.toLowerCase();

            // Shift one character at a time
            alphabet = ciphertext.charAt(i);
            // if alphabet lies between a and z 
            if (alphabet >= 'a' && alphabet <= 'z') {
                // shift alphabet
                alphabet = (char) (alphabet - shift);

                // shift alphabet lesser than 'a'
                if (alphabet < 'a') {
                    //reshift to starting position 
                    alphabet = (char) (alphabet - 'a' + 'z' + 1);
                }
                plaintxt = plaintxt + alphabet;
            }
        }

        return plaintxt;

    }

}
