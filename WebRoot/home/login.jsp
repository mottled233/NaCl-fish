<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
		
		<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home.html"><img alt="logo" src="../images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
				<div class="login-box">

							<h3 class="title">登陆商城</h3>

							<div class="clear"></div>
						
						<div class="login-form">
						  <form>
							   <div class="user-name">
								    <label for="user"><i class="am-icon-user"></i></label>
								    <input type="text" name="" id="user" placeholder="用户名">
                 </div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="password" placeholder="请输入密码">
                 </div>
              </form>
           </div>
            
            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
								<a href="#" class="am-fr">忘记密码</a>
								<a href="register.html" class="zcnext am-fr am-btn-default">注册</a>
								<br />
            </div>
								<div class="am-cf">
									<input type="submit" name="" value="登 录" id="sub-btn" class="am-btn am-btn-primary am-btn-sm">
								</div>
						<div class="partner">		
								<h3>合作账号</h3>
							<div class="am-btn-group">
								<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
								<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
								<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
							</div>
						</div>	

				</div>
			</div>
		</div>


					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">NaclFish</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# "></a>
								<a href="# "></a>
								<a href="# "></a>
								<a href="# "></a>
								<em></em>
							</p>
						</div>
					</div>
					

<script>
    var username;
    var password;
    $(document).ready(function(){
        $("#sub-btn").click(function(e){
        	username = $("#user").val();
        	password = $("#password").val();
            $.post("../servlet/LoginServlet",
                    {username:username,password:password},
                    function(data){
                        if(data=="success") {
                            location.href = "home2.html"
                        }else if(data=="failed"){
                           alert("Login Failed!");
                        }
                    });
        });
       	
    });
</script>
	
	</body>

</html>