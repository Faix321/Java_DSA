public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
        LinkedListNode<Integer> previousNode = head;
        int j = 0;
        if (previousNode == null) {
            previousNode = newNode;
            newNode = null;
        } else {
            while (j < pos - 1 && previousNode != null) {
                previousNode = previousNode.next;
                ++j;
            }
            if (previousNode != null) {
                newNode.next = previousNode.next;
                previousNode.next = newNode;
            }
        }

        return head;
    }