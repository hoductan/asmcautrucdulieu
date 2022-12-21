class Transfer {
    public String destination="";
    String subDestination = "";
    // Setup maximum buffer public
    int maxBuffer = 50;
    // Setup limit characters of Message
    public int messageLimit = 250;
    public Transfer() {
    }

    public void SendMessage(String source) {
        Queue myQueue = new Queue(maxBuffer, new char[250]);
        Stack myStack = new Stack();
        int n = 0;
        try {

            while (n < source.length() && n < messageLimit) {

                while (myQueue.Count <= maxBuffer) {
                    if (n == messageLimit) {
                        break;
                    }
                    myQueue.enQueue(source.charAt(n));
                    n++;
                }
                //When buffer is full!
                while (myQueue.Count != 0) {
                    myStack.push(myQueue.deQueue());
                }

                while (myStack.Count != 0) {
                    subDestination = myStack.pop() + subDestination;
                }
                destination = destination + subDestination;
                subDestination = "";

            }

        } catch (Exception e) {
            subDestination = "";

            while (myQueue.Count != 0) {
                myStack.push(myQueue.deQueue());
            }

            while (myStack.Count != 0) {
                subDestination = myStack.pop() + subDestination;
            }
            destination = destination + subDestination;

        }

    }

    public void ShowMessage() {

        System.out.println("Your message: "+destination);
        System.out.println("\nNumber of character: "+destination.length());
    }

}