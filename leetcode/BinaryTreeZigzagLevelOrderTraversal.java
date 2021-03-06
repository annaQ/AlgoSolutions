/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' 
 * values. 
 * (ie, from left to right, then right to left for the next level and alternate 
 * between).

 * For example:
 * Given binary tree {3,9,20,#,#,15,7},

 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:

 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) 
            return res;
        ArrayList<Integer> saveNodeVal = new ArrayList<Integer>();
        LinkedList<TreeNode> curLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        curLevel.add(root);
        boolean isL2R = true;
        while(!curLevel.isEmpty()) {
            TreeNode cur = curLevel.remove();
            saveNodeVal.add(cur.val);
            if(cur.left != null)
                nextLevel.add(cur.left);
            if(cur.right != null) 
                nextLevel.add(cur.right);
            if(curLevel.isEmpty()) {
                if(!isL2R)
                    Collections.reverse(saveNodeVal);
                isL2R = !isL2R;
                res.add(saveNodeVal);
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                saveNodeVal = new ArrayList<Integer>();
            }
        }   
        return res;
    }
}
