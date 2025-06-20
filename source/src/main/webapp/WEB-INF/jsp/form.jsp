<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>情報追加（仮）</title>
</head>
<body>
 <!-- ヘッダー（ここから） -->
	<header>
		<a href="/B1/LoginServlet">
			<img src="img/logo.png" alt="NaviZaka"  height="130">
		</a>
		<nav>
			<ul>
			<li><a href="/B1/LoginServlet">ホーム</a></li>
			<li><a href="/B1/ManuListServlet">マニュアル一覧</a></li>
			<li><a href="/B1/UserUpServlet">ユーザー情報</a></li>
			<li><a href="/B1/LoginServlet"><img src="img/logout.png" alt="ログアウト" width="100"></a>
			</ul>
		</nav>
	</header>
  <!-- ヘッダー（ここまで） -->
  
  <div class="wrapper">
   <p id="error_message">メッセージエリア</p>
   
   <form id="manual_form" method="POST" action="<c:url value='/ManuMakeServlet' />">
    <table class="make">
     <tr>
     
     <!-- カテゴリ -->
     <th rowspan="2">カテゴリ</th>
     <td rowspan="2">
      <div>
       <select id="category" name="category">
         <c:forEach items="${categoList}" var="category" varStatus="status"></c:forEach>
       </select>
      </div>
     </td>
    </table>
   </form>
  </div>
</body>
</html>