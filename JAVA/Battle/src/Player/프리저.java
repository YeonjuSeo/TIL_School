package Player;

public class ������ extends Character {
    
    public ������() {
    	this.setInit_HP(800);
    	this.setInit_������(530);
    	this.setInit_��(450);
    	this.setHP(800);
    	this.set������(530);
    	this.set��(450);
    	this.�̸� = "������";
    }
    @Override
    public <Character, Int> String attack(Character target, int num) {
    	int attack = (int)(Math.random()*1000);
    	String dialog = null;
    	this.showStatus();
    	if(attack%3==0) {
    		dialog = ������(target);
    	}
    	else if(attack%3==1) {
    		dialog = �����Ҽ�(target);
    	}
    	else if(attack%3==2) {
    		dialog = ������(target);
    	}
    	return dialog;
    }
    public <Character> String ������(Character target){
    	if(this.get��() < 70) {
    		System.out.println("\"�⸦ ��ƾ��մϴ�.\"");
    		this.��ȸ��();
    		return "\"�⸦ ��ƾ� �մϴ�.\"";
    	}
    	else {
    		System.out.println("\"���� �־����ϴ�!\" �������� ������!");
        	this.���(target, (int)(this.get������()*0.4), 70);
        	return "\"���� �־����ϴ�!\" �������� ������!";
    	}
    	
    }

    public <Character> String �����Ҽ�(Character target){
    	if(this.get��() < 65) {
    		System.out.println("\"�⸦ ��ƾ��մϴ�.\"");
    		this.��ȸ��();
    		return "\"�⸦ ��ƾ� �մϴ�.\"";
    	}
    	else {
    		System.out.println("\"���� �־����ϴ�!\" �������� �����Ҽ�!");
        	this.���(target, (int)(this.get������()*0.5), 65);
        	return "\"���� �־����ϴ�!\" �������� �����Ҽ�!";
    	}
    	
    }

    public <Character> String ������(Character target){
    	if(this.get��() < 80) {
    		System.out.println("\"�⸦ ��ƾ��մϴ�.\"");
    		this.��ȸ��();
    		return "\"�⸦ ��ƾ� �մϴ�.\"";
    	}
    	else {
    		System.out.println("\"���� �־����ϴ�!\" �������� ������!");
        	this.���(target, (int)(this.get������()*0.6), 80);
        	return "\"���� �־����ϴ�!\" �������� ������!";
    	}
    	
    }

}
