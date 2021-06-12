package Player;

import java.util.Scanner;

public class 손오공 extends Character implements Trainable, Syanable {
	Scanner scanner = new Scanner(System.in);
    private boolean 초사이어인;
    
    public 손오공() {
    	this.setInit_HP(100);
    	this.setInit_전투력(60);
    	this.setInit_기(100);
    	this.setHP(this.getInit_HP());
    	this.set전투력(this.getInit_전투력());
    	this.set기(this.getInit_기());
    	this.초사이어인되기(false);
    	this.이름 = "손오공";
    }

    public <Character, Int>String attack(Character target, int num) {
    	this.showStatus();
    	String dialog = null;
    	if(num == 1) dialog = 가위바위보권법(target);
    	else if(num == 2) dialog = 에네르기파(target);
    	return dialog;
    	
    }
    
    public <Character> String 가위바위보권법(Character target){
    	System.out.println("\"가위! 바위! 보!\" 손오공의 공격!");
    	if(this.초사이어인 == false) this.깎기(target, (int)(this.get전투력()*0.1), 0);
    	else  this.깎기(target, (int)(this.get전투력()*0.2), 0);
    	this.기회복();
    	return "\"가위! 바위! 보!\" 손오공의 공격!";
    }

    public <Character> String 에네르기파(Character target){
    	if(this.get기() < 55) {
    		System.out.println("\"기가 모자라서 에네르기파를 쓸 수가 없어!\"");
    		this.기회복();
    		return "\"기가 모자라서 에네르기파를 쓸 수가 없어!\"";
    	}
    	else {
    		System.out.println("\"에~네~르~기~ 파!!!!!\" 손오공의 공격!");
    		if(this.초사이어인 == false) this.깎기(target, (int)(this.get전투력()*0.3), 45);
        	else  this.깎기(target, (int)(this.get전투력()*0.5), 55);
    		return "\"에~네~르~기~ 파!!!!!\" 손오공의 공격!";
    	}
    	
    }

//  수련
  public void 수련하기() {
  	this.setInit_HP(this.getInit_HP()*2);
  	this.setInit_전투력((int)(this.getInit_전투력()*1.5));
  	this.setInit_기(this.getInit_기()*2);
  	this.setHP(this.getInit_HP());
  	this.set전투력(this.getInit_전투력());
  	this.set기(this.getInit_기());
  }
  public boolean get초사이어인() {
	  return 초사이어인;
  }
  public void 초사이어인되기(boolean b) {
	  this.초사이어인=b;
  }

}
