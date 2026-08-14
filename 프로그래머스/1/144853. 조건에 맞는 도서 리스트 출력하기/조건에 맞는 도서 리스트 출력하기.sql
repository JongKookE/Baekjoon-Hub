-- 코드를 입력하세요
SELECT
    book_id,
    PUBLISHED_DATE
from
    book
where category = '인문'
and PUBLISHED_DATE > '2020-12-31'
and PUBLISHED_DATE < '2022-1-1'
order by PUBLISHED_DATE;
