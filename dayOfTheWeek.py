# THE PROBLEM STATEMENT IS TO RETURN THE WHICH DAY OF THE WEEK CORRESPONDS TO THE GIVEN DATE.

# MY APPROACH IS TO USE THE IN-BUILT DATE CLASS IN WHICH THE WEEKDAY FUNCTION RETURNS THE INDEX OF WHICH DAY IT CORRESPONDS TO.
# 0 REPRESENTS MONDAY AND 6 REPRESENTS SUNDAY.

class Solution:
    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        days = ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]
        
        d = date(year,month,day)
        
        return days[d.weekday()]
      
