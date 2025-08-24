class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        this.input = new Stack();
        this.output = new Stack();
    }

    public void push(int x) {
        this.input.push(x);
    }

    public int pop() {
        this.peek();
        return this.output.pop();
    }

    public int peek() {
        if (this.output.isEmpty()) {
            while (!this.input.isEmpty()) {
                this.output.push(this.input.pop());
            }
        }
        return this.output.peek();
    }

    public boolean empty() {
        return this.input.isEmpty() && this.output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */