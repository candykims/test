<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.commit{
  			margin:100px auto;
            background: #fff;
            box-shadow: 1px 1px 2px 0 rgba(0,0,0,.3);
            padding:30px 50px 50px;
            font-family: "microsoft yahei";
            font-size: 14px;
            color:#404040;
}
</style>
</head>
<body>
<h1>金运通主动扫码支付确认页面</h1>
<div class="commit">
	<img alt="确认支付二维码" src="${param.imgurl}">
</div>
</body>
</html>