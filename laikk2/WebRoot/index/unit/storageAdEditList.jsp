<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../global/global.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		${meta_view}
		<title>${session_title}</title>
		<meta name="Keywords" content="${meta_keywords}" />
		<meta name="Description" content="${meta_description}" />
	</head>
	<body>
		<div data-role="page" id="adCustomEditListPage" class="com_pany page" data-dom-cache="false">
		<script type="text/javascript">
		$(document).ready(function() {
			loadData(${adInfo.unit});
		});
		/*
		$("#adCustomEditListPage").live("pageshow", function() {
			$("#contentList").html("<div class=\"cl\" id=\"lastDiv\"></div>");
			startNum = -1;
			count = -1;
			loadData(${adInfo.customStorage});
		});*/
	
				var startNum = -1;
				var count = -1;
				function loadData(value){
					var url = "ajax!getAllAdListByState";
					var params = {unitId:value,adState:0,startNum:startNum,count:count};
					$.ajax({
						type : "POST",
						url : url,
						dataType : 'json',
						data:params,
						beforeSend : function() {
							// Handle the beforeSend event
							pageLoading();
						},
						success : function(data) {
							var jsonObject = eval("(" + data + ")");
							startNum = Number(jsonObject.startNum);
							count = Number(jsonObject.count);
							if(startNum<count){
								$("#moreDiv").show();
							}else{
								$("#moreDiv").hide();
							}
							$("#lastDiv").before(jsonObject.str);
							pageLoading_hide();
						},
						error : function(msg) {
							pageLoading_hide();
						}

					});

					
				}
			</script>
			
			<div data-role="header">
				<a data-ajax="false" href="javascript:window.history.back()"
					data-rel="back"><img src="${basePath}index/images/back.png" />
				</a>
				<h1>
					商品列表
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>

			<div class=" com_pany_li">

			<div data-role="content">
				<ul class="product" id="contentList">
				<!--  
				<c:forEach items="${advertisementList}" var="a">
					<li>
						<a href="#"><span><img
									src="${basePath}${a.picture}" onerror="errpic(this)"> <em>${a.title}</em>
						</span>
							<div class="product_list">
								<span><a href="${basePath}main/ad!gotoEdit?adType=2&id=${a.id}">编辑</a> 
								<a href="javascript:window.location.href='${basePath}main/ad!del?id=${a.id}'"  onclick="return confirm('您确定删除吗?')">删除</a></span>
							</div>
							<div class="cl"></div>
						</a>
					</li>
				</c:forEach>
			-->
					<div class="cl" id="lastDiv"></div>
				</ul>
				
				
				<div class="res_btn" id="moreDiv">
									<input type="button" value="加载更多" onclick="loadData(${adInfo.unit})"> 
								</div>
			</div>
			
				<%@ include file="../global/footer.jsp"%>
			</div>
		</div>
	</body>
</html>
