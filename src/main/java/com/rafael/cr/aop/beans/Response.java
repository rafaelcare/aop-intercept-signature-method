package com.rafael.cr.aop.beans;

/**
 * The Class Response.
 *
 * @author carpinteyror
 * @version 1.0
 * @since 18/04/2018
 */
public class Response {

	private boolean success;
	private long codeOperation;
	
	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	/**
	 * Gets the code operation.
	 *
	 * @return the code operation
	 */
	public long getCodeOperation() {
		return codeOperation;
	}
	
	/**
	 * Sets the code operation.
	 *
	 * @param codeOperation the new code operation
	 */
	public void setCodeOperation(long codeOperation) {
		this.codeOperation = codeOperation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [success=" + success + ", codeOperation=" + codeOperation + "]";
	}
	
}
