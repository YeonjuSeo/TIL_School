package HunterAnimal;
public class �� extends ���� {
	private int hp=30;
    public ��(){
    }

    public ��(String �̸�){
    	this.�̸�=�̸�;
    }
    @Override
    public boolean ����ġ��(String name) {
    	int escape = (int)(Math.random()*1000)%10;
    	if(this.hp<15) {
    		if(escape>5) return true;
    	}
    	else {
    		if(escape > 4) return true;
    	}
    	
    	�ڱ�();
    	System.out.println(name+"��(��) ���� �����ϴ�...");
    	return false;
    }

    public void �̸�Ʋ��(){
    	System.out.println("\"�ڸ鼭 �̸��� Ʈ�ϱ� ���� ��ȯ�� �� �ȵ�...\"");
    }
    @Override
    public void �ڱ�(){
    	�̸�Ʋ��();
    }
    public int getHP() {
		return this.hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}
}
