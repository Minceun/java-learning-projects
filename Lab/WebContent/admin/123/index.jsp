<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>沈阳工业大学人机交互实验室</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<style type="text/css">
			body {
				width: 100%;
				height: 100%;
				text-align: center;
			}
			
			.container {
				text-align: center;
				width: 100%;
				height: 100%;
				margin-left: auto;
				margin-right: auto;
			}
			
			.carousel1 {
				width: 1000px;
				height: 507px;
				text-align: center;
				border: 1px solid black;
				margin-left: auto;
				margin-right: auto;
			}
			
			.contain {
				width: 1200px;
				height: 400px;
				/*background-color: pink;*/
				display: inline-block;
			}
			
			.box-left-info {
				position: relative;
				left: 10px;
				text-align: center;
				width: 550px;
				height: 250px;
				/*background-color: aquamarine;*/
				display: inline-block;
				border-radius:10px;
				box-shadow:10px 10px 30px #000;
			}
			
			.box-right-info {
				position: relative;
				left: 50px;
				top: 70px;
				text-align: center;
				width: 540px;
				height: 400px;
				/*background-color: aquamarine;*/
				display: inline-block;
				border-radius:10px;
				box-shadow:10px 10px 30px #000;
			}
			
			.row {
				margin-bottom: 20px;
			}
			
			.row .row {
				margin-top: 10px;
				margin-bottom: 0;
			}
			
			[class*="col-md-9"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: rgba(86, 61, 124, .15);
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
			}
			[class*="col-lg-9"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: darkgray;
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
				border-radius:10px;
			}
			[class*="col-md-10"] {
				padding-top: 15px;
				padding-bottom: 15px;
				background-color: #eee;
				background-color: white;
				border: 1px solid #ddd;
				border: 1px solid rgba(86, 61, 124, .2);
				position: relative;
				left: 100px;
			}
			.date{
				width: 100px;
				height: 90px;
			}
			.box-bottom-info-news{
				position: relative;
				top: 120px;
				left: -50px;
				width: 1300px;
				height: 1000px;
				margin-left: auto;
				margin-right: auto;
				text-align: center;
				border-radius:10px;
				box-shadow:10px 10px 20px #000;

			}
			#news-position{
				position: absolute;
				float: left;
				left: -120px;
			}
		</style>
	</head>

	<body>
		<%@ include file="NavHeader.jsp" %>
		<div class="container">
			<div class="carousel1">
				<!--轮播-->
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="img/img1.jpg" alt="...">
							<div class="carousel-caption">
								<h3>图片简介</h3>
							</div>
						</div>
						<div class="item">
							<img src="img/dog.jpg" alt="...">
							<div class="carousel-caption">
								<h3>图片简介</h3>
							</div>
						</div>
					</div>

					<!-- Controls -->
					<!--data-......表示js的标志位-->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<div class="contain">
			<div class="box-left-info">
				<h2 style="text-align: left;font:bolder;">&nbsp;&nbsp;简介</h2>
				<p style="color: blue;font:bolder;">———————————————————————————————————————</p>
				<p style="font-size: medium;">沈阳工业大学人机交互实验室。。。。。。。</p>
			</div>
			<div class="box-right-info">
				<h2 style="text-align: left;font:bolder;">&nbsp;&nbsp;实验室成果</h2>
				<p style="color: blue;font:bolder;">———————————————————————————————————————</p>
				<ul class="nav">
					<li>
						<div class="row">
							<div class="col-md-9 col-md-offset-1">
								沈阳工业大学人机交互实验室。。。。。。。
							</div>
						</div>
					</li>
					<li>
						<div class="row">
							<div class="col-md-9 col-md-offset-1">
								col-md-4
							</div>
						</div>
					</li>
					<li>
						<div class="row">
							<div class="col-md-9 col-md-offset-1">
								col-md-4
							</div>
						</div>
					</li>
					<li>
						<div class="row">
							<div class="col-md-9 col-md-offset-1">
								col-md-4
							</div>
						</div>
					</li>
				</ul>

			</div>
			<div class="box-bottom-info-news">
				<br />
				<h1 style="color: blue;">实验室动态</h1>
				<br />
				<hr />
				<br />
				<div class="row" id="all_news">
          <div class="col-md-10" id="news1">
            <div class="article">
              <div class="row">
                <div class="col-md-10">
                  <div class="col-sm-1 col-xs-2">
                    <div class="row">
                      <div class="date col-lg-9">11<br/><span>11月</span><br/><span>2019</span></div>
                    </div>
                  </div>
                  <div class="col-sm-9 col-xs-8">
                    <p class="article-data"><strong>论文"Hearing Lips: Improving Lip Reading by Distilling Speech
                        Recognizers"被The Thirty-Fourth AAAI Conference on Artificial Intelligence收录</strong></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-10" id="news2">
            <div class="article">
              <div class="row">
                <div class="col-md-10">
                  <div class="col-sm-1 col-xs-2">
                    <div class="row">
                      <div class="date col-lg-9">11<br/><span>11月</span><br/><span>2019</span></div>
                    </div>
                  </div>
                  <div class="col-sm-9 col-xs-8">
                    <p class="article-data"><strong>论文"Hearing Lips: Improving Lip Reading by Distilling Speech
                        Recognizers"被The Thirty-Fourth AAAI Conference on Artificial Intelligence收录</strong></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-10" id="news3">
            <div class="article">
              <div class="row">
                <div class="col-md-10">
                  <div class="col-sm-1 col-xs-2">
                    <div class="row">
                      <div class="date col-lg-9">11<br/><span>11月</span><br/><span>2019</span></div>
                    </div>
                  </div>
                  <div class="col-sm-9 col-xs-8">
                    <p class="article-data"><strong>论文"Hearing Lips: Improving Lip Reading by Distilling Speech
                        Recognizers"被The Thirty-Fourth AAAI Conference on Artificial Intelligence收录</strong></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-10" id="news4">
            <div class="article">
              <div class="row">
                <div class="col-md-10">
                  <div class="col-sm-1 col-xs-2">
                    <div class="row">
                      <div class="date col-lg-9">11<br/><span>11月</span><br/><span>2019</span></div>
                    </div>
                  </div>
                  <div class="col-sm-9 col-xs-8">
                    <p class="article-data"><strong>论文"Hearing Lips: Improving Lip Reading by Distilling Speech
                        Recognizers"被The Thirty-Fourth AAAI Conference on Artificial Intelligence收录</strong></p>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
        <div class="col-md-12">
          <div class="row is-centered">
            <a href="#" class="btn btn-info" id="news_btn">查看更多</a>
          </div>
        </div>
				
			</div>
			<br />
			<br />
			
			 

		</div>
		
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

	</body>

</html>