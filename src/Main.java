import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello, type a word or a phrase.");

        editHistory();
    }

    private static void editHistory() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String words = scanner.nextLine();
        System.out.println("Do you want to copy, delete, or undo?");


        Stack<String> stack = new Stack<>();
        stack.push(words);
        String holdsWhatWasDeleted = "";
        Stack<String> undoStack = new Stack<>();
        boolean quit = true;

        while (quit) {

            String input = scanner.next();
            //System.out.println(stack.pop());
            switch (input) {
                case "copy":
                    stack.push(words);
                    System.out.println(stack.toString());
                    break;


                case "delete":
                    try {
                         undoStack.push(stack.pop());
                        System.out.println(stack.toString());
                        break;


                    } catch (EmptyStackException emptyStack){
                        System.out.println("empty stack ");
                        break;
                    }





                case "undo":
                    try {
                        stack.push(undoStack.pop());
                        System.out.println(stack.toString());
                        break;
                    } catch (EmptyStackException undoS){
                        System.out.println("nothing to undo ");
                    }




                case "quit":
                    quit= false;


                    break;
            }


        }
    }
}