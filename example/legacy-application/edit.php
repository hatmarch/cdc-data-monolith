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
echo '
    <div class="container-fluid">
    <div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Type</li>
                    <li class="active"><a href="#">Entered</a></li>
                    <li><a href="#">Retrieved</a></li>
                    <li><a href="index.php">Imported</a></li>
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
            <h1>Entered Inventory</h1>
';

if ( isset($_GET["inv"]) == false ) 
{
  die("No inventory selected");
}

$inv = json_decode(base64_decode(htmlspecialchars($_GET["inv"])), true);

if ( isset($_POST["submit"]) == true ) 
{
  require 'includes/connection.php';

  /* update row */
  $query = "UPDATE [InternationalDB].[dbo].[Inventory]
            SET [ItemName] = (?), [Quantity] = (?), [Description] = (?), [Price] = (?), [Location] = (?), [Link] = (?) 
            WHERE [ItemId] = (?)";
  $params = array($_POST["ItemName"], $_POST["Quantity"], $_POST["Description"], $_POST["Price"], $_POST["Location"], $_POST["Link"], $_POST["ItemId"]);

  $stmt = sqlsrv_query( $conn, $query, $params);

  if( $stmt === false)  
  {
    echo "Error in statement execution: <br />";
    die( print_r( sqlsrv_errors(), true));
  }  
  /* Free statement resources. */
  sqlsrv_free_stmt( $stmt );
  
  /* Free connection resources. */
  sqlsrv_close( $conn );

  echo '<span class="label label-success">Inventory Saved!</span>';

  $inv = array_merge($inv, $_POST);
}  

echo '
            <form class="form-horizontal" method="post">
              <fieldset>
                <legend>Edit Item ' . $inv["ItemId"] . '</legend>
                <input type="hidden" name="ItemId" value="' . $inv["ItemId"] . '">
                <label>Item Name</label>
                <input type="text" name="ItemName" placeholder="ItemName" value="' . $inv["ItemName"] . '">
                <label>Quantity</label>
                <input type="text" name="Quantity" placeholder="Quantity" value="' . $inv["Quantity"] . '">
                <label>Description</label>
                <input type="text" name="Description"  placeholder="Description" value="' . $inv["Description"] . '">
                <label>Price</label>
                <input type="text" name="Price"  placeholder="Price" value="' . $inv["Price"] . '">
                <label>Location</label>
                <input type="text" name="Location"  placeholder="Location" value="' . $inv["Location"] . '">
                <label>Link</label>
                <input type="text" name="Link"  placeholder="Link" value="' . $inv["Link"] . '">
                <span class="help-block">Click Save to update the record.</span>
                <button type="submit" name="submit" class="btn">Save</button>
              </fieldset>
            </form>
        </div>
        <!--/span-->
    </div>
    <!--/row-->
  </div>
<hr>
';

include 'includes/footer.php';

echo '

</body>

</html>
';
?>