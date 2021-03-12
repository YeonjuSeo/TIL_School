//예제 2-7
public class Operator {
	public static void main(String [] args) {
		System.out.println('a'>'b'); //false
		System.out.println(3>=2); //true
		System.out.println(-1<0); //true
		System.out.println(3.45<=2); //false
		System.out.println(3==2); //false
		System.out.println(3!=2); //true
		System.out.println(!(3!=2)); //false
		//비교 연산과 논리 연산이 동시에
		System.out.println((3>2) && (3>4)); //false
		System.out.println((3!=2)||(-1>0)); //true
	}
}
