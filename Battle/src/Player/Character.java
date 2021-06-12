package Player;
public class Character {
	public String 이름;
    private int init_HP;
    private int init_전투력;
    private int init_기;
    private int HP;
    private int 전투력;
    private int 기;
    private boolean 아군;
    
    public Character() {}
    
//    getter와 setter
    public int getHP() {
    	return this.HP;
    }
    public <Int> void setHP(int hp) {
    	this.HP=hp;
    }
    public int get전투력() {
    	return this.전투력;
    }
    public <Int> void set전투력(int 전투력) {
    	this.전투력=전투력;
    }
    public int get기() {
    	return this.기;
    }
    public <Integer> void set기(int 기) {
    	this.기=기;
    }
    
    public int getInit_HP() {
    	return this.init_HP;
    }
    public <Int> void setInit_HP(int init_HP) {
    	this.init_HP = init_HP;
    }
    public int getInit_전투력() {
    	return this.init_전투력;
    }
    public <Int> void setInit_전투력(int init_전투력) {
    	this.init_전투력 = init_전투력;
    }
    public int getInit_기() {
    	return this.init_기;
    }
    public <Int> void setInit_기(int init_기) {
    	this.init_기 = init_기;
    }
    
//  공격과 방어

    public <Character> String 체술(Character target){
    	return"";
    }

    public void 기회복(){
    	if(this.get기()<this.getInit_기()) {
    		if(this.getInit_기()-this.get기() <10) this.기 = this.getInit_기();
    		else this.기+=10;
    	}
    		
    }

    public <Character> void HP회복(Character target){
    }
    
    public <Character, Int, Int1> void 깎기(Character target, int d, int cost) {
    	((Player.Character) target).setHP(((Player.Character) target).getHP()-d);
    	this.기-=cost;
    	System.out.println(((Player.Character) target).이름+"이(가) 데미지를 "+d+" 입었습니다.");
    }
    
    public <Character, Int>String attack(Character target, int num) {
    	return"";
    }
    
    
//    현재 상태 보여주기 show 만들기
    public void showStatus() {
    	System.out.println(this.이름+"[HP:"+this.getHP()+" 전투력:"+this.get전투력()+"기:"+this.get기()+"]");
    }
    

}
