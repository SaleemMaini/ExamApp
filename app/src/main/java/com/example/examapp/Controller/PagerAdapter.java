package com.example.examapp.Controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.examapp.Views.Course1;
import com.example.examapp.Views.Course2;
import com.example.examapp.Views.Course3;
import com.example.examapp.Views.Course4;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new Course2();
            case 2:
                return new Course3();
            case 3:
                return new Course4();
        }
        return new Course1();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new Course1();
//            case 1:
//                return new Course2();
//            case 2:
//                return new Course3();
//            case 3:
//                return new Course4();
//            default:
//                return null;
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return numOfTabs;
//    }