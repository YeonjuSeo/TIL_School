package HunterAnimal;
public class ��ɲ� {
    public static ����[] ��������=new ����[10];
    private static ��ɲ� instance = null;
    private int wallet = 100, hunts, shots, goal;
    
    private ��ɲ�(){}
    
    public static ��ɲ� getInstance() {
    	if(instance==null) instance = new ��ɲ�();
    	return instance;
    }
    
    public void makeGoal() {
    	while(true) {
    		System.out.println("������ ��� ��ǥ��?(1 ~ 4)");
    		goal=Main.input.nextInt();
    		if(goal>=1&&goal<=4) break;
    		else if(goal<1)  System.out.println("��ɲ��̶� ����� �ϴ� ��!");
    		else System.out.println("����� �� �� �õ��� ������ $9�� �Һ��մϴ�!");
    		Main.makeDelay(1);
    	}
    	
		
		shots=0;
		hunts=0;
		System.out.println();
		System.out.println("����� �����մϴ�!");
		Main.makeDelay(3);
    }
    
    public int getWallet() {
		return this.wallet;
	}
    public int getShots() {
    	return this.shots;
    }
    public int getHunts() {
    	return this.hunts;
    }
    public int getGoal() {
    	return this.goal;
    }
    //��� ���� ���θ� ��ȯ
    public boolean canHunt(���� animal) {
    	int caught = (int)(Math.random()*1000)%10;
    	if(animal instanceof ������ && caught<8) return true;
    	else if(animal instanceof ������ && caught<6) return true;
    	else if(animal instanceof �� && caught <5) return true;
    	else if(animal instanceof ��� && caught<3) return true;
    	else return false;
    }
    //��� �� �������� �������� �ش�
    public void makeDamage(���� animal) {
    	int damage = (int)(Math.random()*1000)%animal.getHP();
		System.out.println(animal.�̸�+"���� �������� "+damage+"��ŭ �־����ϴ�!");
		animal.setHP(animal.getHP()-damage);
    }
    
    public void makeMoney() {
    	for(int i=0;i<Main.zooNum;i++) {
    		if(��������[i]==null) continue;
    		//������ 2 ������ 6 �� 4 ��� 8
    		System.out.println(��������[i].�̸�+" �� "+��������[i].getHP()+"�޷��� �Ⱦҽ��ϴ�!");
    		wallet+=��������[i].getHP();
    		��������[i]=null;
    	}
    	Main.zooNum=0;
    	System.out.println("[wallet : $"+wallet+"]");
    	System.out.println();
    }

//    ���� �迭�� ���ڷ� �޾Ƽ� �ƹ��ų� ����ϱ�
    public void ����ϱ�(����[] animals){
//    	���� �迭 �߿��� �����ϰ� �ƹ��ų� ���� //Math.random�� �Ҽ����̶� 1000ó�� ū �� ���Ѵ�.
    	int r = (int)(Math.random()*1000)%Main.animalNum; //r���� 0���� 9������ ���� ���´�
    	if(wallet<9) {
    		�����ϱ�();
    		return;
    	}
    	if(canHunt(animals[r])==true) {
    		makeDamage(animals[r]);
    		System.out.println(animals[r].�̸�+" ��� ����!");
    		
//        	���� �迭�� �ű��
        	��������[Main.zooNum++]=animals[r];
//        	���� �迭 �ش� ���� �����
        	animals[r]=null;
        	
//        	���� �迭�� ������ ������ �̵���Ű��
        	animals[r]=animals[Main.animalNum-1];
        	animals[Main.animalNum-1]=null;
        	
        	hunts++;
        	Main.animalNum--;
    	}
    	else {
    		System.out.println(animals[r].�̸�+"��(��) ������� �޾Ƴ� ���Ƚ��ϴ�...");
    	}
    	wallet-=9;
    	shots++;
    }
    
    public void �����ϱ�() {
    	System.out.println("��ɲ��� �� ������ �ƴѰ���~~~~");
		Main.didAnimalWin = true;
    }
}
