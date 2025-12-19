package sc.queues;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

public class QueueLL {
    ListNode front ;
    ListNode rear;
    private int size;

    QueueLL()
    {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(int val)
    {
        ListNode newNode = new ListNode(val);
        if(rear == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode ;
        }
        size++;
    }

    int poll() throws Exception {
        if(isEmpty()) //Throws an exception if polling from
        {
            throw new Exception("QueueLL is empty.");
        }

        int removedAtA = front.val;
        front = front.next;
        if(front == null)
            rear = null;
        size--;
        return removedAtA;
    }

    boolean isEmpty(){
//        return front == null && rear == null;
        return size == 0;
    }

    int peek() throws Exception {
        if(isEmpty())
            throw new Exception("Nothing to peek");
        return front.val;
    }

    int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueLL qll = new QueueLL();
        qll.add(20);
        qll.add(18);
        qll.add(90);
        qll.add(56);
        System.out.println("Size before peek " + qll.size());

        try {
            System.out.println(qll.peek());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Size after peek " + qll.size());

        try {
            System.out.println(qll.poll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(qll.size());

        System.out.println(qll.isEmpty());
    }
}


