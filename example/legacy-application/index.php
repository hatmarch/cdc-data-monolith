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
                        <h1>Pre-generated Inventory</h1>
                        <p>This is a template for a simple marketing or informational website. It includes a large
                            callout called the hero unit and three supporting pieces of content. Use it as a starting
                            point to create something more unique.</p>
                        <form action="upload.php" method="post" enctype="multipart/form-data">
                            <label for="profile_pic">Select File: </label>
                            <input id="fileToUpload" name="fileToUpload" type="file" class="btn">
                            <input type="hidden" name="MAX_FILE_SIZE" value="300000" />
                            <p><input type="submit" name="submit" class="btn btn-primary btn-large" value="Load File &raquo;"/></p>
                        </form>
                    </div>
                    <div class="row-fluid">
                        <div class="span4">
                            <h2>Heading</h2>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
                                commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam
                                porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn" href="#">View details &raquo;</a></p>
                        </div>
                        <!--/span-->
                        <div class="span4">
                            <h2>Heading</h2>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
                                commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam
                                porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn" href="#">View details &raquo;</a></p>
                        </div>
                        <!--/span-->
                        <div class="span4">
                            <h2>Heading</h2>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
                                commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam
                                porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn" href="#">View details &raquo;</a></p>
                        </div>
                        <!--/span-->
                    </div>
                    <!--/row-->
                    <div class="row-fluid">
                        <div class="span4">
                            <h2>Heading</h2>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
                                commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam
                                porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn" href="#">View details &raquo;</a></p>
                        </div>
                        <!--/span-->
                        <div class="span4">
                            <h2>Heading</h2>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
                                commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam
                                porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn" href="#">View details &raquo;</a></p>
                        </div>
                        <!--/span-->
                        <div class="span4">
                            <h2>Heading</h2>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
                                commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam
                                porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn" href="#">View details &raquo;</a></p>
                        </div>
                        <!--/span-->
                    </div>
                    <!--/row-->
                </div>
                <!--/span-->
            </div>
            <!--/row-->

            <hr>

            <footer>
                <p>&copy; International Inc 1995</p>
            </footer>

        </div> <!-- /container -->

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.js"></script>
        <script>
        var forms = document.getElementsByTagName("form"); 
        for(var i=0; i<forms.length;i++) forms[i].addEventListener("submit", 
        function(){ 
            var hidden = document.createElement("input");  
            hidden.setAttribute("type","hidden"); 
            hidden.setAttribute("name","fragment");  
            hidden.setAttribute("value",window.location.hash); 
            this.appendChild(hidden);
        });
        </script>

</body>

</html>
'; ?>