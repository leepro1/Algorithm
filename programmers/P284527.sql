SELECT 
    g.SCORE,
    e.EMP_NO, 
    e.EMP_NAME, 
    e.POSITION, 
    e.EMAIL
FROM 
    HR_EMPLOYEES e
JOIN 
    (SELECT 
         EMP_NO, SUM(SCORE) AS SCORE
     FROM 
         HR_GRADE
     WHERE
        YEAR = 2022
     GROUP BY 
         EMP_NO
     ORDER BY 
         SCORE DESC
     LIMIT 1) g
ON 
    e.EMP_NO = g.EMP_NO;
