import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HaybaleDistribution {
	
	static int N;
	static long[] X;
	static long[] P;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = new long[N+1];
		P = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			X[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		long[] A = new long[Q];
		long[] B = new long[Q];
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
		}
		
		br.close();
		
		Arrays.sort(X);
		
		for (int i = 1; i <= N; i++) {
			P[i] = P[i-1] + X[i];
		}
		
		// StringBuilder sb = new StringBuilder("");
		StringBuilder opt = new StringBuilder("");
		
		for (int i = 0; i < Q; i++) {
			// long best = Long.MAX_VALUE;
			
			// for (int j = 1; j <= N; j++) {
			// best = Math.min(best, f(A[i], B[i], j));
			// }
			
			// sb.append(best + "\n");
			long LN = N;
			long index = (B[i] * LN)/(A[i] + B[i]);
			int cast = (int) (index);
			
			long optionA = f(A[i], B[i], 1);
			long optionB = f(A[i], B[i], N);
			long optionC = f(A[i], B[i], cast);
			
			if (cast + 1 <= N) {
				optionC = Math.min(optionC, f(A[i], B[i], cast+1));
			}
			long result = Math.min(Math.min(optionA, optionB), optionC);
			
			opt.append(result + "\n");
		}
		
		// System.out.print(sb);
		System.out.print(opt);
		
	}
	
	static long f(long a, long b, int index) {
		long convert = index;
		long comp = N - convert;
		long result = 0;
		
		result = a * (X[index] * convert - P[index]) + b * (P[N] - P[index] - comp * X[index]);
		
		return result;
	}
}
