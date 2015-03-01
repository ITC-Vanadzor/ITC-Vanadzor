/*
Get sale by firms DESC
*/
CREATE TEMPORARY TABLE IF NOT EXISTS counts_tmp SELECT firm_id, count(firm_id) AS counts FROM History GROUP BY firm_id ORDER BY counts DESC;
SELECT * FROM counts_tmp INNER JOIN Firms ON Firms.id = counts_tmp.firm_id;
DROP TABLE counts_tmp;