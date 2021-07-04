class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countOfRoundSandwiches = 0,countOfSquareSandwiches = 0;
        int countOfRoundSandwichesRequired = 0,countOfSquareSandwichesRequired = 0;
        
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
