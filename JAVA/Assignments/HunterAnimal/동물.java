package HunterAnimal;

public abstract class 동물 implements Playable, Escapable {
    public String 이름;
    public int money;
    private int hp;

    public 동물(){
    }

    public 동물(String 이름){
    	this.이름 = 이름;
    }
    
    @Override
    public boolean 도망치기(String name) {
		return true;
	};
    
	public void 놀기(){
    }

    public void 자기(){
    }

    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
