class MinStack {

    private LinkedList<Value> stack;

    public MinStack() {
       stack = new LinkedList<Value>();
    }
    
    public void push(int val) {
        int min;
        if(stack.size() == 0){
          min = val;
        }else{
          int curMin = stack.getFirst().min;
          min = val < curMin ? val : curMin;
        }
        stack.addFirst(new Value(val, min));
    }
    
    public void pop() {
        stack.removeFirst();
    }
    
    public int top() {
        return stack.peekFirst().val;
    }
    
    public int getMin() {
        return stack.peekFirst().min;
    }

    static class Value {
      int val;
      int min;

      public Value(int val, int min){
        this.val = val;
        this.min = min;
      }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */