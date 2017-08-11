package test;

public class ListNode {
	private int IntVal;
	private char CharVal;
	private String StrVal;
	private long LongVal;
	private ListNode next = null;

	ListNode(int val) {
		this.IntVal = val;
	}

	ListNode(int val, ListNode next) {
		this.IntVal = val;
		this.next = next;
	}

	ListNode(char val) {
		this.CharVal = val;
	}

	ListNode(char val, ListNode next) {
		this.CharVal = val;
		this.next = next;
	}

	ListNode(String val) {
		this.StrVal = val;
	}

	ListNode(String val, ListNode next) {
		this.StrVal = val;
		this.next = next;
	}

	ListNode(long val) {
		this.LongVal = val;
	}

	ListNode(long val, ListNode next) {
		this.LongVal = val;
		this.next = next;
	}

	public int getIntVal() {
		return IntVal;
	}

	public void setIntVal(int intVal) {
		IntVal = intVal;
	}

	public char getCharVal() {
		return CharVal;
	}

	public void setCharVal(char charVal) {
		CharVal = charVal;
	}

	public String getStrVal() {
		return StrVal;
	}

	public void setStrVal(String strVal) {
		StrVal = strVal;
	}

	public long getLongVal() {
		return LongVal;
	}

	public void setLongVal(long longVal) {
		LongVal = longVal;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
