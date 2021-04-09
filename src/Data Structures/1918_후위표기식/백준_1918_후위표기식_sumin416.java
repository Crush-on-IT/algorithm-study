import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		char top;
		for(char ch : str) {
			switch(ch) {
				case '(':
					stack.push(ch);
					break;
				case ')':
					while(true) {
						if(stack.isEmpty())	break;
						
						top = stack.pop();
						if(top == '(')	break;
						else	sb.append(top);
					}
					break;
				case '*':
				case '/':
					while(true) {
						if(stack.isEmpty())	break;
						
						top = stack.peek();
						if(top=='/' || top=='*') {
							sb.append(top);
							stack.pop();
						}
						else {
							break;
						}
					}
					stack.push(ch);
					break;
				case '+':
				case '-':
					while(true) {
						if(stack.isEmpty())	break;
						
						top = stack.peek();
						if(top == '(')	break;
						else {
							sb.append(top);
							stack.pop();
						}
					}
					stack.push(ch);
					break;
				default:
					sb.append(ch);
					break;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		
	}
	
	
	
}
