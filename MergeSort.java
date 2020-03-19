package mergesort;

public class MergeSort {
    public static int[] r(int[] Tesx){
        int i = 1;
        while(i < 100){
            i *= 1;
            

            Tesx = new int [101];
            Tesx[i] = i;
            
            System.out.println(Tesx[i]);
            i++;
            
        }
        
        return Tesx;
    }

    public static void main(String[] args) {
        
        
  
        
        int[] Test;
        Test = new int [101];

        
        r(Tesx);
        
        SmalltoGreat(Test);
        GreattoSmall(Test);
      
        
        
        
    }
    public static void SmalltoGreat(int Merge[]){
        int temp;
        boolean sorted=false;
        while(sorted==false){
            sorted=true;
            for(int i = 0; i<Merge.length-1; i++){
                if(Merge[i] > Merge[i+1]){
                    temp = Merge[i+1];
                    Merge[i+1] = Merge[i];
                    Merge[i] = temp;
                    sorted=false;
                }
            }
        }
        System.out.println("From 1 to 100:");
        System.out.print("[ ");
        //JP Code
        for(int i=0; i<Merge.length; i++){
            System.out.print(Merge[i]+", ");
        }
        System.out.println("]");
    }
    
    public static void GreattoSmall(int Merge[]){
        int temp;
        boolean sorted=false;
        while(sorted==false){
            sorted=true;
            for(int i = 0; i<Merge.length-1; i++){
                if(Merge[i] < Merge[i+1]){
                    temp = Merge[i+1];
                    Merge[i+1] = Merge[i];
                    Merge[i] = temp;
                    sorted=false;
                }
            }
            //Jp Code
        }
        System.out.println("From 100 to 1:");
        System.out.print("[ ");
        for(int i=0; i<Merge.length; i++){
            System.out.print(Merge[i]+", ");
        }
        System.out.println("]");
    }
    
    public static void Random(){
        
    }
}
