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
	Character ������ = new ������();
	int round = 1, �Ʊ�HP = 0, �Ʊ��� = 0;;

	MyTTS2 mary = new MyTTS2("mary");
	String winner = "0";
	private JPanel contentPane;

//	�ʿ� ������Ʈ ����
	JButton attackButton1 = new JButton("�����������ǹ�");
	JButton attackButton2 = new JButton("���׸�����");
	JButton attackButton3 = new JButton("�����");
	private final JLabel bg = new JLabel("");
	JLabel �⺻�տ��� = new JLabel("");
	JLabel �⺻������ = new JLabel("");
	JLabel ���̾���� = new JLabel("");
	JLabel �Ʊ������� = new JLabel("");
	JLabel ������1 = new JLabel("");
	JProgressBar HPBar1 = new JProgressBar();
	JProgressBar HPBar2 = new JProgressBar();
	JProgressBar ��Bar1 = new JProgressBar();
	JProgressBar ��Bar2 = new JProgressBar();
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

	public void �����ϱ�() {
		�Ʊ�HP = 0;
		�Ʊ��� = 0;

		makeText("�ð��� ������ �濡�� �����ϴ� ��...\n");

		for (int i = 0; i < round; i++) {
			((Trainable) team.get(i)).�����ϱ�();
		}
		makeDelay(2);

		for (int i = 0; i < round; i++) {
			�Ʊ�HP += team.get(i).getInit_HP();
			�Ʊ��� += team.get(i).getInit_��();
		}
		HPBar1.setMaximum(�Ʊ�HP);
		��Bar1.setMaximum(�Ʊ���);
		HPBar1.setValue(�Ʊ�HP);
		��Bar1.setValue(�Ʊ���);

	}

	public void updateTeamInfo() {
		�Ʊ�HP = 0;
		�Ʊ��� = 0;
		for (int i = 0; i < round; i++) {
			�Ʊ�HP += this.team.get(i).getHP();
			�Ʊ��� += this.team.get(i).get��();
			this.team.get(i).showStatus();

		}
		HPBar1.setValue(this.�Ʊ�HP);
		��Bar1.setValue(this.�Ʊ���);

	}

	public void VillainAttack() {
		int target = (int) (Math.random() * 1000) % round; // �Ʊ� �� �������� �� ���� ����
		String dialog;
		dialog = villain.<Character, Int>attack(team.get(target), -1);
		makeText(dialog + '\n');
		updateTeamInfo();
		��Bar2.setValue(this.villain.get��());
		makeWinner();
	}

	protected void ��������������() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				String dialog;
				if (round > 1 && team.get(round - 1).getHP() < 50) {
					((Syanable) team.get(0)).<Boolean>�ʻ��̾��εǱ�(true);
					makeText("������ ���뿡 �г��� �տ����� �ʻ��̾���ȭ! \n");
					�⺻�տ���.setVisible(false);
					���̾����.setVisible(true);
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

	protected void ���׸����İ���() {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				String dialog;
				if (round > 1 && team.get(round - 1).getHP() < 50) {
					((Syanable) team.get(0)).�ʻ��̾��εǱ�(true);
					makeText("������ ���뿡 �г��� �տ����� �ʻ��̾���ȭ! \n");
					�⺻�տ���.setVisible(false);
					���̾����.setVisible(true);
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

				�����ϱ�();

				if (round == 2) {
					villain = new ������();

					�⺻������.setVisible(false);
					�Ʊ�������.setVisible(true);
					������1.setVisible(true);
					attackButton3.setVisible(true);
					attackButton3.setEnabled(false);
					villain.showStatus();

				} else if (round == 3)
					return;
				makeText('\n' + villain.�̸� + "(��)�� ��Ÿ�����ϴ�\n");
				HPBar2.setMaximum(villain.getInit_HP());
				��Bar2.setMaximum(villain.getInit_��());
				HPBar2.setValue(villain.getInit_HP());
				��Bar2.setValue(villain.getInit_��());

				attackButton1.setEnabled(true);
				attackButton2.setEnabled(true);
				winner = "0";
			}

		});

		th.start();
	}

	public void makeWinner() {
		if (this.villain.getHP() <= 0) {
			winner = "�տ���";
			if (round != 2) {
				((Joinable) this.villain).<Boolean>set�Ʊ�(true);
				team.add(round, this.villain);
				makeText("���� " + this.villain.�̸� + "�� �Բ� �ο� �� �ֽ��ϴ�!\n");
				System.out.println(team.get(round).�̸� + "�� ���ο� ���ᰡ �Ǿ����ϴ�.");
			}
			round++;
		} else if (HPBar1.getValue() <= 0) {
			winner = this.villain.�̸�;
		}
		if (winner != "0") {
			attackButton1.setEnabled(false);
			attackButton2.setEnabled(false);
			textArea.append("���ڴ� " + winner + '\n');
			villain.setHP(villain.getInit_HP());
			villain.set��(villain.getInit_��());
			villain.set������(villain.getInit_������());
			if (round != 3)
				setRound(round);

			((Syanable) team.get(0)).<Boolean>�ʻ��̾��εǱ�(false);
			�⺻�տ���.setVisible(true);
			���̾����.setVisible(false);
		}
	}

	public GameWindow(ArrayList team, Character villain) { // character ����
		this(); // ������Ʈ�� ��ȯ
		this.team = team;
		this.villain = villain;
		team.add(0, new �տ���());

		HPBar1.setMaximum(this.team.get(0).getInit_HP());
		��Bar1.setMaximum(this.team.get(0).getInit_��());
		HPBar2.setMaximum(this.villain.getHP());
		��Bar2.setMaximum(this.villain.get��());
		HPBar1.setValue(this.team.get(0).getInit_HP());
		��Bar1.setValue(this.team.get(0).getInit_��());
		HPBar2.setValue(this.villain.getHP());
		��Bar2.setValue(this.villain.get��());
	}

	public GameWindow() {

		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/�巡�ﺼ���ӹ��ȭ��.JPG")));
//		Panel ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("�巡�ﺼ ����! ~�������� �����~");

		contentPane.setLayout(null);
		attackButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				��������������();
			}

		});
		attackButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				���׸����İ���();

			}
		});

//		���� ��ư ����
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

		��Bar2.setBackground(Color.gray);
		��Bar2.setForeground(Color.blue);
		��Bar2.setBounds(620, 22, 180, 10);
		contentPane.add(��Bar2);
//    	��Bar ����
		��Bar1.setBackground(Color.gray);
		��Bar1.setForeground(Color.blue);
		��Bar1.setBounds(60, 22, 180, 10);
		contentPane.add(��Bar1);

		HPBar2.setBackground(Color.gray);
		HPBar2.setForeground(Color.red);
		HPBar2.setBounds(500, 35, 300, 25);
		contentPane.add(HPBar2);

//		HPBar ����
		HPBar1.setBackground(Color.gray);
		HPBar1.setForeground(Color.red);
		HPBar1.setBounds(60, 35, 300, 25);
		contentPane.add(HPBar1);

		scrollPane.setBounds(293, 228, 325, 170);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textArea);

		contentPane.add(attackButton1);
		contentPane.add(attackButton2);

//		�̹��� Label ����, ũ�� ����
		ImageIcon SBasicIcon = new ImageIcon(getClass().getResource("/assets/�տ���basic.png"));
		Image SBasic = SBasicIcon.getImage();
		Image SmallSBasic = SBasic.getScaledInstance(230, 400, Image.SCALE_SMOOTH);
		ImageIcon SmallSBasicIcon = new ImageIcon(SmallSBasic);
		�⺻�տ���.setIcon(SmallSBasicIcon);
		�⺻�տ���.setBounds(103, 22, 230, 455);
		contentPane.add(�⺻�տ���);

		ImageIcon SSyanIcon = new ImageIcon(getClass().getResource("/assets/���̾�տ���.png"));
		Image SSyan = SSyanIcon.getImage();
		Image SmallSSyan = SSyan.getScaledInstance(230, 400, Image.SCALE_SMOOTH);
		ImageIcon SmallSSyanIcon = new ImageIcon(SmallSSyan);
		���̾����.setIcon(SmallSSyanIcon);
		���̾����.setBounds(103, 22, 230, 455);
		contentPane.add(���̾����);
		���̾����.setVisible(false);

		ImageIcon VBasicIcon = new ImageIcon(getClass().getResource("/assets/������basic.png"));
		Image VBasic = VBasicIcon.getImage();
		Image SmallVBasic = VBasic.getScaledInstance(150, 400, Image.SCALE_SMOOTH);
		ImageIcon SmallVBasicIcon = new ImageIcon(SmallVBasic);
		�⺻������.setIcon(SmallVBasicIcon);
		�⺻������.setBounds(620, 35, 180, 474);
		contentPane.add(�⺻������);
		�⺻������.setVisible(true);

		ImageIcon VTeamIcon = new ImageIcon(getClass().getResource("/assets/�Ʊ�������.png"));
		Image VTeamImg = VTeamIcon.getImage();
		Image resizeVTeamImg = VTeamImg.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		ImageIcon resizeVTeamIcon = new ImageIcon(resizeVTeamImg);
		�Ʊ�������.setIcon(resizeVTeamIcon);
		�Ʊ�������.setBounds(0, 22, 220, 446);
		contentPane.add(�Ʊ�������);
		�Ʊ�������.setVisible(false);

		ImageIcon Free1Icon = new ImageIcon(getClass().getResource("/assets/�������⺻.png"));
		Image Free1Img = Free1Icon.getImage();
		Image resizeFree1Img = Free1Img.getScaledInstance(250, 400, Image.SCALE_SMOOTH);
		ImageIcon resizeFree1Icon = new ImageIcon(resizeFree1Img);
		������1.setIcon(resizeFree1Icon);
		������1.setBounds(570, 0, 316, 509);
		contentPane.add(������1);
		������1.setVisible(false);

//		���ȭ�� Label ����, ũ�� ����
		ImageIcon bgIcon = new ImageIcon(getClass().getResource("/assets/�巡�ﺼ���ӹ��ȭ��.jpg"));
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

		Character villain = new ������();
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
