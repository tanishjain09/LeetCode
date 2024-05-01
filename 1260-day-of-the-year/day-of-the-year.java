class Solution {
    public int dayOfYear(String date) {
        String[] sdate = date.split("-");
        int days = Integer.parseInt(sdate[2]);
        System.out.println(days);
        int total = 0;
        int month = Integer.parseInt(sdate[1]);
        int year = Integer.parseInt(sdate[0]);
        int[] daysinmonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        if(year%4==0 && year % 100 != 0 || year % 400 == 0){
            daysinmonth[2]++;
        }

        // add days
        for(int i = 0; i<month; i++){
            total += daysinmonth[i];
            System.out.println(daysinmonth[i]);
        }


        return total + days;
    }
}