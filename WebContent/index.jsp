<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String bathPath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Dashboard Template for Bootstrap</title>
		<!-- Bootstrap core CSS -->
		<link href="asserts/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="asserts/css/dashboard.css" rel="stylesheet">
		<style type="text/css">
			/* Chart.js */
			
			@-webkit-keyframes chartjs-render-animation {
				from {
					opacity: 0.99
				}
				to {
					opacity: 1
				}
			}
			
			@keyframes chartjs-render-animation {
				from {
					opacity: 0.99
				}
				to {
					opacity: 1
				}
			}
			
			.chartjs-render-monitor {
				-webkit-animation: chartjs-render-animation 0.001s;
				animation: chartjs-render-animation 0.001s;
			}

		.hidden {
			width: 100%;
			height: 100%;
			position: fixed;
			left: 0;
			top: 0;
			z-index: 90;
			background: rgba(0,0,0,0.5);
			display: none;
		}

		#edit {
			width: 800px;
			height: 400px;
			background-color: #fff;
			border: 1px solid #666;
			padding: 30px;
			position: absolute;
			z-index: 99;
			top: 130px;
			left: 400px;
			box-shadow: 10px 10px 5px #888888;
			/* display: none; */
		}

		.col-md-9 {
			position: relative;
		}
		#cancel {
            width: 20px;
            height: 20px;
            font-size: 20px;
            background-color: #ccc;
            position: absolute;
            right: 0;
            top: 0;
            text-align: center;
            line-height: 18px;
            cursor: default
        }
		</style>
	</head>

	<body>
		
		<jsp:include page="/WEB-INF/commons/bars.jsp"></jsp:include>

		<div class="container-fluid">
			<div class="row">
				<nav class="col-md-2 d-none d-md-block bg-light sidebar">
					<div class="sidebar-sticky">
						<ul class="nav flex-column">
							<li class="nav-item">
								<a class="nav-link active" href="<%=bathPath%>/">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
										<path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
										<polyline points="9 22 9 12 15 12 15 22"></polyline>
									</svg>
									班级管理 <span class="sr-only">(current)</span>
								</a>
							</li>
						
							
							<li class="nav-item">
								<a class="nav-link" href="<%=bathPath%>/students">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
										<path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
										<circle cx="9" cy="7" r="4"></circle>
										<path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
										<path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
									</svg>
									学生管理
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="<%=bathPath%>/reports">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2">
										<line x1="18" y1="20" x2="18" y2="10"></line>
										<line x1="12" y1="20" x2="12" y2="4"></line>
										<line x1="6" y1="20" x2="6" y2="14"></line>
									</svg>
									分类统计
								</a>
							</li>
							
						</ul>

					</div>
				</nav>

				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
					<h2>班级管理</h2>
					<button class="btn btn-primary" id="addClass">添加班级</button>
					<div class="table-responsive">
						<table class="table table-striped table-sm">
						
							<thead>
								<tr>
									<th>ID</th>
									<th>班级名称</th>
									<th>专业</th>
									<th>院系</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="classlist">
								
								
								
							</tbody>
						</table>
					</div>
				</main>
			</div>
		</div>
			<div class="hidden">
				<div id="edit">
					<span id="cancel" title="取消">x</span>
					<form>
						<div class="form-group">
							<label for="className">班级名称</label>
							<input type="text" class="form-control" id="className" aria-describedby="emailHelp">
						</div>
						<div class="form-group">
							<label for="major">专业</label>
							<input type="text" class="form-control" id="major">
						</div>
						<div class="form-group">
							<label for="department">院系</label>
							<input type="text" class="form-control" id="department">
						</div>
						<button type="submit" class="btn btn-primary" id="update">提交</button>
					</form>
				</div>
			</div>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
		<script type="text/javascript" src="asserts/js/popper.min.js"></script>
		<script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>
		<script>
			$.ajax({
				url: "<%=bathPath%>/classinfo",
				success: function(data) {
					data = data.classes
					for (i=0;i<data.length;i++) {
						var modifbtn = "<button class='btn btn-primary modif' classid="+data[i].id+">编辑</button>";
						var delbtn = "<button class='btn btn-primary del' classid="+data[i].id+">删除</button>";
						
						var str = "<tr><td>"+data[i].id+"</td><td>"+data[i].classname+"</td><td>"+data[i].subject+"</td><td>"+data[i].dept+"</td><td>"+modifbtn +delbtn+"</td></tr>";
						$("#classlist").append(str);
					}
					$("button.del").on('click',function() {
						$.ajax({
							method:"post",
							url:"<%=bathPath%>/classinfo",
							data:{"_method":"delete","id":$(this).attr("classid")},
							success: function() {
								window.location.reload();
							}
						})
						
					})
					$("button.modif").on('click', function () {
						// console.log(data)
						var oldData = {};
						var classId = $(this).attr("classid");
						$.each(data, function (i, item) {
							if (item.id == classId) {
								// console.log(item)
								oldData = item;
							}
							// console.log(item);
						});
						$('.hidden').css('display', 'block');
						$('#className').val(oldData.classname);
						$('#major').val(oldData.subject);
						$('#department').val(oldData.dept);
						$('#update').click(function () {
							$.ajax({
								method: 'post',
								url: '<%=bathPath%>/classinfo',
								data: {
									'_method': 'put',
									'id': classId,
									'classname': $('#className').val(),
									'subject': $('#major').val(),
									'dept': $('#department').val()
								},
								success: function (data) {
									
									alert(data.info);
									$('.hidden').css('display', 'none');
									
									//window.location.reload();
								}
							})
						})
					});
				}
			})
			$('#addClass').on('click', function () {
				$('.hidden').css('display', 'block');
				
				$('#update').click(function () {
					console.log($('#className').val());
					$.ajax({
						method: 'post',
						url: '<%=bathPath%>/classinfo',
						data: {
							'classname': $('#className').val(),
							'subject': $('#major').val(),
							'dept': $('#department').val()
						},
						success: function () {
							// $('.hidden').css('display', 'none');
							// window.location.reload();
						}
					})
				})
			});
			$('#cancel').on('click', function() {
	            $('.hidden').css('display', 'none');
	        });
		</script>
		<!-- Icons -->
		<script type="text/javascript" src="asserts/js/feather.min.js"></script>
		<script>
			feather.replace()
		</script>

		<!-- Graphs -->
		<script type="text/javascript" src="asserts/js/Chart.min.js"></script>
		<script>
			var ctx = document.getElementById("myChart");
			var myChart = new Chart(ctx, {
				type: 'line',
				data: {
					labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
					datasets: [{
						data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
						lineTension: 0,
						backgroundColor: 'transparent',
						borderColor: '#007bff',
						borderWidth: 4,
						pointBackgroundColor: '#007bff'
					}]
				},
				options: {
					scales: {
						yAxes: [{
							ticks: {
								beginAtZero: false
							}
						}]
					},
					legend: {
						display: false,
					}
				}
			});
		</script>
			
	</body>

</html>