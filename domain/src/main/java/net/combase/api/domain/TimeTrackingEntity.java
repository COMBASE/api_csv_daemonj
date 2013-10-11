package net.combase.api.domain;

/**
 * 
 * @author Mario Zieschang
 *
 */
public class TimeTrackingEntity extends AbstractRootAndNumberDataObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8985588092320455156L;
	private boolean paidTime;

	public boolean isPaidTime()
	{
		return paidTime;
	}

	public void setPaidTime(boolean isPaidTime)
	{
		// TODO Auto-generated method stub
		paidTime = isPaidTime;
	}

}
