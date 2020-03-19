package mergesortversion2;
import java.util.*;
public class MergeSortVersion2 {
    

    public static void main(String[] args) {
        int []Merge; 
        Merge = new int[101];
        
        for(int i = 1; i<101; i++){
            Merge[i] = i;
        }
        System.out.println("Ascending Sorted : ");
        Ascending(Merge);
        System.out.println("Descending Sorted : ");
        Decending(Merge);
        System.out.println("Randomed Sorted : ");
        ShuffleArray(Merge);
    }
    public static void Ascending(int Merge[]){
        int temp;   
    
        

            for(int i = 0; i<Merge.length-1; i++){
                if(Merge[i] > Merge[i+1]){
                    temp = Merge[i+1];
                    Merge[i+1] = Merge[i];
                    Merge[i] = temp;       
                }
            }
        
        for(int i=0; i<Merge.length; i++){
            System.out.print(Merge[i]+", ");
        }
        System.out.println(" "
                + "\n");
    }
    
    public static void Decending(int Merge[]){
        int temp;
        for(int ii = 0; ii != 100; ii ++){
            for(int i = 0; i<Merge.length-1; i++){
                if(Merge[i] < Merge[i+1]){
                    temp = Merge[i+1];
                    Merge[i+1] = Merge[i];
                    Merge[i] = temp;
                }
            }
        }
        for(int i=0; i<Merge.length; i++){
            System.out.print(Merge[i]+", ");
        }
        System.out.println(" "
                + "\n");
    }
    
    public static void ShuffleArray(int []Merge){
        int index, temp;
        Random random = new Random();
        for(int i = Merge.length-1; i>0; i--){
            index = random.nextInt(i+1);
            temp = Merge[index];
            Merge[index] = Merge[i];
            Merge[i] = temp;
        }
        for(int i=0; i<Merge.length; i++){
            System.out.print(Merge[i]+", ");
        }
    }
}