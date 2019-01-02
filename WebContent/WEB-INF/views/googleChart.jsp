<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('date', 'Date');
      data.addColumn('number', 'Day High');
      data.addColumn('number', 'Day Low');
      data.addColumn('number', 'Day Close');
    	<%
    		for (int i = initData.size()-1; i >= 0; i--){
    		%>
      			var d = new Date('<%=initData.get(i).timestampToDate()%>');
      			data.addRow([d,<%=initData.get(i).getHigh()%>, <%=initData.get(i).getLow()%>, <%=initData.get(i).getClose()%>]);
    		<%}%>

      var options = {
        chart: {
          title: '<%=coinBasic.getCoinName()%>',
          subtitle: 'in US dollars'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        },
        explorer: {
            actions: ['dragToPan, rightClickToReset'],
            keepInBounds: true,
            maxZoomIn: 4.0
   		}
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, options);
    }
  </script>
</head>
<body>
  <div id="line_top_x"></div>
</body>
</html>
