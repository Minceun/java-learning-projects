<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="NavHeader.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>历届毕业生</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<style type="text/css">
			body {
				width: 100%;
				height: 100%;
			}
			
			.row {
				margin-bottom: 20px;
			}
			
			.row .row {
				margin-top: 10px;
				margin-bottom: 0;
				width: 100%;
				height: 100%;
				text-align: center;
				margin-left: auto;
				margin-right: auto;
			}
			
			.left-info {
				width: 100%;
				height: 100%;
				position: relative;
				left: 100px;
				top: -150px;
				border: 1px red solid;
				width: 450px;
				height: 400px;
				display: inline-block;
			}
			.right-info{
				border: 1px red solid;
				width: 500px;
				height: 100%;
				position: relative;
				left: 150px;
				display: inline-block;
				text-align: center;
				margin-left: auto;
				margin-right: auto;
			}
			[class*="col-md-2"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: rgba(86, 61, 124, .15);
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
				text-align: center;
				margin-left: auto;
				margin-right: auto;
				width: 100%;
				height: 100%;
			}
			[class*="col-md-7"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: white;
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
				text-align: center;
				width: 100%;
				height: 100%;
				position: relative;
				left: 50px;
			}
			img{
				width: 200px;
				height: 200px;
			}
		</style>
	</head>

	<body>
		<div class="contain">
			<div class="left-info">
				<div class="info-choice">
					<ul class="nav">
						<li class="active" role="presentation">
							<div class="row">
								<div class="col-md-2 col-md-offset-1">
									<a href="#"><span style="color: blueviolet; font-size: 1.5em;">所有毕业生</span></a>
								</div>
							</div>
						</li>
						<li>
							<div class="row">
								<div class="col-md-2 col-md-offset-1">
									<a href="#doc"><span style="color: blueviolet; font-size: 1.5em;">博士毕业生</span></a>
								</div>
							</div>
						</li>
						<li>
							<div class="row">
								<div class="col-md-2 col-md-offset-1">
									<a href="#mas"><span style="color: blueviolet; font-size: 1.5em;">硕士毕业生</span></a>
								</div>
							</div>
						</li>
						<li>
							<div class="row">
								<div class="col-md-2 col-md-offset-1">
									<a href="#bac"><span style="color: blueviolet; font-size: 1.5em;">学士毕业生</span></a>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="right-info">
				<h2 id="doc" style="color: darkblue;">博士毕业生</h2>
				<hr />
				<div class="info-show">
					<table>
					<c:forEach var="d" items="${LISTDOC}">
						<tr>
							<td>
								<li style="list-style-type: none;">
									<div class="row">
										<div class="col-md-7 col-md-offset-1">
											<a href="#" style="text-decoration: none;">
												<span style="color: blueviolet; font-size: 1.5em;">
													<img id="img1" src="img/dog.jpg"/>
													<span>${d.DOCname }</span>
													<br />
													<hr />
													<span>研究方向：${d.DOCfield }</span>
													<br />
													<span>电子邮箱：${d.DOCemail }</span>
												</span>
											</a>
										</div>
									</div>
								</li>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<h2 id="mas" style="color: darkblue;">硕士毕业生</h2>
				<hr />
				<div class="info-show">
					<table>
					<c:forEach var="m" items="${LISTMAS}">
						<tr>
							<td>
								<li style="list-style-type: none;">
									<div class="row">
										<div class="col-md-7 col-md-offset-1">
											<a href="#" style="text-decoration: none;">
												<span style="color: blueviolet; font-size: 1.5em;">
													<img id="img1" src="img/dog.jpg"/>
													<span>${m.MASname }</span>
													<br />
													<hr />
													<span>研究方向：${m.MASfield }</span>
													<br />
													<span>电子邮箱：${m.MASemail }</span>
												</span>
											</a>
										</div>
									</div>
								</li>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<h2 id="bac" style="color: darkblue;">学士毕业生</h2>
				<hr />
				<div class="info-show">
					<table>
					<c:forEach var="b" items="${LISTBAC}">
						<tr>
							<td>
								<li style="list-style-type: none;">
									<div class="row">
										<div class="col-md-7 col-md-offset-1">
											<a href="#" style="text-decoration: none;">
												<span style="color: blueviolet; font-size: 1.5em;">
													<img id="img1" src="img/dog.jpg"/>
													<span>${b.BACname }</span>
													<br />
													<hr />
													<span>联系方式：${B.BACtele }</span>
													<br />
													<span>电子邮箱：${d.DOCemail }</span>
												</span>
											</a>
										</div>
									</div>
								</li>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	</body>

</html>