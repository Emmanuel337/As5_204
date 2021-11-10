import java.util.ArrayList;

 
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

  private TreeNode<String> root;

   
  public MorseCodeTree() {
    buildTree();
  }

  @Override
  public TreeNode<String> getRoot() {
    return root;
  }

   
  @Override
  public void buildTree() {
    root = new TreeNode<String>("");

    // Level 1
    insert(".", "e");
    insert("-", "t");

    // Level 2
    insert("..", "i");
    insert(".-", "a");
    insert("-.", "n");
    insert("--", "m");

    // Level 3
    insert("...", "s");
    insert("..-", "u");
    insert(".-.", "r");
    insert(".--", "w");
    insert("-..", "d");
    insert("-.-", "k");
    insert("--.", "g");
    insert("---", "o");

    // Level 4
    insert("....", "h");
    insert("...-", "v");
    insert("..-.", "f");
    insert(".-..", "l");
    insert(".--.", "p");
    insert(".---", "j");
    insert("-...", "b");
    insert("-..-", "x");
    insert("-.-.", "c");
    insert("-.--", "y");
    insert("--..", "z");
    insert("--.-", "q");
  }

  @Override
  public ArrayList<String> toArrayList() {
    ArrayList<String> list = new ArrayList<>();
    LNRoutputTraversal(root, list);
    return list;
  }

  

   
  @Override
  public void setRoot(TreeNode<String> newNode) {
    this.root = new TreeNode<String>(newNode);
  }

  
  @Override
  public MorseCodeTree insert(String code, String letter) {
    addNode(root, code, letter);
    return this;
  }

  

  
  @Override
  public String fetch(String code) {
    return fetchNode(root, code);
  }

  
  @Override
  public String fetchNode(TreeNode<String> root, String code) {
    if (code.length() == 1) {
      if (code.charAt(0) == '.') {
        return root.left.data;
      } else if (code.charAt(0) == '-') {
        return root.right.data;
      }
    } else {
      if (code.charAt(0) == '.') {
        return fetchNode(root.left, code.substring(1));
      } else if (code.charAt(0) == '-') {
        return fetchNode(root.right, code.substring(1));
      }
    }
    return null;
  }

  
  @Override
  public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      LNRoutputTraversal(root.left, list);
    }
    list.add(root.data);
    if (root.right != null) {
      LNRoutputTraversal(root.right, list);
    }
  }
   
  @Override
  public MorseCodeTree delete(String data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addNode(TreeNode<String> root, String code, String letter) {
    if (code.length() == 1) {
      if (code.charAt(0) == '.') {
        root.left = new TreeNode<String>(letter);
      } else if (code.charAt(0) == '-') {
        root.right = new TreeNode<String>(letter);
      }
    } else {
      if (code.charAt(0) == '.') {
        addNode(root.left, code.substring(1), letter);
      } else if (code.charAt(0) == '-') {
        addNode(root.right, code.substring(1), letter);
      }
    }
  }
   
  @Override
  public MorseCodeTree update() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

}