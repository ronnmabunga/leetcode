/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode addTwoNodes(ListNode l1, ListNode l2, int carry) {
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int sum = val1 + val2 + carry;
        int newCarry = sum / 10;
        int val = sum % 10;
        if (l1 == null && l2 == null) {
            return val == 0 ? null : new ListNode(val);
        }
        return new ListNode(val, addTwoNodes(l1 == null ? null : l1.next, l2 == null ? null : l2.next, newCarry));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNodes(l1, l2, 0);
    }
}