$(document).ready( function () {
	 var table = $('#scrapedTable').DataTable({
			"sAjaxSource": "/scrapedData",
			"sAjaxDataProp": "",
			"order" : [ [ 0, 'asc' ] ],
			"aoColumns": [
		          { "mData": "Price" },
				  { "mData": "Description" }
			]
	 })
});