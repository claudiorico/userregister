package br.com.hcpsensor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity @IdClass(MasterDataId.class)
@Table(name = "T_IOT_84F1A4F3933C9CE7E334")
@NamedQueries({
    @NamedQuery(name = "SelecionaTodos", query = "select t from MasterData t"),
    @NamedQuery(name = "SelecionaOpt", query = "select t from MasterData t order by t.g_created desc"),
    @NamedQuery(name = "SelecionaObjTemp", query = "select t.g_created, t.c_tagobjtemp from MasterData t order by t.g_created")})
public class MasterData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String g_device;
	
	@Id
//	@Column(name="G_CREATED", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date g_created;
	private double c_tagaccx;
	private double c_tagaccy;
	private double c_tagaccz;
	private double c_taggyrox;
	private double c_taggyroy;
	private double c_taggyroz;
	private double c_tagmagx;
	private double c_tagmagy;
	private double c_tagmagz;
	private double c_taghum;
	private double c_tagobjtemp;
	private double c_tagambtemp;
	private double c_tagbmp;
	private double c_tagoptical;

	public String getG_device() {
		return g_device;
	}

	public void setG_device(String g_device) {
		this.g_device = g_device;
	}

	public Date getG_created() {
		return g_created;
	}

	public void setG_created(Date g_created) {
		this.g_created = g_created;
	}

	public double getC_tagaccx() {
		return c_tagaccx;
	}

	public void setC_tagaccx(double c_tagaccx) {
		this.c_tagaccx = c_tagaccx;
	}

	public double getC_tagaccy() {
		return c_tagaccy;
	}

	public void setC_tagaccy(double c_tagaccy) {
		this.c_tagaccy = c_tagaccy;
	}

	public double getC_tagaccz() {
		return c_tagaccz;
	}

	public void setC_tagaccz(double c_tagaccz) {
		this.c_tagaccz = c_tagaccz;
	}

	public double getC_taggyrox() {
		return c_taggyrox;
	}

	public void setC_taggyrox(double c_taggyrox) {
		this.c_taggyrox = c_taggyrox;
	}

	public double getC_taggyroy() {
		return c_taggyroy;
	}

	public void setC_taggyroy(double c_taggyroy) {
		this.c_taggyroy = c_taggyroy;
	}

	public double getC_taggyroz() {
		return c_taggyroz;
	}

	public void setC_taggyroz(double c_taggyroz) {
		this.c_taggyroz = c_taggyroz;
	}

	public double getC_tagmagx() {
		return c_tagmagx;
	}

	public void setC_tagmagx(double c_tagmagx) {
		this.c_tagmagx = c_tagmagx;
	}

	public double getC_tagmagy() {
		return c_tagmagy;
	}

	public void setC_tagmagy(double c_tagmagy) {
		this.c_tagmagy = c_tagmagy;
	}

	public double getC_tagmagz() {
		return c_tagmagz;
	}

	public void setC_tagmagz(double c_tagmagz) {
		this.c_tagmagz = c_tagmagz;
	}

	public double getC_taghum() {
		return c_taghum;
	}

	public void setC_taghum(double c_taghum) {
		this.c_taghum = c_taghum;
	}

	public double getC_tagobjtemp() {
		return c_tagobjtemp;
	}

	public void setC_tagobjtemp(double c_tagobjtemp) {
		this.c_tagobjtemp = c_tagobjtemp;
	}

	public double getC_tagambtemp() {
		return c_tagambtemp;
	}

	public void setC_tagambtemp(double c_tagambtemp) {
		this.c_tagambtemp = c_tagambtemp;
	}

	public double getC_tagbmp() {
		return c_tagbmp;
	}

	public void setC_tagbmp(double c_tagbmp) {
		this.c_tagbmp = c_tagbmp;
	}

	public double getC_tagoptical() {
		return c_tagoptical;
	}

	public void setC_tagoptical(double c_tagoptical) {
		this.c_tagoptical = c_tagoptical;
	}

}
