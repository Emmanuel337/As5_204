 
public class TreeNode<T> {

  protected T data;
  protected TreeNode<T> left, right;

 
  public TreeNode(TreeNode<T> node) {
    this.data = node.data;
    this.left = node.left;
    this.right = node.right;
  }

  public TreeNode(T dataNode) {
	    this.data = dataNode;
	    this.left = this.right = null;
	  }

   
  public T getData() {
    return this.data;
  }

}