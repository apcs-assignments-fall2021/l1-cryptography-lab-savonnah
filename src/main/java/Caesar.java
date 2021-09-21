import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        int length = message.length();
        String newstr = "";
        for (int i = 0; i < length; i++) {
            int chnum = message.charAt(i);
            if (chnum >= 97 && chnum <= 122) {
                int newchnum = chnum - 'a';
                int originalplace = newchnum + 3;
                int newplace = originalplace % 26;
                char newch = (char) (newplace + 'a'); //go back to original place
                newstr = newstr + newch;
            }
            else if  (chnum >= 65 && chnum <= 90) {
                int newchnum = chnum - 'A';
                int originalplace = newchnum + 3;
                int newplace = originalplace % 26;
                char newch = (char) (newplace + 'A'); //go back to original place
                newstr = newstr + newch;
            }
            else {
                newstr = newstr + (char)chnum;
            }
        }
        return newstr;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        int length = message.length();
        String newstr = "";
        for (int i = 0; i < length; i++) {
            int chnum = message.charAt(i);
            if (chnum >= 97 && chnum <= 122) {
                int newchnum = chnum - 'a';
                int originalplace = newchnum - (3%26);
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'a'); //go back to original place
                newstr = newstr + newch;
            }
            else if (chnum >= 65 && chnum <= 90) {
                int newchnum = chnum - 'A';
                int originalplace = newchnum - (3%26);
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'A'); //go back to original place
                newstr = newstr + newch;
            }
            else {
                newstr = newstr + (char) chnum;
            }
        }
        return newstr;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key){
        int length = message.length();
        String newstr = "";
        for (int i = 0; i < length; i++) {
            int chnum = message.charAt(i);
            if (chnum >= 97 && chnum <= 122) {
                int newchnum = chnum - 'a';
                int originalplace = newchnum + key;
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'a'); //go back to original place
                newstr = newstr + newch;
            }
            else if (chnum >= 65 && chnum <= 90) {
                int newchnum = chnum - 'A';
                int originalplace = newchnum + key;
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'A'); //go back to original place
                newstr = newstr + newch;
            }
            else {
                newstr = newstr + (char) chnum;
            }
        }
        return newstr;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey (String message,int key){
        int length = message.length();
        String newstr = "";
        for (int i = 0; i < length; i++) {
            int chnum = message.charAt(i);
            if (chnum >= 97 && chnum <= 122) {
                int newchnum = chnum - 'a';
                int originalplace = newchnum - (key%26);
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'a'); //go back to original place
                newstr = newstr + newch;
            }
            else if (chnum >= 65 && chnum <= 90) {
                int newchnum = chnum - 'A';
                int originalplace = newchnum - (key%26);
                int origplace = originalplace + 26;
                int newplace = origplace % 26;
                char newch = (char) (newplace + 'A'); //go back to original place
                newstr = newstr + newch;
            }
            else {
                newstr = newstr + (char) chnum;
            }
        }
        return newstr;
    }


        // The main method is already provided for you
        // You do not need to edit this code until Part 2
        public static void main (String[]args){
            Scanner scan = new Scanner(System.in);

            System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
            String command = scan.nextLine().trim().toLowerCase();
            /*
            if (command.equals("encrypt")) {
                System.out.println("Please enter your message to be encrypted: ");
                String message = scan.nextLine();
                System.out.println("Here is your encrypted message: ");
                System.out.println(encryptCaesar(message));
            } else if (command.equals("decrypt")) {
                System.out.println("Please enter your message to be decrypted: ");
                String message = scan.nextLine();
                System.out.println("Here is your decrypted message: ");
                System.out.println(decryptCaesar(message));
            } else {
                System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
            }
            */
            if (command.equals("encrypt")) {
                System.out.println("Please enter your message to be encrypted: ");
                String message = scan.nextLine();
                System.out.println("Please enter the key for your message: ");
                int num = scan.nextInt();
                System.out.println("Here is your encrypted message: ");
                System.out.println(encryptCaesarKey(message, num));
            } else if (command.equals("decrypt")) {
                System.out.println("Please enter your message to be decrypted: ");
                String message = scan.nextLine();
                System.out.println("Please enter the key for your message: ");
                int numdiff = scan.nextInt();
                System.out.println("Here is your decrypted message: ");
                System.out.println(decryptCaesarKey(message, numdiff));
            } else {
                System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
            }
            scan.close();
        }
    }
