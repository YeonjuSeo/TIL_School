package HunterAnimal;

public abstract class ���� implements Playable, Escapable {
    public String �̸�;
    public int money;
    private int hp;

    public ����(){
    }

    public ����(String �̸�){
    	this.�̸� = �̸�;
    }
    
    @Override
    public boolean ����ġ��(String name) {
		return true;
	};
    
	public void ���(){
    }

    public void �ڱ�(){
    }

    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
