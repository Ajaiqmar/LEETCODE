class Solution(object):
    def numDifferentIntegers(self, word):
        number = ""
        ans = set()
        
        for i in word:
            if(i.isalpha()):
                if(len(number) > 0):
                    number = int(number)
                    ans.add(number)
                    number = ""
            else:
                number+=i
                
        if(len(number) > 0):
            number = int(number)
            ans.add(number)
        
        return len(ans)
