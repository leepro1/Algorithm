SELECT
    ANIMAL_ID, NAME,
    CASE
        WHEN INSTR(SEX_UPON_INTAKE, "Neutered") >= 1 THEN "O"
        WHEN INSTR(SEX_UPON_INTAKE, "Spayed") >= 1 THEN "O"
        ELSE "X"
    END AS "중성화"
FROM
    ANIMAL_INS;
