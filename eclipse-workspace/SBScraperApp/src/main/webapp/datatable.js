$(document).ready( function () {
	  $('#scrapedTable').DataTable({
			"sAjaxSource": "/scrapedData",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
			      { "data": "Price"},
		          { "data": "Description" },
				  { "data": "Url" }
			]
	 })
});