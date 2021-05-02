package HunterAnimal;

public class 강아지 extends 동물 {
	private int hp=30;
    public 강아지(){
    }

    public 강아지(String name){
    	this.이름=name;
    }

    @Override
    public boolean 도망치기(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(this.hp<15) {
    		if(escape > 7) return true;
    	}
    	else {
    		if(escape > 5) return true;
    	}
    	
    	놀기();
    	System.out.println(name+"은(는) 오늘도 즐겁게 놀았습니다!");
    	return false;
    }
    @Override
    public void 놀기(){
    	인형물어뜯기();
    	신발물고도망가기();
    }

    public void 인형물어뜯기(){
    	System.out.println("\"인형이 너덜너덜 해졌네...\"");
    }

    public void 신발물고도망가기(){
    	System.out.println("\"내 입에서 냄새나는 것 같아!\"");
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
    
}
