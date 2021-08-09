-- THE PROBLEM STATEMENT IS TO REFORMAT THE GIVEN DEPARTMENT TABLE.

SELECT a.id,b.Jan_Revenue,c.Feb_Revenue,d.Mar_Revenue,e.Apr_Revenue,f.May_Revenue,g.Jun_Revenue,h.Jul_Revenue,i.Aug_Revenue,j.Sep_Revenue,k.Oct_Revenue,l.Nov_Revenue,m.Dec_Revenue 
FROM (SELECT DISTINCT id AS id FROM department ORDER BY id) a
LEFT OUTER JOIN
(SELECT id,revenue AS Jan_Revenue FROM department WHERE month = 'Jan' ORDER BY id) b ON a.id = b.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Feb_Revenue FROM department WHERE month = 'Feb' ORDER BY id) c ON a.id = c.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Mar_Revenue FROM department WHERE month = 'Mar' ORDER BY id) d ON a.id = d.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Apr_Revenue FROM department WHERE month = 'Apr' ORDER BY id) e ON a.id = e.id 
LEFT OUTER JOIN
(SELECT id,revenue AS May_Revenue FROM department WHERE month = 'May' ORDER BY id) f ON a.id = f.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Jun_Revenue FROM department WHERE month = 'Jun' ORDER BY id) g ON a.id = g.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Jul_Revenue FROM department WHERE month = 'Jul' ORDER BY id) h ON a.id = h.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Aug_Revenue FROM department WHERE month = 'Aug' ORDER BY id) i ON a.id = i.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Sep_Revenue FROM department WHERE month = 'Sep' ORDER BY id) j ON a.id = j.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Oct_Revenue FROM department WHERE month = 'Oct' ORDER BY id) k ON a.id = k.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Nov_Revenue FROM department WHERE month = 'Nov' ORDER BY id) l ON a.id = l.id 
LEFT OUTER JOIN
(SELECT id,revenue AS Dec_Revenue FROM department WHERE month = 'Dec' ORDER BY id) m ON a.id = m.id;
