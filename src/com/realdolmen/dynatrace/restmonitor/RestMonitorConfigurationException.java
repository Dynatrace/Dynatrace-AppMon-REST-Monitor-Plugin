package com.realdolmen.dynatrace.restmonitor;

/**
 * @author heydenb
 *
 */
public class RestMonitorConfigurationException extends Exception {
	private static final long serialVersionUID = 7821905448854118332L;

	/**
	 * 
	 */
	public RestMonitorConfigurationException() {}

	/**
	 * @param message
	 */
	public RestMonitorConfigurationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public RestMonitorConfigurationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RestMonitorConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

}
