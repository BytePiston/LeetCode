# Write your MySQL query statement below
Select e2.name AS Employee FROM Employee e1 INNER JOIN Employee e2 ON e2.managerId = e1.id where e2.salary > e1.salary