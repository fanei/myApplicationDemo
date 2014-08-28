package fanei.guildedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GuildeActivity extends Activity {

	LinearLayout ll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guilde);
		setupViews();
	}

	// 记录当前选中位置
	private int currentIndex;

	private void setupViews() {
		ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
		ll = (LinearLayout) findViewById(R.id.ll);
		GuildePagerAdater adater = new GuildePagerAdater(iniViews(), GuildeActivity.this);
		pager.setAdapter(adater);
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

				if (arg0 < 0 || arg0 > ll.getChildCount() - 1 || currentIndex == arg0) {
					return;
				}

				ImageView imageView = (ImageView) ll.getChildAt(arg0);
				imageView.setImageResource(R.drawable.butn_navigation_prompt1);

				((ImageView) ll.getChildAt(currentIndex)).setImageResource(R.drawable.butn_navigation_prompt);
				currentIndex = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private ArrayList<View> iniViews() {
		ArrayList<View> list = new ArrayList<View>();

		int i = 0;

		LinearLayout layout1 = (LinearLayout) LinearLayout.inflate(getApplicationContext(), R.layout.guilde, null);
		layout1.setBackgroundResource(R.drawable.guilde1);
		layout1.findViewById(R.id.butn).setVisibility(View.GONE);
		list.add(layout1);

		i++;

		LinearLayout layout2 = (LinearLayout) LinearLayout.inflate(getApplicationContext(), R.layout.guilde, null);
		layout2.setBackgroundResource(R.drawable.guilde2);
		layout2.findViewById(R.id.butn).setVisibility(View.GONE);
		list.add(layout2);

		i++;

		LinearLayout layout3 = (LinearLayout) LinearLayout.inflate(getApplicationContext(), R.layout.guilde, null);

		layout3.setBackgroundResource(R.drawable.guilde3);
		layout3.findViewById(R.id.butn).setVisibility(View.GONE);
		list.add(layout3);

		i++;

		LinearLayout layout4 = (LinearLayout) LinearLayout.inflate(getApplicationContext(), R.layout.guilde, null);
		layout4.setBackgroundResource(R.drawable.guilde4);

		list.add(layout4);

		i++;

		for (int j = 0; j < i; j++) {
			ImageView imageView = new ImageView(getApplicationContext());
			imageView.setImageResource(R.drawable.butn_navigation_prompt);
			ll.addView(imageView);
		}

		currentIndex = 0;
		return list;
	}
}
