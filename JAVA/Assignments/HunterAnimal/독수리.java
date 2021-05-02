package HunterAnimal;
public class 독수리 extends 동물 {
	private int hp=40;
    public 독수리(){
    }

    public 독수리(String 이름){
    	this.이름=이름;
    }
    @Override
    public boolean 도망치기(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(this.hp<20) {
    		if(escape > 5) return true;
    	}
    	else {
    		if(escape > 3) return true;
    	}
    	
    	놀기();
    	System.out.println(name+"은(는) 오늘도 즐겁게 놀았습니다!");
    	return false;
    }
    
    @Override
    public void 놀기(){
    	System.out.println("\"공중 날기 묘기!!\"");
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
