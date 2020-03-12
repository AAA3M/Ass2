// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
 * This is a node object for the binary search tree. It represents the data at a specific entry in a Binary Tree.
 * 
 * @param <dataType> This is the Type of data that the node is. ie String or int.
 */

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;

   /**
    * Contructor for the BinaryTreeNode object. which takes arguments of @param d @param l @param r
    * 
    * @param d the datatype of the data stored in the Node
    * @param l the left child of the node
    * @param r the right child of the node
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }

   /**
    * Gets the left most child of the current node
    * 
    * @return returns the left child of this.BinaryTreeNode
    */
   BinaryTreeNode<dataType> getLeft () { 
      return left; }

   /**
    * Gets the right most child of the current node
    * 
    * @return returns the right child of this.BinaryTreeNode
    */

   BinaryTreeNode<dataType> getRight () { 
      return right; }
}
