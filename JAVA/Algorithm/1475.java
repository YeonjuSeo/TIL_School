import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		int N, max=1, idx=0;
		int [] arr = new int[10];
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		while(N>0) {
			int temp;
			temp=N%10;
			N/=10;
			if(temp==6) {
				arr[9]++;
			}
			else {
				arr[temp]++;
			}
		}
		if(arr[9]>0) {
			if(arr[9]%2==1) {
				max=arr[9]/2+1;
			}
			else {
				max=arr[9]/2;
			}
		}
		for(int i=0;i<9;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
}
