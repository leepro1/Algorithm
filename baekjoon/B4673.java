package baekjoon;

public class B4673 {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		boolean[] selfNumChecker=new boolean[10001];
		
		//생성자를 구한 뒤, 있으면 체크 
		for(int i=1;i<=10000;i++) {
			int generator=i;
			for(int j=i;j>0;j/=10) {
				generator+=j%10;
			}
			if(generator<=10000)
				selfNumChecker[generator]=true;
		}
		
		for(int i=1;i<=10000;i++) {
			if(selfNumChecker[i]==false)
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
