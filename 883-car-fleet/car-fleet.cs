public class Solution {
    public int CarFleet(int target, int[] position, int[] speed) {
        int n = position.Length;
        var cars = new List<(int p, int s)>();
        for (int i = 0; i < n; i++) cars.Add((position[i], speed[i]));
        cars.Sort((a, b) => a.p.CompareTo(b.p));

        int fleets = 0;
        double lastTime = -1;
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - cars[i].p) / cars[i].s;
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
            // else this car catches up to the fleet ahead
        }
        return fleets;
    }
}
