/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Note: stack with no element throw error on peek and pop.
*/
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
