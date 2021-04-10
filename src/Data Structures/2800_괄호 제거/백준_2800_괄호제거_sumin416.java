import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		
		new Main().recur(list,input,new StringBuilder(),0, new Stack<Boolean>());
	}
	
	private void recur(List<Character> list,String input,StringBuilder sb,int idx, Stack<Boolean> isRemove) {
		char ch;
		Stack<Boolean> copy = new Stack<Boolean>();
		
		
		while(true) {
			if(idx==list.size()) {	
				System.out.println(sb.toString());
				break;
			}
			
			ch = list.get(idx);
			
			switch(ch) {
				case '(':
					//괄호 제거
					isRemove.push(true);
					recur(list,input,sb,idx+1,isRemove);
					
					
					//괄호 놔두기
					isRemove.push(false);
					sb.append(ch);
					recur(list,input,sb,idx+1,isRemove);
					return;
				case ')':
					if(!isRemove.pop()) {
						sb.append(ch);
					}
					++idx;
					break;
				default:
					sb.append(ch);
					++idx;
					break;
			}
		}
	}
	

}
