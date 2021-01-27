package de.ajutil;

import java.util.Scanner;

public class AJCommunicator {

    private final String WRONG_INPUT = "\nFehlerhafte Eingabe!";
    private final String EMPTY_INPUT = "\nDu musst etwas eingeben!";

    private Scanner sc = new Scanner(System.in);

    public AJCommunicator() {

    }

    public int askInt(String question) {
        while (true) {
            System.out.println(question);

            try {
                int output = Integer.parseInt(sc.nextLine());
                return output;
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT);
            }
        }
    }

    public char askChar(String question) {
        while (true) {
            System.out.println(question);
            String input = sc.nextLine();
            if (input.equals("")) {
                System.out.println(EMPTY_INPUT);
                continue;
            }

            return input.charAt(0);
        }
    }

    public char askChar(String question, char... options) {
        while (true) {
            char output = askChar(question);

            for (int i = 0; i < options.length; i++) {
                if (output == options[i]) {
                    return output;
                }
            }
        }
    }
}
