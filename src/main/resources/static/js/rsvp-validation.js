var today = new Date().toISOString().split('T')[0];
document.getElementById("birthDate").setAttribute('max', today); 


/*Function to validate the rsv form by the plugin JQuery Vlidation*/
jQuery(function() {

	jQuery("#rsvp-form").validate({
		rules : {
			/* Names of the fields to validate */
			name : {
				required : true,
				minlength : 3,
				maxlength : 30
			},
			birthDate : {
				required : true
			},

			email : {
				required : true,
				email : true
			},

			attend : "required",
			
			suggestion: {
				maxlength : 100
			}
		},
		
	});
});