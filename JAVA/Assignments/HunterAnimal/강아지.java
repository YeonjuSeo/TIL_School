package HunterAnimal;

public class ������ extends ���� {
	private int hp=30;
    public ������(){
    }

    public ������(String name){
    	this.�̸�=name;
    }

    @Override
    public boolean ����ġ��(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(this.hp<15) {
    		if(escape > 7) return true;
    	}
    	else {
    		if(escape > 5) return true;
    	}
    	
    	���();
    	System.out.println(name+"��(��) ���õ� ��̰� ��ҽ��ϴ�!");
    	return false;
    }
    @Override
    public void ���(){
    	����������();
    	�Ź߹���������();
    }

    public void ����������(){
    	System.out.println("\"������ �ʴ��ʴ� ������...\"");
    }

    public void �Ź߹���������(){
    	System.out.println("\"�� �Կ��� �������� �� ����!\"");
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
    
}
