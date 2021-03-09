<?php
/* Connect to the remote server using SQL Server Authentication and   
specify the InternationalDB database as the database in use. */
$serverName = $_ENV["SERVER_NAME"] ? $_ENV["SERVER_NAME"] : "localhost, 1433";
$connectionOptions = array(
    "Database"=>"InternationalDB",  
    "Authentication"=>"SqlPassword",
    "UID"=>"sa", "PWD"=>"Password!",
    "TrustServerCertificate"=>true);  
$conn = sqlsrv_connect($serverName, $connectionOptions);
if($conn == false) 
{
  die(var_dump(sqlsrv_errors()));
}
?>
