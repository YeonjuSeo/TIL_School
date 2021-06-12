package View;

import Player.*;
import Player.Character;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import mary.TextToSpeech;
import tts_view.MyTTS2;
import javax.swing.JTextField;

public class GameWindow<Int> extends JFrame {
	Scanner input = new Scanner(System.in);
	ArrayList<Character> team;
	Character villain;
	Character 프리저 = new 프리저();
	int round = 1, 아군HP = 0, 아군기 = 0;;

	MyTTS2 mary = new MyTTS2("mary");
	String winner = "0";
	private JPanel contentPane;

//	필요 컴포넌트 선언
	JButton attackButton1 = new JButton("가위바위보권법");
	JButton attackButton2 = new JButton("에네르기파");
	JButton attackButton3 = new JButton("원기옥");
	private final JLabel bg = new JLabel("");
	JLabel 기본손오공 = new JLabel("");
	JLabel 기본베지터 = new JLabel("");
	JLabel 사이언오공 = new JLabel("");
	JLabel 아군베지터 = new JLabel("");
	JLabel 프리저1 = new JLabel("");
	JProgressBar HPBar1 = new JProgressBar();
	JProgressBar HPBar2 = new JProgressBar();
	JProgressBar 기Bar1 = new JProgressBar();
	JProgressBar 기Bar2 = new JProgressBar();
	JScrollPane scrollPane = new JScrollPane();
	JTextArea textArea = new JTextArea();
	private JButton btnNewButton;

	public void makeDelay(int s) {
		try {
			Thread.sleep(s * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void makeText(String s) {
		textArea.append(s);
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	public void 수련하기() {
		아군HP = 0;
		아군기 = 0;

		makeText("시간과 정신의 방에서 수련하는 중...\n");

		for (int i = 0; i < round; i++) {
			((Trainable) team.get(i)).수련하기();
		}
		makeDelay(2);

		for (int i = 0; i < round; i++) {
			아군HP += team.get(i).getInit_HP();
			아군기 += team.get(i).getInit_기();
		}
		HPBar1.setMaximum(아군HP);
		기Bar1.setMaximum(아군기);
		HPBar1.setValue(아군HP);
		기Bar1.setValue(아군기);

	}

	public void updateTeamInfo() {
		아군HP = 0;
		아군기 = 0;
		for (int i = 0; i < round; i++) {
			아군HP += this.team.get(i).getHP();
			아군기 += this.team.get(i).get기();
			this.team.get(i).showStatus();

		}
		HPBar1.setValue(this.아군HP);
		기Bar1.setValue(this.아군기);

	}

	public void VillainAttack() {
		int target = (int) (Math.random() * 1000) % round; // 아군 중 랜덤으로 한 명을 공격
		String dialog;
		dialog = villain.<Character, Int>attack(team.get(target), -1);
		makeText(dialog + '\n');
		updateTeamInfo();
		기Bar2.setValue(this.villain.get기());
		makeWinner();
	}

	protected void 가위바위보공격() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				String dialog;
				if (round > 1 && team.get(round - 1).getHP() < 50) {
					((Syanable) team.get(0)).<Boolean>초사이어인되기(true);
					makeText("동료의 고통에 분노한 손오공의 초사이어인화! \n");
					기본손오공.setVisible(false);
					사이언오공.setVisible(true);
				}
				for (int i = 0; i < round; i++) {
					dialog = team.get(i).attack(villain, 1);
					makeText(dialog + '\n');
				}
				HPBar2.setValue(villain.getHP());
				updateTeamInfo();
				makeDelay(1);
				VillainAttack();
			}

		});
		th.start();
	}

	protected void 에네르기파공격() {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				String dialog;
				if (round > 1 && team.get(round - 1).getHP() < 50) {
					((Syanable) team.get(0)).초사이어인되기(true);
					makeText("동료의 고통에 분노한 손오공의 초사이어인화! \n");
					기본손오공.setVisible(false);
					사이언오공.setVisible(true);
				}
				for (int i = 0; i < round; i++) {
					dialog = team.get(i).attack(villain, 2);
					makeText(dialog + '\n');
				}
				mary.speak("PA A A A A A");
				HPBar2.setValue(villain.getHP());
				updateTeamInfo();
				makeDelay(1);
				VillainAttack();

			}

		});
		th.start();
	}

	public <Int> void setRound(int round) {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {

				수련하기();

				if (round == 2) {
					villain = new 프리저();

					기본베지터.setVisible(false);
					아군베지터.setVisible(true);
					프리저1.setVisible(true);
					attackButton3.setVisible(true);
					attackButton3.setEnabled(false);
					villain.showStatus();

				} else if (round == 3)
					return;
				makeText('\n' + villain.이름 + "(이)가 나타났습니다\n");
				HPBar2.setMaximum(villain.getInit_HP());
				기Bar2.setMaximum(villain.getInit_기());
				HPBar2.setValue(villain.getInit_HP());
				기Bar2.setValue(villain.getInit_기());

				attackButton1.setEnabled(true);
				attackButton2.setEnabled(true);
				winner = "0";
			}

		});

		th.start();
	}

	public void makeWinner() {
		if (this.villain.getHP() <= 0) {
			winner = "손오공";
			if (round != 2) {
				((Joinable) this.villain).<Boolean>set아군(true);
				team.add(round, this.villain);
				makeText("이제 " + this.villain.이름 + "와 함께 싸울 수 있습니다!\n");
				System.out.println(team.get(round).이름 + "가 새로운 동료가 되었습니다.");
			}
			round++;
		} else if (HPBar1.getValue() <= 0) {
			winner = this.villain.이름;
		}
		if (winner != "0") {
			attackButton1.setEnabled(false);
			attackButton2.setEnabled(false);
			textArea.append("승자는 " + winner + '\n');
			villain.setHP(villain.getInit_HP());
			villain.set기(villain.getInit_기());
			villain.set전투력(villain.getInit_전투력());
			if (round != 3)
				setRound(round);

			((Syanable) team.get(0)).<Boolean>초사이어인되기(false);
			기본손오공.setVisible(true);
			사이언오공.setVisible(false);
		}
	}

	public GameWindow(ArrayList team, Character villain) { // character 연결
		this(); // 컴포넌트들 소환
		this.team = team;
		this.villain = villain;
		team.add(0, new 손오공());

		HPBar1.setMaximum(this.team.get(0).getInit_HP());
		기Bar1.setMaximum(this.team.get(0).getInit_기());
		HPBar2.setMaximum(this.villain.getHP());
		기Bar2.setMaximum(this.villain.get기());
		HPBar1.setValue(this.team.get(0).getInit_HP());
		기Bar1.setValue(this.team.get(0).getInit_기());
		HPBar2.setValue(this.villain.getHP());
		기Bar2.setValue(this.villain.get기());
	}

	public GameWindow() {

		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/드래곤볼게임배경화면.JPG")));
//		Panel 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("드래곤볼 게임! ~프리저를 무찌르자~");

		contentPane.setLayout(null);
		attackButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				가위바위보공격();
			}

		});
		attackButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				에네르기파공격();

			}
		});

//		공격 버튼 설정
		attackButton1.setBounds(70, 400, 150, 30);
		attackButton2.setBounds(70, 440, 150, 30);
		attackButton3.setBounds(70, 480, 150, 30);
		attackButton3.setVisible(false);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new save(textArea.getText()).setVisible(true);;
				
			}
		});
		btnNewButton.setBounds(500, 408, 118, 25);
		contentPane.add(btnNewButton);

		기Bar2.setBackground(Color.gray);
		기Bar2.setForeground(Color.blue);
		기Bar2.setBounds(620, 22, 180, 10);
		contentPane.add(기Bar2);
//    	기Bar 설정
		기Bar1.setBackground(Color.gray);
		기Bar1.setForeground(Color.blue);
		기Bar1.setBounds(60, 22, 180, 10);
		contentPane.add(기Bar1);

		HPBar2.setBackground(Color.gray);
		HPBar2.setForeground(Color.red);
		HPBar2.setBounds(500, 35, 300, 25);
		contentPane.add(HPBar2);

//		HPBar 설정
		HPBar1.setBackground(Color.gray);
		HPBar1.setForeground(Color.red);
		HPBar1.setBounds(60, 35, 300, 25);
		contentPane.add(HPBar1);

		scrollPane.setBounds(293, 228, 325, 170);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textArea);

		contentPane.add(attackButton1);
		contentPane.add(attackButton2);

//		이미지 Label 설정, 크기 조절
		ImageIcon SBasicIcon = new ImageIcon(getClass().getResource("/assets/손오공basic.png"));
		Image SBasic = SBasicIcon.getImage();
		Image SmallSBasic = SBasic.getScaledInstance(230, 400, Image.SCALE_SMOOTH);
		ImageIcon SmallSBasicIcon = new ImageIcon(SmallSBasic);
		기본손오공.setIcon(SmallSBasicIcon);
		기본손오공.setBounds(103, 22, 230, 455);
		contentPane.add(기본손오공);

		ImageIcon SSyanIcon = new ImageIcon(getClass().getResource("/assets/사이어손오공.png"));
		Image SSyan = SSyanIcon.getImage();
		Image SmallSSyan = SSyan.getScaledInstance(230, 400, Image.SCALE_SMOOTH);
		ImageIcon SmallSSyanIcon = new ImageIcon(SmallSSyan);
		사이언오공.setIcon(SmallSSyanIcon);
		사이언오공.setBounds(103, 22, 230, 455);
		contentPane.add(사이언오공);
		사이언오공.setVisible(false);

		ImageIcon VBasicIcon = new ImageIcon(getClass().getResource("/assets/베지터basic.png"));
		Image VBasic = VBasicIcon.getImage();
		Image SmallVBasic = VBasic.getScaledInstance(150, 400, Image.SCALE_SMOOTH);
		ImageIcon SmallVBasicIcon = new ImageIcon(SmallVBasic);
		기본베지터.setIcon(SmallVBasicIcon);
		기본베지터.setBounds(620, 35, 180, 474);
		contentPane.add(기본베지터);
		기본베지터.setVisible(true);

		ImageIcon VTeamIcon = new ImageIcon(getClass().getResource("/assets/아군베지터.png"));
		Image VTeamImg = VTeamIcon.getImage();
		Image resizeVTeamImg = VTeamImg.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		ImageIcon resizeVTeamIcon = new ImageIcon(resizeVTeamImg);
		아군베지터.setIcon(resizeVTeamIcon);
		아군베지터.setBounds(0, 22, 220, 446);
		contentPane.add(아군베지터);
		아군베지터.setVisible(false);

		ImageIcon Free1Icon = new ImageIcon(getClass().getResource("/assets/프리더기본.png"));
		Image Free1Img = Free1Icon.getImage();
		Image resizeFree1Img = Free1Img.getScaledInstance(250, 400, Image.SCALE_SMOOTH);
		ImageIcon resizeFree1Icon = new ImageIcon(resizeFree1Img);
		프리저1.setIcon(resizeFree1Icon);
		프리저1.setBounds(570, 0, 316, 509);
		contentPane.add(프리저1);
		프리저1.setVisible(false);

//		배경화면 Label 설정, 크기 조절
		ImageIcon bgIcon = new ImageIcon(getClass().getResource("/assets/드래곤볼게임배경화면.jpg"));
		Image bgImg = bgIcon.getImage();
		Image resizeBgImg = bgImg.getScaledInstance(900, 550, Image.SCALE_SMOOTH);
		ImageIcon resizeBgIcon = new ImageIcon(resizeBgImg);
		bg.setIcon(resizeBgIcon);
		bg.setBounds(0, 0, 886, 513);
		contentPane.add(bg);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList team = new ArrayList<Character>();

		Character villain = new 베지터();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow(team, villain);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
