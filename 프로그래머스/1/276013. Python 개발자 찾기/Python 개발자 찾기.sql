select 
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
from
    DEVELOPER_INFOS
where
    SKILL_1 = 'python'
OR
    SKILL_2 = 'python'
OR
    SKILL_3 = 'python'
ORDER BY ID ;