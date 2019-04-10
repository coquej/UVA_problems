#include <iostream>
#include <vector>
#include <cstring>
#include <limits>
#include <algorithm>
using namespace std;

struct turtle
{
    int w, s;
};

bool comp(const turtle &t1, const turtle &t2)
{
   return t1.s < t2.s;
}

vector<turtle> T;
int dp[5607];


int main()
{
    turtle t;
    while (cin >> t.w >> t.s)
        T.push_back(t);

    sort(T.begin(), T.end(), comp);

    fill(dp, dp + 5607, numeric_limits<int>::max());

    dp[0] = 0;
    
    int lmax = 0;

    for (int i = 0; i < T.size(); ++i)
        for (int j = lmax; j >= 0; --j)
            if (T[i].s >= dp[j] + T[i].w
                && T[i].w + dp[j] < dp[j + 1])
            {
                dp[j + 1] = dp[j] + T[i].w;
                lmax = max(lmax, j + 1);
            }
    
    printf("%d\n",lmax);
}