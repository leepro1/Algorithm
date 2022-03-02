import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine()," "); //사용자 입력한줄을 띄어쓰기를 기준으로 나눠 받습니다.
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int day=(V-B)/(A-B);
		
		if((V-B)%(A-B)!=0) {
			day++;
		}
		
		System.out.println(day);
	}
}
