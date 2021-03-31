package tree.binaryTree.implementation;
/*
    	(1)
  	         ↙     ↘
  	  (2)  (3)
             ↙     ↘
   (4)  (5) 
   
   Preorder (Root, Left, Right) : 1 2 4 5 3
   Inorder (Left, Root, Right): 4 2 5 1 3
   Postorder (Left, Right, Root) : 4 5 2 3 1
   주석 변경
 */
public class Test {

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		//t.root = n1;
		t.setRoot(n1);
		//t.inorder(n1);
		t.inorder(t.getRoot());
		System.out.println("-----------");
		t.preorder(t.getRoot());
		System.out.println("-----------");
		t.postorder(t.getRoot());
	}

}
