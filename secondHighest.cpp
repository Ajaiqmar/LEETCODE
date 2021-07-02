class Solution {
public:
    int secondHighest(string s) {
        int largest = -1,secondLargest = -1;
        
        for(int i=0;i<s.size();i++)
        {
            if(isdigit(s[i]))
            {
                int val = s[i]-'0';
                
                if(val > largest)
                {
                    secondLargest = largest;
                    largest = val;
                }
                else if(val < largest && val > secondLargest)
                {
                    secondLargest = val;
                }
            }
        }
        
        return secondLargest;
    }
};
