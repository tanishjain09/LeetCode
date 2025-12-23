class MyCalendar {
    TreeSet<int[]> books = new TreeSet<int[]>((a,b)->a[0]-b[0]);
    public MyCalendar() {
    }
    
    public boolean book(int startTime, int endTime) {
        int[] book = new int[]{startTime, endTime};
        int[] floor = books.floor(book);
        int[] ceiling = books.ceiling(book);
        if(floor !=null && startTime < floor[1]) return false;
        if(ceiling != null && ceiling[0] < endTime) return false;
        books.add(book);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */