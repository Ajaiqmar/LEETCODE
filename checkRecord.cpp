// THE PROBLEM STATEMENT IS TO CHECK IF THE STUDENT IS ELIGIBLE FOR AN ATTENDANCE AWARD. THE ATTENDANCE RECORD IS GIVEN IN THE FORM OF A STRING.
// THE STRING WILL CONTAIN ONLY 'A','L' OR 'P' WHICH REPRESENTS ABSENT,LATE OR PRESENT. THE STUDENT IS ELIGIBLE FOR THE ATTENDANCE AWARD IF THE STUDENT
// WAS NEVER LATE FOR THREE CONSECUTIVE DAYS AND THE STUDENT WAS ABSENT FOR STRICTLY FEWER THAN 2 DAYS IN TOTAL.

// MY APPROACH IS TO APPLY KADANE ALGORITHM TO KEEP IN CHECK OF THE NUMBER OF DAYS LATE, AND ALSO COUNT THE NUMBER OF DAYS ABSENT. IF THE NUMBER OF DAYS ABSENT 
// GOES BEYOND 2 OR HE IS LATE FOR THREE CONSECUTIVE DAYS RETURN FALSE, ELSE RETURN TRUE.

class Solution {
public:
    bool checkRecord(string s) {
        bool ans = true;
        int countOfAbsent = 0, countOfLate = 0;
        
        // TRAVERSING THE STUDENT'S ATTENDANCE RECORD.
        for(int i=0;i<s.size();i++)
        {
            if(s[i] == 'L')
            {
                countOfLate += 1;
            }
            else
            {
                countOfLate = 0;
            }
            
            if(s[i] == 'A')
            {
                countOfAbsent += 1;
            }
            
            if(countOfLate >= 3 || countOfAbsent >= 2)
            {
                ans = false;
                break;
            }
        }
        
        return ans;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
