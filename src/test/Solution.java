package test;


import  java.util.Stack;
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
		while(head.next!=null){
            stack.push(head.val);
            head=head.next;
        }
        while(!stack.empty()){
            head.val=stack.pop();
            head=head.next;
        }   
        return head;
}
}
