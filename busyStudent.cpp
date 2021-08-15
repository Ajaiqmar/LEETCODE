// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF STUDENTS WHO ARE CURRENTLY DOING THEIR HOMEWORK AT THE QUERYTIME.
// THE I-TH STUDENT STARTS DOING HOMEWORK FROM STARTTIME[I] TO ENDTIME[I].

// MY APPROACH IS TO TRAVERSE THE STARTTIME AND ENDTIME ARRAY, AND CHECK IF THE QUERY TIME IS IN BETWEEN THE STARTTIME[I] AND
// ENDTIME[I].

class Solution {
public:
    int busyStudent(vector<int>& startTime, vector<int>& endTime, int queryTime) {
        int noOfStudent = 0;
        
        // TRAVERSING THE STARTTIME AND ENDTIME ARRAY.
        for(int i=0;i<startTime.size();i++)
        {
            if(startTime[i] <= queryTime && endTime[i] >= queryTime)
            {
                noOfStudent += 1;
            }
        }
        
        return noOfStudent;
    }
};

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
