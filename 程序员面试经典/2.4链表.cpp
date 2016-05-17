/*
题目描述

编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
*/

struct ListNode {
int val;
struct ListNode *next;
ListNode(int x) : val(x), next(NULL) {}
};
class Partition {
public:
	ListNode* partition(ListNode* pHead, int x) {
		// write code here
		ListNode *lessNode = new ListNode(0);
		ListNode *lessHead = lessNode;
		ListNode *biggerNode = new ListNode(0);
		ListNode *biggerHead = biggerNode;
		while (pHead != NULL) {
			if (pHead->val >= x) {
				biggerNode->next = pHead;
				biggerNode = pHead;
			}
			else {
				lessNode->next = pHead;
				lessNode = pHead;
			}
			pHead = pHead->next;
		}

		biggerNode->next = NULL;
		lessNode->next = biggerHead->next;

		return lessHead->next;
	}
};