package HunterAnimal;
public class 상어 extends 동물 {
	private int hp=80;
    public 상어(){
    }

    public 상어(String 이름){
    	this.이름=이름;
    }
    
    @Override
    public boolean 도망치기(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(hp<50) {
    		if(escape>7) return true;
    	}
    	else {
    		if(escape > 5) return true;
    	}
    	
    	놀기();
    	System.out.println(name+"은(는) 우울합니다...");
    	return false;
    }

    public void 헤엄치기(){
    	System.out.println("\"산에서는 헤엄을 칠 수 없어...\"");
    }
    @Override
    public void 놀기(){
    	헤엄치기();
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
