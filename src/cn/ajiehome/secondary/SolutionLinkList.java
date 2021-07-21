package cn.ajiehome.secondary;

/**
 * author: huang
 * time: 2021/7/14
 * description:{
 *      计算两个列表之和，列表里面的数据是倒叙的，
 *      example：
 *          data: 123
 *          data: 456
 *          linkList: 3->2->1
 *          linkList: 6->5->4
 *
 *          linkListResult: 9->7->5
 *          outResult: 579
 * }
 */

public class SolutionLinkList {

    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static ListNode calculation(ListNode l1, ListNode l2, int carry) {
        ListNode result = null;
        if(l1==null&&l2==null){
            if (carry!=0){
                result = new ListNode(carry);
            }
            return result;
        }else {
            result = new ListNode();

            int temp = (l1==null?0:l1.value)+(l2==null?0:l2.value)+carry;
            if (temp>=10){
                result.value = temp % 10;
            }else {
                result.value =temp;
            }
            result.next = calculation((l1==null?null:l1.next),(l2==null?null:l2.next),temp/10);
            return result;
        }

    }

}
