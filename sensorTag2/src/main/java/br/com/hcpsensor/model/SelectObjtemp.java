package br.com.hcpsensor.model;

import java.io.Serializable;
import java.util.Date;

public class SelectObjtemp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date g_created;
	private double c_tagobjtemp;
	public Date getG_created() {
		return g_created;
	}
	public void setG_created(Date g_created) {
		this.g_created = g_created;
	}
	public double getC_tagobjtemp() {
		return c_tagobjtemp;
	}
	public void setC_tagobjtemp(double c_tagobjtemp) {
		this.c_tagobjtemp = c_tagobjtemp;
	}
	
	
}
