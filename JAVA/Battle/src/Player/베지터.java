package Player;

public class ������ extends Character implements Trainable, Syanable, Joinable {
    private boolean �ʻ��̾���;
    private boolean �Ʊ�;
    
    public ������(){
    	this.setInit_HP(150);
    	this.setInit_������(80);
    	this.setInit_��(120);
    	this.setHP(this.getInit_HP());
    	this.set������(this.getInit_������());
    	this.set��(this.getInit_��());
    	this.set�Ʊ�(false);
    	this.�ʻ��̾��εǱ�(false);
    	this.�̸� = "������";
    }
    public <Boolean> void set�Ʊ�(boolean b) {
    	this.�Ʊ�=b;
    }
    public boolean get�Ʊ�() {
    	return this.�Ʊ�;
    }
    
    @Override
    public <Character, Int> String attack(Character target, int num) {
    	int attack = (int)(Math.random()*1000);
    	int divisor = 2;
    	String dialog = null;
    	this.showStatus();    
    	if(this.get�Ʊ�()==true) divisor = 3;
    	
    	if(attack%divisor==0) {
    		dialog = ü��(target);
    	}
    	else if(attack%divisor==1) {
    		dialog = ������(target);
    	}
    	else if(attack%divisor==2) {
    		dialog = ������(target);
    	}
    	
    	return dialog;
    }
    
    @Override
    public <Character>String ü��(Character target) {
    	System.out.println("\"����!!! \" �������� ����!");
    	this.���(target, (int)(this.get������()*0.1), 0);
    	this.��ȸ��();
    	return "\"����!!! \" �������� ����!";
    }
    
    public<Character> String ������(Character target){
    	if(this.get��() < 55) {
    		System.out.println("\"�⸦ ������ ���̴�!\"");
    		this.��ȸ��();
    		return "\"�⸦ ������ ���̴�!\"";
    	}
    	else {
    		System.out.println("\"������ �Բ� ������ ������ �Ŷ�!!!!!\" �������� ������ ����!");
    		this.���(target, (int)(this.get������()*0.3), 55);
    		return "\"������ �Բ� ������ ������ �Ŷ�!!!!!\" �������� ������ ����!";
    	}
    }

    public <Character>String ������(Character target){
    	if(this.get��() < 55) {
    		System.out.println("\"���� �� ��ٷ���!\"");
    		return "\"���� �� ��ٷ���!\"";
    	}
    	else {
    		System.out.println("\"������!!!!!\" �������� ������ ����!");
    		this.���(target, (int)(this.get������()*0.3), 55);
        	return "\"������!!!!!\" �������� ������ ����!";
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
