import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Transfer myTransfer = new Transfer();
        System.out.println("Enter your message (Max: " + myTransfer.messageLimit + " character): ");
        Scanner input = new Scanner(System.in);
        String source = input.nextLine();

        boolean key = true;
        while (key) {
            if (source.length() <= 0) {

                System.out.println("Your input is empty, please input again to send message!\n");
                System.out.println("Enter your message (Max: " + myTransfer.messageLimit + " character): ");
                source = input.nextLine();
            } else if (source.length() <= myTransfer.messageLimit && source.length() != 0) {
                key = false;
                // Send Message
                long start = System.nanoTime();
                myTransfer.SendMessage(source);
                long elapsedTime = System.nanoTime() - start;
                //Show Message
                System.out.println();
                myTransfer.ShowMessage();
                //Show time execution
                System.out.println("\nExecution Time (Buffer = " + myTransfer.maxBuffer + "): " + elapsedTime);
            } else {

                key = false;
                //Show error
                System.out.println();
                System.out.println("Your input too long (" + source.length() + "), we just send message with max " + myTransfer.messageLimit + " characters!");

                //Send Message
                long start = System.nanoTime();
                myTransfer.SendMessage(source);
                long elapsedTime = System.nanoTime() - start;
                //Show Message
                System.out.println();
                myTransfer.ShowMessage();
                //Show time execution
                System.out.println("\nExecution Time (Buffer = " + myTransfer.maxBuffer + "): " + elapsedTime);
            }

        }

    }
}