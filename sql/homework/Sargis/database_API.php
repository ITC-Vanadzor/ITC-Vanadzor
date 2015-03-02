<?php
$username = 'root';
$servername = 'localhost';
$password = '123456';
$db_name = 'Comp_Store';
$conn = mysql_connect($servername, $username, $password, $db_name);

if (!$conn) {
    die("Can't connect :" . mysql_error());
}

mysql_select_db($db_name);

function print_table($name)
{
	$result = mysql_query("SELECT * FROM " . $name);
	while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
		foreach ($row as $key => $value) {
			$v = $key . " = " . $value . " ";
    		echo ($v); 
    	}
    	echo("\n");
    }
    echo("time");
	echo(time());
}

/*
| C_id      | int(11)       | NO   |     | NULL              |                             |
| B_id      | int(11)       | NO   |     | NULL              |                             |
| P_id      | int(11)       | NO   |     | NULL              |                             |
| price     | decimal(10,2) | YES  |     | NULL              |                             |
| quantity  | int(11)       | NO   |     | NULL              |                             |
| sell_date | timestamp     | NO   | MUL | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
| amount    | decimal(10,2) | YES  |     | NULL              | 
*/

function insert_sale($C_id, $B_id, $P_id, $price, $quantity)
{
	$time = time();
	$query = "INSERT INTO Sales (C_id, B_id, P_id, price, quantity, amount) Values ( " . 
								$C_id . ", " . $B_id . ", " . $P_id . ", " . $price . ", " . 
								$quantity . ", " . $price * $quantity . ");";
	echo($query);
	mysql_query($query);
}

/*
for($i = 0; $i < 1000; ++$i) {
	
	insert_sale($i % 8, $i % 10, $i % 30, $i, $i % 5);

}

*/

function most_sold_prod($stat_time, $end_time)
{

	$query = "select P_id, SUM(quantity) as qnt 
			  from Sales 
			  where UNIX_TIMESTAMP(sell_date) > " . $stat_time . " AND UNIX_TIMESTAMP(sell_date) < " . $end_time .  
	 		  " group by P_id order by qnt DESC limit 1;";



	$result = mysql_query($query);

	
	while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
		foreach ($row as $key => $value) {
			$v = $key . " = " . $value . " ";
    		echo ($v); 
    	}
	}

}

function row_to_html($cells, $name)
{
	$table = "<table><tr>";
	foreach ($cells as $key => $value) {
		$table .= "<td>" . $value . "</td>";	
	}
	$table .= "</tr>";

	$result = mysql_query("SELECT * FROM " . $name);

	while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
		$table .= "<tr>";
		foreach ($cells as $key => $value) {
			$table .= "<td>" . $row[$value] . "</td>";
    	}
		$table .= "</tr>";
    }
    $table .= "</table>";
    echo $table;
}

// amenashat vacarvac brand@
//select B_id, SUM(amount) as amountSum from Sales group by B_id order by amountSum DESC limit 1;
//select B_id, SUM(quantity) as qnt from Sales group by B_id order by qnt DESC limit 1;

//amboxch ekamut
//select  SUM(amount) from Sales; 

//amenashat vacharvac sarq@
//select P_id, SUM(quantity) as qnt from Sales group by P_id order by qnt DESC limit 1;

//amenashat vacharvac sarqe@ @et firmaneri


//UNIX_TIMESTAMP(sell_date) < 1425240840  AND UNIX_TIMESTAMP(sell_date) > 0

//strtotime( '-1 month', $timestamp );


//strtotime( '-1 month', $timestamp );

//print_table("Sales");
$cells = array();

array_push($cells, "C_id");

array_push($cells, "B_id");

array_push($cells, "P_id");

array_push($cells, "price");

array_push($cells, "quantity");

array_push($cells, "sell_date");

array_push($cells, "amount");
//row_to_html($cells, "Sales");
most_sold_prod(0, 1425278618);
?>
