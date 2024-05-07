SELECT BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
JOIN AUTHOR
USING (AUTHOR_ID)
WHERE CATEGORY = '경제'
ORDER BY PUBLISHED_DATE;
