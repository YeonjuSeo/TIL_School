package tts_view;
import mary.TextToSpeech;

public class Mary extends TextToSpeech {

//    private TextToSpeech tts = new TextToSpeech();
    String name;
    public Mary() {
        this.name ="mimi"; //�⺻ �̹�
    }
 
    public Mary(String name) {
        this.name=name;
    }        
    //�������̵��� �����ε��� �Բ�
    public void speak(String msg) {
        super.speak(msg, 1.0f, false, true); //��ư �� ������ true�� �ؼ� ����!
    }
 
    public void speak(String msg, float vol) {
        super.speak(msg, vol, false, true);
    }
 
    public void call(String name) {
    	int start = name.indexOf(" ");
    	String str = name;
    	if(start !=0) str = name.substring(start+1);
    	System.out.println(str);
        //�̸��� ������ ��
        if (!this.name.equals(str))
            speak("I am not" + name +"!! My name is "+ this.name);
        else speak("Yes my load! have a Good Day~~~~!!");
        
    }
    
    public void changeWoman() {
        setVoice("dfki-poppy-hsmm");
    }
    public void changeMan() {
        setVoice("cmu-rms-hsmm");
    }
    
    public static void main(String [] args) {
        
        Mary mary = new Mary("mary");
        mary.changeMan();
        mary.speak("a a  voice test! ");
        
        mary.call("marymary");
        
        mary.call("hi~ alexa");
        mary.call("hi~ ari");        
        mary.call("hi~ mimi");
        mary.call("hi~ mary");
        mary.call("mimi");
        
        mary.speak("Today we will learn how to use text-to-speach service with small and good class library on Mary T T S!");
        mary.speak("you can use Sound-effect instead console System.out.println .");
        mary.speak("I can read numbers and some characters!");
        
        mary.changeWoman();
        
        mary.speak("hello~~ good morning!");
        mary.speak("hi girls~!  i am a  't t s '");
        mary.call("mary");
        mary.call("mimi");      
        mary.speak( "my favorite number is " + 3  );
          
          //tts�� ���� �� �ִ� ���ڴ�?
        mary.speak( " !  @  #  $  %  ^   &  *   ( ) - = +  " );
          
          
        mary.changeWoman();
        int a=30, b=5;          
        mary.speak( a + " + " + b + " = " + (a+b) );   
        
    }
}
 

