package randommethod;

import java.io.*;

public class RandomMethod {
   

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Min. Number : ");
        int min = Integer.parseInt(br.readLine());
        
        System.out.print("Enter Max. Number : ");
        int max = Integer.parseInt(br.readLine());
        
        if(min > max){
            System.err.println("ERROR : Try Again!");
          
        }

        getRandom(max,min);

       
    }
    public static int getRandom(int max,int min){
        int x = (int) (Math.random()*((max-min))+1);
        
        System.out.println("The Generated Random Number From "+min+" To "+max+" is : "+x);
        return x;
    }
    
}
