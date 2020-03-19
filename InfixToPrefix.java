package infixtoprefix;

public class InfixToPrefix {

    public static void main(String[] args) {
        toPrefix("((5+3)*6/7^3(1-9)+4)^8/2#");
        //(9+2)-(7*1)/2^((8+4*1)/(2-3))*5#
        //((5+3)*6/7^3(1-9)+4)^8/2#
        //a+b/c*(d+e)-f#
    }

    public static void toPrefix(String exp) {
        String reverse = reverse(exp);
        String output = " ";
        String stack = "#";
        System.out.println("Token\tStack\t\tOutput");

        for (int i = 0; i < reverse.length(); i++) {
            char current = reverse.charAt(i);
            int lastStack = stack.length() - 1;
            System.out.print(current + "\t");

            if (Character.isLetterOrDigit(current)) {
                output += current;
            } else if (current == '(') {
                stack += current;
            } else if (current == ')') {
                while (stack.charAt(lastStack) != '(') {
                    output += stack.charAt(lastStack);
                    lastStack -= 1;
                }
                stack = stack.substring(0, lastStack);
            } else {
                while (stack.length() != 1 && getPrec(stack.charAt(lastStack)) >= getPrec(current)) {
                    output += stack.charAt(lastStack);
                    stack = stack.substring(0, lastStack);
                    lastStack = stack.length() - 1;
                }
                if (current == '#') {
                    stack = "";
                }
                stack += current;
            }
            System.out.println(stack + "\t\t" + reverse(output));
        }
    }

    public static String reverse(String input) {
        char[] in = input.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        if(in[in.length-1] == '#'){
            end--;
        }
        char temp;
        while (end > begin) {
            temp = in[begin];
            if (temp == ')') {
                temp = '(';
            } else if (temp == '(') {
                temp = ')';
            }
            in[begin] = in[end];
            if (in[begin] == ')') {
                in[begin] = '(';
            } else if (in[begin] == '(') {
                in[begin] = ')';
            }
            in[end] = temp;
            end--;
            begin++;
        }
        String out = new String(in).replace(" ", "");
        return out;
    }

    // A utility function to return precedence of a given operator 
    // Higher returned value means higher precedence 
    static int getPrec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return 0;
    }
}
