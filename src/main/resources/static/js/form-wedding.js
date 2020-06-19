$(document).ready(function() {
	// When the user scrolls the page, execute myFunction
	window.onscroll = function() {
		myFunction()
	};

	// Get the header
	var header = document.getElementById("formHeader");

	// Get the offset position of the navbar
	var sticky = header.offsetTop;

	// Add the sticky class to the header when you reach its scroll position.
	// Remove "sticky" when you leave the scroll position
	function myFunction() {
		if (window.pageYOffset > sticky) {
			header.classList.add("sticky");
			header.style.borderTop = "none";
		} else {
			header.classList.remove("sticky");
			header.style.borderTop = "1px dotted";
		}
	}

	// SCRIPT TO SCROLL TOP THE PAGE BY BUTTON
	$(window).scroll(function() {
		/* Show and hidden the button depending of the height of scroll */
		if ($(this).scrollTop() > 100) {
			/* show button */
			$('.ir-arriba').fadeIn();
		} else {
			/* hide button */
			$('.ir-arriba').fadeOut();
		}
	});
	/* scroll top */
	$('.ir-arriba').click(function() {
		$("html, body").animate({
			scrollTop : 0
		}, 600);
		return false;
	});
});
