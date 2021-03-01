<?php

$servername = "localhost";
$username = "lollxgiu_admin";
$password = "Naim@Imran2454";
$dbname = "lollxgiu_office_eployee";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);


//Variables
$email = $_POST["email"];
$password = $_POST["password"];

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM employee WHERE email = '$email' AND password = '$password'";
$result = mysqli_query($conn, $sql);




if ($result->num_rows > 0) {
  echo "logged in successfully";
} else {
  echo "User not found";
}

?>