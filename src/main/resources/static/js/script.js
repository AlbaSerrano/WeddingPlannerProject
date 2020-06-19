/*----------------------------------------------------

	[Table of contents]
	1. Counter
	2. Slider
	3. Animate on Scroll
	4. Masonry gallery
	5. Mobile Menu (open/close)

----------------------------------------------------*/

(function ($) {
	"use strict";

	/*==== 1. Counter  ====*/
	var $counter = $('.js-counter');
	var $date = $counter.attr('data-date');

	$counter.countdown($date, function(event) {
		$('.js-counter-days').html(event.strftime('%D'));
		$('.js-counter-hours').html(event.strftime('%H'));
		$('.js-counter-minutes').html(event.strftime('%M'));
		$('.js-counter-seconds').html(event.strftime('%S'));
	});

	/*==== 2. Friends slider  ====*/
	var $slider = $('.js-slider').slick({
		centerMode: true,
		centerPadding: '5%',
		slidesToShow: 5,
		autoplay: true,
		prevArrow: '.js-arrow-prev',
		nextArrow: '.js-arrow-next',
		focusOnSelect: true,
		responsive: [
			{
			breakpoint: 1200,
			settings: {
				slidesToShow: 3
				}
			},
			{
			breakpoint: 480,
			settings: {
				arrows: false,
				slidesToShow: 1
				}
			}
		]
	});

	/*==== 3. Animate on Scroll ====*/
	AOS.init({
		disable: false,
		offset: 120,
		duration: 900, // values from 0 to 3000, with step 50ms
		easing: 'ease', // default easing for AOS animations
		once: true, // whether animation should happen only once - while scrolling down
	});


	/*==== 4. Masonry gallery ====*/
	var $grid = $('.grid').masonry({
		itemSelector: '.grid-item',
		//columnWidth: '.grid-sizer',
		gutter: '.gutter-sizer',
	});

	// layout Masonry after each image loads
	$grid.imagesLoaded().progress( function() {
		$grid.masonry('layout');
	});


	/*==== 5. Mobile menu (open/close) ====*/
	$(document).on('click', '.js-open-menu', function(e) {
		e.preventDefault();
		var $self = $(this);
		var $icon = $('.icon', $self);
		var iconName = $icon.attr('name');

		/*Change the icon when the user click on it*/
		var iconAttr = (iconName == 'menu' ? 'close' : 'menu');
		
		/*change the color of the close icon to black, because is a link and default the color is blue*/
		$icon.attr('name', iconAttr);
		if ($icon.attr('name') == 'close'){
			$icon.css('color', 'black');
		} 
		/*Show the menu when click to menu icon and hide the menu when click to close icon with with a sliding effect*/
		$('.js-menu').slideToggle('slow');

	} );
	
	/*==== 5.1 Mobile menu (icon-menu hover effect) ====*/
	$(".icon-menu").hover(function(){
		  $(this).css("background-color", "pink");
		  }, function(){
		  $(this).css("background-color", "white");
		});

}(jQuery));