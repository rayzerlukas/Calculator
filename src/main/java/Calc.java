import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Calc { 
    public String evaluate(String input) {
        String temp = removeSpaces(input);
        if (checkInput(temp)) {
            return calculate(toPostfix(addMissingMultiplication(removeAddition(tokenize(temp)))));
        } else {
            throw new IllegalArgumentException("Invalid input: only numbers and operators are allowed. Please try again.");
        }
    }

    private String removeSpaces(String input) {
        String temp;
        temp = input.replace(" ", "");
        //
//        System.out.println("without spaces: " + temp);
        //
        return temp;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '*' || c == '-' || c == '/';
    }

    // whitelist for allowed characters
    private boolean checkInput(String input) { 
        for (int i=0; i<input.length(); i++) {
            if (!isOperator(input.charAt(i)) && !Character.isDigit(input.charAt(i)) && !(input.charAt(i)=='(') && !(input.charAt(i)==')') && !(input.charAt(i)=='.')) {
                return false;
            } 
        }
    return true;
    }

    // tokenizes one input String: ("7+3") --> ("7","+","3")
    private List<String> tokenize(String input) {
        List<String> output = new ArrayList<>();
        String temp = "";
        char prevChar ='\0';
        for (char i: input.toCharArray()) {
            if (Character.isDigit(i) || i=='.') {
                temp += i;
            } else if (i == '-' && (isOperator(prevChar) || prevChar == '\0' || prevChar == '(' || prevChar == ')')) {
                temp += i;
            } else {
                if (!temp.isEmpty()) {
                    output.add(temp);
                }
                temp = "";
                output.add(String.valueOf(i));
            }
            prevChar =i;
        }
        if (!temp.isEmpty()) {
            output.add(temp);
        }
        // testing
//        System.out.println("tokenized:");
//        for (String l: output) {
//            System.out.println(l);
//        }
        // testing
    return output;
    }  

        // adds missing *: (3+3)(3+3) to (3+3)*(3+3)
        // cases:
        // 1(
        // )(
        // )1
    private List<String> addMissingMultiplication(List<String> output) {
        String prevString = "";

        for (int i =0; i < output.size(); i++) {

            if (i>0) {
                prevString=output.get(i-1);
                boolean NumberOrClose = isNumber(prevString) || prevString.equals(")");
                boolean NumberOrOpen = output.get(i).equals("(") || isNumber((output.get(i)));
                if (NumberOrClose && NumberOrOpen) {
                    output.add(i, "*");
                    i++; //skip added *
                }
            }
            prevString = output.get(i);
        }
        return output;
    }

    private boolean isNumber(String test) {
        if (test.isEmpty()) return false;
        if (Character.isDigit(test.charAt(0))) return true;
        if (test.length()>1 && Character.isDigit(test.charAt(1))) return true;
        if (test.length()>2 && Character.isDigit(test.charAt(2))) return true;
        return false;
    }

        // removes additional + in beginning or after parentheses: "+3-4" -> "3-4"
    private List<String> removeAddition(List<String> output) {
        if (output.get(0).equals("+")) {
            output.remove(0);
        }

        List<Integer> del = new ArrayList<>();
        String prevString = output.get(0);
        for (int x = 1; x < output.size(); x++) {    
            if (prevString.equals("(") && output.get(x).equals("+")) {
                del.add(x);
            }
            prevString = output.get(x);
        } 
        int count = 0;
        while (!del.isEmpty()) {
            output.remove(del.removeFirst() - count);
            count++;
        }
    return output;
    }
    
        // returns precedence value of operator
    private int checkPrecedence(String a) {
        return switch (a) {
             case "*", "/" -> 2;
             case "+", "-"-> 1;
             default -> 0;
        };
    }

    private List<String> toPostfix(List<String> input) {            
        Stack<String> temp = new Stack<>();
        List<String> output = new ArrayList<>();
        for (String i: input) {
            if (i.length() > 1) { // only numbers, exluding 1 digit numbers, including negatives
                output.add(i);
            } else if (Character.isDigit((i.charAt(0)))) {
                output.add(i);
            } else if (i.equals("(")) { // start parenthesis
                 temp.push(i);
            } else if (i.equals(")")) { // end parenthesis
                while (!temp.isEmpty() && !temp.peek().equals("(")) {
                    output.add(temp.pop());
                }
                temp.pop();
            } else if (isOperator(i.charAt(0)))  {
                while (!temp.isEmpty() && checkPrecedence(temp.peek()) >= checkPrecedence(i) && !temp.peek().equals("(")) {
                    output.add(temp.pop()); 
                    }
                temp.push(i);
            }
        }
        while (!temp.isEmpty()) {
            output.add(temp.pop());
        } 
//        System.out.println("postfix:");
//   for (String a: output) {
//        System.out.println(a);
//   }    
    return output;
    }

    private String calculate(List<String> input) {
        Stack<String> temp = new Stack<>();
        for(String x: input) {
            if (x.length() == 1 && isOperator(x.charAt(0))) {
                double b = Double.parseDouble(temp.pop());
                double a = Double.parseDouble(temp.pop());
                switch (x) {
                    case "+":
                        temp.push(String.valueOf(a+b));
                        break;
                    case "-":
                        temp.push(String.valueOf(a-b));
                        break;
                    case "*":
                        temp.push(String.valueOf(a*b));
                        break;
                    case "/":
                        if (b==0) {
//                          System.out.println("No divison by 0!");
                            break;
                        }
                        temp.push(String.valueOf(a/b));
                        break;
                    default:
                        break;
                }
            } else {
                temp.push(x);
            }
        }
        return temp.pop();
    }
}