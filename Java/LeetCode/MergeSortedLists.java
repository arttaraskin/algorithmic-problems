// https://leetcode.com/problems/merge-two-sorted-lists/description/
// 21. Merge Two Sorted Lists
// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, result = null, prevResult = null;
        while (list1 != null || list2 != null) {
            if (list1 == null || (list1 != null && list2 != null && list1.val > list2.val)) {
                result = list2;
                list2 = list2.next;
            } else {
                result = list1;
                list1 = list1.next;
            }
            if (prevResult != null) {
                prevResult.next = result;
            } else {
                head = result;
            }
            prevResult = result;
        }
        return head;
    }
}
