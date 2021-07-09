class Solution:
    def validate(self,s,i,j,count):
        if(i<j):
            if(s[i] == s[j]):
                return self.validate(s,i+1,j-1,count)
            
            else:
                count += 1
                
                if(count > 1):
                    return False
                
                if(s[i] == s[j-1] and s[i+1] == s[j]):
                    return self.validate(s,i,j-1,count) or self.validate(s,i+1,j,count)
                
                elif(s[i] == s[j-1]):
                    return self.validate(s,i,j-1,count)
                
                elif(s[i+1] == s[j]):
                    return self.validate(s,i+1,j,count)
                
                else:
                    return self.validate(s,i,j,count)
                
        return True
    
    def validPalindrome(self, s: str) -> bool:
        return self.validate(s,0,len(s)-1,0)
