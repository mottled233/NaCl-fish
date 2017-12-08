<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人资料</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/infstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>			
	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<a href="#" target="_top" class="h">亲，请登录</a>
									<a href="#" target="_top">免费注册</a>
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
							</div>
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
						</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="../images/logobig.png" /></li>
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">个人中心</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
							</ul>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-info">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">发布物品</strong> / <small>发布新物品</small></div>
						</div>
						<hr/>

						<!--头像 -->
						<div class="user-infoPic">

							<div class="filePic">
								<input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
								<img class="am-circle am-img-thumbnail" src="../images/getAvatar.do.jpg" alt="" />
							</div>

							<p class="am-form-help">图片</p>

							<div class="info-m">
								<div><b>点击上传图片</b></div>
								
							</div>
						</div>

						<!--商品信息 -->
						<div class="info-main">
							<form class="am-form am-form-horizontal">

								<div class="am-form-group">
									<label for="p_goods_name" class="am-form-label">物品名称</label>
									<div class="am-form-content">
										<input type="text" id="p_goods_name" placeholder="物品名称">
                                          <small>名称长度不能超过40个汉字</small>
									</div>
								</div>

								<div class="am-form-group">
									<label for="p_goods_detail" class="am-form-label">物品详情</label>
									<div class="am-form-content">
										<textarea id="p_goods_detail" rows="" cols=""></textarea>
                                         
									</div>
								</div>

								<div class="am-form-group">
									<label for="p_goods_price" class="am-form-label">物品价格</label>
									<div class="am-form-content">
										<input type="text" id="p_goods_price" placeholder="价格">
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-birth" class="am-form-label">物品类别</label>
									<div class="am-form-content birth">
										<div class="p_kind_select">
											
											<select data-am-selected>
												<option value="电子数码">电子数码</option>
												<option value="服饰">服饰</option>
												<option value="食品">食品</option>
												<option value="运动健身">运动健身</option>
												<option value="生活家居">生活家居</option>
											</select>
											
										</div>
										
									</div>
							
								</div>
								<div class="am-form-group">
									<label for="user-phone" class="am-form-label">发货地址</label>
									<div class="am-form-content">
										<input id="p_goods_adress" placeholder="发货地址" type="text">

									</div>
								</div>
								
								<div class="info-btn">
									<div class="am-btn am-btn-danger">提交上传</div>
								</div>

							</form>
						</div>

					</div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>©版权所有.</em>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="index.html"><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人中心</p>
						<ul>
							<li> <a href="information.html">个人信息</a></li>
							<li> <a href="safety.html">发布物品</a></li>
							<li> <a href="address.html">订单管理</a></li>
							<li> <a href="cardlist.html">我发布的</a></li>
						</ul>
					</li>
					
				</ul>

			</aside>
		</div>
<script type="text/javascript">
    $("#register_btn").click(function(e){
        var name = $("#p_goods_name").val();
        var detail = $("#p_goods_detail").val();
        var kind = $("#p_goods_kind").val();
        var price = $("#p_goods_price").val();
        var address = $("#p_goods_address").val();
		var jpg = "../images/logobig.png";
		
        if(!(name==null||name==""||detail==null||detail==""||kind==null||kind==""||price==null||price==""||address==null||address=="")){
            $.post("../servlet/PostServlet",
                {in_gname:name, in_gprice:price, in_gkind:kind, in_glocation:address, in_gimg:jpg, in_info:detail},
                function(data,status){
                    var res = "提交失败，请联系管理员qq:"
                    if(data!=null&&data!="") {
                        if(data.indexOf("-1")!=-1){
                            res = "提交失败";
                        }else{
                            res = "提交成功";
                        }

                    }
                    alert(res);
                });
        }else{
            alert("输入不能为空或密码长度太短（大于六位）！");
        }
    });
</script>
	</body>

</html>