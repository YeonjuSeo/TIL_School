package HunterAnimal;
public class ������ extends ���� {
	private int hp=40;
    public ������(){
    }

    public ������(String �̸�){
    	this.�̸�=�̸�;
    }
    @Override
    public boolean ����ġ��(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(this.hp<20) {
    		if(escape > 5) return true;
    	}
    	else {
    		if(escape > 3) return true;
    	}
    	
    	���();
    	System.out.println(name+"��(��) ���õ� ��̰� ��ҽ��ϴ�!");
    	return false;
    }
    
    @Override
    public void ���(){
    	System.out.println("\"���� ���� ����!!\"");
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
