package net.combase.cloud.buttler.db.domain;

import java.io.Serializable;
/**
 * 
 * @author Mario Zieschang
 *
 */
public class ButlerDbObject implements Serializable {

	private static final long serialVersionUID = -4686396790644653L;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
