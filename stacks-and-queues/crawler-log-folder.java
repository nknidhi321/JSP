// https://leetcode.com/problems/crawler-log-folder/

class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        stack.push("Main");
        int n = logs.length;
        for(int i = 0; i < n; i++) {
            String command = logs[i];
            if(command.equals("../")) {
                if(stack.peek().equals("Main")) continue;
                else stack.pop();
            }
            else if(command.equals("./")) {
                continue;
            }
            else {
                stack.push(command);
            }
        }
        return stack.size() - 1; // -1 to Remove "Main"
    }
}
