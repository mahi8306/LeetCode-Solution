# Write your MySQL query statement below
SELECT person_name
FROM Queue
WHERE turn = (
    SELECT MAX(q.turn)
    FROM Queue q
    WHERE (
        SELECT SUM(weight)
        FROM Queue q2
        WHERE q2.turn <= q.turn
    ) <= 1000
);
