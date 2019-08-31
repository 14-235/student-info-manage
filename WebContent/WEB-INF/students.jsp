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
		<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
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

        #classAdd {
            display: none;
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
								<a class="nav-link" href="<%=bathPath%>/">
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
										<path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
										<polyline points="9 22 9 12 15 12 15 22"></polyline>
									</svg>
									班级管理 <span class="sr-only">(current)</span>
								</a>
							</li>
						
							
							<li class="nav-item">
								<a class="nav-link active" href="<%=bathPath%>/students">
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
					<h2>学生管理</h2>
					<button class="btn btn-primary" id="addStudent">添加学生</button>
					<form role="form">
					  <div class="form-group">
					    <label for="name">选择列表</label>
					    <select class="form-control" id="classlist">
					      
					    </select>
					  </div>
					</form>
					
					<div class="table-responsive">
						<table class="table table-striped table-sm">
						
							<thead>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>班级</th>
									<th>入学时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="studentlist">
								
								
								
							</tbody>
						</table>
					</div>
				</main>
			</div>
		</div>

	<div class="hidden">
        <div id="edit">
            <span id="cancel" title="取消">x</span>
            <nav aria-label="breadcrumb" id="classAdd">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page" id="addToClass"></li>
                </ol>
            </nav>
            <form>
                <div class="form-group">
                    <label for="studentName">姓名</label>
                    <input type="text" class="form-control" id="studentName" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="studentSex">性别</label>
                    <select class="form-control selector" id="studentSex">
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="date">入学时间</label>
                    <select class="form-control selector" id="date">
                        <option value="2013.9.1">2013年</option>
                        <option value="2014.9.1">2014年</option>
                        <option value="2015.9.1">2015年</option>
                        <option value="2016.9.1">2016年</option>
                        <option value="2017.9.1">2017年</option>
                        <option value="2018.9.1">2018年</option>
                        <option value="2019.9.1">2019年</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" id="update">提交</button>
            </form>
        </div>
    </div>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->

		<script type="text/javascript" src="asserts/js/popper.min.js"></script>
		<script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>
		<script>
			var AllClass={};
			$.ajax({
				url: "<%=bathPath%>/classinfo",
				success: function(data) {
					data = data.classes;
					for (i=0;i<data.length;i++) {
						
						var str = str = "<option classid="+data[i].id+">"+data[i].classname+"</option>";
						AllClass[data[i].id] = data[i].classname;
						$("#classlist").append(str);
					}
					$("option").on('click',function() {
						alert($(this).attr('classid'))
					})
					
					 $("#classlist").on("change",function(){
						 $("#studentlist").html("");
					     var classid = $("option:selected",this).attr('classid');
					     $.each(data, function (i, item) {
		                        if (item.id == classid) {
		                            // console.log(item);
		                            $('#addToClass').text(item.classname);
		                        }
		                    })
		                 $('#addStudent').attr('classId', classid);
					     $.ajax({
					    	 url: "<%=bathPath%>/student?classid="+classid,
					    	 success: function(data) {
					    		 for (i=0;i<data.length;i++) {
					    			 var modifbtn = "<button class='btn btn-primary modif' sid="+data[i].sid+">编辑</button>";
									 var delbtn = "<button class='btn btn-primary del' sid="+data[i].sid+">删除</button>";
					    			 
					    			 var str = "<tr><td>"+data[i].sid+"</td><td>"+data[i].sname+"</td><td>"+(data[i].sex==0?"女":"男")+"</td><td>"+AllClass[data[i].classid]+"</td><td>"+data[i].date+"</td><td>"+modifbtn +delbtn+"</td></tr>";
					    			 //++"</td><td>"+data[i].class+"</td><td>"+data[i].date+"
									 $("#studentlist").append(str);
					    		 }
					    		 
					    		 $("button.del").on('click',function() {
										$.ajax({
											method:"post",
											url:"<%=bathPath%>/student",
											data:{"_method":"delete","sid":$(this).attr("sid")},
											success: function() {
												$("#studentlist").html("");
												$("#classlist").trigger("change");
											}
										})
										
									})
								     $("button.modif").on('click', function () {

		                                var oldData = {};
		                                var studentId = $(this).attr("sid");
		                                $.each(data, function (i, item) {
		                                    if (item.sid == studentId) {
		                                        console.log(item)
		                                        oldData = item;
		                                    }
		                                    // console.log(item);
		                                });
		                                $('.hidden').css('display', 'block');
		                                $('#studentName').val(oldData.sname);
		                                // var sSex = oldData.sex == 0 ? '女' : '男';
		                                $(".selector").find("option[value='" + oldData
		                                    .sex + "']").attr("selected", true);
		
		                                $('#date').val(oldData.date);
		                                $('#update').click(function () {
		                                    $.ajax({
		                                        method: 'post',
		                                        url: '<%=bathPath%>/student',
		                                        data: {
		                                            '_method': 'put',
		                                            'sid': studentId,
		                                            'sname': $(
		                                                '#studentName'
		                                            ).val(),
		                                            'sex': $(
		                                                    '.selector'
		                                                )
		                                                .val(),
		                                            'class': oldData
		                                                .classid,
		                                            'date': $('#date')
		                                                .val()
		                                        },
		                                        success: function () {
		                                            $('.hidden')
		                                                .css(
		                                                    'display',
		                                                    'none');
		                                            window.location
		                                                .reload();
		                                        }
		                                    })
		                                })
		                            });
					    	 }
					     })
					 });   
					$("#classlist").trigger("change");
					
					
				}
			})
			 $('#addStudent').on('click', function () {
		            $('.hidden').css('display', 'block');
		            $('#classAdd').css('display', 'block');
		            var classid = $(this).attr('classId');
		            $('#update').click(function () {
		                $.ajax({
		                    method: 'post',
		                    url: '<%=bathPath%>/student',
		                    data: {
		                        'sname': $(
		                            '#studentName'
		                        ).val(),
		                        'sex': $(
		                                '.selector'
		                            )
		                            .val(),
		                        'class': classid,
		                        'date': $('#date')
		                            .val()
		                    },
		                    success: function () {
		                        $('.hidden')
		                            .css(
		                                'display',
		                                'none');
		                        window.location
		                            .reload();
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