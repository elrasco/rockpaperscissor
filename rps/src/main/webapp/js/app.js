$(document).ready(function() {
	$(".sign>span").on("click", function () {
		var $div = $(this).closest(".sign");
		$.getJSON("play", {sign: $($div).data("sign"), _: new Date().getTime()}, function(outcome) {
			var msg = "you play against a " + outcome.against + " and you " + outcome.outcome + "!!";
			alert(msg);
			var el = $("<span class='result " + outcome.outcome + "'>" + outcome.against + "</span>")
			$(".append", $div).append(el);
		});
	})
});