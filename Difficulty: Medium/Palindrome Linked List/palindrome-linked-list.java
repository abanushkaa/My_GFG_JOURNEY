/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1) end of first half
        Node firstHalfEnd = endOfFirstHalf(head);

        // 2) reverse second half
        Node secondStart = reverse(firstHalfEnd.next);

        // 3) compare halves
        Node p1 = head;
        Node p2 = secondStart;
        boolean result = true;
        while (p2 != null) {
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4) restore list (optional but good for multi-test environments)
        firstHalfEnd.next = reverse(secondStart);

        return result;
    }

    private Node endOfFirstHalf(Node head) {
        Node slow = head;
        Node fast = head;
        // stop with slow at the end of first half
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
