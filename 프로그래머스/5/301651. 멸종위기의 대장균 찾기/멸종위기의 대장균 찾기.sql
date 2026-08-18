WITH RECURSIVE GENERATIONS AS (
    SELECT 
        ID, 
        PARENT_ID, 
        1 AS GEN
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT 
        E.ID, 
        E.PARENT_ID, 
        G.GEN + 1
    FROM 
        ECOLI_DATA AS E
    JOIN 
        GENERATIONS AS G 
    ON
        E.PARENT_ID = G.ID
)
SELECT 
    COUNT(*) AS 'COUNT',
    G.GEN AS 'GENERATION'
FROM 
    ECOLI_DATA AS ED
JOIN
    GENERATIONS AS G
ON ED.ID = G.ID
WHERE 
    ED.ID NOT IN (
        SELECT 
            PARENT_ID 
        FROM 
            GENERATIONS 
        WHERE 
            PARENT_ID IS NOT NULL
    )
GROUP BY 
    G.GEN
ORDER BY 
    G.GEN;