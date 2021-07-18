class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if(len(s) != len(goal) or len(s) == 1):
            return False
        
        alphad = {}
        flag = 0
        
        for i in s:
            if i in alphad:
                alphad[i] += 1
                flag = 1
            else:
                alphad[i] = 1
        
        if(s == goal and flag == 1):
            return True
        
        for i in goal:
            if i not in alphad or alphad[i] == 0:
                return False
            else:
                alphad[i] -= 1
        
        countOfMisplaced = 0
        
        for i in range(len(s)):
            if(s[i] != goal[i]):
                countOfMisplaced += 1
        
        return countOfMisplaced == 2
