<!Doctype html>
<html>
<head><meta charset="UTF-8"></head>
<body>
<?php
$conn_string = "host=localhost port=5432 dbname=comp_store_db user=postgres password=25773";    
$conn = pg_connect($conn_string);

if (!$conn) {
    die("Can't connect :" . mysql_error());
}


function print_table($name)
{
    global $conn;
    $sql = "SELECT * FROM " . $name;
    $result = pg_query($conn, $sql);
    while ($row = pg_fetch_array($result, PGSQL_ASSOC)) {
        foreach ($row as $key => $value) {
            $v = $key . " = " . $value . " ";
            echo ($v); 
        }
        echo("\n");
    }
   // echo("time");
   // echo(time());
}

//sales table
//               | integer                     | not null default nextval('sales_id_seq'::regclass)
//    unit_id    | integer                     | not null
//    firm_id    | integer                     | not null
//    product_id | integer                     | not null
//    price      | numeric                     | 
//    quantity   | integer                     | 
//    time       | timestamp without time zone | 
//    amount     | numeric                     |
//

function insert_sale($unit_id, $firm_id, $product_id, $price, $quantity)
{
    global $conn;
    $time = time();
    $query = "INSERT INTO Sales (unit_id, firm_id, product_id, price, quantity, amount) Values ( " . 
                                $unit_id . ", " . $firm_id . ", " . $product_id . ", " . $price . ", " . 
                                $quantity . ", " . $price * $quantity . ");";
    echo($query);
    pg_query($conn, $query);
}

//product table
//     id            | integer               | not null default nextval('product_id_seq'::regclass)
//     unit_id       | integer               | not null
//     firm_id       | integer               | not null
//     price         | numeric               | 
//     quantity      | integer               | 
//     serial_number | character varying(30) | 
//

function insert_poduct($unit_id, $firm_id, $price, $quantity)
{
    global $conn;
    $query = "INSERT INTO product (unit_id, firm_id, price, quantity) Values ( " . 
                                $unit_id . ", " . $firm_id . ","  . $price . ", " . 
                                $quantity . ");";
    echo($query);
    pg_query($conn, $query);
}
for($i = 0; $i < 100; ++$i) {

   insert_sale($i % 12, $i % 4, $i % 80, $i, $i % 5);

   }
 
       

function most_sold_prod($stat_time, $end_time)
{
    global $conn;

    $query = "select P_id, SUM(quantity) as qnt 
              from Sales 
              where UNIX_TIMESTAMP(sell_date) > " . $stat_time . " AND UNIX_TIMESTAMP(sell_date) < " . $end_time .  
              " group by P_id order by qnt DESC limit 1;";



    $result = pg_query($conn, $query);

    
    while ($row = pg_fetch_array($result, PGSQL_ASSOC)) {
        foreach ($row as $key => $value) {
            $v = $key . " = " . $value . " ";
            echo ($v); 
        }
    }

}

function row_to_html($cells, $name)
{
    global $conn;
    $table = "<table><tr>";
    foreach ($cells as $key => $value) {
        $table .= "<td>" . $value . "</td>";    
    }
    $table .= "</tr>";

    $result = pg_query($conn, "SELECT * FROM " . $name);

    while ($row = pg_fetch_array($result, PGSQL_ASSOC)) {
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
// //select B_id, SUM(amount) as amountSum from Sales group by B_id order by amountSum DESC limit 1;
// //select B_id, SUM(quantity) as qnt from Sales group by B_id order by qnt DESC limit 1;
//
// //amboxch ekamut
// //select  SUM(amount) from Sales; 
//
// //amenashat vacharvac sarq@
// //select P_id, SUM(quantity) as qnt from Sales group by P_id order by qnt DESC limit 1;
//
// //amenashat vacharvac sarqe@ @et firmaneri
//
//
// //UNIX_TIMESTAMP(sell_date) < 1425240840  AND UNIX_TIMESTAMP(sell_date) > 0
//
// //strtotime( '-1 month', $timestamp );
//
//
// //strtotime( '-1 month', $timestamp );
//
//print_table("sales");
$cells = array();
echo "Hello!";
array_push($cells, "unit_id");

array_push($cells, "firm_id");

array_push($cells, "product_id");

array_push($cells, "price");

array_push($cells, "quantity");

array_push($cells, "time");

array_push($cells, "amount");
row_to_html($cells, "sales");
// most_sold_prod(0, 1425228140);  
?>
</body>
</html>
