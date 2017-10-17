package com.irshad.uiretrofitapp.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.adapter.FeedPagerAdapter;
import com.irshad.uiretrofitapp.fragments.BottomBar;


public class FeedPollsAct extends AppCompatActivity {
    ViewPager viewPager;
    FeedPagerAdapter adapter;
    String[] one_txt_Str;
    String[] two_txt_Str;
    String[] three_txt_Str;
    String[] four_txt_Str;
    String[] five_txt_Str;
    int[] img_cover;

    int vl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_polls);
        /*VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.vPager);
        verticalViewPager.setAdapter(new VerticlePagerAdapter(this));*/
        viewPagerAlt();
        setBottom();
    }


    /*private void StartSwiping(){
        VerticalViewPager viewPager = (VerticalViewPager) findViewById(R.id.vPager);
        //viewPager.setPageTransformer(false, new ZoomOutTransformer());
        //viewPager.setPageTransformer(true, new StackTransformer());
        String title = "ContentFragment";
        viewPager.setAdapter(new ContentFragmentAdapter.Holder(getSupportFragmentManager())
                .add(ContentFragment.newInstance(title, 1))
                .add(ContentFragment.newInstance(title, 2))
                .add(ContentFragment.newInstance(title, 3))
                .add(ContentFragment.newInstance(title, 4))
                .add(ContentFragment.newInstance(title, 5))
                .set());
        //If you setting other scroll mode, the scrolled fade is shown from either side of display.
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
*/
    private void viewPagerAlt(){
        // Generate sample data
        one_txt_Str = new String[] {
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?"
        };

        two_txt_Str = new String[] {
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?",
                "Question comes hereare you ok with this?" };

        three_txt_Str = new String[] {getString(R.string.txtone), getString(R.string.txtone),
                getString(R.string.txtone), getString(R.string.txtone), getString(R.string.txtone), getString(R.string.txtone),
                getString(R.string.txtone), getString(R.string.txtone), getString(R.string.txtone), getString(R.string.txtone)};
        four_txt_Str = new String[] { "More at NDTV", "More at NDTV",
                "More at NDTV", "More at NDTV", "More at NDTV", "More at NDTV",
                "More at NDTV", "More at NDTV", "More at NDTV", "More at NDTV" };
        five_txt_Str = new String[] { "Vote to see more content inside", "Vote to see more content inside",
                "Vote to see more content inside", "2Vote to see more content inside", "Vote to see more content inside", "Vote to see more content inside",
                "Vote to see more content inside", "Vote to see more content inside", "Vote to see more content inside", "1Vote to see more content inside" };

        img_cover = new int[] { R.drawable.images, R.drawable.images,
                R.drawable.images, R.drawable.images,
                R.drawable.images, R.drawable.images, R.drawable.images,
                R.drawable.images, R.drawable.images, R.drawable.images };

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.vPager);
        // Pass results to ViewPagerAdapter Class
        adapter = new FeedPagerAdapter(FeedPollsAct.this, one_txt_Str, two_txt_Str, three_txt_Str, four_txt_Str, five_txt_Str,img_cover);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        /*viewPager.setPageTransformer(true, new AccordionTransformer());*/
    }

    public void setBottom(){
        BottomBar bottomBar = new BottomBar();
        getSupportFragmentManager().beginTransaction().add(R.id.bottombar, bottomBar).commit();
    }
}
