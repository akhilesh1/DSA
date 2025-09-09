public class Solution {
    public int CarFleet(int target, int[] position, int[] speed) {
        int n = position.Length;
        var cars = position.Zip(speed, (p, s) => (p, s)).OrderBy(c => c.p).ToList();
        var stack = new Stack<double>();
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - cars[i].p) / cars[i].s;
            stack.Push(time);
            if (stack.Count > 1 && stack.Peek() <= stack.ElementAt(1)) 
                stack.Pop();
        }
        return stack.Count;
    }
}
