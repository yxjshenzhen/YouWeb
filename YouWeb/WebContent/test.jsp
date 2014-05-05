<%@ page contentType="text/html;charset=GBK"%> 

<%@ page import = "org.jfree.chart.ChartFactory,org.jfree.chart.JFreeChart, org.jfree.chart.servlet.ServletUtilities, 

org.jfree.chart.title.TextTitle, org.jfree.data.time.TimeSeries, 

org.jfree.data.time.Month,org.jfree.chart.plot.XYPlot, 

org.jfree.data.time.TimeSeriesCollection,java.awt.Font, 

org.jfree.chart.renderer.xy.XYLineAndShapeRenderer, 

org.jfree.chart.renderer.xy.XYItemRenderer, 

org.jfree.ui.RectangleInsets, 

org.jfree.chart.labels.*, 

org.jfree.ui.*, 

org.jfree.chart.axis.*,java.util.*"%> 

<%
 	//访问量统计时间线 

 	TimeSeries timeSeries = new TimeSeries("某网站访问量统计", Month.class);

 	//时间曲线数据集合 

 	TimeSeriesCollection lineDataset = new TimeSeriesCollection();

 	//构造数据集合 

 	timeSeries.add(new Month(1, 2010), 1100);

 	timeSeries.add(new Month(2, 2010), 1200);

 	timeSeries.add(new Month(3, 2010), 1000);

 	timeSeries.add(new Month(4, 2010), 900);

 	timeSeries.add(new Month(5, 2010), 1000);

 	timeSeries.add(new Month(6, 2010), 1200);

 	timeSeries.add(new Month(7, 2010), 1300);

 	timeSeries.add(new Month(8, 2010), 1400);

 	timeSeries.add(new Month(9, 2010), 1200);

 	timeSeries.add(new Month(10, 2010), 1500);

 	timeSeries.add(new Month(11, 2010), 1600);

 	timeSeries.add(new Month(12, 2010), 1300);

 	lineDataset.addSeries(timeSeries);

 	JFreeChart chart = ChartFactory.createTimeSeriesChart("访问量统计时间线",
 			"月份", "访问量", lineDataset, true, true, true);

 	//设置主标题 

 	chart.setTitle(new TextTitle("某网站访问量统计", new Font("隶书",
 			Font.ITALIC, 15)));

 	//设置子标题 

 	TextTitle subtitle = new TextTitle("2010年度", new Font("黑体",
 			Font.BOLD, 12));

 	chart.addSubtitle(subtitle);

 	chart.setAntiAlias(true);

 	XYPlot plot = (XYPlot) chart.getPlot();

 	//设置时间轴的范围。 

 	DateAxis dateaxis = (DateAxis) plot.getDomainAxis();

 	dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("M月"));

 	dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH, 1));

 	Calendar date = Calendar.getInstance();

 	date.set(2009, 11, 1);

 	Calendar mdate = Calendar.getInstance();

 	mdate.set(2010, 11, 30);

 	dateaxis.setRange(date.getTime(), mdate.getTime());

 	//设置最大坐标范围 

 	ValueAxis axis = plot.getRangeAxis();

 	axis.setRange(800, 1800);

 	plot.setRangeAxis(axis);

 	//设置曲线图与xy轴的距离 [上,左,下,右] 

 	plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 12D));

 	//设置曲线是否显示数据点 

 	XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer) plot
 			.getRenderer();
 	xylinerenderer.setBaseShapesVisible(true);

 	//设置曲线显示各数据点的值 

 	XYItemRenderer xyitem = plot.getRenderer();

 	xyitem.setBaseItemLabelsVisible(true);

 	xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
 			ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));

 	xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());

 	xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12));

 	plot.setRenderer(xyitem);

 	String filename = ServletUtilities.saveChartAsPNG(chart, 500, 360,
 			null, session);
 	String graphURL = request.getContextPath()
 			+ "/servlet/DisplayChart?filename=" + filename;
 %> 



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="<%= graphURL %>" width=500 height=360 border=0 >
</body>
</html>