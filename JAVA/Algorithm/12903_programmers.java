import java.util.Scanner;

class Solution {
    public StringBuffer solution(String s) {
        StringBuffer answer = new StringBuffer();
        if(s.length()%2==0){ //주어진 문자열 길이가 짝수라면
            answer.append(s.charAt(s.length()/2-1));
            answer.append(s.charAt(s.length()/2));
        }
        else{
            answer.append(s.charAt(s.length()/2));
        }
        return answer;
    }
}
