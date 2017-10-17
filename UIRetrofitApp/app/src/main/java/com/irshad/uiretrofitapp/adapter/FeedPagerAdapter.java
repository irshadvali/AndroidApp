package com.irshad.uiretrofitapp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.ui.FeedPollsAct;


/**
 * Created by irshadvali on 22/10/16.
 */

public class FeedPagerAdapter extends PagerAdapter {
    Context context;
    String[] one_txt_Str;
    String[] two_txt_Str;
    String[] three_txt_Str;
    String[] four_txt_Str;
    String[] five_txt_Str;
    int[] img_cover;
    int vl;
    LayoutInflater inflater;
    public FeedPagerAdapter(FeedPollsAct feedPollsAct, String[] one_txt_Str, String[] two_txt_Str, String[] three_txt_Str, String[] four_txt_Str, String[] five_txt_Str, int[] img_cover) {
        this.context = feedPollsAct;
        this.one_txt_Str = one_txt_Str;
        this.two_txt_Str = two_txt_Str;
        this.three_txt_Str = three_txt_Str;
        this.four_txt_Str = four_txt_Str;
        this.five_txt_Str = five_txt_Str;
        this.img_cover = img_cover;
    }

    @Override
    public int getCount() {
        return one_txt_Str.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtone,texttwo,txtthree,txtfour,txtfive,txtsix;
        ImageView imgCover;
       final RadioButton option1,option2,option3,option4;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.feedpoll_pager_item, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        txtone = (TextView) itemView.findViewById(R.id.txt_one);
        texttwo = (TextView) itemView.findViewById(R.id.txt_two);
        txtthree = (TextView) itemView.findViewById(R.id.txt_three);
        txtfour = (TextView) itemView.findViewById(R.id.txt_four);
        txtfive = (TextView) itemView.findViewById(R.id.txt_five);
        option1=(RadioButton) itemView.findViewById(R.id.option1);
        option2=(RadioButton) itemView.findViewById(R.id.option2);
        option3=(RadioButton) itemView.findViewById(R.id.option3);
        option4=(RadioButton) itemView.findViewById(R.id.option4);

        // Capture position and set to the TextViews
        txtone.setText(one_txt_Str[position]);
        texttwo.setText(two_txt_Str[position]);
        txtthree.setText(three_txt_Str[position]);
        txtfour.setText(four_txt_Str[position]);
        txtfive.setText(five_txt_Str[position]);

        // Locate the ImageView in viewpager_item.xml
        imgCover = (ImageView) itemView.findViewById(R.id.poster);
        // Capture position and set to the ImageView
        imgCover.setImageResource(img_cover[position]);
            option1.setTag(position);
            option2.setTag(position);
            option3.setTag(position);
            option4.setTag(position);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneRadiotrue(option1,option2,option3,option4);
                option1.setChecked(true);
                vl=1;
                Toast.makeText(context, ""+vl, Toast.LENGTH_LONG).show();
            }
        });option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoRadiotrue(option1,option2,option3,option4);
                option2.setChecked(true);
                vl=2;
                Toast.makeText(context, ""+vl, Toast.LENGTH_LONG).show();
            }
        });option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threeRadiotrue(option1,option2,option3,option4);
                option3.setChecked(true);
                vl=3;
                Toast.makeText(context, ""+vl, Toast.LENGTH_LONG).show();
            }
        });option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourRadiotrue(option1,option2,option3,option4);
                option4.setChecked(true);
                vl=4;
                Toast.makeText(context, ""+vl, Toast.LENGTH_LONG).show();
            }
        });
        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

    public void oneRadiotrue(RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4){
        //Toast.makeText(getApplicationContext(), ""+vl,Toast.LENGTH_LONG).show();
        option3.setChecked(false);
        option4.setChecked(false);
        option2.setChecked(false);
    }
    public void twoRadiotrue(RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4){
        //Toast.makeText(getApplicationContext(), ""+vl,Toast.LENGTH_LONG).show();
        option3.setChecked(false);
        option4.setChecked(false);
        option1.setChecked(false);
    }
    public void threeRadiotrue(RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4){
        //Toast.makeText(getApplicationContext(), ""+vl,Toast.LENGTH_LONG).show();
        option2.setChecked(false);
        option4.setChecked(false);
        option1.setChecked(false);
    }
    public void fourRadiotrue(RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4){

        option2.setChecked(false);
        option3.setChecked(false);
        option1.setChecked(false);
    }
}