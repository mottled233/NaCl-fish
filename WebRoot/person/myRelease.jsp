<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="bean.Goods"%>
<%@page import="bean.GoodInfo"%>
<% 
HttpSession session1 = request.getSession();
List<Goods> resultGoods = (List<Goods>)session1.getAttribute("have_list");
List<GoodInfo> goodinfo = (List<GoodInfo>)session1.getAttribute("have_list_info");
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>订单管理</title>

<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="../css/personal.css" rel="stylesheet" type="text/css">
<link href="../css/orstyle.css" rel="stylesheet" type="text/css">

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
								<a href="#" target="_top" class="h">亲，请登录</a> <a href="#"
									target="_top">免费注册</a>
							</div>
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">商城首页</a>
							</div>
						</div>
						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng">
								<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
							</div>
						</div>
						<div class="topMessage mini-cart">
							<div class="menu-hd">
								<a id="mc-menu-hd" href="#" target="_top"><i
									class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
									id="J_MiniCartNum" class="h">0</strong> </a>
							</div>
						</div>
						<div class="topMessage favorite">
							<div class="menu-hd">
								<a href="#" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>收藏夹</span> </a>
							</div>
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
							<input id="searchInput" name="index_none_header_sysc" type="text"
								placeholder="搜索" autocomplete="off"> <input
								id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
								type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>

		</article>
	</header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
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

				<div class="user-order">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">我发布的</strong> / <small>Goods</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a href="#tab1">所有订单</a></li>
						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">发布地点</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">物品分类</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">点赞数</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">收藏数</td>
									</div>
								</div>
<% for(int i = 0; i<resultGoods.size();i++){ %>
								<div class="order-main">
									<div class="order-list">

										<!--交易成功-->
										<div class="order-status5">
											<div class="order-title">
												<div class="dd-num">
													商品编号：<a href="javascript:;"><%=resultGoods.get(i).getgID() %></a>
												</div>
												
											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=resultGoods.get(i).getgImg() %>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=resultGoods.get(i).getgName() %></p>
																		<p class="info-little">
																			 <%=goodinfo.get(i).getgInfo() %>
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=resultGoods.get(i).getgPrice() %></div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span></span>1
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
															<%=resultGoods.get(i).getgLocation() %>
															</div>
														</li>
													</ul>

												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															<%=resultGoods.get(i).getgKind() %>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<%=goodinfo.get(i).getgNice() %>
															</div>
														</li>
														<li class="td td-change">
															<div class="item-status">
																<%=goodinfo.get(i).getgCollect() %>
															</div>
														</li>
													</div>
												</div>
											</div>
										</div>

									</div>

								</div>
<%} %>
							</div>
						</div>

					</div>

				</div>
			</div>

		</div>
	</div>
	<!--底部-->
	<div class="footer">
		<div class="footer-hd">
			<p>
				<a href="#">NaclFish</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
					href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
			</p>
		</div>
		<div class="footer-bd">
			<p></p>
		</div>

	</div>

	<aside class="menu">
		<ul>
			<li class="person active"><a href="index.html"><i
					class="am-icon-user"></i>个人中心</a></li>
			<li class="person">
				<p>
					<i class="am-icon-newspaper-o"></i>个人资料
				</p>
				<ul>
					<li><a href="information.html">个人信息</a></li>
					<li><a href="safety.html">安全设置</a></li>
					<li><a href="address.html">地址管理</a></li>
					<li><a href="cardlist.html">快捷支付</a></li>
				</ul>
			</li>

		</ul>

	</aside>


<script>

</script>


</body>

</html>