package HunterAnimal;
public class ��� extends ���� {
	private int hp=80;
    public ���(){
    }

    public ���(String �̸�){
    	this.�̸�=�̸�;
    }
    
    @Override
    public boolean ����ġ��(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(hp<50) {
    		if(escape>7) return true;
    	}
    	else {
    		if(escape > 5) return true;
    	}
    	
    	���();
    	System.out.println(name+"��(��) ����մϴ�...");
    	return false;
    }

    public void ���ġ��(){
    	System.out.println("\"�꿡���� ����� ĥ �� ����...\"");
    }
    @Override
    public void ���(){
    	���ġ��();
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
