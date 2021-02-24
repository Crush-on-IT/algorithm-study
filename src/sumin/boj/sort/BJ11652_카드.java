package sumin.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ11652_카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//long으로 해도 안터지넹...ㅎㅎ
		Map<String,Integer> map = new HashMap<>();
		String cur = null;
		
		for (int i = 0; i < N; i++) {
			cur = br.readLine();
			if(map.containsKey(cur)) {
				int curValue = map.get(cur);
				map.replace(cur, ++curValue);
			}
			else	map.put(cur, 1);
		}
		
		int maxCnt = 0;
		String maxValue = null;
		
		for(String str : map.keySet()) {
			int cnt = map.get(str);
			if(cnt>maxCnt) {
				maxCnt = cnt;
				maxValue = str;
			}
			else if(cnt==maxCnt) {
				
				boolean m1 = (str.charAt(0)=='-')?true:false;
				boolean m2 = maxValue.charAt(0)=='-'?true:false;
				
				//부호가 같은 경우
				if(m1 == m2 ) {
					String tmp = null;
					//두 수의 길이 같으면
					if(str.length() == maxValue.length()) {
						for (int i = 0; i < str.length(); i++) {
							if(str.charAt(i) == maxValue.charAt(i))	continue;
							int digit1 = str.charAt(i)-'0';
							int digit2 = maxValue.charAt(i)-'0';
							if(m1)	maxValue = digit1>digit2?str:maxValue;
							else	maxValue = digit1<digit2?str:maxValue;
							break;
						}
					}
					
					//두 수의 길이 다르면 긴게 크고, 짧ㅇ느게 작고
					else {
						if(m1)	maxValue = str.length()>maxValue.length()?str:maxValue;
						else	maxValue = str.length()<maxValue.length()?str:maxValue;
					}
					
				}
				//부호 다른 경우
				else {
					if(m1) {
						maxValue = str;
					}
				}
			}
		}
		
		System.out.println(maxValue);
	}

}
