<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<c:url value='/template/admin/css/bootstrap.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.2.0/css/font-awesome.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/template/admin/fonts/fonts.googleapis.com.css'/>" />
<link rel="stylesheet" href="<c:url value='/template/admin/css/ace.min.css'/>" class="ace-main-stylesheet" id="main-ace-style" />
<script src="<c:url value='/template/admin/js/ace-extra.min.js'/>"></script>
</head>
<body>
	<!-- /header -->
	<%@ include file="/common/admin/header.jsp" %>
	<!-- /end header -->

	<!-- /.main-container -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e)
			{
				
			}
		</script>
		<!-- /menu -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- /end menu -->




		<!-- /menu -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- /end menu -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> 
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->




	<script
		src="<c:url value='/template/admin/js/jquery.2.1.1.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery-ui.custom.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery.easypiechart.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery.sparkline.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.pie.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.resize.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/js/ace-elements.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/ace.min.js'/>"></script>
</body>
</html>