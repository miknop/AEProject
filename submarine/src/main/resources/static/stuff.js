function createPoints(){
	var counter = 0;
	var maxPoints = 576;
	var minY = 0;
	var minX = 0;
	var maxY = 60;
	var maxX = 460;
	//beginn des aufbaus
	var yPos = 60;
	var xPos = 220;
	
	while counter < maxPoints{
		// Ursprung 360 - 200
		
				
		
		d3.select("body").select("svg").append("circle").attr("r",1).style("fill","white").attr("cx",200).attr("cy",200);
		counter = counter + 1;
	}
	
}

