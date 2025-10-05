import java.util.Arrays;

class kQueues {
    int[] arr;       
    int n, k;             
    int[] front;    
    int[] rear;      

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
    }
    
    // Function to check if queue 'qn' is empty
    boolean isEmpty(int qn) {
        return (front[qn] == -1);
    }
    
    // Function to check if queue 'qn' is full
    boolean isFull(int qn) {
        int nextPos = (rear[qn] + 1) % (n / k);
        return (nextPos == front[qn] % (n / k) && front[qn] != -1);
    }
    
    // Function to enqueue 'x' into queue 'qn'
    boolean enqueue(int x, int qn) {
        if (isFull(qn))
            return false;

        int base = qn * (n / k);
        if (isEmpty(qn))
            front[qn] = base;

        rear[qn] = (rear[qn] == -1) ? 
            base : 
            base + (rear[qn] + 1 - base) % (n / k);
        arr[rear[qn]] = x;

        return true;
    }
    
    // Function to dequeue from queue 'qn'
    int dequeue(int qn) {
        if (isEmpty(qn))
            return -1;

        int base = qn * (n / k);
        int x = arr[front[qn]];

        if (front[qn] == rear[qn]) {
            front[qn] = -1;
            rear[qn] = -1;
        } else {
            front[qn] = base + (front[qn] + 1 - base) % (n / k);
        }

        return x;
    }
}

public class GfG {
    public static void main(String[] args) {
        int n = 10, k = 3;
        kQueues queues = new kQueues(n, k);

        System.out.print(queues.enqueue(10, 0) + " "); 
        System.out.print(queues.enqueue(20, 1) + " "); 
        System.out.print(queues.enqueue(30, 0) + " "); 
        System.out.print(queues.enqueue(40, 2) + " "); 

        System.out.print(queues.dequeue(0) + " ");     
        System.out.print(queues.dequeue(1) + " ");     
        System.out.print(queues.dequeue(2) + " ");     
        System.out.print(queues.dequeue(0) + " ");     
        System.out.print(queues.dequeue(0) + " ");     
    }
}
