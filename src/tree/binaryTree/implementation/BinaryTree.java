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
		if(node != null) { //��尡 null�� �ƴѵ��� �����Ѵ�.
			System.out.println(node.value);
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left); //���� ���ȣ��
			System.out.println(node.value); //�ڽ� ȣ��
			inorder(node.right); //������ ���ȣ��
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
