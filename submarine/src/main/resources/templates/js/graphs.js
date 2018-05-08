document.addEventListener("DOMContentLoaded", function () {
	var graph = document.querySelector("#functionGraph"),
		label = document.querySelector("#graph-label"),
		form = document.forms[0],
		a = document.querySelector('input[name="a"]'),
		c = document.querySelector('input[name="c"]');

	function redraw() {
		var xa, ya, xz, yz, txt;
		// die eigentliche lineare Funktion
		function f(x) {
				return Math.floor(parseFloat(a.value) * x
					// Karo-Maß ist in 10er-Schritten
					+ 10 * parseInt(c.value));
			}
			// -350 <= x <= 350
			// -200 <= y <= 200
			// Startpunkt des Graphen
		xa = -351;
		ya = -201;
		while (xa <= 350 && (ya <= -200 || ya >= 200)) {
			xa++;
			ya = f(xa);
		}
		// Endpunkt des Graphen
		xz = 351;
		yz = 201;
		while (xz >= -350 && (yz <= -200 || yz >= 200)) {
			xz--;
			yz = f(xz);
		}
		graph.setAttribute("d",
			// Startpunkt absolut (origin 350|200)
			"M" + (350 + xa) + "," + (200 - ya) // Y-Koordinate spiegeln!
			// Endpunkt absolut (origin 350|200)
			+ " L" + (350 + xz) + "," + (200 - yz) // Y-Koordinate spiegeln!
		);
		txt = "f(x)=";
		if (a.value != 1) {
			txt += (a.value == -1 ? "-" : a.value);
		}
		txt += "x";
		if (c.value != 0) {
			txt += (c.value > 0 ? "+" + c.value : c.value);
		}
		label.innerHTML = txt;
	}
	a.addEventListener("change", redraw);
	c.addEventListener("change", redraw);
	form.addEventListener("submit", function (event) {
		redraw();
		/* Standardaktionen des Formulars unterdrücken
		   (wir versenden ja nichts) */
		event.preventDefault();
		event.stopPropagation();
		return false;
	});
});
