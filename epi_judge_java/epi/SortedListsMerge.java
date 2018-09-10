package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SortedListsMerge {
    @EpiTest(testDataFile = "sorted_lists_merge.tsv")
    //@include
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                        ListNode<Integer> L2) {
        ListNode<Integer> head = null;
        ListNode<Integer> currentNode = null;
        while (L1 != null || L2 != null) {
            ListNode<Integer> nextNode;
            if (L1 == null) {
                nextNode = L2;
                L2 = L2.next;
            } else if (L2 == null) {
                nextNode = L1;
                L1 = L1.next;
            } else {
                if (L1.data < L2.data) {
                    nextNode = L1;
                    L1 = L1.next;
                } else {
                    nextNode = L2;
                    L2 = L2.next;
                }
            }

            if (head == null) {
                currentNode = nextNode;
                head = nextNode;
            } else {
                currentNode.next = nextNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
