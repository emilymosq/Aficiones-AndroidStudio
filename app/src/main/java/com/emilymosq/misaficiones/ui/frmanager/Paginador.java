package com.emilymosq.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.emilymosq.misaficiones.fr.aficiones.Series;
import com.emilymosq.misaficiones.fr.aficiones.Musica;

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;
    public Paginador(Context context, FragmentManager fm) {
        super (fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Series();
            case 1:
                return new Musica();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public Fragment getFragmentAt(int position) {
        return getItem(position);
    }
}
