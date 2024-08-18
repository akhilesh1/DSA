
public class MinStack {
    Stack<int> minSTC;
    Stack<int> curSTC;
    public MinStack() {
        minSTC=new Stack<int>();
        curSTC=new Stack<int>();
    }
    
    public void Push(int val) {
        if(minSTC.Count>0)
            minSTC.Push(Math.Min(val,minSTC.Peek()));
        else
            minSTC.Push(val);
        curSTC.Push(val);
    }
    
    public void Pop() {
        minSTC.Pop();
        curSTC.Pop();
    }
    
    public int Top() {
        return curSTC.Peek();
    }
    
    public int GetMin() {
        return minSTC.Peek();
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
