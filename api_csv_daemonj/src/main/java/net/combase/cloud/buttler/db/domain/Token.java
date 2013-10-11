package net.combase.cloud.buttler.db.domain;
/**
 * 
 * @author Mario Zieschang
 *
 */
public class Token extends ButlerDbObject{

	private static final long serialVersionUID = -8789778067837536099L;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
