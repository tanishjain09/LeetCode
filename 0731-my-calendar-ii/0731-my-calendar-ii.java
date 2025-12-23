class MyCalendarTwo {

    List<int[]> doubleBooking = new ArrayList<>();
    List<int[]> overAllBooking = new ArrayList<>();
    
    public MyCalendarTwo() {
        
    }
    private boolean isOverLapping(int start1, int end1, int start2, int end2){
        return Math.max(start1, start2) < Math.min(end1 , end2);
    }
    public boolean book(int startTime, int endTime) {
        //check for triple booking
        for(int[] ov : doubleBooking){
            if(isOverLapping(ov[0], ov[1], startTime, endTime)){
                return false;
            }
        }
        //add in the booking and doublebooking range in list
        for(int[] booking : overAllBooking){
            if(isOverLapping(booking[0], booking[1], startTime, endTime)){
                int overlapStart = Math.max(booking[0], startTime);
                int overlapEnd = Math.min(booking[1], endTime);
                doubleBooking.add(new int[]{overlapStart, overlapEnd});
            }
        }
        overAllBooking.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */