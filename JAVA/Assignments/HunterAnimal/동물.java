public class ���� implements Playable, Moveable {
    public String �̸�;
    private int ����;
    public int hp;
    public int power;
    private int money;
    private int hunted; //���� attribute
dl 
    public ����(){
//    	System.out.println("������ �Ѹ��� �����մϴ�.");
    }

    public ����(String �̸�){
    	this.�̸� = �̸�;
//    	System.out.println(this.�̸�+"�� ���� ������ �Ѹ��� �����մϴ�.");
    }
    
    //���� �޼ҵ�
    public int getHunted() {
    	return this.hunted;
    }
    public void setHunted(int hunted) {
    	this.hunted = hunted;
    }
    
    //���̰� private
    //Getter
    public int get����(){  //get�� �������� ��
        return this.����;
    }
    //Setter
    public void set����(int ����){
    	this.���� = ����;
    }

    public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void ���(){
    }

    public void �Ա�(){
    }

    public void �ڱ�(){
    }

    public void �����̱�(){
    }

    public void show(){ //���� ���� �Ӽ�(����)�� ��� �����ִ� �޼ҵ�
    }

}
