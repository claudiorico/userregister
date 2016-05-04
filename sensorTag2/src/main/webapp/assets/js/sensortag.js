/**
 * Arquivo javascript com funções utilizadas no projeto sensorTag
 */
function printList() {
	google.charts.load('current', {
		'packages' : [ 'gauge', 'line' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {

		var iv_value = 40;
		var i = 1;

		var data = google.visualization.arrayToDataTable([
				[ 'Label', 'Value' ], [ 'Temp Obj', 0 ], [ 'Temp Amb', 0 ],
				[ 'Luz', 0 ] ]);

		var options = {
			width : 400,
			height : 120,
			redFrom : 90,
			redTo : 100,
			yellowFrom : 75,
			yellowTo : 90,
			minorTicks : 5
		};

		var chart = new google.visualization.Gauge(document
				.getElementById('chart_div'));

		chart.draw(data, options);

		setInterval(function() {
			$.get('GetSensor', {
				obj : 'objtemp'
			}, function(responseJson) {
				$.each(responseJson, function(key, value) {
					data.setValue(0, 1, value);
					if (value > 32) {
						document.getElementById("msg1").innerHTML = "Alerta de temperatura do Objeto!";
						document.getElementById("msgid1").style.display = 'block';
					}else{
						document.getElementById("msgid1").style.display = 'none';
					}
				});
				chart.draw(data, options);

			})
		}, 5000);

		setInterval(function() {
			$.get('GetSensor', {
				obj : 'ambtemp'
			}, function(responseJson) {
				$.each(responseJson, function(key, value) {
					data.setValue(1, 1, value);
					if (value > 32) {
						document.getElementById("msg2").innerHTML = "Alerta de temperatura do ambiente!";
						document.getElementById("msgid2").style.display = 'block';
					}else{
						document.getElementById("msgid2").style.display = 'none';
					}					
				});
				chart.draw(data, options);
			})
		}, 5000);

		setInterval(function() {
			$.get('GetSensor', {
				obj : 'optical'
			}, function(responseJson) {
				$.each(responseJson, function(key, value) {
					data.setValue(2, 1, value);
					if (value > 32) {
						document.getElementById("msg3").innerHTML = "Alerta de Luminosidade!";
						document.getElementById("msgid3").style.display = 'block';
					}else{
						document.getElementById("msgid3").style.display = 'none';
					}					
				});
				chart.draw(data, options);
			})
		}, 5000);

		// Gráfico em linha
		var dataline = new google.visualization.DataTable();

		dataline.addColumn('string', 'Tempo');
		dataline.addColumn('number', 'Temperatura');
		// for(i = 0; i < lista1.length; i++){
		dataline.addRow([ "0", 0 ]);
		// console.log(lista1[i]);
		// };
		var optionsLineGraph = {
			width : 800,
			legend : 'none',
			vAxis : {
				minValue : 0
			},
			colors : [ '#e2431e', '#d3362d', '#e7711b', '#e49307', '#e49307',
					'#b9c246' ]
		};

		var chart1 = new google.charts.Line(document
				.getElementById('linechart_material'));
		chart1.draw(dataline, optionsLineGraph);

		setInterval(function() {
			$.get('GetTemperatura', {
				obj : 'objtemp'
			}, function(responseJson) {

				var dataline = new google.visualization.DataTable();

				dataline.addColumn('string', 'Tempo');
				dataline.addColumn('number', 'Temperatura');
				//dataline.addRow([ "0", 0 ]);

				$.each(responseJson, function(key, value) {
					dataline.addRow([ key, value ]);
				});
				chart1.draw(dataline, optionsLineGraph);
			})

		}, 5000);

	}
}

function gravar() {

}
