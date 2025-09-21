-- 코드를 입력하세요
SELECT 
    b.book_id AS "BOOK_ID",
    a.author_name AS "AUTHOR_NAME",
    DATE_FORMAT(b.PUBLISHED_DATE, "%Y-%m-%d") AS "PUBLISHED_DATE"
FROM book AS b
INNER JOIN author AS a
USING(AUTHOR_ID)
WHERE b.category = "경제"
ORDER BY b.PUBLISHED_DATE ASC;

