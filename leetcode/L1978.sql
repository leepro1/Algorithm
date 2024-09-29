SELECT
    employee_id
FROM
    Employees
WHERE
    manager_id NOT IN (
        SELECT 
            employee_id AS manager_id
        FROM
            Employees
    )
    AND
        salary < 30000
    AND
        manager_id IS NOT NULL
ORDER BY
    employee_id;
