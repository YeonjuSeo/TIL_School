import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Player.Character;
import Player.������;
import Player.�տ���;
import View.GameWindow;

public class Main {
	public static Scanner input = new Scanner(System.in);
	static ArrayList team = new ArrayList<Character>();
	static Character ������ = new ������(); 
	
	public static void main(String[] args) {
		
//		�����쿡�� �����׽�Ʈ
		new GameWindow(team,������);
		
	}

}
