package com.rocky.ye;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class YuE extends Activity {

	private SMS_Util sms;

	private Button ye;
	private Button cxtc;
	private Button kthk;
	private Button qxhk;
	private Button ktmc;
	private Button qxmc;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		sms = new SMS_Util();
		init();

	}

	private void init() {
		ye = (Button) findViewById(R.id.ye);
		ye.setOnClickListener(new SMSListener("ye"));

		cxtc = (Button) findViewById(R.id.cxtc);
		cxtc.setOnClickListener(new SMSListener("cxtc"));

		kthk = (Button) findViewById(R.id.kthk);
		kthk.setOnClickListener(new SMSListener("kthk"));
		qxhk = (Button) findViewById(R.id.qxhk);
		qxhk.setOnClickListener(new SMSListener("qxhk"));

		ktmc = (Button) findViewById(R.id.ktmc);
		ktmc.setOnClickListener(new SMSListener("ktmc"));
		qxmc = (Button) findViewById(R.id.qxmc);
		qxmc.setOnClickListener(new SMSListener("qxmc"));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();
	}

	class SMSListener implements OnClickListener {

		private String message;
		private String context;

		public SMSListener(String message) {
			this.message = message;
			if (message.equals("ye")) {
				context = "����ѯ�����ѷ��ͳɹ�!";
			} else if (message.equals("cxtc")) {
				context = "GPRS��ѯ�����ѷ��ͳɹ�!";
			} else if (message.equals("kthk")) {
				context = "��ͨ������ζ����ѷ��ͳɹ�!";
			} else if (message.equals("qxhk")) {
				context = "ȡ��������ζ����ѷ��ͳɹ�!";
			} else if (message.equals("ktmc")) {
				context = "��ͨ�������ζ����ѷ��ͳɹ�!";
			} else if (message.equals("qxmc")) {
				context = "ȡ���������ζ����ѷ��ͳɹ�!";
			}
		}

		@Override
		public void onClick(View v) {
			sms.sentSMS(message);
			Toast.makeText(YuE.this, context, Toast.LENGTH_LONG).show();
		}

	}
}