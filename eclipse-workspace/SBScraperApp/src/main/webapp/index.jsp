<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> 
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<style>
body{
    background-image:url('https://cdn.pixabay.com/photo/2016/03/27/17/59/vintage-1283299_960_720.jpg');
    background-repeat:no-repeat;
    background-size: 100%;
}

.bg__card__navbar{
	background-color: #000000;
}
.bg__card__footer{
	background-color: #000000 !important;
}
#add__new__list{
    top: -38px;
    right: 0px;
}
.footer { 
    position: fixed; 
    bottom: 0; 
    width: 100%; 
    height: 55px;
     background-color: #2C2C2C; 
}
</style>
<script>
	$(document).ready( function () {
		 var table = $('#scrapedTable').DataTable({
				"sAjaxSource": "/scraped",
				"sAjaxDataProp": "",
				"order" : [ [ 3, 'asc' ] ],
				"aoColumns": [
			          { "mData": "price" },
					  { "mData": "description" },
					  { "mData": "url",						  
						  "render": function ( url ) { 
							  return '<a href= '+ url  + ' target=_blank> link </a>';
						  }
					  },
					  { "mData": "location" },
					  { "mData": "state" }
				]
		 })
	});
	
	function changeType(){
        var dataTableId = '#scrapedTable';
        var selectedValue = document.getElementById("scrapedTableId").value;           
        $(dataTableId).dataTable().fnFilter(selectedValue , 4, true, false, false, false);

  }
	</script>
	<!DOCTYPE html>
<html lang="en"  class="h-100">
<body>
<!---->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" style="font-size:300%;" href="http://www.findmynextbike.com/">Find my next Ride </a>

  <div class="collapse navbar-collapse" id="collapsibleNavbar">

  </div>  
   <div title="Choose state to filter by">       
      <h4> <span >Filter by States:
      <select name='scrapedTableSelector'id='scrapedTableId' onChange=changeType()>
      <option value=""> </option>
      <option  value="AZ">Arizona</option>
      <option value="AL">Alabama</option>
      <option value="AR">Arkansas</option>     
      <option  value="CA">California</option>
      <option  value="CO">Colorado</option>   
      <option  value="CT">Connecticut</option>     
      <option  value="DE">Deleware</option> 
      <option  value="DC">Dist. of Columbia</option>
      <option  value="FL">Florida</option>        
      <option  value="DE">Deleware</option> 
      <option  value="GA">Georgia</option> 
      <option  value="ID">Idaho</option> 
      <option  value="IL">Illinois</option> 
      <option  value="IN">Indiana</option> 
      <option  value="IA">Iowa</option> 
      <option  value="KS">Kansas</option> 
      <option  value="KY">Kentucky</option>               
      <option  value="LA">Louisiana</option>           
      <option value="ME">Maine</option>
      <option value="MD">Maryland</option>
      <option value="MA">Massachusetts</option>    
      <option value="MI">Michigan</option>    
      <option value="MN">Minnesota</option>    
      <option value="MS">Mississippi</option>    
      <option value="MO">Missouri</option>    
      <option value="MT">Montana</option>    
      <option value="NE">Nebraska</option>    
      <option value="NV">Nevada</option>    
      <option value="NH">New Hampshire</option>    
      <option value="NJ">New Jersey</option>    
      <option value="NM">New Mexico</option>  
      <option value="NY">New York</option>  
      <option value="NC">North Carolina</option>  
      <option value="ND">North Dakota</option>  
      <option value="OH">Ohio</option>  
      <option value="OK">Oaklahoma</option>  
      <option value="OR">Oregon</option> 
      <option value="PA">Pennsylvania</option> 
      <option value="RI">Rhode Island</option> 
      <option value="SC">South Carolina</option>    
      <option value="SD">South Dakota</option> 
      <option value="TN">Tennessee</option> 
      <option value="TX">Texas</option> 
      <option value="UT">Utah</option> 
      <option value="VT">Vermont</option> 
      <option value="VA">Virginia</option> 
      <option value="WA">Washington</option> 
      <option value="WV">West Virginia</option> 
      <option value="WI">Wisconsin</option> 
      <option value="WY">Wyoming</option>       
      </select>   
      </span></h4>
  </div> 
</nav>
<div class="container-fluid">
	<table id="scrapedTable" class="table table-hover compact"  title="Click link to open, sort by column or search field"> 	     
       <!-- Header Table -->
       <thead >
            <tr>
				<th>Price</th>
                <th>Description</th>
                <th>Url</th>
                <th>Location</th>
                <th>State</th>
            </tr>
        </thead>
        <!-- Footer Table -->
        <tfoot>
            <tr>
				<th>Price</th>
                <th>Description</th>
                <th>Url</th>
                <th>Location</th>
                <th>State</th>
            </tr>
        </tfoot>
    </table>
   </div>

<footer  class="footer" id="footer">
  <ul class="btn btn-outline-white btn-rounded">
      <li class="list-inline-item">
        <a  href="/parts"  title="Click to see MC parts">Motorcycle Parts </a>
      </li>
    </ul>
    <ul class="btn btn-outline-white btn-rounded">
      <li>
        <a th:href="@{notify}" class="btn btn-outline-white btn-rounded">Sign up for notifications!  title="Click to setup notifications"</a>
      </li>
    </ul>
</footer>
</body>
<!-- Footer -->
</html>