import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class div2_975_a {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder("");
	
	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			solve();
		}
		
		br.close();
		System.out.print(sb.toString());
	}
	
	static void solve() throws IOException {
		int n = Integer.parseInt(st.nextToken());
		int[] A = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		for (int i = 1; i <= n; i++) {
			int L = i-2;
			int R = n-i-1;
			int loc = 0;
			if (L >= 0) {
				loc += c(L);
			}
			
			if (R >= 0) {
				loc += c(R);
			}
			
			loc += A[i] + 1;
			
			if (ans < loc) {
				ans = loc;
			}
		}
		
		sb.append(ans + "\n");
	}
	
	static int c(int n) {
		return (n+1)/2;
	}
	
	
}
