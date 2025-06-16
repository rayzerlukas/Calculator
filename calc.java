import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class calc { 
    public int evaluate(String input) {
        String temp = removeSpaces(input);
        if (checkInput(temp)) {
            return calculate(toPostfix(tokenize(temp)));
        } else {
            throw new IllegalArgumentException("Invalid input: only numbers and operators are allowed. Please try again.");
        }
    }

    private String removeSpaces(String input) {
        String temp;
        temp = input.replace(" ", "");
        //
        System.out.println("without spaces: " + temp);
        //
        return temp;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '*' || c == '-' || c == '/';
    }

    private boolean checkInput(String input) {
        for (int i=0; i<input.length(); i++) {
            if (!isOperator(input.charAt(i)) && !Character.isDigit(input.charAt(i)) && !(input.charAt(i)=='(') && !(input.charAt(i)==')')) {
                return false;
            } 
        }
    return true;
    }

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
        for (String l: output) {
            System.out.println(l);
        }
        // testing

        // (3+3)(3+3) to (3+3)*(3+3)
        String prevString = "";
        for (int x = 0; x < output.size(); x++ ) {
             if (prevString.equals(")") && !isOperator(output.get(x).charAt(0)) && output.get(x).charAt(0)!=')') {
                output.add(x, "*");
                x++;
             } else if (!prevString.isEmpty() && Character.isDigit(prevString.charAt(0)) && output.get(x).equals("(")) {
                output.add(x, "*");
                x++;
             } else if (prevString.equals(")") && output.get(x).equals("(")) {
                output.add(x, "*");
                x++;     
             }
             prevString=output.get(x);
        }
             
    return output;
    }
    

        private int checkPrecedence(String a) {
            switch (a) {
                case "*":
                    return 2;
                case "/":
                    return 2;
                case "+":
                    return 1;
                case "-":
                    return 1;
                default:
                    break;
            }
            return 0;
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
        for (String a: output) {
            System.out.println("postifx: " + a);
        }    
        return output;
    }

    private int calculate(List<String> input) {
        Stack<String> temp = new Stack<>();
        for(String x: input) {
            if (x.length() == 1 && isOperator(x.charAt(0))) {
                int b = Integer.parseInt(temp.pop());
                int a = Integer.parseInt(temp.pop());
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
                        temp.push(String.valueOf(a/b));
                        break;
                    default:
                        break;
                }
            } else {
                temp.push(x);
            }
        }
        return Integer.parseInt(temp.pop());
    }
}
    
