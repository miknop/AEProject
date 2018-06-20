function getClickPosition(e) {
    //var parentPosition = getPosition(e.currentTarget);
    var xPosition = e.clientX ;
    var yPosition = e.clientY ;
    
	//workaround 
	var helpfield = document.getElementById("counterSlave").getAttribute("value");
	
	if ( helpfield == 0 ) {
		var px1In = document.getElementById("p1X");
		var py1In = document.getElementById("p1Y");
	}
	if ( helpfield == 1 ) {
		var px2In = document.getElementById("p2X");
		var py2In = document.getElementById("p2Y");
	}
	
	
    /*theThing.style.left = xPosition + "px";
    theThing.style.top = yPosition + "px";*/
}
 
// Helper function to get an element's exact position
function getPosition(el) {
  var xPos = 0;
  var yPos = 0;
 
  while (el) {
    if (el.tagName == "svg") {
      // deal with browser quirks with body/window/document and page scroll
      var xScroll = el.scrollLeft || document.documentElement.scrollLeft;
      var yScroll = el.scrollTop || document.documentElement.scrollTop;
 
      xPos += (el.offsetLeft - xScroll + el.clientLeft);
      yPos += (el.offsetTop - yScroll + el.clientTop);
    } else {
      // for all other non-BODY elements
      xPos += (el.offsetLeft - el.scrollLeft + el.clientLeft);
      yPos += (el.offsetTop - el.scrollTop + el.clientTop);
    }
 
    el = el.offsetParent;
  }
  return {
    x: xPos,
    y: yPos
  };
}