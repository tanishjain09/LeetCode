class NumArray {
    int n;
    int[] segTree;
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        buildSegTree(0, 0, n-1, segTree, nums);
    }
    private void buildSegTree(int i, int l, int r, int[] segTree, int[] nums){
        if(l == r){
            segTree[i] = nums[l];
            return;
        }    
        int mid = l+(r-l)/2;
        buildSegTree(2*i+1, l, mid, segTree, nums);
        buildSegTree(2*i+2, mid+1, r, segTree, nums);

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];        
    }
    
    public void update(int index, int val) {
        updateSegTree(0, index, val, 0, n-1);
    }
    private void updateSegTree(int i, int index, int val, int l, int r){
        if(l == r){
            segTree[i] = val;
            return;
        }

        int mid = l + (r-l) / 2;
        if(index <= mid){
            updateSegTree(2*i+1, index, val, l, mid);
        }else{
            updateSegTree(2*i+2, index, val, mid+1, r);
        }
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, 0, 0, n-1);
    }
    private int query(int left, int right, int i, int l, int r){
        if(l > right || r < left) return 0;

        if(l >= left && r <= right){
            return segTree[i];
        }
        int mid = l + (r-l) / 2;
        
        return query(left, right, 2*i+1, l, mid) + query(left, right, 2*i+2, mid+1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */