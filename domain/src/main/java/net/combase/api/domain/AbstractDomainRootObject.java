package net.combase.api.domain;

import java.io.Serializable;

/**
 *
 * @author mziescha
 *
 */
public class AbstractDomainRootObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private String uuid;
	private Long revision;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getRevision() {
		return revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}
}
