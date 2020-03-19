package finalkruskal;
import java.io.*;
import java.util.*;

public class FinalKruskal {
    
    static BufferedReader gg = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        System.out.print("Enter number of Vertices :");
        int V = Integer.parseInt(gg.readLine());
        System.out.print("Enter number of Edges :");
        int E = Integer.parseInt(gg.readLine());
        
        String arrS[] = new String[E];
        String arrD[] = new String[E];
        int arrW[] = new int[E];
        
        FinalKruskal graph = new FinalKruskal(V, E); 
        for(int i = 0; i<E; i++){
            System.out.println("\n======== "+(i)+" ========");
            System.out.print("Enter Source: ");
            String UwU = gg.readLine();
            int s = LettersToNumbers(UwU);
            System.out.print("Enter Destination: ");
            String UmU = gg.readLine();
            int d = LettersToNumbers(UmU);
            System.out.print("Enter Weight: ");
            int w = Integer.parseInt(gg.readLine());
            System.out.println("("+UwU+","+UmU+","+w+") == ("+UmU+","+UwU+","+w+")");
            graph.edge[i].src = s; 
            graph.edge[i].dest = d; 
            graph.edge[i].weight = w; 

            arrS[i] = UwU;
            arrD[i] = UmU;
            arrW[i] = w;
        }
        System.out.println("\n==============================");
        System.out.println("GRAPH");
        System.out.println("==============================");
        for(int i = 0; i<E; i++){
            System.out.println("("+arrS[i]+","+arrD[i]+","+arrW[i]+") == ("+arrD[i]+","+arrS[i]+","+arrW[i]+")");
        }
        System.out.println("==============================");
        int firstTotal = arrW[0];
        for(int i = 1; i<E; i++){
            firstTotal = firstTotal+arrW[i];
        }
        System.out.println("Total Weight: "+firstTotal);
        System.out.println("==============================");
        graph.KruskalMST();
    }

    class Edge implements Comparable<Edge> {
        int src, dest, weight; 
        public int compareTo(Edge compareEdge) 
        { 
            return this.weight-compareEdge.weight; 
        } 
    };
    
    class subset{
        int parent, rank; 
    };
    
    int V, E;
    Edge edge[];
    
    FinalKruskal(int v, int e) {
        V = v; 
        E = e; 
        edge = new Edge[E]; 
        for (int i=0; i<e; ++i) {
            edge[i] = new Edge(); 
        }
    }
    
    int find(subset subsets[], int i){
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent); 
        }
        return subsets[i].parent;
    }
    
    void Union(subset subsets[], int x, int y){
        int xroot = find(subsets, x); 
        int yroot = find(subsets, y); 
  
        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 
  
        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    }
    
    void KruskalMST(){
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i=0; i<V; ++i){
            result[i] = new Edge(); 
        }
        Arrays.sort(edge);
        
        subset subsets[] = new subset[V]; 
        for(i=0; i<V; ++i){
            subsets[i]=new subset();
        }
        for (int v = 0; v < V; ++v){ 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 
        i = 0;
        while (e < V - 1){
            Edge next_edge = new Edge(); 
            next_edge = edge[i++];
            
            int x = find(subsets, next_edge.src); 
            int y = find(subsets, next_edge.dest);
            
            if (x != y){
                result[e++] = next_edge; 
                Union(subsets, x, y);
            }
        }
        
        System.out.println("\n==============================");
        System.out.println("MINIMUM PATH");
        System.out.println("==============================");
        for(i = 0; i < e; ++i){
            String ezS = NumbersToLetters(result[i].src);
            String ezD = NumbersToLetters(result[i].dest);
            System.out.println("("+ezS+","+ezD+","+result[i].weight+") == ("+ezS+","+ezD+","+result[i].weight+")");
        }
        int total = result[0].weight;
        for(i = 1; i < e; ++i){
            total = total+ result[i].weight;
        }
        System.out.println("==============================");
        System.out.println("Total Weight: "+total);
        System.out.println("==============================");
    }
    
    static int LettersToNumbers(String letter){
        int send = 0;
        String [] letters = {"A","B","C","D","E","F","G","H","I","J","K"
                                ,"L","M","N","O","P","Q","R","S","T","U"
                                ,"V","W","X","Y","Z"};
        
        for(int i = 0; i< letters.length; i++){
            if(letter.equals(letters[i])){
                send = i;
            }
        }
        return send;
    }
    static String NumbersToLetters(int num){
        String send = "";
        String [] letters = {"A","B","C","D","E","F","G","H","I","J","K"
                                ,"L","M","N","O","P","Q","R","S","T","U"
                                ,"V","W","X","Y","Z"};
        
        for(int i = 0; i< letters.length; i++){
            if(num == i){
                send = letters[i];
            }
        }
        return send;
    }
}

