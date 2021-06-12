package Player;

public class 베지터 extends Character implements Trainable, Syanable, Joinable {
    private boolean 초사이어인;
    private boolean 아군;
    
    public 베지터(){
    	this.setInit_HP(150);
    	this.setInit_전투력(80);
    	this.setInit_기(120);
    	this.setHP(this.getInit_HP());
    	this.set전투력(this.getInit_전투력());
    	this.set기(this.getInit_기());
    	this.set아군(false);
    	this.초사이어인되기(false);
    	this.이름 = "베지터";
    }
    public <Boolean> void set아군(boolean b) {
    	this.아군=b;
    }
    public boolean get아군() {
    	return this.아군;
    }
    
    @Override
    public <Character, Int> String attack(Character target, int num) {
    	int attack = (int)(Math.random()*1000);
    	int divisor = 2;
    	String dialog = null;
    	this.showStatus();    
    	if(this.get아군()==true) divisor = 3;
    	
    	if(attack%divisor==0) {
    		dialog = 체술(target);
    	}
    	else if(attack%divisor==1) {
    		dialog = 갤릭포(target);
    	}
    	else if(attack%divisor==2) {
    		dialog = 빅뱅어택(target);
    	}
    	
    	return dialog;
    }
    
    @Override
    public <Character>String 체술(Character target) {
    	System.out.println("\"간다!!! \" 베지터의 공격!");
    	this.깎기(target, (int)(this.get전투력()*0.1), 0);
    	this.기회복();
    	return "\"간다!!! \" 베지터의 공격!";
    }
    
    public<Character> String 갤릭포(Character target){
    	if(this.get기() < 55) {
    		System.out.println("\"기를 모으는 중이다!\"");
    		this.기회복();
    		return "\"기를 모으는 중이다!\"";
    	}
    	else {
    		System.out.println("\"지구와 함께 우주의 먼지가 돼라!!!!!\" 베지터의 갤릭포 공격!");
    		this.깎기(target, (int)(this.get전투력()*0.3), 55);
    		return "\"지구와 함께 우주의 먼지가 돼라!!!!!\" 베지터의 갤릭포 공격!";
    	}
    }

    public <Character>String 빅뱅어택(Character target){
    	if(this.get기() < 55) {
    		System.out.println("\"조금 더 기다려라!\"");
    		return "\"조금 더 기다려라!\"";
    	}
    	else {
    		System.out.println("\"빅뱅어택!!!!!\" 베지터의 빅뱅어택 공격!");
    		this.깎기(target, (int)(this.get전투력()*0.3), 55);
        	return "\"빅뱅어택!!!!!\" 베지터의 빅뱅어택 공격!";
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
