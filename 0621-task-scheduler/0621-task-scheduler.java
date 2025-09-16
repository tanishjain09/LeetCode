class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char t : tasks){
            freq[t - 'A']++;
        }
        int fMax = 0;
        for(int f: freq){
            fMax = Math.max(f, fMax);
        }
        int maxCount = 0;
        for(int f : freq){
            if(f == fMax) maxCount++;
        }

        int minIntervals = (fMax -1) * (n+1) + maxCount;
        return Math.max(minIntervals, tasks.length);
    }
}