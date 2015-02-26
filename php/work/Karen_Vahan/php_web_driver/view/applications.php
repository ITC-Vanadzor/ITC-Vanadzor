<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <div>
        <?php
            $servername = "localhost";
            $username = "root";
            $password = "student2014";
            $dbname = "my_web_db";
            // Create connection
            $conn = new mysqli($servername, $username, $password, $dbname);
            // Check connection
            if ($conn->connect_error) {
                die("Connection failed: " . $conn->connect_error);
            } 

echo "HELLO!!!";
            $sql = "SELECT id, name FROM apps";
            $result = $conn->query($sql);

            
            if ($result->num_rows > 0) {
                // output data of each row
                while($row = $result->fetch_assoc()) {
                    echo "<br> id: ". $row["id"]. " - Name: ". $row["name"] . "<br>";
                }
            } else {
                echo "0 results";
            }

            $conn->close();
        ?>  
    </div>
</body>
</html>
