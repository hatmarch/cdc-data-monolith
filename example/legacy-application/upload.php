<?php
echo '
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>International Inc</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="/css/bootstrap.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
        tr:hover { 
          background: red; 
        }
    </style>
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>
';

include 'includes/navbar.php';

echo'
    <div class="container-fluid">
    <div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Type</li>
                    <li><a href="#">Entered</a></li>
                    <li><a href="#">Retrieved</a></li>
                    <li class="active"><a href="#">Imported</a></li>
                    <li><a href="#">Generated</a></li>
                    <li class="nav-header">Status</li>
                    <li><a href="#">Open</a></li>
                    <li><a href="#">Printed</a></li>
                    <li><a href="#">Deleted</a></li>
                    <li><a href="#">Posted</a></li>
                </ul>
            </div>
            <!--/.well -->
        </div>
        <!--/span-->
        <div class="span9">
            <div class="hero-unit">
            <h1>Imported Inventory</h1>
';

if ( isset($_POST["submit"]) == false ) 
{
  die("No file selected");
}

if ( isset($_FILES["fileToUpload"]) == false) 
{
  die("No file selected");
}

//if there was an error uploading the file
if ($_FILES["fileToUpload"]["error"] > 0) 
{
  die("Return Code: " . $_FILES["fileToUpload"]["error"]);
}

//Print file details
echo "Upload: " . $_FILES["fileToUpload"]["name"] . "<br />";
echo "Type: " . $_FILES["fileToUpload"]["type"] . "<br />";
echo "Size: " . ($_FILES["fileToUpload"]["size"] / 1024) . " Kb<br />";
echo "Temp file: " . $_FILES["fileToUpload"]["tmp_name"] . "<br />";

$csvFile = file($_FILES["fileToUpload"]["tmp_name"]);
$csv = array_map('str_getcsv', $csvFile);
array_shift($csv);

require 'includes/connection.php';

$tsql_callSP = "{call SpUpsertInventory( ?, ?, ?, ?, ?, ?, ? )}";

foreach ($csv as $item) 
{
  $stmt = sqlsrv_query( $conn, $tsql_callSP, $item);
  if ( $stmt == false )
  {
    echo "Error in statement execution: <br />";
    die( print_r( sqlsrv_errors(), true));
  }  
  /* Free statement resources. */
  sqlsrv_free_stmt( $stmt );
}

require 'includes/view_partial.php';

include 'includes/footer.php';

echo '

</body>

</html>
';
?>