class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
	   int n=0;
        ListNode* curr=head;
        while(curr!=NULL)
        {
            curr=curr->next;
            n++;
        }
        if(n/k==0)
        {
            return head;
        }
        
        ListNode* prevptr=NULL;
        ListNode* currptr=head;
        ListNode* nextptr;
        int count=0;
        while(currptr!=NULL && count<k)
        {
            nextptr=currptr->next;
            currptr->next=prevptr;
            
            prevptr=currptr;
            currptr=nextptr;
            count++;
        }
        if(currptr!=NULL)
        {
            head->next=reverseKGroup(currptr, k);
        }
        return prevptr;
    }
};
