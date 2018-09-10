package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.concurrent.atomic.AtomicBoolean;

public class IsTreeBalanced {

    @EpiTest(testDataFile = "is_tree_balanced.tsv")

    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        if(tree == null){
            return true;
        }
        AtomicBoolean status = new AtomicBoolean(true);
        calculateHeight(tree, status);
        return status.get();
    }

    private static int calculateHeight(BinaryTreeNode<Integer> root, AtomicBoolean isBalanced) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        AtomicBoolean rightStatus = new AtomicBoolean(true);
        AtomicBoolean leftStatus = new AtomicBoolean(true);
        if (root.left != null) {
            leftHeight = calculateHeight(root.left, leftStatus) + 1;
        }
        if (root.right != null) {
            rightHeight = calculateHeight(root.right, rightStatus) + 1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced.set(false);
        } else {
            isBalanced.set(isBalanced.get() & leftStatus.get() & rightStatus.get());
        }
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
