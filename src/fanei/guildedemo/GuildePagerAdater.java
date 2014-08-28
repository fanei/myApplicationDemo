package fanei.guildedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class GuildePagerAdater extends PagerAdapter {

	List<View> list = new ArrayList<View>();
	private Activity mActivity;

	public GuildePagerAdater(ArrayList<View> arrayList, Activity activity) {
		this.list = arrayList;
		mActivity = activity;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		if (list != null && list.get(position) != null)
			container.removeView(list.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(list.get(position));

		if (position == list.size() - 1) {
			Button button = (Button) ((LinearLayout) list.get(position)).findViewById(R.id.butn);
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setGuilde();
					goMain();
				}
			});

		}
		return list.get(position);
	}

	private void goMain() {
		Intent intent = new Intent(mActivity, MainActivity.class);
		mActivity.startActivity(intent);
		mActivity.finish();
	}

	private void setGuilde() {
		SharedPreferences preferences = mActivity.getSharedPreferences(SplashActivity.SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putBoolean("is_first", false);
		editor.commit();
	}
}
