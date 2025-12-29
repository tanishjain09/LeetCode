class Solution {
    HashMap<String, List<Character>> map = new HashMap<>();
    HashSet<String> deadStrings = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        for (String s : allowed) {
            String pair = s.substring(0, 2);
            char ch = s.charAt(2);
            if(!map.containsKey(pair)) map.put(pair, new ArrayList<>());
            map.get(pair).add(ch);
        }
        return dfs(bottom);
    }

    private boolean dfs(String row) {
        if (row.length() == 1) return true;
        if(deadStrings.contains(row)) return false;
         List<String> nextRow = new ArrayList<>();
        buildNextRows(row, 0, new StringBuilder(), nextRow);

        for (String next : nextRow) {
            if (dfs(next))
                return true;
        }
        deadStrings.add(row);
        return false;
    }

    private void buildNextRows(String row, int idx, StringBuilder sb, List<String> nextRow) {
        if (idx == row.length()-1) {
            nextRow.add(sb.toString());
            return;
        }
        String pair = row.substring(idx, idx + 2);
        if (!map.containsKey(pair))
            return;

        for (char ch : map.get(pair)) {
            sb.append(ch);
            buildNextRows(row, idx + 1, sb, nextRow);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}