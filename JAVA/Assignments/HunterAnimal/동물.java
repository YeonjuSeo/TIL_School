public class 동물 implements Playable, Moveable {
    public String 이름;
    private int 나이;
    public int hp;
    public int power;
    private int money;
    private int hunted; //예시 attribute
dl 
    public 동물(){
//    	System.out.println("동물을 한마리 생성합니다.");
    }

    public 동물(String 이름){
    	this.이름 = 이름;
//    	System.out.println(this.이름+"을 가진 동물을 한마리 생성합니다.");
    }
    
    //예시 메소드
    public int getHunted() {
    	return this.hunted;
    }
    public void setHunted(int hunted) {
    	this.hunted = hunted;
    }
    
    //나이가 private
    //Getter
    public int get나이(){  //get은 가져오는 것
        return this.나이;
    }
    //Setter
    public void set나이(int 나이){
    	this.나이 = 나이;
    }

    public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void 놀기(){
    }

    public void 먹기(){
    }

    public void 자기(){
    }

    public void 움직이기(){
    }

    public void show(){ //현재 가진 속성(정보)을 모두 보여주는 메소드
    }

}
