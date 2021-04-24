public class 사냥꾼 {
    동물[] 동물농장=new 동물[10];
    int 지갑 = 100;
    
    public 사냥꾼(){
    	
    }
    public 사냥꾼(int size){
//    	System.out.println("오늘 목표는 "+size+"마리야!!");
    }
//  동물 농장에 있는 동물 출력
    public void show() {
    	System.out.println("--------------Zoo----------------");
		for(int i=0;i<동물농장.length;i++) {
			if(동물농장[i]==null) {
				System.out.print("X | ");
			}
			else {
				System.out.print(동물농장[i].이름+" | ");
			}
		}
		System.out.println();
		System.out.println("---------------------------------");
    }
    
    public void 사냥하기(동물 animal){
    }
    
//    더 나은 메소드로 바꿀 수 있을 것 같은데...
    public void makeGoal() {
    	System.out.println("오늘의 사냥 목표는?"); //1~5 등 제한 두기
		Main.goal=Main.input.nextInt();
    }
    
    public boolean canHunt(String 종류) {
    	int caught = (int)(Math.random()*1000)%10;
    	if(종류 =="강아지" && caught<8) return true;
    	else if(종류 == "독수리" && caught<4) return true;
    	else if(종류 == "뱀" && caught <6) return true;
    	else if(종류 == "상어" && caught<3) return true;
    	else return false;
    }

//  독수리 사냥 확률 40%
    public void 사냥하기(독수리 bird){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<4) {
//    		System.out.println(bird.이름+" 사냥하기 성공!");
//    		동물농장[Main.zooNum++]=bird;
//    	}
//    	else {
//    		System.out.println(bird.이름+"이 재빨리 날아가 버렸습니다...");
//    	}
    }

//  뱀 사냥 확률: 60%
    public void 사냥하기(뱀 snake){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<6) {
//    		System.out.println(snake.이름+" 사냥하기 성공!");
//    		동물농장[Main.zooNum++]=snake;
//    	}
//    	else {
//    		System.out.println(snake.이름+"이 숨어 버렸습니다...");
//    	}
    }
    
//  강아지 사냥 확률: 80%
    public void 사냥하기(강아지 dog){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<8) {
//    		System.out.println(dog.이름+" 사냥하기 성공!");
//    		동물농장[Main.zooNum++]=dog;
//    	}
//    	else {
//    		System.out.println(dog.이름+"이 달아나 버렸습니다...");
//    	}
    }
    
//  상어 사냥 확률: 30%
    public void 사냥하기(상어 shark){
//    	int caught = (int)(Math.random()*1000)%10;
//    	if(caught<3) {
//    		System.out.println(shark.이름+" 사냥하기 성공!");
//    		동물농장[Main.zooNum++]=shark;
//    	}
//    	else {
//    		System.out.println(shark.이름+"한테서 달아났습니다!");
//    	}
    }

//    숲속 배열을 인자로 받아서 아무거나 사냥하기
    public void 사냥하기(동물[] animals){
//    	동물 배열 중에서 랜덤하게 아무거나 고르기 //Math.random은 소수점이라 1000처럼 큰 걸 곱한다.
    	int r = (int)(Math.random()*1000)%Main.animalNum; //r에는 0부터 9까지의 수가 들어온다
    	if(canHunt(animals[r].getClass().getName())==true) {
    		System.out.println(animals[r].이름+" 사냥 성공!");
//        	동물 배열로 옮기기
        	동물농장[Main.zooNum++]=animals[r];
//        	숲속 배열 해당 동물 지우기
        	animals[r]=null;
        	
//        	숲속 배열의 마지막 동물을 이동시키기
        	animals[r]=animals[Main.animalNum-1];
        	animals[Main.animalNum-1]=null;
        	
//        	숲속 배열에 살고있는 동물 마리수 줄이기 //배열 크기와 살고있는 동물 수 다름
        	Main.animalNum--;
    	}
    	else {
    		System.out.println(animals[r].이름+"이(가) 재빠르게 달아나 버렸습니다...");
    	}
    }

}
