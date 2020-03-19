package sort;
import java.util.stream.*;
public class BubbleSorting {
    
    public static void main(String[] args){
        
       
        int[] Bubble= IntStream.range(1,101).toArray();
        int temp;
        //JP Code
        boolean sorted=false;
        
        while(sorted==false){
            sorted=true;
            
            for(int i = 0; i<Bubble.length-1; i++){
                if(Bubble[i] > Bubble[i+1]){
                    temp = Bubble[i+1];
                    Bubble[i+1] = Bubble[i];
                    Bubble[i] = temp;
                    
                    sorted=false;
                }
            }
        }
        System.out.print("[ ");
        for(int i=0; i<Bubble.length; i++){
            System.out.print(Bubble[i]+", ");
            //JP Code
        }
        System.out.println("]");
    }
}
//JP Code