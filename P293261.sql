SELECT
    ID, FISH_NAME, LENGTH
FROM
    FISH_INFO
INNER JOIN
    FISH_NAME_INFO
USING
    (FISH_TYPE)
WHERE
    (FISH_TYPE, LENGTH) IN
        (
            SELECT
                FISH_TYPE, MAX(LENGTH) AS LENGTH
            FROM
                FISH_INFO
            GROUP BY
                FISH_TYPE
        )
ORDER BY
    ID;
