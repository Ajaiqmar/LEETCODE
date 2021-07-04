SELECT course.class FROM (SELECT c.class,COUNT(c.class) AS countOfClass FROM (SELECT DISTINCT * FROM courses) c GROUP BY class) course WHERE course.countOfClass >= 5;
