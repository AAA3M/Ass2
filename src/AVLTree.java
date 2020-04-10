// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

/**
 * AVLTree object. This is a special kind of Binary Search Tree which self balances. The height of a left sub tree and right sub tree may only differ by 1 at a given node.
 * 
 * @param <dataType> This is the data type which is sotred in the AVL data structure, and it must extend comparable.
 */

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   /**
    * This method determines the height of a given @param node in the AVL tree
    * 
    * @param node this the node on which the height method is done. It is a node in the AVL tree
    * @return this returns the height of @param node as an int. If the node isn't null otherwise it will return -1.
    */

    public int DiscreteCounterInsert = 0;
    public int DiscreteCounterFind = 0;
    private String orderString;


   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**
    * This methods determines the balancing factor of a given node. this is determined by taking the difference of the right sub tree and left sub tree of a node
    * 
    * @param node the node in the AVL tree whose balance factor is being determined
    * @return an int which is the difference of the right and left subtrees of @param node
    */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   /**
    * This method sets the height of a node as the maximum of the left and right sub trees
    * 
    * @param node this is the Binary Tree Node which the method operates on.
    */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   /**
    * This method rotates the right sub tree of a node to the left.
    * 
    * @param p the node which is being rotated.
    * @return a BinaryTreeNode which has been rotated to the right.
    */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   /**
    * This method rotates the left sub tree of a node to the right.
    * 
    * @param q the node which is being rotated.
    * @return a BinaryTreeNode which has been rotated to the left.
    */
   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   /**
    * A method that will balance a node by finding the balance factors of nodes, and rotating the nodes left or right depending on the balance factor
    * 
    * @param p the node which is being balanced
    * @return a balanced BinaryTreeNode which has a Balance factor of at most 1.
    */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      DiscreteCounterInsert++;
      if (balanceFactor (p) == 2)
      {
         DiscreteCounterInsert++;
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      DiscreteCounterInsert++;
      if (balanceFactor (p) == -2)
      {
         DiscreteCounterInsert++;
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   /**
    * Method to insert an object into the AVL tree.
    * 
    * @param d the object being inserted which is of the same dataType as the other nodes.
    */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /**
    * Method which will insert an object into the AVL tree by starting at the root node and recursivly going through the nodes.
    * 
    * @param d the object which is being inserted
    * @param node the current node which is being operated on. Starts as the root node of the tree.
    * @return returns a balanced Binary Tree Node. or if the tree is null, returns an empty tree with @param d as the root.
    */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      DiscreteCounterInsert++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   
   /**
    * Method to remove an Object from the AVL Tree starting at the root node and recursivly working through the nodes.
    * 
    * @param d the object whihc is being removed
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   /**
    * Method which removes an object from the AVL tree.
    * 
    * @param d the object which will be removed.
    * @param node the node which is being checked 
    * @return a balanced BinaryTreeNode.
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   /**
    * Method which finds the left most node in the AVL Tree by recursivly calling the left tree.
    * 
    * @param node the current node which is being operated on.
    * @return a BinaryTreeNode which is the left most branch.
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   /**
    * Method to removes the minimal element in the tree by recursivly going through the nodes in the tree.
    * 
    * @param node the current node in the AVL tree being operated on
    * @return returns a balanced @param node
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   /**
    * A method to find an object in a given AVL tree starting with the root node of the tree.
    * 
    * @param d the object which is being searched for.
    * @return reursivly finds the element in the Tree. 
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**
    * A method to find an object in an ALV tree at a given node.
    * 
    * @param d the object which is being searched for
    * @param node the node being compared to the object @param d
    * @return returns either the object or recursivly calls the find method on the left or right subtree.
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      DiscreteCounterFind++;
      if (d.compareTo (node.data) == 0) {
         return node;}

      else if (d.compareTo (node.data) < 0){
         DiscreteCounterFind++;
         return (node.left == null) ? null : find (d, node.left);}
      else{
         DiscreteCounterFind++;
         return (node.right == null) ? null : find (d, node.right);}
   }
   
   /**
    * Method to print out the objects in an AVL Tree in the tree Order starting at the root node.
    */
   public void treeOrder ()
   {
      orderString = "";
      treeOrder (root, 0);
   }
   /**
    * A method which recursily prints out the Tree order of an AVL Tree by recursivly calling the treeORder method on a given node. 
    * 
    * @param node the current node which is the treeOrder method is operating on
    * @param level an integer representing the level of the tree
    */
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         orderString += node.data.toString() + "\n";
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
/**My own method to return a string interpritation of the output from a traversal
 * 
 * @return output of a traversal as a string
 */
   public String getOrderString(){
      return this.orderString;
   }
}

