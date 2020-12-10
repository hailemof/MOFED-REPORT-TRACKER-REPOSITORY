<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Send Your Reports To Account Directorate</div>
		
		<br></br>
		<form action="/uploadFiles" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple required />
       <button type="submit">Submit</button>
     </form>
  
		</div>
	</div>
<%@ include file="common/footer.jspf"%>


  