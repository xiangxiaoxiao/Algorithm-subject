/*
题目描述

请编写一个函数，检查链表是否为回文。
给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
测试样例：
{1,2,3,2,1}
返回：true
{1,2,3,2,3}
返回：false
*/

struct ListNode {
int val;
struct ListNode *next;
ListNode(int x) : val(x), next(NULL) {}
};
class Palindrome {
public:
	bool isPalindrome(ListNode* pHead) {
		// write code here
		ListNode*q=pHead;
		stack<int> sint;
		while (q)
		{
			sint.push(q->val);
			q = q->next;
		}
		q = pHead;
		int temp;
		while (q)
		{
			temp = sint.top();
			if (q->val!=temp)
			{
				return false;
			}
			sint.pop();
			q = q->next;
		}
		return true;
	}
};