package com.jsc.ex1;

import org.apache.struts.action.ActionForm;

public class TestForm extends ActionForm {
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 418001975429917774L;
	/**
	 * The user id
	 */
	private String m_userId = null;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return m_userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		m_userId = userId;
	}
}
