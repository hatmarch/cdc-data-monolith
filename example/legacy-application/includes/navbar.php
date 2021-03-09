<?php
echo '
<div class="navbar navbar-inverse navbar-fixed-top">
<div class="navbar-inner">
    <div class="container-fluid">
        <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="brand" href="#">Inventory Deluxe &#39;95</a>
        <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
                Logged in as <a href="#" class="navbar-link">SuperAdmin</a>
            </p>
            <ul class="nav">
                <li class="active"><a href="index.php">Home</a></li>
                <li><a href="#invoice">Invoices</a></li>
                <li><a href="view.php">Inventory</a></li>
                <li><a href="#accounts">Accounts</a></li>
                <li><a href="#shipments">Shipments</a></li>
                <li><a href="#reports">Reports</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
</div>
';
?>