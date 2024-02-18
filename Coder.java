/*
 * ID: 6588187  
 * NAME: PUNYAPORN PUTTHAKJAKSRI
 * SEC: 2
 */

public class Coder {
    private static String code[] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", 
            "...", "-", "..-", "...-", ".--", "-..-", 
            "-.--", "--.."};
    
    //INCOMPLETE
    public static String encode(char c) {
        String str="?";
        //CODE HERE
        int position;
        if(Character.isAlphabetic(c)) {
        	if(Character.isUpperCase(c)) {
        		position = c - 'A';
        	}else {
        		position = c - 'a';
        	}
        	for(int i=0;i<code.length;i++) {
        		if(i==position) {
        			str=code[i]+" ";
        		}
        	}
        }else if(c==' ') {
        	str=" ";
        }
        return str;
    }
}
