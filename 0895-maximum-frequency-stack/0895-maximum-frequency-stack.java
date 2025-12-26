class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> m;
    int maxFreq;
    public FreqStack() {
        this.freq = new HashMap<>();
        this.m = new HashMap<>();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0)+1;
        freq.put(val, f);
        maxFreq = Math.max(f, maxFreq);
        if(!m.containsKey(f)) m.put(f, new Stack<>());
        m.get(f).add(val);
    }
    
    public int pop() {
        int x = m.get(maxFreq).pop();
        freq.put(x, maxFreq-1);
        if(m.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */