package Player;
public class Character {
	public String �̸�;
    private int init_HP;
    private int init_������;
    private int init_��;
    private int HP;
    private int ������;
    private int ��;
    private boolean �Ʊ�;
    
    public Character() {}
    
//    getter�� setter
    public int getHP() {
    	return this.HP;
    }
    public <Int> void setHP(int hp) {
    	this.HP=hp;
    }
    public int get������() {
    	return this.������;
    }
    public <Int> void set������(int ������) {
    	this.������=������;
    }
    public int get��() {
    	return this.��;
    }
    public <Integer> void set��(int ��) {
    	this.��=��;
    }
    
    public int getInit_HP() {
    	return this.init_HP;
    }
    public <Int> void setInit_HP(int init_HP) {
    	this.init_HP = init_HP;
    }
    public int getInit_������() {
    	return this.init_������;
    }
    public <Int> void setInit_������(int init_������) {
    	this.init_������ = init_������;
    }
    public int getInit_��() {
    	return this.init_��;
    }
    public <Int> void setInit_��(int init_��) {
    	this.init_�� = init_��;
    }
    
//  ���ݰ� ���

    public <Character> String ü��(Character target){
    	return"";
    }

    public void ��ȸ��(){
    	if(this.get��()<this.getInit_��()) {
    		if(this.getInit_��()-this.get��() <10) this.�� = this.getInit_��();
    		else this.��+=10;
    	}
    		
    }

    public <Character> void HPȸ��(Character target){
    }
    
    public <Character, Int, Int1> void ���(Character target, int d, int cost) {
    	((Player.Character) target).setHP(((Player.Character) target).getHP()-d);
    	this.��-=cost;
    	System.out.println(((Player.Character) target).�̸�+"��(��) �������� "+d+" �Ծ����ϴ�.");
    }
    
    public <Character, Int>String attack(Character target, int num) {
    	return"";
    }
    
    
//    ���� ���� �����ֱ� show �����
    public void showStatus() {
    	System.out.println(this.�̸�+"[HP:"+this.getHP()+" ������:"+this.get������()+"��:"+this.get��()+"]");
    }
    

}
