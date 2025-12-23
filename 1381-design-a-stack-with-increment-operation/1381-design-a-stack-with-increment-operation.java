class CustomStack {
    int[] arr;
    int count = 0;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(count < arr.length) {
            arr[count] = x;
            ++count;
        }
        return;
    }
    
    public int pop() {
        int val;
        if(count == 0) {
            val = -1;
        } else {
            val = arr[count - 1];
            --count;
        }
        return val;
    }
    
    public void increment(int k, int val) {
        if(k > count) {
            for(int i = 0; i < count; i++) {
                arr[i] = arr[i] + val;
            }
        } else {
            for(int i = 0; i < k; i++) {
                arr[i] = arr[i] + val;
            }
        }
        return;
    }
}

