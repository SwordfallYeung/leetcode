package com.swordfall.leetcode.tree._101_symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root){
        return check(root, root);
    }

    /**
     * 递归
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q){

        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 迭代
     * @param u
     * @param v
     * @return
     */
    public boolean check2(TreeNode u, TreeNode v){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()){
            v = q.poll();
            u = q.poll();
            if (u == null && v == null){
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)){
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
