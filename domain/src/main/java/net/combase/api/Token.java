package net.combase.api;

import java.io.Serializable;


/**
 * 
 * @author Mario Zieschang
 *
 */
public class Token implements Serializable{

	private static final long serialVersionUID = -8789778067837536099L;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
