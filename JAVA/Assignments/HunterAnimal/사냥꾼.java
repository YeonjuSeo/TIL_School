package HunterAnimal;
public class 사냥꾼 {
    public static 동물[] 동물농장=new 동물[10];
    private static 사냥꾼 instance = null;
    private int wallet = 100, hunts, shots, goal;
    
    private 사냥꾼(){}
    
    public static 사냥꾼 getInstance() {
    	if(instance==null) instance = new 사냥꾼();
    	return instance;
    }
    
    public void makeGoal() {
    	while(true) {
    		System.out.println("오늘의 사냥 목표는?(1 ~ 4)");
    		goal=Main.input.nextInt();
    		if(goal>=1&&goal<=4) break;
    		else if(goal<1)  System.out.println("사냥꾼이란 사냥을 하는 자!");
    		else System.out.println("사냥을 한 번 시도할 때마다 $9씩 소비합니다!");
    		Main.makeDelay(1);
    	}
    	
		
		shots=0;
		hunts=0;
		System.out.println();
		System.out.println("사냥을 시작합니다!");
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
    //사냥 성공 여부를 반환
    public boolean canHunt(동물 animal) {
    	int caught = (int)(Math.random()*1000)%10;
    	if(animal instanceof 강아지 && caught<8) return true;
    	else if(animal instanceof 독수리 && caught<6) return true;
    	else if(animal instanceof 뱀 && caught <5) return true;
    	else if(animal instanceof 상어 && caught<3) return true;
    	else return false;
    }
    //사냥 시 동물에게 데미지를 준다
    public void makeDamage(동물 animal) {
    	int damage = (int)(Math.random()*1000)%animal.getHP();
		System.out.println(animal.이름+"에게 데미지를 "+damage+"만큼 주었습니다!");
		animal.setHP(animal.getHP()-damage);
    }
    
    public void makeMoney() {
    	for(int i=0;i<Main.zooNum;i++) {
    		if(동물농장[i]==null) continue;
    		//강아지 2 독수리 6 뱀 4 상어 8
    		System.out.println(동물농장[i].이름+" 을 "+동물농장[i].getHP()+"달러에 팔았습니다!");
    		wallet+=동물농장[i].getHP();
    		동물농장[i]=null;
    	}
    	Main.zooNum=0;
    	System.out.println("[wallet : $"+wallet+"]");
    	System.out.println();
    }

//    숲속 배열을 인자로 받아서 아무거나 사냥하기
    public void 사냥하기(동물[] animals){
//    	동물 배열 중에서 랜덤하게 아무거나 고르기 //Math.random은 소수점이라 1000처럼 큰 걸 곱한다.
    	int r = (int)(Math.random()*1000)%Main.animalNum; //r에는 0부터 9까지의 수가 들어온다
    	if(wallet<9) {
    		포기하기();
    		return;
    	}
    	if(canHunt(animals[r])==true) {
    		makeDamage(animals[r]);
    		System.out.println(animals[r].이름+" 사냥 성공!");
    		
//        	동물 배열로 옮기기
        	동물농장[Main.zooNum++]=animals[r];
//        	숲속 배열 해당 동물 지우기
        	animals[r]=null;
        	
//        	숲속 배열의 마지막 동물을 이동시키기
        	animals[r]=animals[Main.animalNum-1];
        	animals[Main.animalNum-1]=null;
        	
        	hunts++;
        	Main.animalNum--;
    	}
    	else {
    		System.out.println(animals[r].이름+"이(가) 재빠르게 달아나 버렸습니다...");
    	}
    	wallet-=9;
    	shots++;
    }
    
    public void 포기하기() {
    	System.out.println("사냥꾼은 내 적성이 아닌가봐~~~~");
		Main.didAnimalWin = true;
    }
}
