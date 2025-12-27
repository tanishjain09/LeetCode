class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0],b[0]));
        long[] lastAvailableAt = new long[n];
        int[] roomUsedCount = new int[n];

        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;
            long earlyEndingRoomTime = Long.MAX_VALUE;
            int earlyEndingRoom = 0;
            boolean found = false;

            for(int room = 0; room< n; room++){
                if(lastAvailableAt[room] <= start){
                    lastAvailableAt[room] = end;
                    roomUsedCount[room]++;
                    found = true;
                    break;
                }
                if(lastAvailableAt[room] < earlyEndingRoomTime){
                    earlyEndingRoomTime = lastAvailableAt[room];
                    earlyEndingRoom = room;
                }
            }
            if(!found){
                    lastAvailableAt[earlyEndingRoom] += duration;
                    roomUsedCount[earlyEndingRoom]++;
                }
        }
        int resultRoom = -1;
        int maxUse = 0;
        for(int room = 0; room < n; room++){
            if(roomUsedCount[room] > maxUse){
                maxUse = roomUsedCount[room];
                resultRoom = room;
            }
        }
        return resultRoom;
    }
}