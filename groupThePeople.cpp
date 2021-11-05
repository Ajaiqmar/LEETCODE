// THE PROBLEM STATEMENT IS TO GROUP THE PEOPLE GIVEN THE GROUP SIZE THEY BELONG TO, HERE THE INDICES OF THE GIVEN ARRAY ARE THE PEOPLE
// AND THE VALUE AT THAT INDEX IS THE GROUP SIZE THEY BELONG TO. THE PEOPLE WILL ALWAYS BE DIVIDED INTO CORRECT AMOUNT OF GROUPS AND EVERY GROUP WILL BE FILLED.

// MY APPROACH IS TO TRAVERSE THE ARRAY AND LOG THE GROUP SIZE AS THE KEY AND THE LIST OF PEOPLE AS THE VALUE IN THE UNORDERED MAP.
// ONCE THE SIZE OF THE LIST IS EQUAL TO THE KEY VALUE, THEN INSERT THAT LIST INTO THE ANS ARRAY.

class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) 
    {
        // INITIALISING ANS 2D MATRIX.
        vector<vector<int>> ans;
        unordered_map<int,vector<int>> m;
        
        // TRAVERSING THE GIVENA ARRAY.
        for(int i=0;i<groupSizes.size();i++)
        {
            if(m.find(groupSizes[i]) == m.end())
            {
                vector<int> arr;
                m[groupSizes[i]] = arr;
                m[groupSizes[i]].push_back(i);
            }
            else
            {
                m[groupSizes[i]].push_back(i);
            }
            
            if(m[groupSizes[i]].size() == groupSizes[i])
            {
                ans.push_back(m[groupSizes[i]]);
                m.erase(groupSizes[i]);
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(G*M) WHERE G IS THE NUMBER OF GROUPS AND M IS THE MAXIMUM GROUP SIZE.
