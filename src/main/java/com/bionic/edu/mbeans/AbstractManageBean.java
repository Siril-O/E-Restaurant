package com.bionic.edu.mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractManageBean {

	
	public void showMessage(String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(summary, detail));
	}
}
