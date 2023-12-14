package dfaornek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class DFAOrnek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = readFile("Values.txt");

        for (int j = 0; j < arr.length; j++) {
            controlDFA(arr[j]);
        }
    }

    public static void controlDFA(String arr) {
        Stack<String> stack = new Stack<String>();
        STATES state = STATES.Q0;
        char value;
        int index = 0;
        int i = 0;
        while (index < arr.length()) {
            value = arr.charAt(index);

            if (value != 'a' && value != 'b' && value != 'c') {
                System.out.println("Yanlis karakter girdiniz!");
                System.exit(0);
            }

            if (state == STATES.Q0) {
                if (value == 'a') {
                    stack.push("a");
                    state = STATES.Q1;
                } else {
                    state = STATES.DEATH;
                    break;
                }
            } else if (state == STATES.Q1) {
                if (value == 'a') {
                    stack.push("a");
                } else if (value == 'b') {
                    stack.pop();
                    state = STATES.Q2;
                } else {
                    state = STATES.DEATH;
                    break;
                }
            } else if (state == STATES.Q2) {
                if (value == 'b' && !stack.isEmpty()) {
                    stack.pop();
                } else if (value == 'b' && stack.isEmpty()) {
                    break;
                } else if (value == 'c') {
                    state = STATES.Q3;
                } else {
                    state = STATES.DEATH;
                    break;
                }
            } else if (state == STATES.Q3) {
                if (value == 'c') {
                    state = STATES.Q3;
                } else {
                    state = STATES.DEATH;
                    break;
                }
            }

            index++;
        }

        if (state == STATES.Q3 && stack.isEmpty()) {
            System.out.println(arr + " kelimesi taniniyor.");
        } else {
            System.out.println(arr + " kelimesi taninmiyor.");
        }
    }

    public static String[] readFile(String fileName) {
        File file = new File(fileName);
        Scanner scanner;
        String values = "";
        try {
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                values += scanner.next() + " ";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return values.split(" ");
    }

    enum STATES {
        Q0,
        Q1,
        Q2,
        Q3,
        DEATH
    }

}
