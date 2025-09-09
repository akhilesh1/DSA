public class Solution {
    public int CarFleet(int target, int[] position, int[] speed) {
        int n = position.Length;
        var cars = position.Zip(speed, (p, s) => (p, s)).OrderBy(c => c.p).ToList();
        var stack = new Stack<double>();
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - cars[i].p) / cars[i].s;
            //stack is relevant here just to chech one car ahead.
            // time is current car time taken to reach target
            //if current time taken is greter then just ahead car it will form a new fleet
            if(stack.Count==0 || stack.Peek()<time)// if 
                stack.Push(time);
        }
        return stack.Count; //total fleets
    }
}
