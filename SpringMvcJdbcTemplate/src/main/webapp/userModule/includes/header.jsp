<!--Navigation bar-->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Men<span>tor</span></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#feature">Features</a></li>
				<li><a href="#organisations">Organisations</a></li>
				<li><a href="#courses">Courses</a></li>
				<li><a href="#pricing">Pricing</a></li>
				<li><a href="#" data-target="#login" data-toggle="modal">Sign
						in</a></li>
				<li class="btn-trial"><a href="#footer">Free Trail</a></li>
			</ul>
		</div>
	</div>
</nav>
<!--/ Navigation bar-->

<!--Modal box-->
<div class="modal fade" id="login" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content no 1-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title text-center form-title">Login</h4>
			</div>
			<div class="modal-body padtrbl">

				<div class="login-box-body">
					<p class="login-box-msg">Sign in to start your session</p>
					<div class="form-group">
						<form name="" id="loginForm">
							<div class="form-group has-feedback">
								<!----- username -------------->
								<input class="form-control" placeholder="Username" id="loginid"
									type="text" autocomplete="off" /> <span
									style="display: none; font-weight: bold; position: absolute; color: red; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
									id="span_loginid"></span>
								<!---Alredy exists  ! -->
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<!----- password -------------->
								<input class="form-control" placeholder="Password" id="loginpsw"
									type="password" autocomplete="off" /> <span
									style="display: none; font-weight: bold; position: absolute; color: grey; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
									id="span_loginpsw"></span>
								<!---Alredy exists  ! -->
								<span class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="checkbox icheck">
										<label> <input type="checkbox" id="loginrem">
											Remember Me
										</label>
									</div>
								</div>
								<div class="col-xs-12">
									<button type="button" class="btn btn-green btn-block btn-flat"
										onclick="userlogin()">Sign In</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!--/ Modal box-->

<!--Banner-->
<div class="banner">
	<div class="bg-color">
		<div class="container">
			<div class="row">
				<div class="banner-text text-center">
					<div class="text-border">
						<h2 class="text-dec">Trust & Quality</h2>
					</div>
					<div class="intro-para text-center quote">
						<p class="big-text">Learning Today . . . Leading Tomorrow.</p>
						<p class="small-text">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Laudantium enim repellat sapiente quos architecto<br>Laudantium
							enim repellat sapiente quos architecto
						</p>
						<a href="#footer" class="btn get-quote">GET A QUOTE</a>
					</div>
					<a href="#feature" class="mouse-hover">
						<div class="mouse"></div>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!--/ Banner-->
--%>
