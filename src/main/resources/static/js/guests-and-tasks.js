$(document).ready(function($) {

	/*
	 * Call the function DataTable() to get a fully interactive table through
	 * the id of the table guests
	 */
	$('#guests').DataTable({
		/* Change the language of the data table jquery plugin to spanish */
		language : {
			"url" : "/json/spanish.json"
		}
	});

	/*
	 * Call the function DataTable() to get a fully interactive table through
	 * the id of the table tasks
	 */
	$('#tasks').DataTable({
		/* Change the language of the data table jquery plugin to spanish */
		language : {
			"url" : "/json/spanish.json"
		}
	});

	$('.counter').counterUp({
		delay : 10,
		time : 2000
	});
	$('.counter').addClass('animated fadeInDownBig');
	$('h3').addClass('animated fadeIn');
});