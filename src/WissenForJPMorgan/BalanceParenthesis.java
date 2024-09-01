package WissenForJPMorgan;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()" Output: true
Example 2:
Input: s = "()[]{}" Output: true
Example 3:
Input: s = "(]" Output: false
 */
public class BalanceParenthesis {

    public static boolean calculate(String s) {

        Stack<String> stc = new Stack<>();
        String[] splitStr = s.split("");

        for (String str : splitStr) {
            if (str.equals("{") || str.equals("(") || str.equals("["))
                stc.push(str);
            else {
                if (str.equals("}")) {
                    if (!stc.isEmpty() && stc.peek().equals("{"))
                        stc.pop();
                    else
                        return false;
                } else if (str.equals("]")) {
                    if (!stc.isEmpty() && stc.peek().equals("["))
                        stc.pop();
                    else
                        return false;
                } else if (str.equals(")")) {
                    if (!stc.isEmpty() && stc.peek().equals("("))
                        stc.pop();
                    else
                        return false;
                } else
                    return false;
            }
        }

        if(stc.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String s = "(){}[[]";
        System.out.println(BalanceParenthesis.calculate(s));
    }
}
