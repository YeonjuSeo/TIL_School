package HunterAnimal;
public class 뱀 extends 동물 {
	private int hp=30;
    public 뱀(){
    }

    public 뱀(String 이름){
    	this.이름=이름;
    }
    @Override
    public boolean 도망치기(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(this.hp<15) {
    		if(escape>5) return true;
    	}
    	else {
    		if(escape > 4) return true;
    	}
    	
    	자기();
    	System.out.println(name+"은(는) 몸이 저립니다...");
    	return false;
    }

    public void 똬리틀기(){
    	System.out.println("\"자면서 똬리를 트니까 혈액 순환이 잘 안돼...\"");
    }
    @Override
    public void 자기(){
    	똬리틀기();
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
