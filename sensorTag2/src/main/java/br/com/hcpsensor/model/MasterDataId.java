package br.com.hcpsensor.model;

import java.io.Serializable;
import java.util.Date;

public class MasterDataId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String g_device;
	Date g_created;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((g_created == null) ? 0 : g_created.hashCode());
		result = prime * result + ((g_device == null) ? 0 : g_device.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MasterDataId other = (MasterDataId) obj;
		if (g_created == null) {
			if (other.g_created != null)
				return false;
		} else if (!g_created.equals(other.g_created))
			return false;
		if (g_device == null) {
			if (other.g_device != null)
				return false;
		} else if (!g_device.equals(other.g_device))
			return false;
		return true;
	}

}
