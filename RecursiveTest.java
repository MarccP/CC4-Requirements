
package recursivetest;


public class RecursiveTest {
    public void r(int i){
        if(i <= 100){
            i *= 1;
            System.out.println(i);
            i++;
            r(i);
        }
    }

    public static void main(String[] args) {
        RecursiveTest r = new RecursiveTest();
        r.r(1);
       
    }
    
}
