package com.realdolmen.dynatrace.restmonitor;

/**
 * @author heydenb
 *
 */
public class XmlJsonPathTest {

	public static void main(String[] args) throws Exception{
		System.out.println("**** JSON TEST ****");
		testJSON();
		
		System.out.println("**** XML TEST ****");
		testXML();
	}
	
	public static void testJSON() throws Exception{
		String json = "{" + 
				"   \"@name\": \"CHEMAG_WPR\"," + 
				"   \"@version\": \"6.5.6.1013\"," + 
				"   \"@reportdate\": \"2017-02-02T15:55:18.358Z\"," + 
				"   \"@description\": \"\"," + 
				"   \"source\": {" + 
				"      \"@name\": \"CHEMAG\"," + 
				"      \"filters\": {" + 
				"         \"@summary\": \"last 30 days\"," + 
				"         \"filter\": \"tf:Last30d\"" + 
				"      }" + 
				"   }," + 
				"   \"reportheader\": {" + 
				"      \"reportdetails\": {" + 
				"         \"user\": \"admin\"" + 
				"      }" + 
				"   }," + 
				"   \"data\": {" + 
				"      \"chartdashlet\": {" + 
				"         \"@name\": \"Chart\"," + 
				"         \"@description\": \"\"," + 
				"         \"@showabsolutevalues\": true," + 
				"         \"measures\": {" + 
				"            \"@structuretype\": \"tree\"," + 
				"            \"measure\": {" + 
				"               \"@measure\": \"Web Page Requests\"," + 
				"               \"@color\": \"#c0c080\"," + 
				"               \"@aggregation\": \"Count\"," + 
				"               \"@unit\": \"num\"," + 
				"               \"@thresholds\": false," + 
				"               \"@drawingorder\": \"1\"," + 
				"               \"measurement\": [" + 
				"                  {" + 
				"                     \"@timestamp\": \"1484784000000\"," + 
				"                     \"@avg\": \"78.39553443104795\"," + 
				"                     \"@min\": 0.4539780020713806," + 
				"                     \"@max\": 5," + 
				"                     \"@sum\": \"112811.174046278\"," + 
				"                     \"@count\": \"1439\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1484870400000\"," + 
				"                     \"@avg\": \"338.15147367971565\"," + 
				"                     \"@min\": \"0.400081992149353\"," + 
				"                     \"@max\": \"60064.421875\"," + 
				"                     \"@sum\": \"512299.4826247692\"," + 
				"                     \"@count\": \"1515\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1484956800000\"," + 
				"                     \"@avg\": \"60.99343339800835\"," + 
				"                     \"@min\": \"3.4462950229644775\"," + 
				"                     \"@max\": \"1558.5716552734375\"," + 
				"                     \"@sum\": \"87830.54409313202\"," + 
				"                     \"@count\": \"1440\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485043200000\"," + 
				"                     \"@avg\": \"98.58105633843309\"," + 
				"                     \"@min\": \"2.2345240116119385\"," + 
				"                     \"@max\": \"60042.46484375\"," + 
				"                     \"@sum\": \"142351.04535269737\"," + 
				"                     \"@count\": \"1444\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485129600000\"," + 
				"                     \"@avg\": \"62.778911990893334\"," + 
				"                     \"@min\": \"0.5198389887809753\"," + 
				"                     \"@max\": \"2629.703857421875\"," + 
				"                     \"@sum\": \"97997.8816177845\"," + 
				"                     \"@count\": \"1561\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485216000000\"," + 
				"                     \"@avg\": \"40.78188918948536\"," + 
				"                     \"@min\": \"0.3026210069656372\"," + 
				"                     \"@max\": \"3006.574462890625\"," + 
				"                     \"@sum\": \"67086.20771670341\"," + 
				"                     \"@count\": \"1645\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485302400000\"," + 
				"                     \"@avg\": \"30.429948506421514\"," + 
				"                     \"@min\": \"2.3614768981933594\"," + 
				"                     \"@max\": \"786.216064453125\"," + 
				"                     \"@sum\": \"43819.12584924698\"," + 
				"                     \"@count\": \"1440\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485388800000\"," + 
				"                     \"@avg\": \"66.70362208966593\"," + 
				"                     \"@min\": \"0.3257119655609131\"," + 
				"                     \"@max\": \"1776.2265625\"," + 
				"                     \"@sum\": \"116798.04227900505\"," + 
				"                     \"@count\": \"1751\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485475200000\"," + 
				"                     \"@avg\": \"31.492919663734003\"," + 
				"                     \"@min\": \"0.36511504650115967\"," + 
				"                     \"@max\": \"460.5836181640625\"," + 
				"                     \"@sum\": \"47207.88657593727\"," + 
				"                     \"@count\": \"1499\"" + 
				"                  }," + 
				"                  {" + 
				"                     \"@timestamp\": \"1485561600000\"," + 
				"                     \"@avg\": \"31.86502965291341\"," + 
				"                     \"@min\": \"3.679409980773926\"," + 
				"                     \"@max\": \"80.53182220458984\"," + 
				"                     \"@sum\": \"286.7852668762207\"," + 
				"                     \"@count\": \"9\"" + 
				"                  }" + 
				"               ]" + 
				"            }" + 
				"         }" + 
				"      }" + 
				"   }" + 
				"}";
		
		MeasureCapturedValues mcv = new MeasureCapturedValues(null);
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.measures.measure.measurement[0].@avg", null));
		
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.measures.measure.measurement[0].@min", null));
		
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.measures.measure.measurement[0].@max", null));
		
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.measures.measure.@thresholds", mcv.createConversionMap("{\"true\":1.0,\"false\":0.0}")));
		
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.measures.measure.@thresholds", null));
		
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.@showabsolutevalues", null));
		
		System.out.println(mcv.extractJSONPathValue(json, "$.data.chartdashlet.@showabsolutevalues", mcv.createConversionMap("{\"true\":10.0,\"false\":-10.0}")));
		
		System.out.println(mcv.extractJSONPathValue("{doubleValue:0.1}", "$.doubleValue", null));
	}
	
	public static void testXML() throws Exception{
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
				"<dashboardreport name=\"CHEMAG_WPR\" version=\"6.5.6.1013\" reportdate=\"2017-02-02T15:29:28.132Z\" description=\"\">" + 
				"  <source name=\"CHEMAG\">" + 
				"    <filters summary=\"last 30 days\">" + 
				"      <filter>tf:Last30d</filter>" + 
				"    </filters>" + 
				"  </source>" + 
				"  <reportheader>" + 
				"    <reportdetails>" + 
				"      <user>admin</user>" + 
				"    </reportdetails>" + 
				"  </reportheader>" + 
				"  <data>" + 
				"    <chartdashlet name=\"Chart\" description=\"\" showabsolutevalues=\"false\">" + 
				"      <measures structuretype=\"tree\">" + 
				"        <measure measure=\"Web Page Requests\" color=\"#c0c080\" aggregation=\"Count\" unit=\"num\" thresholds=\"false\" drawingorder=\"1\">" + 
				"          <measurement timestamp=\"1484784000000\" avg=\"78.39553443104795\" min=\"0.4539780020713806\" max=\"5140.67724609375\" sum=\"112811.174046278\" count=\"1439\"/>" + 
				"          <measurement timestamp=\"1484870400000\" avg=\"338.15147367971565\" min=\"0.400081992149353\" max=\"60064.421875\" sum=\"512299.4826247692\" count=\"1515\"/>" + 
				"          <measurement timestamp=\"1484956800000\" avg=\"60.99343339800835\" min=\"3.4462950229644775\" max=\"1558.5716552734375\" sum=\"87830.54409313202\" count=\"1440\"/>" + 
				"          <measurement timestamp=\"1485043200000\" avg=\"98.58105633843309\" min=\"2.2345240116119385\" max=\"60042.46484375\" sum=\"142351.04535269737\" count=\"1444\"/>" + 
				"          <measurement timestamp=\"1485129600000\" avg=\"62.778911990893334\" min=\"0.5198389887809753\" max=\"2629.703857421875\" sum=\"97997.8816177845\" count=\"1561\"/>" + 
				"          <measurement timestamp=\"1485216000000\" avg=\"40.78188918948536\" min=\"0.3026210069656372\" max=\"3006.574462890625\" sum=\"67086.20771670341\" count=\"1645\"/>" + 
				"          <measurement timestamp=\"1485302400000\" avg=\"30.429948506421514\" min=\"2.3614768981933594\" max=\"786.216064453125\" sum=\"43819.12584924698\" count=\"1440\"/>" + 
				"          <measurement timestamp=\"1485388800000\" avg=\"66.70362208966593\" min=\"0.3257119655609131\" max=\"1776.2265625\" sum=\"116798.04227900505\" count=\"1751\"/>" + 
				"          <measurement timestamp=\"1485475200000\" avg=\"31.492919663734003\" min=\"0.36511504650115967\" max=\"460.5836181640625\" sum=\"47207.88657593727\" count=\"1499\"/>" + 
				"          <measurement timestamp=\"1485561600000\" avg=\"31.86502965291341\" min=\"3.679409980773926\" max=\"80.53182220458984\" sum=\"286.7852668762207\" count=\"9\"/>" + 
				"        </measure>" + 
				"      </measures>" + 
				"    </chartdashlet>" + 
				"  </data>" + 
				"</dashboardreport>";
		
		MeasureCapturedValues mcv = new MeasureCapturedValues(null);
		System.out.println(mcv.extractXPathValue(xml, "/dashboardreport/data/chartdashlet/measures/measure/measurement[1]/@avg", null));
		
		System.out.println(mcv.extractXPathValue(xml, "/dashboardreport/data/chartdashlet/measures/measure/@color", mcv.createConversionMap("{\"#c0c080\":1,\"#202020\":2}")));
		
		System.out.println(mcv.extractXPathValue(xml, "/dashboardreport/data/chartdashlet/measures/measure/@color", mcv.createConversionMap("{\"#c0c080\":\"2\",\"#202020\":\"3\"}")));
		
		try{
			System.out.println(mcv.extractXPathValue(xml, "/dashboardreport/data/chartdashlet/measures/measure/@color", mcv.createConversionMap("{\"#c0c080\":\"broken\",\"#202020\":\"3\"}")));
		}catch(RestMonitorConfigurationException e){
			System.out.println("expected exception : " + e.getMessage());
		}
		
		System.out.println(mcv.extractXPathValue(xml, "/dashboardreport/data/chartdashlet/measures/measure/@thresholds", mcv.createConversionMap("{\"true\":1.0,\"false\":0.0}")));
		
		/*
		InputStream inputStream = new FileInputStream("path-to-xml.xml");
		StringBuilder buf = new StringBuilder();
		if (inputStream != null) {
			int bytesRead;
			byte[] data = new byte[1024];
			String charset = "UTF-8";
			
			while ((bytesRead = inputStream.read(data)) > 0) {
				buf.append(EncodingUtils.getString(data, 0, bytesRead, charset));
			}
			inputStream.close();
		}
		
		System.out.println(mcv.extractXPathValue(buf.toString(), "/dashboardreport/data/chartdashlet[1]/measures[1]/measure[1]/measure[1]/measurement[1]/@avg", null));
		*/
	}
}
