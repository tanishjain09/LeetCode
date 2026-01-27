class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000")) return -1;

        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.add("0000");

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String curr = q.poll();

                if(curr.equals(target)) return count;


                StringBuilder currCombination = new StringBuilder(curr);

                for(int idx = 0; idx < 4; idx++){
                    char original = currCombination.charAt(idx);

                    char nextChar = (char) ((original-'0' + 1) % 10 + '0');
                    currCombination.setCharAt(idx, nextChar);
                    String nextCombination = currCombination.toString();
                    if(!dead.contains(nextCombination)){
                        q.add(nextCombination);
                        dead.add(nextCombination);
                    }

                    char prevChar = (char) ((original-'0'+9) % 10 + '0');
                    currCombination.setCharAt(idx, prevChar);
                    nextCombination = currCombination.toString();

                    if(!dead.contains(nextCombination)){
                        q.add(nextCombination);
                        dead.add(nextCombination);
                    }

                    currCombination.setCharAt(idx, original);
                }
            }
            count++;
        }
        return -1;
    }
}