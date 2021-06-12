package tts_view;
import mary.TextToSpeech;

public class MyTTS2 {
    
    private TextToSpeech tts = new TextToSpeech();
    String name;
    public MyTTS2() {
        this.name ="mimi"; //기본 미미
    }
 
    public MyTTS2(String name) {
        this();
        this.name=name;
    }        
    //오버라이딩과 오버로딩을 함께
    public void speak(String msg) {
        tts.speak(msg, 1.0f, false, true);
    }
 
    public void speak(String msg, float vol) {
        tts.speak(msg, vol, false, true);
    }
 
    public void call(String name) {
    	int start = name.indexOf(" ");
    	String str = name;
    	if(start !=0) str = name.substring(start+1);
    	System.out.println(str);
        //이름이 같은지 비교
        if (!this.name.equals(str))
            speak("I am not" + name +"!! My name is "+ this.name);
        else speak("Yes my load! have a Good Day~~~~!!");
        
    }
    
    public void changeWoman() {
        tts.setVoice("dfki-poppy-hsmm");
    }
    public void changeMan() {
        tts.setVoice("cmu-rms-hsmm");
    }
    
    public static void main(String [] args) {
        
        MyTTS2 mary= new MyTTS2("mary");
        mary.speak("a a  voice test! ");
        
        mary.call("marymary");
        mary.call("hi~alexa");
        mary.call("hi~ari");        
        mary.call("hi~mimi");
        mary.call("hi~mary");
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
          
          //tts가 읽을 수 있는 문자는?
        mary.speak( " !  @  #  $  %  ^   &  *   ( ) - = +  " );
          
          
        mary.changeWoman();
        int a=30, b=5;          
        mary.speak( a + " + " + b + " = " + (a+b) );   
        
    }
}
 
