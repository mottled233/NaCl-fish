<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="bean.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
Users user=(Users)request.getSession().getAttribute("user");
session=request.getSession();
ArrayList<Goods> rank1=(ArrayList<Goods>)request.getSession().getAttribute("main_views_数码");
ArrayList<Goods> rank2=(ArrayList<Goods>)request.getSession().getAttribute("main_views_服装");
ArrayList<Goods> rank3=(ArrayList<Goods>)request.getSession().getAttribute("main_views_生鲜");
%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="../css/hmstyle.css" rel="stylesheet" type="text/css" />
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		
	</head>

	<body>
		<div class="hmtop">
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
							<%if(user==null){ %>
								<a href="#" target="_top" class="h">亲，请登录</a>
								<a href="#" target="_top">免费注册</a>
							<%}else{ %>
								<a href="#" target="_top" class="h">欢迎<%user.getUsername(); %></a>
								<a href="#" target="_top">我的账户</a>
							<%} %>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="./" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div></div>
				</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logo"><img src="../images/logo.png" /></div>
					<div class="logoBig">
						<li><img src="../images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form action="search.html" method="post" name="Search" id="searchform">
							<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
             <b class="line"></b>
			<div class="shopNav">
				<div class="slideall" style="height: auto;">
			        
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>

							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
                
			    <div class="bannerTwo">
                      <!--轮播 -->
						<div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
							<ul class="am-slides">
								<li class="banner2"><a><img src="../images/head.jpg" /></a></li>
								<li class="banner3"><a><img src="../images/head2.jpg" /></a></li>
							</ul>
						</div>
						<div class="clear"></div>	
			    </div>

						<!--侧边导航 -->
						<div id="nav" class="navfull" style="position: static;">
							<div class="area clearfix">
								<div class="category-content" id="guide_2">
									
									<div class="category" style="box-shadow:none ;margin-top: 2px;">
										<ul class="category-list navTwo" id="js_climit_li">
											<li>
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/cake.png"></i><a class="ml-22" title="数码">数码</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="数码">数码</span></dt>
																		<dd><a title="手机" href="#"><span>手机</span></a></dd>
																		<dd><a title="平板" href="#"><span>平板</span></a></dd>
																		<dd><a title="相机" href="#"><span>相机</span></a></dd>
																	</dl>
																	<dl class="dl-sort">
																		<dt><span title="数码">数码</span></dt>
																		<dd><a title="手机" href="#"><span>手机</span></a></dd>
																		<dd><a title="平板" href="#"><span>平板</span></a></dd>
																		<dd><a title="相机" href="#"><span>相机</span></a></dd>
																	</dl>																	</dl>

																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力卖家</span></dt>
																		<dd><a rel="nofollow" title="呵官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >呵官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="格瑞旗舰店" target="_blank" href="#" rel="nofollow"><span >格瑞旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="飞彦大厂直供" target="_blank" href="#" rel="nofollow"><span  class="red" >飞彦大厂直供</span></a></dd>
																		<dd><a rel="nofollow" title="红e·艾菲妮" target="_blank" href="#" rel="nofollow"><span >红e·艾菲妮</span></a></dd>
																		<dd><a rel="nofollow" title="本真旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >本真旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="杭派女装批发网" target="_blank" href="#" rel="nofollow"><span  class="red" >杭派女装批发网</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
											<b class="arrow"></b>	
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/cookies.png"></i><a class="ml-22" title="服装">服装</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="服装">女装</span></dt>
																		<dd><a title="裙子" href="#"><span>裙子</span></a></dd>
																		<dd><a title="卫衣" href="#"><span>卫衣</span></a></dd>
																		<dd><a title="饰品" href="#"><span>饰品</span></a></dd>
																		<dd><a title="羽绒服" href="#"><span>羽绒服</span></a></dd>
																	</dl>
																	<dl class="dl-sort">
																		<dt><span title="服装">男装</span></dt>
																		<dd><a title="T恤" href="#"><span>T恤</span></a></dd>
																		<dd><a title="大衣" href="#"><span>大衣</span></a></dd>
																		<dd><a title="牛仔裤" href="#"><span>牛仔裤</span></a></dd>
																	</dl>

																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="YYKCLOT" target="_blank" href="#" rel="nofollow"><span  class ="red" >YYKCLOT</span></a></dd>
																		<dd><a rel="nofollow" title="池氏品牌男装" target="_blank" href="#" rel="nofollow"><span  class ="red" >池氏品牌男装</span></a></dd>
																		<dd><a rel="nofollow" title="男装日志" target="_blank" href="#" rel="nofollow"><span >男装日志</span></a></dd>
																		<dd><a rel="nofollow" title="索比诺官方旗舰店" target="_blank" href="#" rel="nofollow"><span >索比诺官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="onTTno傲徒" target="_blank" href="#" rel="nofollow"><span  class ="red" >onTTno傲徒</span></a></dd>
																		<dd><a rel="nofollow" title="玛狮路男装旗舰店" target="_blank" href="#" rel="nofollow"><span >玛狮路男装旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="劳威特品牌男装" target="_blank" href="#" rel="nofollow"><span >劳威特品牌男装</span></a></dd>
																		<dd><a rel="nofollow" title="卡斯郎世家批发城" target="_blank" href="#" rel="nofollow"><span  class ="red" >卡斯郎世家批发城</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                             <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/meat.png"></i><a class="ml-22" title="乐器">乐器</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="乐器">古典乐器</span></dt>
																		<dd><a title="钢琴" href="#"><span>钢琴</span></a></dd>
																		<dd><a title="吉他" href="#"><span>吉他</span></a></dd>
																		<dd><a title="二胡" href="#"><span>二胡</span></a></dd>
																		<dd><a title="手风琴" href="#"><span>手风琴</span></a></dd>
																		<dd><a title="琵琶" href="#"><span>琵琶</span></a></dd>
																	</dl>
																	<dl class="dl-sort">
																		<dt><span title="乐器">电子乐器</span></dt>
																		<dd><a title="电吉他" href="#"><span>电吉他</span></a></dd>
																		<dd><a title="效果器" href="#"><span>效果器</span></a></dd>
																		<dd><a title="电钢琴" href="#"><span>电钢琴</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力卖家</span></dt>
																		<dd><a rel="nofollow" title="花颜巧语 " target="_blank" href="#" rel="nofollow"><span  class="red" >花颜巧语 </span></a></dd>
																		<dd><a rel="nofollow" title="糖衣小屋" target="_blank" href="#" rel="nofollow"><span >糖衣小屋</span></a></dd>
																		<dd><a rel="nofollow" title="卡拉迪克  " target="_blank" href="#" rel="nofollow"><span  class="red" >卡拉迪克  </span></a></dd>
																		<dd><a rel="nofollow" title="暖春童话 " target="_blank" href="#" rel="nofollow"><span >暖春童话 </span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                            <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/bamboo.png"></i><a class="ml-22" title="美妆">美妆</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="美妆">美妆</span></dt>
																		<dd><a title="面膜" href="#"><span>面膜</span></a></dd>
																		<dd><a title="洁面" href="#"><span>洁面</span></a></dd>
																		<dd><a title="爽肤水" href="#"><span>爽肤水</span></a></dd>
																		<dd><a title="卸妆水" href="#"><span>卸妆水</span></a></dd>
																	</dl>
																	<dl class="dl-sort">
																		<dt><span title="洗护">洗护</span></dt>
																		<dd><a title="洗发膏" href="#"><span>洗发膏</span></a></dd>
																		<dd><a title="护发素" href="#"><span>护发素</span></a></dd>
																		<dd><a title="洗面奶" href="#"><span>洗面奶</span></a></dd>
																		<dd><a title="精油" href="#"><span>精油</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="歌芙品牌旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >歌芙品牌旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="爱丝蓝内衣厂" target="_blank" href="#" rel="nofollow"><span >爱丝蓝内衣厂</span></a></dd>
																		<dd><a rel="nofollow" title="香港优蓓尔防辐射" target="_blank" href="#" rel="nofollow"><span >香港优蓓尔防辐射</span></a></dd>
																		<dd><a rel="nofollow" title="蓉莉娜内衣批发" target="_blank" href="#" rel="nofollow"><span >蓉莉娜内衣批发</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                             <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/nut.png"></i><a class="ml-22" title="眼镜">眼镜</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="眼镜">眼镜</span></dt>
																		<dd><a title="太阳镜" href="#"><span>太阳镜</span></a></dd>
																		<dd><a title="3D眼镜" href="#"><span>3d眼镜</span></a></dd>
																		<dd><a title="司机镜" href="#"><span>司机镜</span></a></dd>
																		<dd><a title="无框" href="#"><span>无框</span></a></dd>
																		<dd><a title="超耐磨" href="#"><span>超耐磨</span></a></dd>
																		<dd><a title="偏光" href="#"><span>偏光</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="呵呵嘿官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >呵呵嘿官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="格瑞旗舰店" target="_blank" href="#" rel="nofollow"><span >格瑞旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="飞彦大厂直供" target="_blank" href="#" rel="nofollow"><span  class="red" >飞彦大厂直供</span></a></dd>
																		<dd><a rel="nofollow" title="红e·艾菲妮" target="_blank" href="#" rel="nofollow"><span >红e·艾菲妮</span></a></dd>
																		<dd><a rel="nofollow" title="本真旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >本真旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="杭派女装批发网" target="_blank" href="#" rel="nofollow"><span  class="red" >杭派女装批发网</span></a></dd>
																		<dd><a rel="nofollow" title="华伊阁旗舰店" target="_blank" href="#" rel="nofollow"><span >华伊阁旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="独家折扣旗舰店" target="_blank" href="#" rel="nofollow"><span >独家折扣旗舰店</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
												<b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/candy.png"></i><a class="ml-22" title="手表">手表</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="手表">手表</span></dt>
																		<dd><a title="电子表" href="#"><span>电子表</span></a></dd>
																		<dd><a title="腕表" href="#"><span>腕表</span></a></dd>
																		<dd><a title="怀表" href="#"><span>怀表</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="YYKCLOT" target="_blank" href="#" rel="nofollow"><span  class ="red" >YYKCLOT</span></a></dd>
																		<dd><a rel="nofollow" title="池氏品牌男装" target="_blank" href="#" rel="nofollow"><span  class ="red" >池氏品牌男装</span></a></dd>
																		<dd><a rel="nofollow" title="男装日志" target="_blank" href="#" rel="nofollow"><span >男装日志</span></a></dd>
																		<dd><a rel="nofollow" title="索比诺官方旗舰店" target="_blank" href="#" rel="nofollow"><span >索比诺官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="onTTno傲徒" target="_blank" href="#" rel="nofollow"><span  class ="red" >onTTno傲徒</span></a></dd>
																		<dd><a rel="nofollow" title="卡斯郎世家批发城" target="_blank" href="#" rel="nofollow"><span  class ="red" >卡斯郎世家批发城</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                            <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/chocolate.png"></i><a class="ml-22" title="动漫">动漫</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="动漫">动漫</span></dt>
																		<dd><a title="同人作品" href="#"><span>同人作品</span></a></dd>
																		<dd><a title="手办" href="#"><span>手办</span></a></dd>
																		<dd><a title="宅物" href="#"><span>宅物</span></a></dd>
																		<dd><a title="cos服装" href="#"><span>cos服装</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="花颜巧语 " target="_blank" href="#" rel="nofollow"><span  class="red" >花颜巧语 </span></a></dd>
																		<dd><a rel="nofollow" title="糖衣小屋" target="_blank" href="#" rel="nofollow"><span >糖衣小屋</span></a></dd>
																		<dd><a rel="nofollow" title="卡拉迪克  " target="_blank" href="#" rel="nofollow"><span  class="red" >卡拉迪克  </span></a></dd>
																		<dd><a rel="nofollow" title="暖春童话 " target="_blank" href="#" rel="nofollow"><span >暖春童话 </span></a></dd>
																		<dd><a rel="nofollow" title="华盛童装批发行 " target="_blank" href="#" rel="nofollow"><span >华盛童装批发行 </span></a></dd>
																		<dd><a rel="nofollow" title="奈仕华童装旗舰店" target="_blank" href="#" rel="nofollow"><span >奈仕华童装旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="斑蒂尼BONDYNI" target="_blank" href="#" rel="nofollow"><span  class="red" >斑蒂尼BONDYNI</span></a></dd>
																		<dd><a rel="nofollow" title="童衣阁" target="_blank" href="#" rel="nofollow"><span  class="red" >童衣阁</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
												<b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/fish.png"></i><a class="ml-22" title="房产">房产</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="房产">房产</span></dt>
																		<dd><a title="单身公寓" href="#"><span>单身公寓</span></a></dd>
																		<dd><a title="套间" href="#"><span>套间</span></a></dd>
																		<dd><a title="别墅" href="#"><span>别墅</span></a></dd>
																		<dd><a title="小三房" href="#"><span>小三房</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="万达地产" target="_blank" href="#" rel="nofollow"><span  class="red" >歌芙品牌旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="艾克地产" target="_blank" href="#" rel="nofollow"><span >爱丝蓝内衣厂</span></a></dd>
																		<dd><a rel="nofollow" title="恒大地产" target="_blank" href="#" rel="nofollow"><span >炫点服饰</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                             <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/tea.png"></i><a class="ml-22" title="游戏">游戏</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="游戏">游戏</span></dt>
																		<dd><a title="DNF" href="#"><span>DNF</span></a></dd>
																		<dd><a title="英雄联盟" href="#"><span>英雄联盟</span></a></dd>
																		<dd><a title="冒险岛2" href="#"><span>冒险岛2</span></a></dd>
																		<dd><a title="崩崩崩" href="#"><span>崩崩崩</span></a></dd>
																	</dl>

																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a title="今生只围你" target="_blank" href="#" rel="nofollow"><span >今生只围你</span></a></dd>
																		<dd><a title="忆佳人" target="_blank" href="#" rel="nofollow"><span  class="red" >忆佳人</span></a></dd>
																		<dd><a title="斐洱普斯" target="_blank" href="#" rel="nofollow"><span  class="red" >斐洱普斯</span></a></dd>
																		<dd><a title="聚百坊" target="_blank" href="#" rel="nofollow"><span  class="red" >聚百坊</span></a></dd>
																		<dd><a title="朵朵棉织直营店" target="_blank" href="#" rel="nofollow"><span >朵朵棉织直营店</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
												<b class="arrow"></b>
											</li>
											<li>
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/package.png"></i><a class="ml-22" title="家具">家具</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="家具">家具</span></dt>
																		<dd><a title="沙发" href="#"><span>沙发</span></a></dd>
																		<dd><a title="床" href="#"><span>床</span></a></dd>
																		<dd><a title="桌子" href="#"><span>桌子</span></a></dd>
																		<dd><a title="电视柜" href="#"><span>电视柜</span></a></dd>
																		<dd><a title="衣柜" href="#"><span>衣柜</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a title="琳琅木业" target="_blank" href="#" rel="nofollow"><span >琳琅鞋业</span></a></dd>
																		<dd><a title="宏利家具" target="_blank" href="#" rel="nofollow"><span >宏利鞋业</span></a></dd>
																		<dd><a title="比爱靓点柜业" target="_blank" href="#" rel="nofollow"><span >比爱靓点鞋业</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>

											</li>
											
                                 <!--比较多的导航	-->										
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/cookies.png"></i><a class="ml-22" title="汽车">汽车</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="汽车">汽车</span></dt>
																		<dd><a title="SUV" href="#"><span>SUV</span></a></dd>
																		<dd><a title="皮卡" href="#"><span>皮卡</span></a></dd>
																		<dd><a title="轿车" href="#"><span>轿车</span></a></dd>
																		<dd><a title="跑车" href="#"><span>跑车</span></a></dd>
																		<dd><a title="货车" href="#"><span>货车</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="YYKCLOT" target="_blank" href="#" rel="nofollow"><span  class ="red" >YYKCLOT</span></a></dd>
																		<dd><a rel="nofollow" title="池氏品牌男装" target="_blank" href="#" rel="nofollow"><span  class ="red" >池氏品牌男装</span></a></dd>
																		<dd><a rel="nofollow" title="男装日志" target="_blank" href="#" rel="nofollow"><span >男装日志</span></a></dd>
																		<dd><a rel="nofollow" title="索比诺官方旗舰店" target="_blank" href="#" rel="nofollow"><span >索比诺官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="onTTno傲徒" target="_blank" href="#" rel="nofollow"><span  class ="red" >onTTno傲徒</span></a></dd>
																		<dd><a rel="nofollow" title="玛狮路男装旗舰店" target="_blank" href="#" rel="nofollow"><span >玛狮路男装旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="劳威特品牌男装" target="_blank" href="#" rel="nofollow"><span >劳威特品牌男装</span></a></dd>
																		<dd><a rel="nofollow" title="卡斯郎世家批发城" target="_blank" href="#" rel="nofollow"><span  class ="red" >卡斯郎世家批发城</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                             <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/meat.png"></i><a class="ml-22" title="汽车用品">汽车用品</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="汽车用品">汽车用品</span></dt>
																		<dd><a title="玻璃洗涤剂" href="#"><span>玻璃洗涤剂</span></a></dd>
																		<dd><a title="机油" href="#"><span>机油</span></a></dd>
																		<dd><a title="坐垫" href="#"><span>坐垫</span></a></dd>
																		</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="花颜巧语 " target="_blank" href="#" rel="nofollow"><span  class="red" >花颜巧语 </span></a></dd>
																		<dd><a rel="nofollow" title="糖衣小屋" target="_blank" href="#" rel="nofollow"><span >糖衣小屋</span></a></dd>
																		<dd><a rel="nofollow" title="卡拉迪克  " target="_blank" href="#" rel="nofollow"><span  class="red" >卡拉迪克  </span></a></dd>
																		<dd><a rel="nofollow" title="暖春童话 " target="_blank" href="#" rel="nofollow"><span >暖春童话 </span></a></dd>
																		<dd><a rel="nofollow" title="华盛童装批发行 " target="_blank" href="#" rel="nofollow"><span >华盛童装批发行 </span></a></dd>
																		<dd><a rel="nofollow" title="奈仕华童装旗舰店" target="_blank" href="#" rel="nofollow"><span >奈仕华童装旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="斑蒂尼BONDYNI" target="_blank" href="#" rel="nofollow"><span  class="red" >斑蒂尼BONDYNI</span></a></dd>
																		<dd><a rel="nofollow" title="猫儿朵朵 " target="_blank" href="#" rel="nofollow"><span >猫儿朵朵 </span></a></dd>
																		<dd><a rel="nofollow" title="童衣阁" target="_blank" href="#" rel="nofollow"><span  class="red" >童衣阁</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                            <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/bamboo.png"></i><a class="ml-22" title="玩具">玩具</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="玩具">玩具</span></dt>
																		<dd><a title="遥控车" href="#"><span>遥控车</span></a></dd>
																		<dd><a title="模型" href="#"><span>模型</span></a></dd>
																		<dd><a title="娃娃" href="#"><span>娃娃</span></a></dd>
																		<dd><a title="玩具枪" href="#"><span>玩具枪</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="歌芙品牌旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >歌芙品牌旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="爱丝蓝内衣厂" target="_blank" href="#" rel="nofollow"><span >爱丝蓝内衣厂</span></a></dd>
																		<dd><a rel="nofollow" title="香港优蓓尔防辐射" target="_blank" href="#" rel="nofollow"><span >香港优蓓尔防辐射</span></a></dd>
																		<dd><a rel="nofollow" title="蓉莉娜内衣批发" target="_blank" href="#" rel="nofollow"><span >蓉莉娜内衣批发</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                             <b class="arrow"></b>
											</li>
											<li>
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/nut.png"></i><a class="ml-22" title="摄影器材">摄影器材</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="摄影器材">摄影器材</span></dt>
																		<dd><a title="镜头" href="#"><span>镜头</span></a></dd>
																		<dd><a title="单反" href="#"><span>单反</span></a></dd>
																		<dd><a title="云台" href="#"><span>云台</span></a></dd>
																		<dd><a title="三脚架" href="#"><span>三脚架</span></a></dd>
																		<dd><a title="存储卡" href="#"><span>存储卡</span></a></dd>
																		<dd><a title="胶卷" href="#"><span>胶卷</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="呵呵嘿官方旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >呵呵嘿官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="格瑞旗舰店" target="_blank" href="#" rel="nofollow"><span >格瑞旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="飞彦大厂直供" target="_blank" href="#" rel="nofollow"><span  class="red" >飞彦大厂直供</span></a></dd>
																		<dd><a rel="nofollow" title="红e·艾菲妮" target="_blank" href="#" rel="nofollow"><span >红e·艾菲妮</span></a></dd>
																		<dd><a rel="nofollow" title="本真旗舰店" target="_blank" href="#" rel="nofollow"><span  class="red" >本真旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="杭派女装批发网" target="_blank" href="#" rel="nofollow"><span  class="red" >杭派女装批发网</span></a></dd>
																		<dd><a rel="nofollow" title="华伊阁旗舰店" target="_blank" href="#" rel="nofollow"><span >华伊阁旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="独家折扣旗舰店" target="_blank" href="#" rel="nofollow"><span >独家折扣旗舰店</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
												<b class="arrow"></b>
											</li>											
															<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/candy.png"></i><a class="ml-22" title="技能">技能</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="技能">技能</span></dt>
																		<dd><a title="乐器" href="#"><span>乐器</span></a></dd>
																		<dd><a title="外语" href="#"><span>外语</span></a></dd>
																		<dd><a title="会计" href="#"><span>会计</span></a></dd>
																		<dd><a title="设计" href="#"><span>设计</span></a></dd>
																		<dd><a title="编程" href="#"><span>编程</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="YYKCLOT" target="_blank" href="#" rel="nofollow"><span  class ="red" >YYKCLOT</span></a></dd>
																		<dd><a rel="nofollow" title="池氏品牌男装" target="_blank" href="#" rel="nofollow"><span  class ="red" >池氏品牌男装</span></a></dd>
																		<dd><a rel="nofollow" title="男装日志" target="_blank" href="#" rel="nofollow"><span >男装日志</span></a></dd>
																		<dd><a rel="nofollow" title="索比诺官方旗舰店" target="_blank" href="#" rel="nofollow"><span >索比诺官方旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="onTTno傲徒" target="_blank" href="#" rel="nofollow"><span  class ="red" >onTTno傲徒</span></a></dd>
																		<dd><a rel="nofollow" title="卡斯郎世家批发城" target="_blank" href="#" rel="nofollow"><span  class ="red" >卡斯郎世家批发城</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
                                            <b class="arrow"></b>
											</li>
											<li >
												<div class="category-info">
													<h3 class="category-name b-category-name"><i><img src="../images/chocolate.png"></i><a class="ml-22" title="课程">课程</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		<dt><span title="课程">课程</span></dt>
																		<dd><a title="英语" href="#"><span>英语</span></a></dd>
																		<dd><a title="小语种" href="#"><span>小语种</span></a></dd>
																		<dd><a title="设计" href="#"><span>设计</span></a></dd>
																		<dd><a title="绘画" href="#"><span>绘画</span></a></dd>
																		<dd><a title="音乐" href="#"><span>音乐</span></a></dd>
																		<dd><a title="考研" href="#"><span>考研</span></a></dd>
																		<dd><a title="高中科目" href="#"><span>高中科目</span></a></dd>
																	</dl>
																</div>
																<div class="brand-side">
																	<dl class="dl-sort"><dt><span>实力商家</span></dt>
																		<dd><a rel="nofollow" title="花颜巧语 " target="_blank" href="#" rel="nofollow"><span  class="red" >花颜巧语 </span></a></dd>
																		<dd><a rel="nofollow" title="糖衣小屋" target="_blank" href="#" rel="nofollow"><span >糖衣小屋</span></a></dd>
																		<dd><a rel="nofollow" title="卡拉迪克  " target="_blank" href="#" rel="nofollow"><span  class="red" >卡拉迪克  </span></a></dd>
																		<dd><a rel="nofollow" title="暖春童话 " target="_blank" href="#" rel="nofollow"><span >暖春童话 </span></a></dd>
																		<dd><a rel="nofollow" title="华盛童装批发行 " target="_blank" href="#" rel="nofollow"><span >华盛童装批发行 </span></a></dd>
																		<dd><a rel="nofollow" title="奈仕华童装旗舰店" target="_blank" href="#" rel="nofollow"><span >奈仕华童装旗舰店</span></a></dd>
																		<dd><a rel="nofollow" title="斑蒂尼BONDYNI" target="_blank" href="#" rel="nofollow"><span  class="red" >斑蒂尼BONDYNI</span></a></dd>
																		<dd><a rel="nofollow" title="童衣阁" target="_blank" href="#" rel="nofollow"><span  class="red" >童衣阁</span></a></dd>
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
												<b class="arrow"></b>
											</li>
										
										</ul>
									</div>
								</div>

							</div>
						</div>
						<!--导航 -->
						<script type="text/javascript">
							(function() {
								$('.am-slider').flexslider();
							});
							$(document).ready(function() {
								$("li").hover(function() {
									$(".category-content .category-list li.first .menu-in").css("display", "none");
									$(".category-content .category-list li.first").removeClass("hover");
									$(this).addClass("hover");
									$(this).children("div.menu-in").css("display", "block")
								}, function() {
									$(this).removeClass("hover")
									$(this).children("div.menu-in").css("display", "none")
								});
							})
						</script>


					<!--小导航 -->
					<div class="am-g am-g-fixed smallnav">
						<div class="am-u-sm-3">
							<a href="sort.html"><img src="../images/navsmall.jpg" />
								<div class="title">商品分类</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="../images/huismall.jpg" />
								<div class="title">大聚惠</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="../images/mansmall.jpg" />
								<div class="title">个人中心</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="../images/moneysmall.jpg" />
								<div class="title">投资理财</div>
							</a>
						</div>
					</div>

					
				<!--各类活动-->
				<div class="row">
					<li><a><img src="../images/row1.jpg"/></a></li>
					<li><a><img src="../images/row2.jpg"/></a></li>
					<li><a><img src="../images/row3.jpg"/></a></li>
					<li><a><img src="../images/row4.jpg"/></a></li>
				</div>
				<div class="clear"></div>	
					<!--走马灯 -->

					<div class="marqueenTwo">
						<span class="marqueen-title"><i class="am-icon-volume-up am-icon-fw"></i>商城头条<em class="am-icon-angle-double-right"></em></span>
						<div class="demo">

							<ul>
								<li class="title-first"><a target="_blank" href="#">
									<img src="../images/TJ2.jpg"></img>
									<span>[特惠]</span>洋河年末大促，低至两件五折							
								</a></li>
								<li class="title-first"><a target="_blank" href="#">
									<span>[公告]</span>商城与广州市签署战略合作协议
								     <img src="../images/TJ.jpg"></img>
								     <p>XXXXXXXXXXXXXXXXXX</p>
							    </a></li>																    							    
								<li><a target="_blank" href="#"><span>[特惠]</span>女生节商城爆品1分秒	</a></li>
								<li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a></li>
								<li><a target="_blank" href="#"><span>[特惠]</span>家电狂欢千亿礼券 买1送1！</a></li>
								<li><a target="_blank" href="#"><span>[特惠]</span>洋河年末大促，低至两件五折</a></li>
								<li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a></li>
						
							</ul>
                       
						</div>
					</div>
					<div class="clear"></div>
				
				</div>
				
				
							
				<script type="text/javascript">
					if ($(window).width() < 640) {
						function autoScroll(obj) {
							$(obj).find("ul").animate({
								marginTop: "-39px"
							}, 500, function() {
								$(this).css({
									marginTop: "0px"
								}).find("li:first").appendTo(this);
							})
						}
						$(function() {
							setInterval('autoScroll(".demo")', 3000);
						})
					}
				</script>
			</div>
			<div class="shopMainbg">
				<div class="shopMain" id="shopmain">

					<!--热门活动 -->

					<div class="am-container">
					
                     <div class="sale-mt">
		                   <i></i>
		                   <em class="sale-title">限时秒杀</em>
		                   <div class="s-time" id="countdown">
			                    <span class="hh">01</span>
			                    <span class="mm">20</span>
			                    <span class="ss">59</span>
		                   </div>
	                  </div>

					
					  <div class="am-g am-g-fixed sale">
						<div class="am-u-sm-3 sale-item">
							<div class="s-img">
								<a href="# "><img src="../images/sale3.jpg" /></a>
							</div>
                           <div class="s-info">
                           	   <a href="#"><p class="s-title">香水</p></a>
                           	   <div class="s-price">￥<b>999.00</b>
                           	   	  <a class="s-buy" href="#">秒杀</a>
                           	   </div>                          	  
                           </div>								
						</div>
						
						<div class="am-u-sm-3 sale-item">
							<div class="s-img">
								<a href="# "><img src="../images/sale2.jpg" /></a>
							</div>
                           <div class="s-info">
                           	   <a href="#"><p class="s-title">抽纸</p></a>
                           	   <div class="s-price">￥<b>9.99</b>
                           	   	  <a class="s-buy" href="#">秒杀</a>
                           	   </div>                          	  
                           </div>								
						</div>					
						
						<div class="am-u-sm-3 sale-item">
							<div class="s-img">
								<a href="# "><img src="../images/sale1.jpg" /></a>
							</div>
                           <div class="s-info">
                           	   <a href="#"><p class="s-title">零食</p></a>
                           	   <div class="s-price">￥<b>9.00</b>
                           	   	  <a class="s-buy" href="#">秒杀</a>
                           	   </div>                          	  
                           </div>								
						</div>
						
						<div class="am-u-sm-3 sale-item">
							<div class="s-img">
								<a href="# "><img src="../images/sale2.jpg " /></a>
							</div>
                           <div class="s-info">
                           	   <a href="#"><p class="s-title">单反</p></a>
                           	   <div class="s-price">￥<b>999.00</b>
                           	   	  <a class="s-buy" href="#">秒杀</a>
                           	   </div>                          	  
                           </div>								
						</div>
						
					  </div>
                   </div>
					<div class="clear "></div>
            <div class="f1">
					<!--甜点-->
					
					<div class="am-container " >
						<div class="shopTitle ">
							<h4 class="floor-title">数码</h4>
							<div class="floor-subtitle"><em class="am-icon-caret-left"></em><h3>每一个产品都有一个故事</h3></div>
							<div class="today-brands " style="right:0px ;top:13px;">
								<a href="# ">手机</a>|
								<a href="# ">平板</a>|
								<a href="# ">电脑配件 </a>|
								<a href="# ">显示器</a>|
								<a href="# ">耳机</a>|
								<a href="# ">显卡</a>
							</div>

						</div>
					</div>
					
					<div class="am-g am-g-fixed floodSix ">				
						<div class="am-u-sm-5 am-u-md-3 text-one list">
							<div class="word">
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>	
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>	
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>								
							</div>							
							<a href="# ">
								<img src="../images/5.jpg" />
								<div class="outer-con ">
									<div class="title ">
										新活动开始啦
									</div>
									<div class="sub-title ">
										现在下单抽随机折扣
									</div>
								</div>
							</a>
							<div class="triangle-topright"></div>	
						</div>
						
						<div class="am-u-sm-7 am-u-md-5 am-u-lg-2 text-two big">
							
								<div class="outer-con ">
									<div class="title <%if(rank1.size()!=0){%> value=<%=rank1.get(0).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank1.size()!=0){%> value="<%=rank1.get(0).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank1.size()!=0){%> value="<%=rank1.get(0).getgImg()%>"<%} %>>" /></a>
						</div>

						<li>
						<div class="am-u-md-2 am-u-lg-2 text-three">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank1.size()>1){%> value=<%=rank1.get(1).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank1.size()>1){%> value="<%=rank1.get(1).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank1.size()>1){%> value="<%=rank1.get(1).getgImg()%>"<%} %>>" /></a>
						</div>
						</li>
						<li>
						<div class="am-u-md-2 am-u-lg-2 text-three sug">
								<div class="outer-con ">
									<div class="title <%if(rank1.size()>2){%> value=<%=rank1.get(2).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank1.size()>2){%> value="<%=rank1.get(2).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank1.size()>2){%> value="<%=rank1.get(2).getgImg()%>"<%} %>>" /></a>
						</div>
						</li>
						<li>
						<div class="am-u-sm-4 am-u-md-5 am-u-lg-4 text-five">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank1.size()>3){%> value=<%=rank1.get(3).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank1.size()>3){%> value="<%=rank1.get(3).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank1.size()>3){%> value="<%=rank1.get(3).getgImg()%>"<%} %>>" /></a>
						</div>	
						</li>
						<li>
						<div class="am-u-sm-4 am-u-md-2 am-u-lg-2 text-six">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank1.size()>4){%> value=<%=rank1.get(4).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank1.size()>4){%> value="<%=rank1.get(4).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank1.size()>4){%> value="<%=rank1.get(4).getgImg()%>"<%} %>>" /></a>
						</div>	
						</li>
						<li>
						<div class="am-u-sm-4 am-u-md-2 am-u-lg-4 text-six">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank1.size()!=0){%> value=<%=rank1.get(5).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank1.size()!=0){%> value="<%=rank1.get(5).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank1.size()!=0){%> value="<%=rank1.get(6).getgImg()%>"<%} %>>" /></a>
						</div>	
						</li>						
					</div>

					<div class="clear "></div>
            </div>
            <div class="f2">

					<!--坚果-->
					<div class="am-container ">
						<div class="shopTitle ">
							<h4 class="floor-title">摄影</h4>
							<div class="floor-subtitle"><em class="am-icon-caret-left"></em><h3>方寸之间，记录世界</h3></div>
							<div class="today-brands " style="right:0px ;top:13px">
								<a href="# ">镜头</a>|
								<a href="# ">单反</a>|
								<a href="# ">云台</a>|
								<a href="# ">三脚架</a>|
								<a href="# ">胶卷</a>|
								<a href="# ">老相片</a>
							</div>
						</div>
					</div>
					
					<div class="am-g am-g-fixed floodSix ">				
						<div class="am-u-sm-5 am-u-md-3 text-one list">
							<div class="word">
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>	
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>	
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>								
							</div>							
							<a href="# ">
								<img src="../images/5.jpg" />
								<div class="outer-con ">
									<div class="title ">
										新活动开始啦
									</div>
									<div class="sub-title ">
										现在下单抽随机折扣
									</div>
								</div>
							</a>
							<div class="triangle-topright"></div>	
						</div>
						
						<div class="am-u-sm-7 am-u-md-5 am-u-lg-2 text-two big">
							
								<div class="outer-con ">
									<div class="title <%if(rank2.size()>0){%> value=<%=rank2.get(0).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank2.size()>0){%> value="<%=rank2.get(0).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank2.size()>0){%> value="<%=rank2.get(0).getgImg()%>"<%} %>>" /></a>
						</div>

						<li>
						<div class="am-u-md-2 am-u-lg-2 text-three">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank2.size()>=1){%> value=<%=rank2.get(1).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank2.size()>=1){%> value="<%=rank2.get(1).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank2.size()>=1){%> value="<%=rank2.get(1).getgImg()%>"<%} %>>" /></a>
						</div>
						</li>
						<li>
						<div class="am-u-md-2 am-u-lg-2 text-three sug">
								<div class="outer-con ">
									<div class="title <%if(rank2.size()>=2){%> value=<%=rank2.get(2).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank2.size()>=2){%> value="<%=rank2.get(2).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank2.size()>=2){%> value="<%=rank2.get(2).getgImg()%>"<%} %>>" /></a>
						</div>
						</li>
						<li>
						<div class="am-u-sm-4 am-u-md-5 am-u-lg-4 text-five">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank2.size()>=3){%> value=<%=rank2.get(3).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank2.size()>=3){%> value="<%=rank2.get(3).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank2.size()>=3){%> value="<%=rank2.get(3).getgImg()%>"<%} %>>" /></a>
						</div>	
						</li>
						<li>
						<div class="am-u-sm-4 am-u-md-2 am-u-lg-2 text-six">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank2.size()>=4){%> value=<%=rank2.get(4).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank2.size()>=4){%> value="<%=rank2.get(4).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank2.size()>=4){%> value="<%=rank2.get(4).getgImg()%>"<%} %>>" /></a>
						</div>	
						</li>
						<li>
						<div class="am-u-sm-4 am-u-md-2 am-u-lg-4 text-six">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank2.size()>=5){%> value=<%=rank2.get(5).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank2.size()>=5){%> value="<%=rank2.get(5).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank2.size()>=5){%> value="<%=rank2.get(6).getgImg()%>"<%} %>>" /></a>
						</div>	
						</li>						
					</div>
                 <div class="clear "></div>                 
            </div>               						
			<div class="f3">
					
					<div class="am-container " >
						<div class="shopTitle ">
							<h4 class="floor-title">数码</h4>
							<div class="floor-subtitle"><em class="am-icon-caret-left"></em><h3>每一个产品都有一个故事</h3></div>
							<div class="today-brands " style="right:0px ;top:13px;">
								<a href="# ">手机</a>|
								<a href="# ">平板</a>|
								<a href="# ">电脑配件 </a>|
								<a href="# ">显示器</a>|
								<a href="# ">耳机</a>|
								<a href="# ">显卡</a>
							</div>

						</div>
					</div>
					
					<div class="am-g am-g-fixed floodSix ">				
						<div class="am-u-sm-5 am-u-md-3 text-one list">
							<div class="word">
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>	
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>	
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>
								<a class="outer" href="#"><span class="inner"><b class="text">Test</b></span></a>								
							</div>							
							<a href="# ">
								<img src="../images/5.jpg" />
								<div class="outer-con ">
									<div class="title ">
										新活动开始啦
									</div>
									<div class="sub-title ">
										现在下单抽随机折扣
									</div>
								</div>
							</a>
							<div class="triangle-topright"></div>	
						</div>
						
						<div class="am-u-sm-7 am-u-md-5 am-u-lg-2 text-two big">
							
								<div class="outer-con ">
									<div class="title <%if(rank3.size()!=0){%> value=<%=rank3.get(0).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank3.size()!=0){%> value="<%=rank3.get(0).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank3.size()!=0){%> value="<%=rank3.get(0).getgImg()%>"<%} %>>" /></a>
						</div>
						<%for(int i=1;i<rank3.size()||i<6;i++){ %>
						<li>
						<div class="am-u-md-2 am-u-lg-2 text-three">
							<div class="boxLi"></div>
								<div class="outer-con ">
									<div class="title <%if(rank3.size()>i){%> value=<%=rank3.get(i).getgName()%>"<%}%>/>	
									<div class="sub-title "<%if(rank3.size()>i){%> value="<%=rank3.get(i).getgPrice()%>"<%}%>/>
								</div>
								<a href="# "><img src="<%if(rank3.size()>i){%> value="<%=rank3.get(i).getgImg()%>"<%} %>>" /></a>
						</div>
						</li>
						<%} %>
						
												
					</div>

					<div class="clear "></div>
            </div>


            
            
            
					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">恒望科技</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# ">关于恒望</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>

		<!--引导 -->
		<div class="navCir">
			<li class="active"><a href="home2.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>
		<!--菜单 -->
		<div class=tip>
			<div id="sidebar">
				<div id="wrap">
					<div id="prof" class="item ">
						<a href="# ">
							<span class="setting "></span>
						</a>
						<div class="ibar_login_box status_login ">
							<div class="avatar_box ">
								<p class="avatar_imgbox "><img src="../images/no-img_mid_.jpg " /></p>
								<ul class="user_info ">
									<li>用户名：<%=user!=null?user.getUsername():"未登录" %>></li>
									<li>级&nbsp;别：普通会员</li>
								</ul>
							</div>
							<div class="login_btnbox ">
								<a href="# " class="login_order ">我的订单</a>
								<a href="# " class="login_favorite ">我的收藏</a>
							</div>
							<i class="icon_arrow_white "></i>
						</div>

					</div>
					<div id="shopCart " class="item ">
						<a href="# ">
							<span class="message "></span>
						</a>
						<p>
							购物车
						</p>
						<p class="cart_num ">0</p>
					</div>
					<div id="asset " class="item ">
						<a href="# ">
							<span class="view "></span>
						</a>
						<div class="mp_tooltip ">
							我的资产
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div id="foot " class="item ">
						<a href="# ">
							<span class="zuji "></span>
						</a>
						<div class="mp_tooltip ">
							我的足迹
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div id="brand " class="item ">
						<a href="#">
							<span class="wdsc "><img src="../images/wdsc.png " /></span>
						</a>
						<div class="mp_tooltip ">
							我的收藏
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div id="broadcast " class="item ">
						<a href="# ">
							<span class="chongzhi "><img src="../images/chongzhi.png " /></span>
						</a>
						<div class="mp_tooltip ">
							我要充值
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div class="quick_toggle ">
						<li class="qtitem ">
							<a href="# "><span class="kfzx "></span></a>
							<div class="mp_tooltip ">客服中心<i class="icon_arrow_right_black "></i></div>
						</li>
						<!--二维码 -->
						<li class="qtitem ">
							<a href="#none "><span class="mpbtn_qrcode "></span></a>
							<div class="mp_qrcode " style="display:none; "><img src="../images/weixin_code_145.png " /><i class="icon_arrow_white "></i></div>
						</li>
						<li class="qtitem ">
							<a href="#top " class="return_top "><span class="top "></span></a>
						</li>
					</div>

					<!--回到顶部 -->
					<div id="quick_links_pop " class="quick_links_pop hide "></div>

				</div>

			</div>
			<div id="prof-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					我
				</div>
			</div>
			<div id="shopCart-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					购物车
				</div>
			</div>
			<div id="asset-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					资产
				</div>

				<div class="ia-head-list ">
					<a href="# " target="_blank " class="pl ">
						<div class="num ">0</div>
						<div class="text ">优惠券</div>
					</a>
					<a href="# " target="_blank " class="pl ">
						<div class="num ">0</div>
						<div class="text ">红包</div>
					</a>
					<a href="# " target="_blank " class="pl money ">
						<div class="num ">￥0</div>
						<div class="text ">余额</div>
					</a>
				</div>

			</div>
			<div id="foot-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					足迹
				</div>
			</div>
			<div id="brand-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					收藏
				</div>
			</div>
			<div id="broadcast-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					充值
				</div>
			</div>
		</div>
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="../basic/js/quick_links.js "></script>
	</body>

</html>