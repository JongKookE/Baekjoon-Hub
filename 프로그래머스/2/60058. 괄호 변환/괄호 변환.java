import java.util.*;

class Solution {
        public String solution(String p) {
            String answer = "";
            if(p.isEmpty()) return answer;
            if(isCurrectParenthesis(p)) return p;
            String[] uAndV = seperateParenthesis(p);
            String u = uAndV[0];
            String v = uAndV[1];

            if(isCurrectParenthesis(u)) return u + solution(v);
            else return "(" + solution(v) + ")" + reverseParenthesis(u);
        }

        String reverseParenthesis(String s) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < s.length()-1; i++){
                char ch = s.charAt(i);
                if(ch == '(') sb.append(')');
                else sb.append('(');
            }
            return sb.toString();
        }

        String[] seperateParenthesis(String p) {
            Deque<Character> stack = new ArrayDeque<>();
            for(char ch : p.toCharArray()) stack.addLast(ch);
            StringBuilder u = new StringBuilder();
            StringBuilder v = new StringBuilder();
            int openParenthesis = 0, closeParenthesis = 0;

            while(!stack.isEmpty()){
                char ch = stack.pollFirst();
                if(ch == '(') openParenthesis++;
                else if(ch == ')') closeParenthesis++;
                u.append(ch);

                if(openParenthesis == closeParenthesis) {
                    while(!stack.isEmpty()) v.append(stack.pollFirst());
                }
            }
            if(isCurrectParenthesis(u.toString())) seperateParenthesis(v.toString());
            
            return new String[]{u.toString(), v.toString()};
        }

        boolean isCurrectParenthesis(String p){
            Deque<Character> stack = new ArrayDeque<>();
            stack.addLast(p.charAt(0));
            for(int i = 1; i < p.length(); i++){
                char ch = p.charAt(i);
                if(stack.isEmpty()){
                    if(ch == ')') return false;
                    if(ch == '(') stack.addLast(ch);
                }
                else{
                    if(stack.peekLast() == '(' && ch == ')') stack.pollLast();
                    else stack.addLast(ch);
                }
            }
            return stack.isEmpty();
        }

    }