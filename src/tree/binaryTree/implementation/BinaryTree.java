package tree.binaryTree.implementation;

public class BinaryTree {
	public Node root;
	public void setRoot(Node root) {
		this.root = root;
	}
	public Node getRoot() {
		return root;
	}
	public Node makeNode(Node left, int value, Node right) {
		Node node = new Node();
		node.value = value;
		node.left = left;
		node.right = right;
		return node;
	}
	public void preorder(Node node) {
		if(node != null) { //노드가 null이 아닌동안 실행한다.
			System.out.println(node.value);
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left); //왼쪽 재귀호출
			System.out.println(node.value); //자신 호출
			inorder(node.right); //오른쪽 재귀호출
		}
	}
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.value);
		}
	}
}
