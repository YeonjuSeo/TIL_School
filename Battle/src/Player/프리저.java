package Player;

public class 프리저 extends Character {
    
    public 프리저() {
    	this.setInit_HP(800);
    	this.setInit_전투력(530);
    	this.setInit_기(450);
    	this.setHP(800);
    	this.set전투력(530);
    	this.set기(450);
    	this.이름 = "프리저";
    }
    @Override
    public <Character, Int> String attack(Character target, int num) {
    	int attack = (int)(Math.random()*1000);
    	String dialog = null;
    	this.showStatus();
    	if(attack%3==0) {
    		dialog = 데스빔(target);
    	}
    	else if(attack%3==1) {
    		dialog = 데스소서(target);
    	}
    	else if(attack%3==2) {
    		dialog = 데스볼(target);
    	}
    	return dialog;
    }
    public <Character> String 데스빔(Character target){
    	if(this.get기() < 70) {
    		System.out.println("\"기를 모아야합니다.\"");
    		this.기회복();
    		return "\"기를 모아야 합니다.\"";
    	}
    	else {
    		System.out.println("\"아직 멀었습니다!\" 프리저의 데스빔!");
        	this.깎기(target, (int)(this.get전투력()*0.4), 70);
        	return "\"아직 멀었습니다!\" 프리저의 데스빔!";
    	}
    	
    }

    public <Character> String 데스소서(Character target){
    	if(this.get기() < 65) {
    		System.out.println("\"기를 모아야합니다.\"");
    		this.기회복();
    		return "\"기를 모아야 합니다.\"";
    	}
    	else {
    		System.out.println("\"아직 멀었습니다!\" 프리저의 데스소서!");
        	this.깎기(target, (int)(this.get전투력()*0.5), 65);
        	return "\"아직 멀었습니다!\" 프리저의 데스소서!";
    	}
    	
    }

    public <Character> String 데스볼(Character target){
    	if(this.get기() < 80) {
    		System.out.println("\"기를 모아야합니다.\"");
    		this.기회복();
    		return "\"기를 모아야 합니다.\"";
    	}
    	else {
    		System.out.println("\"아직 멀었습니다!\" 프리저의 데스볼!");
        	this.깎기(target, (int)(this.get전투력()*0.6), 80);
        	return "\"아직 멀었습니다!\" 프리저의 데스볼!";
    	}
    	
    }

}
