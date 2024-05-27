class QueueEmptyException extends Exception {
}

class QueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    public int size;

    QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int elem) {
        if (size == data.length) {
            doubleCapacity();
        }
        if (isEmpty()) {
            ++front;
        }

        // concept of circular queue from line 39 to 49

        // technique 1 :
        // ++rear;
        // if (rear == data.length) {
        // rear = 0;
        // }

        // technique 2 :
        rear = (rear + 1) % data.length;

        // concept of circular queue end
        data[rear] = elem;
        ++size;
    }

    private void doubleCapacity() {
        System.out.println("Double Capacity Method Activated");
        int[] temp = data;
        data = new int[2 * temp.length];
        int index = 0;
        for (int i = front; i < temp.length; ++i) {
            data[index++] = temp[i];
        }
        for (int i = 0; i < front - 1; ++i) {
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length - 1;
    }

    public int front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }

        int delElem = data[front];

        // concept of circular queue from line 77 to 87

        // technique 1 :
        // if (front == data.length) {
        // front = 0;
        // }

        // technique 2 :
        front = (front + 1) % data.length;

        // concept of circular queue end

        --size;

        if (isEmpty()) {
            front = -1;
            rear = -1;
        }

        return delElem;
    }

}

public class CircularQueueUsingArrayUse {
    public static void main(String[] args) throws QueueEmptyException {
        QueueUsingArray queue = new QueueUsingArray(2);
        System.out.println(queue.isEmpty());
        queue.enqueue(10);
        System.out.println(queue.front());
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.size());
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.size());
        int getSize = queue.size();
        System.out.println(queue.isEmpty());
        // for(int i = 0; i < queue.size(); ++i){
        for (int i = 0; i < getSize; ++i) {
            // for(int i = 0; i < 5; ++i){
            System.out.println(queue.dequeue());
        }
    }
}
