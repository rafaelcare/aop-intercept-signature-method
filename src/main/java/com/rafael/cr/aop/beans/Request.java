package com.rafael.cr.aop.beans;

/**
 * The Class Request.
 *
 * @author carpinteyror
 * @version 1.0
 * @since 18/04/2018
 */
public class Request {

	private String name;
	private String app;
	private String apm;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the app.
	 *
	 * @return the app
	 */
	public String getApp() {
		return app;
	}
	
	/**
	 * Sets the app.
	 *
	 * @param app the new app
	 */
	public void setApp(String app) {
		this.app = app;
	}
	
	/**
	 * Gets the apm.
	 *
	 * @return the apm
	 */
	public String getApm() {
		return apm;
	}
	
	/**
	 * Sets the apm.
	 *
	 * @param apm the new apm
	 */
	public void setApm(String apm) {
		this.apm = apm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request [name=" + name + ", app=" + app + ", apm=" + apm + "]";
	}

	
}
