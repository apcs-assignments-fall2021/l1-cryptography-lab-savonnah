import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        int chnum = (int) (ch);
            if (chnum >= 97 && chnum <= 122) {
                int newchnum = chnum - 'a';
                int originalplace = newchnum + key;
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'a'); //go back to original place
                return newch;
            }
            else if (chnum >= 65 && chnum <= 90) {
                int newchnum = chnum - 'A';
                int originalplace = newchnum + key;
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'A'); //go back to original place
                return newch;
            }
            else {
                return ch;
            }
    }

    public static char decryptCaesarLetter(char ch, int key) {
        int chnum = (int) (ch);
        if (chnum >= 97 && chnum <= 122) {
            int newchnum = chnum - 'a';
            int originalplace = newchnum - (key%26);
            int origplace = originalplace + 26;
            int newplace = origplace % 26;
            char newch = (char) (newplace + 'a'); //go back to original place
            return newch;
        }
        else if (chnum >= 65 && chnum <= 90) {
            int newchnum = chnum - 'A';
            int originalplace = newchnum - (key%26);
            int origplace = originalplace + 26;
            int newplace = origplace % 26;
            char newch = (char) (newplace + 'A'); //go back to original place
            return newch;
        }
        else {
            return ch;
        }
    }

    public static String encryptVigenere(String message, String key) {
        int length = message.length();
        String newstr = "";
        int currentindex = 0;
        for (int x = 0; x < length; x++) {
            int chnum = message.charAt(x);
            if ((chnum >= 'A' && chnum <= 'Z') || (chnum >= 'a' && chnum <= 'z') ) {
                newstr = newstr + encryptCaesarLetter((message.charAt(x)), key.charAt(currentindex) - 'A');

                if (currentindex < (key.length() - 1)) {
                    currentindex += 1;
                } else {
                    currentindex = 0;

                }
            }
            else {
                newstr = newstr + (char) chnum;
            }
        }
        return newstr;
    }

    public static String decryptVigenere(String message, String key) {
        int length = message.length();
        String newstr = "";
        int currentindex = 0;
        for (int x = 0; x < length; x++) {
            int chnum = message.charAt(x);
            if ((chnum >= 'A' && chnum <= 'Z') || (chnum >= 'a' && chnum <= 'z') ) {
                newstr = newstr + decryptCaesarLetter((message.charAt(x)), key.charAt(currentindex) - 'A');

                if (currentindex < (key.length() - 1)) {
                    currentindex += 1;
                } else {
                    currentindex = 0;

                }
            }
            else {
                newstr = newstr + (char) chnum;
            }
        }
        return newstr;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
        System.out.println("Encrypting 'a' by 5 should give 'f', and got: " + encryptCaesarLetter('a', 5));
        System.out.println("Encrypting 'y' by 8 should give 'g', and got: " + encryptCaesarLetter('y', 8));
        System.out.println("Encrypting 'A' by 4 should give 'E', and got: " + encryptCaesarLetter('A', 4));
        System.out.println("Encrypting 'Z' by 3 should give 'C', and got: " + encryptCaesarLetter('Z', 3));
        System.out.println("Encrypting '#' by 5 should give '#', and got: " + encryptCaesarLetter('#', 5));
        System.out.println();
        System.out.println("Decrypting 'f' by 5 should give 'a', and got: " + decryptCaesarLetter('f', 5));
        System.out.println("Decrypting 'g' by 8 should give 'y', and got: " + decryptCaesarLetter('g', 8));
        System.out.println("Decrypting 'E' by 4 should give 'A', and got: " + decryptCaesarLetter('E', 4));
        System.out.println("Decrypting 'C' by 3 should give 'Z', and got: " + decryptCaesarLetter('C', 3));
        System.out.println("Decrypting '#' by 5 should give '#', and got: " + decryptCaesarLetter('#', 5));
        */

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
