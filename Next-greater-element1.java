#include <vector>
#include <unordered_map>
#include <stack>

class Solution {
public:
    std::vector<int> nextGreaterElement(std::vector<int>& nums1, std::vector<int>& nums2) {
        std::unordered_map<int, int> umap;
        std::stack<int> st;

        for (int i = nums2.size() - 1; i >= 0; i--) {
            int ele = nums2[i];
            
            // Pop elements from the stack that are smaller than or equal to the current element
            while (!st.empty() && st.top() <= ele) {
                st.pop();
            }

            // The result is either the top of the stack or -1 if the stack is empty
            int res = (st.empty()) ? -1 : st.top();

            // Insert the result into the unordered_map
            umap.insert({ele, res});

            // Push the current element onto the stack
            st.push(ele);
        }

        // Build the answer vector based on the unordered_map
        std::vector<int> ans;
        for (auto x : nums1) {
            ans.push_back(umap[x]);
        }

        return ans;
    }
};
