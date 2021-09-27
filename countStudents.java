// THE PROBLEM STATEMENT IS TO RETURN THE NUMBER OF STUDENTS THAT ARE UNABLE TO EAT IN A CAFETERIA. THE SANDWICHES AVAILABLE AND THE STUDENTS PREFERENCE ARE
// REPRESENTED IN THE FORM OF 1'S AND 0'S. IN SANDWICHES ARRAY, 1'S REPRESENT SQUARE SANDWICH AND 0'S REPRESENT ROUND SANDWICH. IN STUDENTS ARRAY, THEIR PREFERENCES
// ARE RECORDED. THE SANDWICHES ARE ARRANGED IN THE FORM OF STACK AND THE STUDENTS ARE LINED IN A QUEUE. THE TOP SANDWICH IS TAKEN BY THE STUDENT
// IF HE/SHE PREFERS IT, ELSE HE/SHE MOVES TO END OF THE QUEUE. IF NONE OF THE STUDENT IN THE QUEUE PREFERS THE TOP SANDWICH, THEN
// THEY WILL BE UNABLE TO EAT.

// MY APPROACH IS RATHER THAN TO SIMULATE THE GIVEN SCENARIO, I AM GOING TO APPLY SOME LOGIC, FIRSTLY I AM GOING THE COUNT THE NUMBER SQUARE AND ROUND SANDWICHES
// THAT ARE REQUIRED BY THE STUDENTS AND THAT ARE PRESENT IN THE CAFETERIA. THEN CHECK WHICH SANDWICH IS LESS IN AMOUNT IN THE CAFETERIA THAN ITS REQUIRED
// BY THE STUDENTS. LASTLY, TRAVERSE AND FIND THE LAST INDEX OF THAT TYPE OF SANDWICH IN THE SANDWICHES ARRAY, RETURN THE DIFFERENCE BETWEEN THE 
// ARRAY LENGTH AND THE LAST INDEX.

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countOfRoundSandwiches = 0,countOfSquareSandwiches = 0;
        int countOfRoundSandwichesRequired = 0,countOfSquareSandwichesRequired = 0;
        
        // TRAVERSING THE STUDENTS AND THE SANDWICHES ARRAY.
        for(int i=0;i<students.length;i++)
        {
            if(students[i] == 0)
            {
                countOfRoundSandwichesRequired++;
            }
            else
            {
                countOfSquareSandwichesRequired++;
            }
            
            if(sandwiches[i] == 0)
            {
                countOfRoundSandwiches++;
            }
            else
            {
                countOfSquareSandwiches++;
            }
        }
        
        // FINDING THE TOTAL STUDENTS THAT ARE UNABLE TO EAT.
        if(countOfRoundSandwichesRequired < countOfRoundSandwiches)
        {
            for(int i=0;i<sandwiches.length;i++)
            {
                if(sandwiches[i] == 0)
                {
                    if(countOfRoundSandwichesRequired == 0)
                    {
                        return (sandwiches.length)-i;
                    }
                    countOfRoundSandwichesRequired--;
                }
            }
        }
        else if(countOfSquareSandwiches > countOfSquareSandwichesRequired)
        {
            for(int i=0;i<sandwiches.length;i++)
            {
                if(sandwiches[i] == 1)
                {
                    if(countOfSquareSandwichesRequired == 0)
                    {
                        return (sandwiches.length)-i;
                    }
                    countOfSquareSandwichesRequired--;
                }
            }
        }
        
        return 0;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)
