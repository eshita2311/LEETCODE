class MyQueue {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!s.isEmpty()) {
            helper.push(s.pop());
        }
        s.push(x);
        while(!helper.isEmpty()) {
            s.push(helper.pop());
        }
    }
    
    public int pop() {
        return s.pop();
    }
    
    public int peek() {
         return s.peek();
    }
    
    public boolean empty() {
        if(s.isEmpty()) {
            return true;
        }
        return false;
    }
}