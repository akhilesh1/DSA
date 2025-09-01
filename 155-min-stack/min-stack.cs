public class MinStack {

    Stack<int> normalStack;
    Stack<int> minStack;
    //-2, 0,-3
    //-2,-2,-3


    public MinStack() {
        normalStack=new();
        minStack=new();
    }
    
    public void Push(int val) {
        normalStack.Push(val);
        if(minStack.Count==0)
            minStack.Push(val);
        else
            minStack.Push(Math.Min(val,minStack.Peek()));
    }
    
    public void Pop() {
        normalStack.Pop();
        minStack.Pop();
    }
    
    public int Top() {
        return normalStack.Peek();
    }
    
    public int GetMin() {
        return minStack.Peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(val);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */