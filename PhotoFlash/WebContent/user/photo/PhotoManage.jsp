<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value='/layer/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/layer/layer.js'/>"></script>
<style type="text/css">
body {
	font-family: "Microsoft Yahei";
	font-size: 12px;
	margin: 0;
}

#pic {
	max-width: 200px;
	max-height: 200px;
}

.topDiv {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #999966;
	background-image: url(background/a2.jpg);
	border: 5px solid #FFFFCC;
	position: absolute;
	z-index: 9999;
	display: none;
	width: 500px;
	height: 300px;
	margin-top: 13%;
	margin-left: 30%;
	padding: 10px;
}

div img {
	width: 200px;
	height: 200px;
}

.icon {
	margin-left: 150px;
	border: solid 1px gray;
	border-right-width: 20px;
	text-align: center;
	float: left;
	margin-bottom: 30px;
	width: 205px;
	height: 200px;
	border: 0;
	display: inline-block;
}
.picture{
 border-radius: 30px;
 margin-left: 10px;
 margin-right:200px; 
}
.pictures {
	border-radius: 30px;
}
div img {
	width: 200px;
	height: 180px;
}
#txt {
	position: absolute;
	bottom: 0px;
	left: 42%;
}

</style>
<script>
 //上传照片提示
function show() {
$('#parentIframe').on('click', function(){
        layer.open({
        type: 2,
        skin: 'layui-layer-lan',
        title: '上传照片',
        fix: false,
        shadeClose: true,
        maxmin: true,
        area: ['700px', '500px'],
        content: 'user/photo/UploadPhoto.jsp',
       
    });
});
}

function sure(){
  if(confirm('确认删除?')){
     return true;
   }
   return false;
}
</script>
</head>
<body bgcolor="#ffffff">

	<center>
		<a href="javascript:void(0);" onclick="javascript:show()">
		<img src="<%=request.getContextPath()%>/background/sha3.png" id="parentIframe"> </a>
			

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="<c:url value='/PhotoServlet?method=findMyPhotos'/>"><img
			src="<%=request.getContextPath()%>/background/sha4.png"> </a>
		<hr color="#E6E6FA" />
		<c:choose>
			<c:when test="${empty photo_pb.photoList}">
         		 没有相片
   		 </c:when>
			<c:otherwise>
				<c:forEach items="${photo_pb.photoList }" var="photo">
					<div class="icon">
						<a
							href="<c:url value='/PhotoServlet?method=find&photoId=${photo.pid }'/>"
							target="center"> <img
							src="<c:url value='/${photo.filepath }'/>" border="0"
							class="pictures" /> </a> <br />
							 <a href="<c:url value='/PhotoServlet?method=find&photoId=${photo.pid }'/>"
							target="center">${photo.photoname }</a>
						
						<c:if test="${user.uid eq photo.uid }">
							<a href="<c:url value='/PhotoServlet?method=findByPid&pid=${photo.pid }'/>" target="center">修改</a>
							<a href="<c:url value='/PhotoServlet?method=delete&pid=${photo.pid }'/>"  onclick="return sure()">删除</a>
						
						</c:if>	
					</div>
				</c:forEach>


				<p>
				<p id="txt">
					第${photo_pb.curpage }页/共${photo_pb.totalpage }页
					<c:if test="${photo_pb.curpage>1 }">
						<a href="<c:url value='PhotoServlet?method=findAll&page=${1 }'/>">首页</a>
					</c:if>
					<c:if test="${photo_pb.curpage>1 }">
						<a
							href="<c:url value='PhotoServlet?method=findAll&page=${photo_pb.curpage-1 }'/>">上一页</a>
					</c:if>

					<c:choose>
						<c:when test="${photo_pb.totalpage<10 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${photo_pb.totalpage }"></c:set>
						</c:when>

						<c:otherwise>
							<c:set var="begin" value="${photo_pb.curpage-5 }"></c:set>
							<c:set var="end" value="${photo_pb.curpage+4 }"></c:set>

							<c:if test="${begin<1 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="10"></c:set>
							</c:if>

							<c:if test="${end>photo_pb.totalpage }">
								<c:set var="begin" value="${photo_pb.totalpage-9}"></c:set>
								<c:set var="end" value="${photo_pb.totalpage }"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>



					<c:forEach var="i" begin="${begin }" end="${end }">
						<c:choose>
							<c:when test="${photo_pb.curpage eq i }">
  							[${i }]
					</c:when>
							<c:otherwise>
								<a
									href="<c:url value='/PhotoServlet?method=findAll&page=${i}'/>">[${i}]</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>


					<c:if test="${photo_pb.curpage<photo_pb.totalpage }">
						<a
							href="<c:url value='/PhotoServlet?method=findAll&page=${photo_pb.curpage+1 }'/>">下一页</a>
					</c:if>
					<c:if test="${photo_pb.curpage<photo_pb.totalpage}">
						<a
							href="<c:url value='/PhotoServlet?method=findAll&page=${photo_pb.totalpage }'/>">尾页</a>
					</c:if>
				</p>
			</c:otherwise>
		</c:choose>
	</center>

</body>
</html>