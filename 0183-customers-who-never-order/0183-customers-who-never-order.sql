# Write your MySQL query statement below
Select c.name as Customers FROM Customers c where c.id NOT IN (select DISTINCT customerId from Orders) 