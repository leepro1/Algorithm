SELECT
    student_id, 
    student_name, 
    subject_name, 
    COUNT(*) AS attended_exams
FROM
    Students
CROSS JOIN
    Subjects
LEFT JOIN
    Examinations 
USING 
    (student_id, subject_name)
GROUP BY
    student_id, student_name, subject_name
ORDER BY
    student_id, subject_name;

