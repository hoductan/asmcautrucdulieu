
public class Queue {
    public int max;
    public char[] Q;
    public int f = 0;
    public int r = 0;
    public int Count=0;

    public Queue(int max, char[] Q) {
        this.max = max;
        this.Q = Q; }



    public int Enum() {
        if ((r + 1) % max == 0) return max;
        else return ((max - f) + r) % max;
    }
    public void enQueue(char x) {
        Q[r] = x;
        Count++;
        if (Enum() != max) {
            r = (r + 1) % max;
        }
    }
    public char deQueue() {
        char dQ = Q[f];
        Count--;
        f = (f + 1) % max;
        return dQ;
    }
}