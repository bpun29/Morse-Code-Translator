/*
 * ID: 6588187  
 * NAME: PUNYAPORN PUTTHAKJAKSRI
 * SEC: 2
 */

public class BinaryTree<E extends Comparable<E>> {
    Node<E> root;

    public BinaryTree() {
        root = null;
    }

    // INCOMPLETE
    private String addToSubTree(Node<E> n, E v) {    
    	//CODE HERE
    	if(v.compareTo(n.getValue())<0) {
    		if(n.getLeft()!=null) {
    			this.addToSubTree(n.getLeft(), v);
    		}else {
    			n.setLeft(new Node<E>(v));
    			if(v.compareTo(root.getValue())<0) {
    				System.out.print("LeftSubTree("+v+")");
    			}else {
    				System.out.print("RightSubTree("+v+")");
    			}
    		}
    		
    	}else {
    		if(n.getRight()!=null) {
    			this.addToSubTree(n.getRight(), v);
    		}else {
    			n.setRight(new Node<E>(v));	
    			if(v.compareTo(root.getValue())<0) {
    				System.out.print("LeftSubTree("+v+")");
    			}else {
    				System.out.print("RightSubTree("+v+")");
    			}
    		}
    	}	
        return "";
    }

 // INCOMPLETE
    public String add(E v) {
    	//CODE HERE
    	if(root==null) {
    		root = new Node<E>(v);
    		System.out.print("Root("+v+")");
    	}
    	else {
    		this.addToSubTree(root, v);
    	}
    	return "";
    }

    // INCOMPLETE.
    private void inOrder(Node<E> n) {
       //CODE HERE 
    	//n is root
    	if(n!=null) {
    		if(n.getLeft()!=null) {
        		this.inOrder(n.getLeft());    		
        	}
    		System.out.print(n.getValue()+" ");
        	if(n.getRight()!=null) {
        		this.inOrder(n.getRight());   
        	}
        	
    	}
    }

    // INCOMPLETE.
    private void preOrder(Node<E> n)
    {
        //CODE HERE
    	if(n!=null) {
    		//visit
    		System.out.print(n.getValue()+" ");
    		//left
    		if(n.getLeft()!=null) {
        		this.preOrder(n.getLeft());    		
        	}
    		//right
        	if(n.getRight()!=null) {
        		this.preOrder(n.getRight());   
        	}
    	}
    }

    // INCOMPLETE.
    private void postOrder(Node<E> n)
    {
    	//CODE HERE
    	if(n!=null) {
    		//left
    		if(n.getLeft()!=null) {
        		this.postOrder(n.getLeft());    		
        	}
    		//right
        	if(n.getRight()!=null) {
        		this.postOrder(n.getRight());   
        	}
        	//visit
        	System.out.print(n.getValue()+" ");
    	}
    }

    public void traversal()
    {
        System.out.print("Inorder traversal: ");
        inOrder(root);
        System.out.println();
        
        System.out.print("Preorder traversal: ");
        preOrder(root);
        System.out.println();
        
        System.out.print("Postorder traversal: ");
        postOrder(root);
        System.out.println();
    }
}
