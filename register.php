<?php

$servername = "localhost";
$username = "lollxgiu_admin";
$password = "Naim@Imran2454";
$dbname = "lollxgiu_office_eployee";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);


//Variables
$name = $_POST["name"];
$email = $_POST["email"];
$password = $_POST["password"];

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO employee (name, email, password)
VALUES ('$name', '$email', '$password')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>