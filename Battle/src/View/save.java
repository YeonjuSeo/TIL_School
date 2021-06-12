package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class save extends JFrame implements KeyListener{

   private JPanel contentPane;
   private JLabel lblNewLabel;
   private JButton save;
   String msg="testtest!!";
   JTextField path ;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               save frame = new save();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public save() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 451, 311);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
       path = new JTextField();
      path.addKeyListener(this);
   
      path.setText("c:\\log");
      path.setFont(new Font("굴림", Font.PLAIN, 20));
      path.setBounds(31, 91, 347, 67);
      contentPane.add(path);
      path.setColumns(10);
      
      lblNewLabel = new JLabel("\uD654\uC77C\uACBD\uB85C(e:\\log)");
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
      lblNewLabel.setBounds(31, 30, 353, 50);
      contentPane.add(lblNewLabel);
      
      save = new JButton("\uC800\uC7A5\uD558\uAE30");
      save.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            fileSave();
         }
      });
      save.setBounds(31, 175, 342, 38);
      contentPane.add(save);
   }


   protected void fileSave() {
      // TODO Auto-generated method stub
      
      //경로만 넣어주기
      File f = new File(path.getText());
      try {
         
         f.mkdir();   
         
         PrintWriter pw = new PrintWriter(f+"\\log.txt");
         pw.write(msg);
         pw.close();
         System.out.println("save!");
      } catch (FileNotFoundException e1) {
         e1.printStackTrace();
         System.out.println("파일 쓰기에 실패했습니다\n");
      }
   }

   public save(String msg) {
      this();
      this.msg =msg;
      
   }

   @Override
   public void keyTyped(KeyEvent e) {}

   @Override
   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode()==10) {
         System.out.println("엔터!");
         fileSave();
      }
      
   }

   @Override
   public void keyReleased(KeyEvent e) {}
}