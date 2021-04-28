import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16987_2 {
static int N;
static int result=Integer.MIN_VALUE;
static Egg[] eggs;

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    eggs = new Egg[N];

    for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0,0,false);
    }

    DFS(0,0);
    if(result == Integer.MIN_VALUE) {
        System.out.println(0);
    }else {
        System.out.println(result);
    }

}

private static void DFS(int idx, int cnt) {

    if(idx == N) { //가장 오른쪽 계란에 도달했을 때
        return;
    }

    Egg egg = eggs[idx]; //가장 왼쪽 계란 
    if(egg.isbreak) {
        //계란이 깨졌으면 다음 계란으로 
        DFS(idx+1, cnt);
        return;
    }
    for(int i=0; i<N; i++) {
        int temp = 0; // 계란 깨지면 값 증가 

        // 같은 계란일 때
        if(idx == i) {
            continue;
        }
        if(eggs[i].isbreak) { //깨진 계란 
            continue;
        }

        //계란 계산 , 내구도 무게로 계산 
        egg.hard -= eggs[i].weight;
        eggs[i].hard -=egg.weight;

        if(egg.hard <=0) {
            egg.isbreak = true;
            temp++;
        }
        if(eggs[i].hard <=0) {
            eggs[i].isbreak = true;
            temp++;
        }


        //최대 값 갱신
        result = Math.max(cnt+temp, result);

        //DFS 시작 
        DFS(idx+1, cnt+temp); 

        //원상복구
        if(egg.hard <=0) {
            egg.isbreak = false;
        }
        if(eggs[i].hard <=0) {
            eggs[i].isbreak = false;
        }

        egg.hard += eggs[i].weight;
        eggs[i].hard += egg.weight; 

    }

}
}

class Egg{
int hard, weight, current, cnt;
boolean isbreak;
public Egg(int hard, int weight, int current, int cnt, boolean isbreak) {
this.hard = hard;
this.weight = weight;
this.isbreak = isbreak;
this.current = current;
this.cnt = cnt;
}
}