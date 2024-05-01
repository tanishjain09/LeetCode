class Solution {
    public String reformatDate(String date) {
      String[] olddate = date.split(" ");
        int day = Integer.parseInt(olddate[0].replaceAll("[^\\d.]", ""));
        String mymonth = olddate[1];
        String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int years = Integer.parseInt(olddate[2]);
        int finalmonth = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<mon.length; i++){
            if(mymonth.equals(mon[i])){
                finalmonth = i + 1;
            }
        }

        // year 
        sb.append(years + "-");

        //month
        if(finalmonth<10){
            sb.append("0" + finalmonth + "-");
        }else{
            sb.append(finalmonth + "-");
        }


        //days
        if(day<10){
            sb.append("0" + day);
        }else{
            sb.append(day);
        }

        return sb.toString();
    }
}