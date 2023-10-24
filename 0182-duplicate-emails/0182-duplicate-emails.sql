# Write your MySQL query statement below
Select email As Email from Person group by email having count(email) > 1;