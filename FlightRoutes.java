import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FlightRoutes {
	
	static int N;
	static int[][] dp;
	static int[][] R;
	static int[][] p;
	static ArrayList<ArrayList<Integer>> adj;
	
	
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		R = new int[N+1][N+1];
		p = new int[N+1][N+1];
		adj = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<Integer>());
		}		
		
		for (int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = i+1; j <= N; j++) {
				if (s.charAt(j-i-1) == '1') {
					p[i][j] = 1;
				}
			}
		}
		
		
		
		int count = 0;
		
		for (int length = 1; length <= N-1; length++) {
			for (int start = 1; start <= N-length; start++) {
				int end = start + length;
				// dp(start, end)
				int local = 0;
				
				for (int ne : adj.get(start)) {
					local += dp[ne][end];
					// R[start][end] += R[start][ne] * R[ne][end];
					local %= 2;
				}
				
				dp[start][end] = local;
				
				
				
				if (local == p[start][end]) {
					continue;
				}
				
				adj.get(start).add(end);
				dp[start][end] = 1 - dp[start][end];
				// R[start][end] += 1;
				count++;
			}
			// System.out.println(adj);
			
		}
		
		
		br.close();
		
		// print(R);
		
		System.out.println(count);
	}
	
	static void print(int[][] grid) {
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
