class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        int n = bombs.size(), ans = 0;
        
        auto bfs = [&](int& i){
            vector<bool> vis(n, false);
            int detonated = 0;
            queue<int> q;
            q.push(i);
            vis[i] = true;
            
            while(!q.empty()){
                int curr = q.front();
                q.pop();
                detonated += 1;
                
                for(int j = 0; j < n; j++){
                    if(!vis[j]){
                        // circle equation : (x - h) ^ 2 + (y - k) ^ 2 - r ^ 2 = 0
                        // if point lie inside the circle then >= 0 else < 0. (simple elementry maths)
                        long long h = bombs[curr][0], k = bombs[curr][1], r = bombs[curr][2];
                        long long a = (bombs[j][0] - h) * (bombs[j][0] - h);
                        long long b = (bombs[j][1] - k) * (bombs[j][1] - k);
                        long long c = r * r;
                        if(a + b <= c){
                            q.push(j);
                            vis[j] = true;
                        }
                    }
                }
            }
            return detonated;
        };
        
        for(int i = 0; i < n; i++){
            ans = max(ans, bfs(i));
        }
        return ans;
    }
};
