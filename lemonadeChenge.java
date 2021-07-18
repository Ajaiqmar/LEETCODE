class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countOfFives = 0,countOfTens = 0,countOfTwentys = 0;
        
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i] == 5)
            {
                countOfFives++;
            }
            else if(bills[i] == 10)
            {
                if(countOfFives == 0)
                {
                    return false;
                }
                countOfFives--;
                countOfTens++;
            }
            else if(bills[i] == 20)
            {
                if(countOfTens > 0 && countOfFives > 0)
                {
                    countOfTens--;
                    countOfFives--;
                    countOfTwentys++;
                }
                else if(countOfFives > 3)
                {
                    countOfFives -= 3;
                    countOfTwentys++;
                }
                else
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
