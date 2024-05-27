class StackFullException extends Exception{
}

class StackEmptyException extends Exception{}

class StackUsingArray {
    private int[] data;
    private int topIndex;

    StackUsingArray() {
        data = new int[2];
        topIndex = -1;
    }

    // public void push(int elem) throws StackFullException {
    public void push(int elem) {
        //if stack is full
        if(topIndex == data.length - 1){
            //Throw Exception
            // StackFullException e = new StackFullException();
            // throw e;
            // throw new StackFullException();
            doubleCapacity();
        }
        data[++topIndex] = elem;
    }

    private void doubleCapacity(){
        System.out.println("doubleCapacity method activated");
        int[] temp = data;
        data = new int[temp.length * 2];
        for(int i = 0; i < temp.length; ++i){
            data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException {
        if(topIndex == -1){
            //Throw StackEmptyException
            throw new StackEmptyException();
        }
        int delElem = data[topIndex];
        --topIndex;
        return delElem;
    }

    public int top() throws StackEmptyException {
        if(topIndex == -1){
            //Throw StackEmptyException
            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    public int size() {
        // int count = 0;
        // for (int i = 0; i < topIndex; ++i) {
        //     ++count;
        // }
        return topIndex + 1;
    }

    public boolean isEmpty() {
        // if (topIndex == -1)
        //     return true;
        // else
        //     return false;
        return topIndex == -1;
    }
}

public class StackUsingArrayUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException{
        StackUsingArray obj = new StackUsingArray();
        boolean ans = obj.isEmpty();
        System.out.println(ans);
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        int popItem = obj.pop();
        System.out.println(popItem);
        obj.top();
        obj.push(50);
        obj.size();
        boolean ans1 = obj.isEmpty();
        System.out.println(ans1);
    }
}
