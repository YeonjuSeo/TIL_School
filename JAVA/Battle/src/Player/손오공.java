package Player;

import java.util.Scanner;

public class �տ��� extends Character implements Trainable, Syanable {
	Scanner scanner = new Scanner(System.in);
    private boolean �ʻ��̾���;
    
    public �տ���() {
    	this.setInit_HP(100);
    	this.setInit_������(60);
    	this.setInit_��(100);
    	this.setHP(this.getInit_HP());
    	this.set������(this.getInit_������());
    	this.set��(this.getInit_��());
    	this.�ʻ��̾��εǱ�(false);
    	this.�̸� = "�տ���";
    }

    public <Character, Int>String attack(Character target, int num) {
    	this.showStatus();
    	String dialog = null;
    	if(num == 1) dialog = �����������ǹ�(target);
    	else if(num == 2) dialog = ���׸�����(target);
    	return dialog;
    	
    }
    
    public <Character> String �����������ǹ�(Character target){
    	System.out.println("\"����! ����! ��!\" �տ����� ����!");
    	if(this.�ʻ��̾��� == false) this.���(target, (int)(this.get������()*0.1), 0);
    	else  this.���(target, (int)(this.get������()*0.2), 0);
    	this.��ȸ��();
    	return "\"����! ����! ��!\" �տ����� ����!";
    }

    public <Character> String ���׸�����(Character target){
    	if(this.get��() < 55) {
    		System.out.println("\"�Ⱑ ���ڶ� ���׸����ĸ� �� ���� ����!\"");
    		this.��ȸ��();
    		return "\"�Ⱑ ���ڶ� ���׸����ĸ� �� ���� ����!\"";
    	}
    	else {
    		System.out.println("\"��~��~��~��~ ��!!!!!\" �տ����� ����!");
    		if(this.�ʻ��̾��� == false) this.���(target, (int)(this.get������()*0.3), 45);
        	else  this.���(target, (int)(this.get������()*0.5), 55);
    		return "\"��~��~��~��~ ��!!!!!\" �տ����� ����!";
    	}
    	
    }

//  ����
  public void �����ϱ�() {
  	this.setInit_HP(this.getInit_HP()*2);
  	this.setInit_������((int)(this.getInit_������()*1.5));
  	this.setInit_��(this.getInit_��()*2);
  	this.setHP(this.getInit_HP());
  	this.set������(this.getInit_������());
  	this.set��(this.getInit_��());
  }
  public boolean get�ʻ��̾���() {
	  return �ʻ��̾���;
  }
  public void �ʻ��̾��εǱ�(boolean b) {
	  this.�ʻ��̾���=b;
  }

}
