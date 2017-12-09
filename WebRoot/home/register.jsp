<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

<script src="../js/registerjs.js"></script>

</head>

<body>

	<div class="login-boxtitle">
		<a href="home/demo.html"><img alt="" src="../images/logobig.png" />
		</a>
	</div>

	<div class="res-banner">
		<div class="res-main">
			<div class="login-banner-bg">
				<span></span><img src="../images/big.jpg" />
			</div>
			<div class="login-box">

				<div class="am-tabs" id="doc-my-tabs">
					<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
						<li class="am-active"><a href="">用户注册</a>
						</li>
						
					</ul>

					<div class="am-tabs-bd">
						<div class="am-tab-panel am-active">
							<form method="post">

								<div class="user-email">
									<label for="email"><i class="am-icon-envelope-o"></i>
									</label> <input type="email" name="" id="username"
										placeholder="请输入用户名">
								</div>
								<div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i>
									</label> <input type="password" name="" id="password"
										placeholder="设置密码">
								</div>
								<div class="user-pass">
									<label for="passwordRepeat"><i class="am-icon-lock"></i>
									</label> <input type="password" name="" id="passwordRepeat"
										placeholder="确认密码">
								</div>

							</form>

							<div class="login-links">
								<label for="reader-me"> <input id="reader-me"
									type="checkbox"> 点击表示您同意商城《服务协议》 </label>
							</div>
							<div class="am-cf">
								<input type="submit" name="" value="注册" id="sub-btn"
									class="am-btn am-btn-primary am-btn-sm am-fl">
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="footer ">
			<div class="footer-hd ">
				<p>
					<a href="# ">NaclFish</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
						href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
				</p>
			</div>
			<div class="footer-bd ">
				<p>
					<a href="# "></a> <a href="# "></a> <a href="# "></a> <a href="# "></a>
				</p>
			</div>
		</div>
	</div>


	<script>
		var username;
		var password;
		var headImg = "";
		var address = "";
		var phoneNumber = "";
		var qq = "";
		var email = "example@example.com";
		var passwordRepeat;
		$("#sub-btn").click(function(e) {
			if (!$("#reader-me").checked) {
				alert("Please read the Service agreement!");
			} else {
				username = $("#username").val();
				password = $("#password").val();
				passwordRepeat = $("#passwordRepeat").val();
				if (password != passwordRepeat) {
					alert("Password Repeat Error!");
				} else {
					$.post("../servlet/RegisterServlet", {
						username : username,
						password : password,
						headImg : headImg,
						address : address,
						phoneNumber : phoneNumber,
						qq : qq,
						email : email
					}, function(data) {
						if (data == "success") {
							alert("Register Success!");
						} else if (data == "exist") {
							alert("User already exist!");
						}
					});
				}
			}
		});
	</script>
</body>



</html>