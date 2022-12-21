public class Stack {
    public static char[] stackArray = new char[255];
    public static int top = -1;
    public static int Count=0;

    public static void push(char x) {

        if (top == 251) {
            System.out.println("Array full");

        } else {

            top++;
            Count++;
            stackArray[top] = x;
        }
    }
    public static char pop() {
        char x;
        if (top < 0) {
            x = (char) -1;
        } else {
            x = stackArray[top];
            top--;
            Count--;
        }
        return x;
    }

}