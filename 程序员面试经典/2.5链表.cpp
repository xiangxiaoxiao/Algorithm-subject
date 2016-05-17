/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class Plus {
public:
    ListNode* plusAB(ListNode* a, ListNode* b) {
        // write code here
         ListNode *head = new ListNode(-1);
        ListNode *p = head;
        ListNode *node = nullptr;
        int c = 0,sum,val1,val2;
        ListNode *pa = a,*pb = b;
        //加法
        while(pa != nullptr || pb != nullptr || c != 0){
            val1 = (pa == nullptr ? 0 : pa->val);
            val2 = (pb == nullptr ? 0 : pb->val);
            sum = val1 + val2 + c;
            // 进位
            c = sum / 10;
            node = new ListNode(sum % 10);
 
            //尾插法
            p->next = node;
            p = node;
            pa = (pa == nullptr ? nullptr : pa->next);
            pb = (pb == nullptr ? nullptr : pb->next);
        }//while
        return head->next;
    }
};