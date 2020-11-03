$(document).ready(function () {
	$("#forget-button").click(function () {
		$("#forget-pass").fadeIn("slow");
	});
	$(".forget-close").click(function () {
		$("#forget-pass").fadeOut();
	});
});
$(".input_condition").focus(function () {
	$(this).parent('.tooltip_codition').find('.login_condition').show();
	blurEve();
}).blur(function () {
	$(this).parent('.tooltip_codition').find('.login_condition').hide();
});
function blurEve() {
	setTimeout(function () {
		$('.login_condition').fadeOut('slow');
	}, 4000);
};