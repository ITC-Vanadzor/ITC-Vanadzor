/*Get sale by firms DESC*/
CREATE TEMPORARY TABLE IF NOT EXISTS counts_tmp SELECT firm_id, count(firm_id) AS counts FROM History where (saledate >= CURDATE() - INTERVAL 1 MONTH) GROUP BY firm_id ORDER BY counts DESC;
SELECT * FROM counts_tmp INNER JOIN Firms ON Firms.id = counts_tmp.firm_id;
DROP TABLE counts_tmp;

/*Suum all products costs in last month*/
SELECT SUM(cost) FROM History where (saledate >= CURDATE() - INTERVAL 1 MONTH);

/*Dfference between last and penultimate monts counts*/
SELECT SUM(cost) FROM History where (saledate BETWEEN (CURDATE() - INTERVAL 2 MONTH) and  (CURDATE() - INTERVAL 1 MONTH)) into @d2;
SELECT SUM(cost) FROM History where (saledate BETWEEN (CURDATE() - INTERVAL 1 MONTH) and  CURDATE()) into @d1;
select(@d1 - @d2);
