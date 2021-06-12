import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Player.Character;
import Player.베지터;
import Player.손오공;
import View.GameWindow;

public class Main {
	public static Scanner input = new Scanner(System.in);
	static ArrayList team = new ArrayList<Character>();
	static Character 베지터 = new 베지터(); 
	
	public static void main(String[] args) {
		
//		윈도우에서 동작테스트
		new GameWindow(team,베지터);
		
	}

}
