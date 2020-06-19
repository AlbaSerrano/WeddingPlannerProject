var today = new Date().toISOString().split('T')[0];
document.getElementById("weddingDate").setAttribute('min', today); 
/*
 * Function to validate the form edit and create a wedding by the plugin JQuery
 * Vlidation
 */
jQuery(function() {

	jQuery("#form_wedding").validate({
		rules : {
			/* Names of the fields to validate */
			nameBride : {
				required : true,
				minlength : 3,
				maxlength : 30
			},

			nameGroom : {
				required : true,
				minlength : 3,
				maxlength : 30
			},

			aboutHer : {
				required : true,
				minlength : 10,
				maxlength : 1000
			},

			brideFile : "required",

			aboutHim : {
				required : true,
				minlength : 10,
				maxlength : 1000
			},

			groomFile : "required",

			weddingDate : {
				required : true,
				date : true
			},

			ceremonyPlace : {
				required : true,
				minlength : 5,
				maxlength : 30
			},

			ceremonyFile : "required",

			ceremonyHour : {
				required : true
			},

			ceremonyDescription : {
				required : true,
				minlength : 10,
				maxlength : 1200
			},

			partyPlace : {
				required : true,
				minlength : 5,
				maxlength : 30
			},
			partyFile1 : "required",

			partyFile2 : "required",

			partyHour : {
				required : true
			},

			partyDescription : {
				required : true,
				minlength : 10,
				maxlength : 1200
			},

			howMeet : {
				required : true,
				minlength : 10,
				maxlength : 1200
			},

			howMeetFile : "required",

			timeTogether : {
				required : true,
				minlength : 10,
				maxlength : 1200
			},

			timeTogetherFile : "required",

			weddingRequest : {
				required : true,
				minlength : 10,
				maxlength : 1200
			},

			weddingRequestFile : "required"
		},
		
	});
});