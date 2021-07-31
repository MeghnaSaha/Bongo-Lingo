package com.example.bongolingo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CategoryAdapter extends FragmentStateAdapter {

    Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm, Lifecycle lc){
        super(fm, lc);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
            default:
                return new PhrasesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public String getPageTitle(int position){
        switch(position){
            case 0:
                return mContext.getString(R.string.category_numbers);
            case 1:
                return mContext.getString(R.string.category_family);
            case 2:
                return mContext.getString(R.string.category_colors);
            case 3:
            default:
                return mContext.getString(R.string.category_phrases);
        }
    }
}
