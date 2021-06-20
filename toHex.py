class Solution:
    def toHex(self, num: int) -> str:
        v = abs(num)
        # DICTIONARY TO CONVERT DECIMAL TO HEX
        dh = {10:'a',11:'b',12:'c',13:'d',14:'e',15:'f'}
        # DICTIONARY TO CONVERT HEX TO DECIMAL
        dd = {'a':10,'b':11,'c':12,'d':13,'e':14,'f':15}
        ans = ""
        
        # CONVERSION OF DECIMAL TO HEX USING ITERATION
        
        while(v!=0):
            if((v%16)>9):
                ans = dh[v%16]+ans
            else:
                ans = str(v%16)+ans
            v=v//16
        
        # IF "NUM" IS POSITIVE RETURN "ANS, ELSE IF "NUM" IS ZERO RETURN "0", ELSE CONVERTI IT INTO TWO'S COMPLEMENT FORM AND RETURN.
        
        if(num>0):
            return ans
        elif(num == 0):
            return "0"
        else:
            rans = list("ffffffff")
            j = 7
            r = 0
            for i in range(len(ans)-1,-1,-1):
                x = 15
                if(ans[i].isalpha()):
                    x-=dd[ans[i]]
                else:
                    x-=int(ans[i])
                
                if(j==7):
                    x+=1
                    if(x==16):
                        r = 1
                        rans[j] = str(0)
                    elif(x>9):
                        r = 0
                        rans[j] = dh[x]
                    else:
                        r = 0
                        rans[j] = str(x)    
                else:
                    x+=r
                    if(x==16):
                        r = 1
                        rans[j] = str(0)
                    elif(x>9):
                        r = 0
                        rans[j] = dh[x]
                    else:
                        r = 0
                        rans[j] = str(x)
                
                j-=1
            
            return "".join(rans)
                
                
            
            
            
