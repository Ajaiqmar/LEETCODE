class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if(root != None):
            maxLev = [0]
            for i in root.children:
                maxLev.append(self.maxDepth(i))
            return 1+max(maxLev)
        return 0
