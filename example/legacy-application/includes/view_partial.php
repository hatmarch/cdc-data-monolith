<?php

// NOTE: Assumes includes/connection.php has been included already in parent page


/* Retrieve rows */
$query = "SELECT [ItemId], [ItemName], [Description], [Quantity], [Price], [Location], [Link] FROM [InternationalDB].[dbo].[Inventory]";

$stmt_s = sqlsrv_query( $conn, $query);

if( $stmt_s === false)  
{  
     echo "Error in query preparation/execution.\n";  
     die( print_r( sqlsrv_errors(), true));  
}  

/* Paint screen */
echo '
</div>
<div class="row-fluid">
<h2>Inventory</h2>
</div>
<table class="table table-condensed">
';
  
/* Retrieve each row as an associative array and display the results.*/  
while( $row = sqlsrv_fetch_array( $stmt_s, SQLSRV_FETCH_ASSOC))  
{  
  echo '<tr>';
  foreach ($row as $val) {
    echo '<td><a href="edit.php?inv=' . base64_encode(json_encode($row)) . '">' . $val . '</a></td>';
  }
  echo '</tr>';
}  
      
/* Free statement resources. */
sqlsrv_free_stmt( $stmt_s );

/* Free connection resources. */
sqlsrv_close( $conn );

echo '
</table>
<div class="pagination pagination-centered">
<ul>
<li class="disabled"><a href="#">Prev</a></li>
<li class="active"><a href="#">1</a></li>
<li><a href="#">2</a></li>
<li><a href="#">3</a></li>
<li><a href="#">4</a></li>
<li><a href="#">5</a></li>
<li><a href="#">Next</a></li>
</ul>
</div>
</div>
<!--/span-->
</div>
<!--/row-->

<hr>
';

?>
