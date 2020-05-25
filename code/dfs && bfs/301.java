class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        if (isValid(s)) {
            res.add(s);
            return res;
        }
        HashSet<String> set = new HashSet();
        set.add(s);
        while (!set.isEmpty()) {
            for (String tmpS: set) {
                if (isValid(tmpS)) {
                    res.add(tmpS);
                }
            }
            if (!res.isEmpty()) return res;
            HashSet<String> nextSet = new HashSet();
            for (String tmpS: set) {
                for (int i = 0; i < tmpS.length(); i++) {
                    if (tmpS.charAt(i) == '(' || tmpS.charAt(i) == ')') {
                        nextSet.add(tmpS.substring(0, i) + tmpS.substring(i+1, tmpS.length()));
                    }
                }
            }
            set = nextSet;
        }

        return res;
    }

    private boolean isValid(String s) {
        int countP = 0;
        for (char a: s.toCharArray()) {
            if (a == '(') countP += 1;
            else {
                if (a == ')') countP -= 1;
                if (countP < 0) return false;
            }
        }
        return countP == 0;

    }
}