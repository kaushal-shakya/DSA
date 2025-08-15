package scaler.queues;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    void add(int val)
    {
        stack1.push(val);
        size++;
    }

    int poll() throws Exception {
        if(isEmpty())
            throw new Exception("Queue is empty, can't poll.");
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        int val = stack2.pop();
        size--;
        return val;
    }

    int peek() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty, can't peek");
        if(stack2.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    int size()
    {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingStack qs = new QueueUsingStack();
        qs.add(34);
        qs.add(21);
        qs.add(67);
        System.out.println(qs.size());
        try {
            System.out.println(qs.poll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(qs.size());
        try {
            System.out.println(qs.poll());
            System.out.println(qs.poll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(qs.size());
        try {
            qs.peek();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
