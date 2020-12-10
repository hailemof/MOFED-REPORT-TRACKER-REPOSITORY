<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">List of User Roles</div>
		
		<br></br>
		<form action="/roles" method="get">
					<input id="txtSearch" type="text" name="keyword">
					<button type="submit">Search </button>
				</form>
				
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" >New Role</button>
        
		
			<table class="table table-striped table-advance table-hover">
                <thead>
                  <tr>
                    
                    <th><i class="icon_table"></i>ID</th>
                    <th><i class="icon_table"></i>Name</th>
                    <th><i class="icon_cogs"></i>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  
        </tbody>
        
       </table>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New Role</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="/organizations/addNew" method="post">
                       
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Name:</label>
            <input type="text" class="form-control" id="recipient-name" name="orgname"  required>
          </div>
        
          
        
                  
        
          <div class="form-group">
          <button type="submit" class="btn btn-primary">Save</button>        
        </div>             
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

  