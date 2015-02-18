<?php
	require 'edit.php';
?>

<html>
<head>
	<meta charset="utf-8">
	<meta name="description" content="<?php echo $desc; ?>">
	<meta name="keywords" content="<?php echo $keyws; ?>">
	<meta name="author" content="<?php echo $author; ?>">
	<title><?php echo $gtitle; ?></title>  
	<link rel="stylesheet" href="css/style.css"
</head>

<body>
	<div class="container">
    	<div class="row title">
        	<div class="tab1 centr"><h1><?php echo $names; ?></h1></div>
        	<div class="tab2">
            	<div><h1><?php echo $status; ?></h1></div>
     <!--           <div class="row">
                		<div class="tab3"><h2>Student</h2></div>
                    	<div class="tab3"><h2>Employee</h2></div>
               		</div>
  -->       </div>
        	<div class="tab1 centr"><h1><?php echo $movie; ?></h1></div>
        </div>
    	<div class="row green">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $chs; ?></h3></div>
                    <div class="tab5"><img src="images/Stepan.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal1" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal1" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Stepan.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row red">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $gm; ?></h3></div>
                    <div class="tab5"><img src="images/Marine.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal2" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal2" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Marine.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row green">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $he; ?></h3></div>
                    <div class="tab5"><img src="images/Eduard.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal3" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal3" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Eduard.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row red">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $jg; ?></h3></div>
                    <div class="tab5"><img src="images/Gor.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal4" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal4" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Gor.jpg" width=50%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row green">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $khm; ?></h3></div>
                    <div class="tab5"><img src="images/Movses.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal5" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal5" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Movses.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row red">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $ks; ?></h3></div>
                    <div class="tab5"><img src="images/non.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal6" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal6" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/non.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row green">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $kk; ?></h3></div>
                    <div class="tab5"><img src="images/Karen.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal7" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal7" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Karen.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row red">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $lv; ?></h3></div>
                    <div class="tab5"><img src="images/Vahan.jpg" style="width: 40%;"></div>
                    <div class="tab5"><a href="#openModal8" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a></div>
                    <div id="openModal8" class="modalDialog">
                        <div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Vahan.jpg" width=100%>
						</div>
					</div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    	<div class="row green">
        	<div class="tab1">
            	<div class="row">
                    <div class="tab4"><h3><?php echo $mh; ?></h3></div>
                    <div class="tab5"><img src="images/Hrach.jpg" style="width: 40%;"></div>
                    <div class="tab5">
                    	<a href="#openModal9" class="zoom"><img src="images/1423250611_zoom_in.png" alt="ZOOM"></a>
                        <div id="openModal9" class="modalDialog">
						<div>
							<a href="#close" title="Close" class="close">X</a>
                            <img src="images/Hrach.jpg" width=100%>
						</div>
					</div>

                    </div>
                </div>
            </div>
        	<div class="tab2">
                <div class="row">
                        <div class="tab3"><input type="checkbox" name="student" value="student" checked><?php echo $student; ?></div>
                        <div class="tab3"><input type="checkbox" name="student" value="Employee"><?php echo $employee; ?></div>
                </div>
			</div>
            <div class="row">
                <div class="tab1"><a href="<?php echo $favmlink; ?>" target="_blank"><?php echo $favmname; ?></a></div>
            </div>
        </div><hr/>
    </div>
</body>
</html>
