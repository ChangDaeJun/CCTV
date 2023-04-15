<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
	



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>사진</th>
							<th>실종장소</th>
							<th>이름</th>
							<th>성별</th>
							
						</tr>
					</thead>
					
					
						<tr>
							
							
							<td>"${child.getChild_location()}"</td>
							
							<td>"${child.child_name}"</td>
							
							<td>"${child.child_age}"</td>
							
							<td>"${child.child_gender}"</td>
							
							<td><img src="${child.child_img}" alt="My Image"></td>
							
						</tr>
					
				</table>
				</div>
				</div>
				</div>
				</div>
				

<%@ include file="../layout/footer.jsp"%>
