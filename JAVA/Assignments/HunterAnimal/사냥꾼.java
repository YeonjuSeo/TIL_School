public class ��ɲ� {
    ����[] ��������=new ����[10];
    int ���� = 100;
    
    public ��ɲ�(){
    	
    }
    public ��ɲ�(int size){
//    	System.out.println("���� ��ǥ�� "+size+"������!!");
    }
//  ���� ���忡 �ִ� ���� ���
    public void show() {
    	System.out.println("--------------Zoo----------------");
		for(int i=0;i<��������.length;i++) {
			if(��������[i]==null) {
				System.out.print("X | ");
			}
			else {
				System.out.print(��������[i].�̸�+" | ");
			}
		}
		System.out.println();
		System.out.println("---------------------------------");
    }
    
    public void ����ϱ�(���� animal){
    }
    
//    �� ���� �޼ҵ�� �ٲ� �� ���� �� ������...
    public void makeGoal() {
    	System.out.println("������ ��� ��ǥ��?"); //1~5 �� ���� �α�
		Main.goal=Main.input.nextInt();
    }
    
    public boolean canHunt(String ����) {
    	int caught = (int)(Math.random()*1000)%10;
    	if(���� =="������" && caught<8) return true;
    	else if(���� == "������" && caught<4) return true;
    	else if(���� == "��" && caught <6) return true;
    	else if(���� == "���" && caught<3) return true;
    	else return false;
    }

//  ������ ��� Ȯ�� 40%
    public void ����ϱ�(������ bird){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<4) {
//    		System.out.println(bird.�̸�+" ����ϱ� ����!");
//    		��������[Main.zooNum++]=bird;
//    	}
//    	else {
//    		System.out.println(bird.�̸�+"�� �绡�� ���ư� ���Ƚ��ϴ�...");
//    	}
    }

//  �� ��� Ȯ��: 60%
    public void ����ϱ�(�� snake){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<6) {
//    		System.out.println(snake.�̸�+" ����ϱ� ����!");
//    		��������[Main.zooNum++]=snake;
//    	}
//    	else {
//    		System.out.println(snake.�̸�+"�� ���� ���Ƚ��ϴ�...");
//    	}
    }
    
//  ������ ��� Ȯ��: 80%
    public void ����ϱ�(������ dog){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<8) {
//    		System.out.println(dog.�̸�+" ����ϱ� ����!");
//    		��������[Main.zooNum++]=dog;
//    	}
//    	else {
//    		System.out.println(dog.�̸�+"�� �޾Ƴ� ���Ƚ��ϴ�...");
//    	}
    }
    
//  ��� ��� Ȯ��: 30%
    public void ����ϱ�(��� shark){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<3) {
//    		System.out.println(shark.�̸�+" ����ϱ� ����!");
//    		��������[Main.zooNum++]=shark;
//    	}
//    	else {
//    		System.out.println(shark.�̸�+"���׼� �޾Ƴ����ϴ�!");
//    	}
    }

//    ���� �迭�� ���ڷ� �޾Ƽ� �ƹ��ų� ����ϱ�
    public void ����ϱ�(����[] animals){
//    	���� �迭 �߿��� �����ϰ� �ƹ��ų� ���� //Math.random�� �Ҽ����̶� 1000ó�� ū �� ���Ѵ�.
    	int r = (int)(Math.random()*1000)%Main.animalNum; //r���� 0���� 9������ ���� ���´�
    	if(canHunt(animals[r].getClass().getName())==true) {
    		System.out.println(animals[r].�̸�+" ��� ����!");
//        	���� �迭�� �ű��
        	��������[Main.zooNum++]=animals[r];
//        	���� �迭 �ش� ���� �����
        	animals[r]=null;
        	
//        	���� �迭�� ������ ������ �̵���Ű��
        	animals[r]=animals[Main.animalNum-1];
        	animals[Main.animalNum-1]=null;
        	
//        	���� �迭�� ����ִ� ���� ������ ���̱� //�迭 ũ��� ����ִ� ���� �� �ٸ�
        	Main.animalNum--;
    	}
    	else {
    		System.out.println(animals[r].�̸�+"��(��) ������� �޾Ƴ� ���Ƚ��ϴ�...");
    	}
    }

}
