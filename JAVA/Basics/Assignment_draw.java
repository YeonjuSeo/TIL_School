import java.util.Scanner;

public class Submit {
	static Scanner scanner = new Scanner(System.in);
	
	public static int showMenu(int num) {
		System.out.println("--------------------------------------------");
		if(num == -1) {
			System.out.println("메뉴 : 1.삼각형 2.사각형 3. 크리스마스 트리 0.그만");
		}
		else if(num == 1) {
			System.out.println("메뉴 : 1.왼쪽직각삼각형 2.오른쪽직각사각형 3. 정삼각형 0.그만");
		}
		else if(num == 3) {
			System.out.println("메뉴 : 1.소형 2.중형 3. 대형");
		}
		System.out.println("--------------------------------------------");
		System.out.print("menu : ");
		return scanner.nextInt();
	}
	
	public static void drawTriangle(int h, int sub) {
		
		if(sub == 0) return;
		
		if(sub == 1) {
			for(int i=0;i<h;i++) {
//				System.out.print(i+"행 : ");
				for(int j=0;j<=i;j++) {
					if(i%2==0) System.out.print("★");
					else System.out.print("☆");
				}
				System.out.print("\n");
			}
		}
		else if(sub == 2) {
			for(int i=0;i<h;i++) {
//				System.out.print(i+"행 : ");
				for(int j=h-1;j>i;j--) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					if(i%2==0) System.out.print("★");
					else System.out.print("☆");
				}
				System.out.print("\n");
			}
		}
		else if(sub == 3) {
			for(int i=0;i<h;i++) {
//				System.out.print(i+"행 : ");
				for(int j=0;j<(h-i);j++) {
					System.out.print(" ");
				}
				for(int j=0;j<2*i+1;j++) {
					if(i%2==0) System.out.print("★");
					else System.out.print("☆");
				}
				System.out.print("\n");
			}
		}
	}
	public static void drawRectangle(int w, int h, int space) {
		
		for(int i=0;i<h;i++) {
//			System.out.print(i+"행 : ");
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<w;j++) {
				if(i%2==0) System.out.print("■");
				else System.out.print("□");
			}
			System.out.print("\n");
		}
	}
	public static void drawTree() {
		int w,h, size;
		size = showMenu(3);
		if(size == 1) {
			drawTriangle(2,3);
			drawRectangle(1, 1, 2);
		}
		else if(size == 2) {
			drawTriangle(12,3);
			drawRectangle(6, 6,12);
		}
		else if(size == 3) {
			drawTriangle(18,3);
			drawRectangle(9,9,18);
		}
		
	}
	
	public static void main (String [] args) {
		
		int width, height, shape, sub;
		
		while(true) {
			shape = showMenu(-1);
			
			if(shape == 0) break;
			if(shape == 1) {
				sub = showMenu(shape);
				System.out.print("높이 : ");
				height=scanner.nextInt();
				drawTriangle(height, sub);
			}
			else if(shape == 2) {
				System.out.print("너비 : ");
				width=scanner.nextInt();
				System.out.print("높이 : ");
				height=scanner.nextInt();
				drawRectangle(width, height,0);
			}
			else if(shape == 3) {
				drawTree();
			}
		}
	}

}
