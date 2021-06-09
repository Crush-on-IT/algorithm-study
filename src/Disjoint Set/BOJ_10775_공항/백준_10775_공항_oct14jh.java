package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class BOJ_10775_공항 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int G, P, val;
    static int answer = 0;
    static int[] root;
    
    static int find(int x){
        if(root[x] == x)
            return x;
        else
            return root[x] = find(root[x]);
    }
    
    static void union(int x, int y){
        root[find(x)] = find(y);
    }
    
     public static void main(String []args) throws java.lang.Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        G = Integer.valueOf(br.readLine());
        P = Integer.valueOf(br.readLine());
        root = new int[G + 1];
        
        for(int i = 1; i <= G; i++) root[i] = i;
        
        for(int i = 1; i <= P; i++){
            val = Integer.valueOf(br.readLine());
            val = find(val);
            if(val == 0)
                break;
                
            union(val, val - 1);
            answer += 1;
        }
        
        
        bw.write(answer + "\n");
        bw.flush();
     }
}
