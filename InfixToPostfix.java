package infixtopostfix;

import java.util.*;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter : ");
        String s = sc.nextLine();
      
    
       
        toPostfix(s+"#");

      
        
        
      
        //(9+2)-(7*1)/2^((8+4*1)/(2-3))*5#
        //((5+3)*6/7^3(1-9)+4)^8/2#
        //a+b/c*(d+e)-f#
    }

    public static void toPostfix(String exp) {
        String output = " ";
        String stack = "#";
        System.out.println("");
        System.out.println("Postfix Table : ");
        System.out.println("Token\tStack\t\tOutput");

        for (int i = 0; i < exp.length(); i++) {
            char current = exp.charAt(i);
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
            
            System.out.println(stack + "\t\t" + output);
           
        }
        System.out.println("");
        System.out.println("Postfix :"+output);
        
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
                return 3;

            case '^':
                return 4;
        }
        return 0;
    }
}