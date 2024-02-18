/*
 * ID: 6588187  
 * NAME: PUNYAPORN PUTTHAKJAKSRI
 * SEC: 2
 */

public class Decoder {
   
	public Node<String> root;

    public Decoder() {
        root = new Node<String>(""); // root Node has no information.

        addMorse(root, "a", ".-");
        addMorse(root, "b", "-...");
        addMorse(root, "c", "-.-.");
        addMorse(root, "d", "-..");
        addMorse(root, "e", ".");
        addMorse(root, "f", "..-.");
        addMorse(root, "g", "--.");
        addMorse(root, "h", "....");
        addMorse(root, "i", "..");
        addMorse(root, "j", ".---");
        addMorse(root, "k", "-.-");
        addMorse(root, "l", ".-..");
        addMorse(root, "m", "--");
        addMorse(root, "n", "-.");
        addMorse(root, "o", "---");
        addMorse(root, "p", ".--.");
        addMorse(root, "q", "--.-");
        addMorse(root, "r", ".-.");
        addMorse(root, "s", "...");
        addMorse(root, "t", "-");
        addMorse(root, "u", "..-");
        addMorse(root, "v", "...-");
        addMorse(root, "w", ".--");
        addMorse(root, "x", "-..-");
        addMorse(root, "y", "-.--");
        addMorse(root, "z", "--..");
    }
    
    
    //INCOMPLETE    
    //Insert Morse Code.
    @SuppressWarnings("unchecked")
    private void addMorse(Node<String> tree, String letter, String code)
    {
      //CODE HERE
//    	for(int i=0;i<code.length();i++) {
//    		if(code.charAt(i)=='-') {
//    			if(i!=code.length()-1) {
//    				tree.setRight(new Node<String>("x"));
////    				continue;
////    				this.addMorse(tree.getRight(), letter, code.substring(i+1));
//    			}else if(tree.getRight()!=null && i==code.length()-1){
//    				tree.setValue(letter);
////    				System.out.println("addR "+letter);
////    				break;
//    			}else {
//    				tree.setRight(new Node<String>(letter));
////    				System.out.println("addRight "+letter+i);
//    			}
//    		}else if(code.charAt(i)=='.'){
//    			if(i!=code.length()-1) {
//    				tree.setLeft(new Node<String>(""));
////    				continue;
////    				this.addMorse(tree.getLeft(), letter, code.substring(i+1));
//    			}else if(tree.getLeft()!=null && i==code.length()-1){
////    				tree.setLeft(new Node<String>(letter));
//    				tree.setValue(letter);
////    				System.out.println("addL "+letter+i);
//    				break;
//    			}else {
//    				tree.setLeft(new Node<String>(letter));
////    				System.out.println("addLeft "+letter);
//    			}
//    		}
//    	}
    	for(int i=0;i<code.length();i++) {
    		if(code.charAt(i)=='-') {
    			if(tree.getRight()==null){
    				tree.setRight(new Node<String>("x"));
    			}
    			tree=tree.getRight();
    		}else if(code.charAt(i)=='.'){
    			if(tree.getLeft()==null){
    				tree.setLeft(new Node<String>("z"));
    			}
    			tree=tree.getLeft();
    		}
    	}
    	tree.setValue(letter);
//    	System.out.println("add "+letter);
    }
    
    //INCOMPLETE
    // An iterative version of the Morse code decoder
    public String decode(String m) {
        Node<String> ptr = root; // start at root of tree
        String str="?"; // For unknow character, the program must show ?

        // Scan through the Morse String
        // CODE HERE
        String morsePattern = "^[.-]+$";
        if(m.matches(morsePattern)) { //to check that it contains only . or -
        	for(int i=0;i<m.length();i++) {
	        	if(m.charAt(i)=='.') {
	        		ptr=ptr.getLeft();
	        	}else if(m.charAt(i)=='-') {
	        		ptr=ptr.getRight();
	        	}
	        }
        	str=ptr.getValue();
        }
        
        return str;
    }


    //INCOMPLETE
    // A Recursive version of the decoder
    public String decodeR(Node<String> n, String m) {
        String str="?m"; // For unknow character, the program must show ?
        //CODE HERE
        
//        if(m.matches(morsePattern)) {
//        	if(m.length()!=0) {
//	        	if(m.charAt(0)=='.') {
//	        		str=this.decodeR(n.getLeft(), m.substring(1));
//	        	}else if(m.charAt(0)=='-') {
//	        		str=this.decodeR(n.getRight(), m.substring(1));
//	        	}
//	        }else {
//	        	str=n.getValue();
//	        }
//        }else {
//        	return str;
//        }
        	if(m.isEmpty()) {
        		str=n.getValue();
        	}else {
        		// if it's not . or - -> it will not match any condition
        		if(m.charAt(0)=='.') {
        			str=this.decodeR(n.getLeft(), m.substring(1));
        		}else if(m.charAt(0)=='-') {
        			str=this.decodeR(n.getRight(), m.substring(1));
        		}
        	}
        return str;
    }

    // public wrapper function to hide decodeR()
    public String decode2(String m) {
        return decodeR(root, m);
    }
}
