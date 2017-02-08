package com.realdolmen.dynatrace.restmonitor;

import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.xml.sax.InputSource;

import com.dynatrace.diagnostics.pdk.MonitorEnvironment;
import com.dynatrace.diagnostics.pdk.MonitorMeasure;
import com.dynatrace.diagnostics.util.modern.StringUtil;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 * @author heydenb
 *
 */
public class MeasureCapturedValues {

	private static final String METRIC_GROUP = "REST Monitor Measures";
	private static final String METRIC_NAME = "capturedValue";
	private static final String PARAM_XJSONPATH = "xjsonPath";
	private static final String PARAM_CONVERSIONMAP = "conversionMap";
	
	private static final Logger log = Logger.getLogger(RestMonitor.class.getName());
	
	private MonitorEnvironment monitorEnvironment;

	/**
	 * @param env
	 */
	MeasureCapturedValues(MonitorEnvironment env) {
		log.info("constructor");
		this.monitorEnvironment = env;
	}
	
	void applyMeasuresToEnvironment(String body, ResponseFormat format) throws RestMonitorConfigurationException{
		Collection<MonitorMeasure> measures;
		
		log.info("applyMeasuresToEnvironment");
		
		if ((measures = monitorEnvironment.getMonitorMeasures(METRIC_GROUP, METRIC_NAME)) != null) {
			log.info("measures count " + measures.size());
			for (MonitorMeasure measure : measures){
				String pathExpression = measure.getParameter(PARAM_XJSONPATH);
				String conversionMapJson = measure.getParameter(PARAM_CONVERSIONMAP);
				Map<String, Double> conversionMap = null;
				if (!StringUtil.isTrimmedEmpty(conversionMapJson)){
					conversionMap = createConversionMap(conversionMapJson);
				}
				if (format == ResponseFormat.JSON){
					Double value = extractJSONPathValue(body, pathExpression, conversionMap);
					measure.setValue(value);
				}
				else if (format == ResponseFormat.XML){
					Double value = extractXPathValue(body, pathExpression, conversionMap);
					measure.setValue(value);
				}
			}
		}
	}
	
	/**
	 * Converts the provided JSON string to a Map which can be used for String to Double conversions 
	 * 
	 * @param json configuration
	 * @return the parsed JSON as Map
	 * @throws RestMonitorConfigurationException
	 */
	Map<String, Double> createConversionMap(String json) throws RestMonitorConfigurationException {
		JSONParser parser = new JSONParser(JSONParser.MODE_PERMISSIVE);
		JSONObject obj = null;
		try {
			obj = (JSONObject)parser.parse(json);
		} catch (Exception e) {
			throw new RestMonitorConfigurationException("ConversionMap parse error: " + e.getMessage());
		}
		
		Map<String, Double> map = new HashMap<String, Double>();
		try {
			obj.forEach(new BiConsumer<String, Object>() {
	
				@Override
				public void accept(String key, Object mapped) {
					Double value = null;
					if (mapped instanceof Double){
						value = (Double)mapped;
					}
					else if (mapped instanceof Long){
						value = ((Long)mapped).doubleValue();
					}
					else if (mapped instanceof String){
						value = Double.valueOf((String)mapped);
					}
					map.put(key, value);
					
				}
			});
		}catch (NumberFormatException e){
			throw new RestMonitorConfigurationException("ConversionMap parse error: " + e.getMessage());
		}
		
		return map;
	}

	/**
	 * 
	 * @param jsonBody
	 * @param jsonPathExpression
	 * @param conversionMap
	 * @return
	 */
	Double extractJSONPathValue(String jsonBody, String jsonPathExpression, Map<String, Double> conversionMap) throws RestMonitorConfigurationException{
		JsonPath jsonPath = JsonPath.compile(jsonPathExpression);
		if (!jsonPath.isDefinite()){
			throw new RestMonitorConfigurationException("jsonPath should be definite");
		}
		
		Object obj = jsonPath.read(jsonBody);
		
		if (conversionMap==null){
			if (obj instanceof Double){
				return (Double)obj;
			}
			if (obj instanceof Long){
				return ((Long)obj).doubleValue();
			}
			if (obj instanceof Integer){
				return ((Integer)obj).doubleValue();
			}
			if (obj instanceof Boolean){
				return ((Boolean)obj)?1d:0d;
			}
			if (obj instanceof String){
				return Double.valueOf((String)obj);
			}
		}
		
		String key = obj.toString();
		return conversionMap.get(key);
	}
	
	/**
	 * Select the xPathExpression from the xmlBody. 
	 * If the conversionMap is null, the result is a double if it can be parsed to a double.
	 * If the conversionMap is provided, the result must be a string that is mapped to a double via the conversionMap
	 * 
	 * @param xmlBody
	 * @param xPathExpression
	 * @param conversionMap
	 * @return
	 * @throws RestMonitorConfigurationException 
	 */
	Double extractXPathValue(String xmlBody, String xPathExpression, Map<String, Double> conversionMap) throws RestMonitorConfigurationException{
		InputSource inputSource = new InputSource( new StringReader(xmlBody));
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		String result = "0.0";
		try {
			XPathExpression expr = xpath.compile(xPathExpression);
			result = expr.evaluate(inputSource);
		} catch (XPathExpressionException e) {
			throw new RestMonitorConfigurationException("XPath Expression error: " + e.getMessage(), e);
		}
		if (conversionMap == null){
			try {
				return Double.parseDouble(result);
			}
			catch (NumberFormatException e){
				throw new RestMonitorConfigurationException("Result could not be parsed as a number and there is no conversionMap provided");
			}
		}
		Double d = conversionMap.get(result);
		if (d==null){
			return -1d;
		}
		return d;
	}
		
}
