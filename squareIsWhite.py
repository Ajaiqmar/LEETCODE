class Solution(object):
    def squareIsWhite(self, coordinates):
        dictionary = {'a':1,'b':2,'c':3,'d':4,'e':5,'f':6,'g':7,'h':8}
        r = int(coordinates[1])
        c = dictionary[coordinates[0]]
        
        if((r%2==0 and c%2==0) or (r%2!=0 and c%2!=0)):
            return False
        else:
            return True
