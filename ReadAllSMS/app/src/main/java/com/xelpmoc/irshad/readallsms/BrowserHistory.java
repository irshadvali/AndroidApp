package com.xelpmoc.irshad.readallsms;

import android.database.Cursor;
import android.net.Uri;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;

public class BrowserHistory extends AppCompatActivity {
    ArrayList<HistoryEntry> list = new ArrayList<HistoryEntry>();
    MyCookieManager myCookieManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_history);
        myCookieManager = new MyCookieManager();
       // myCookieManager.getCookieValue();
        System.out.println("AAAAAAAAA"+ myCookieManager.getCookieValue());
    }


    public ArrayList<HistoryEntry> getBrowserHistory() {

        String title = "";
        String url = "";



//
//
//        Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
//        String[] proj = new String[] { Browser.BookmarkColumns.TITLE,
//               Browser.BookmarkColumns.URL };
//        String sel = Browser.BookmarkColumns.BOOKMARK + " = 0"; // 0 = history,
//        // 1 = bookmark
//        Cursor mCur = getContentResolver().query(Browser.BOOKMARKS_URI, proj,
//                sel, null, null);
//        mCur.moveToFirst();
//
//        if (mCur.moveToFirst() && mCur.getCount() > 0) {
//            boolean cont = true;
//            while (mCur.isAfterLast() == false && cont) {
//                HistoryEntry entry = new HistoryEntry();
//
//                title = mCur.getString(mCur
//                        .getColumnIndex(Browser.BookmarkColumns.TITLE));
//                url = mCur.getString(mCur
//                        .getColumnIndex(Browser.BookmarkColumns.URL));
//                // Do something with title and url
//                entry.setTitle(title);
//                entry.setUrl(url);
//                list.add(entry );
//                Log.d("TAG", "title   " + title);
//                mCur.moveToNext();
//            }
//        }
//
//        mCur.close();

        return list;
    }



}
