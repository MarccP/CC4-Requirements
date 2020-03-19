package booleantraining;

import java.io.*;

public class BooleanTraining {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter start point: ");
        int sp = Integer.parseInt(br.readLine());
        
        System.out.print("Enter end point: ");
        int ep = Integer.parseInt(br.readLine());
        
        for(int i = sp;i <= ep;i+=1){
            if(!multiples(i))
               System.out.println(i);
        }

    }
    
    public static boolean multiples(int num){
    int ep = 0;
    for(int x = 1;x <= ep;x+=1){
        
    
        if(num % x == 0)
            return true;
        else
            return false;
    }
        
    }
    
}
