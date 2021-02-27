SELECT CITY, MIN(LENGTH(CITY)) AS min_value FROM STATION GROUP BY CITY ORDER BY min_value, CITY LIMIT 1;

SELECT CITY, MAX(LENGTH(CITY)) AS max_value FROM STATION GROUP BY CITY ORDER BY max_value DESC LIMIT 1;
