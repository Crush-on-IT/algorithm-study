package Divide_Conquer;

import java.io.*;

public class 백준_1802_종이접기_saeumi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			String str = br.readLine();
			boolean stop = false;

			while (str.length() > 1) {

				int length = str.length();
				int lengthHalf = length / 2;

				for (int k = 0; k < lengthHalf; k++) {
					if (str.charAt(k) != str.charAt(length - k - 1)) {
						continue;
					} else {
						sb.append("NO").append("\n");
						stop = true;
						break;
					}
				}

				if (stop) break;
				str = str.substring(0, lengthHalf); //01001
			} // end of while
			if (!stop) {
				sb.append("YES").append("\n");
			}
		}
		System.out.println(sb);
	}
} // end of class
