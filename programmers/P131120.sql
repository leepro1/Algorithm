SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE Month(DATE_OF_BIRTH) = 3 
    AND TLNO IS NOT NULL
    AND GENDER = 'W'
  ORDER BY 1;