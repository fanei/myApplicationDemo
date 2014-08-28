package fanei.guildedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	public static final String SHAREDPREFERENCES_NAME = "first_pref";
	private boolean isFirest;

	private static final int GO_HOME = 1000;
	private static final int GO_GUILD = 1001;

	private static final long SPLASH_DELAY_MILLIS = 3 * 1000;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goMain();
				break;

			case GO_GUILD:
				goGuilde();
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		SharedPreferences preferences = getSharedPreferences(SHAREDPREFERENCES_NAME, MODE_PRIVATE);

		isFirest = preferences.getBoolean("is_first", true);
		if (!isFirest) {
			mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
		} else {
			mHandler.sendEmptyMessageDelayed(GO_GUILD, SPLASH_DELAY_MILLIS);
		}
	}

	private void goMain() {
		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
		this.startActivity(intent);
		SplashActivity.this.finish();
	}

	private void goGuilde() {
		Intent intent = new Intent(SplashActivity.this, GuildeActivity.class);
		this.startActivity(intent);
		SplashActivity.this.finish();
	}
}
