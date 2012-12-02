package com.rocky.ye;

import android.telephony.SmsManager;

public class SMS_Util {
	
	private SmsManager sms;
	
	public SMS_Util() {
		sms = SmsManager.getDefault();
	}

	public void sentSMS(String message) {
		sms.sendTextMessage("10086", null, message, null, null);
	}
	
}
