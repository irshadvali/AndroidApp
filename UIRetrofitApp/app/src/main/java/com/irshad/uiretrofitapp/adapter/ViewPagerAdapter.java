package com.irshad.uiretrofitapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.irshad.uiretrofitapp.fragments.AchievementFrg;
import com.irshad.uiretrofitapp.fragments.BookMarkedFrg;
import com.irshad.uiretrofitapp.fragments.CommentsFrg;
import com.irshad.uiretrofitapp.fragments.VotedInFrg;


/**
 * Created by irshadvali on 01/01/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitles = new String[]{"TAB ONE", "TAB TWO", "TAB THREE","TAB FOUR"};
    //integer to count number of tabs


    //Constructor to the class
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                AchievementFrg achievementFrg = new AchievementFrg();
                return achievementFrg;
            case 1:
                VotedInFrg votedInFrg = new VotedInFrg();
                return votedInFrg;
            case 2:
                CommentsFrg commentsFrg = new CommentsFrg();
                return commentsFrg;
            case 3:
                BookMarkedFrg bookMarkedFrg=new BookMarkedFrg();
                return bookMarkedFrg;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabTitles.length;
    }
}