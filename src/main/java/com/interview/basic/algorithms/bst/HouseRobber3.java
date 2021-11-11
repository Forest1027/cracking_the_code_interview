package com.interview.basic.algorithms.bst;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/
 * Explanation: https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 * idea: compare between (grandparent and max of grandchildren) and (max of children)
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        // use map to record visited node. Dynamic programming
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        // compare between (current + max of grandchildren) and (max of children)
        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    public static void main(String[] args) {
        // [3,4,5,1,3,null,1]
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        HouseRobber3 sol = new HouseRobber3();
        int sum = sol.rob(root);
        System.out.println(sum);
    }
}
