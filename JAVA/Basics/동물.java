public class 동물 {
    private String 이름;
    private int 나이;

    public 동물() {
		super();
	}

	public 동물(String 이름) {
		super();
		this.이름 = 이름;
	}

	public 동물(String 이름, int 나이) {
		super();
		this.이름 = 이름;
		this.나이 = 나이;
	}

	public void 먹기(){
    	System.out.println(이름+"이 산에서 풀을 뜯어 먹습니다!");
    }

    public void 놀기(){
    	System.out.println(이름+"이 산에서 풀을 뜯고 놉니다!");
    }

    public void 놀기(int 시간){
    	for(int i=0;i<시간;i++) {
    		놀기();
    	}
    }

    public int 잠자기(){
    	System.out.println(이름+"이 산에서 쿨쿨잡니다~~");
        return 0;
    }

}
