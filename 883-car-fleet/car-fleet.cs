public class Solution {
    public int CarFleet(int target, int[] position, int[] speed) {
        int n = position.Length;
        var cars = position.Zip(speed, (p, s) => (p, s)).OrderBy(c => c.p).ToList();
        var stack = new Stack<double>();
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - cars[i].p) / cars[i].s;
            
            if(stack.Count==0 || stack.Peek()<time)
                stack.Push(time);
        }
        return stack.Count;
    }
}
