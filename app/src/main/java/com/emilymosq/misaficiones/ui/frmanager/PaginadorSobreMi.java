package com.emilymosq.misaficiones.ui.frmanager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.emilymosq.misaficiones.data.SobreMiManager;


public class PaginadorSobreMi extends FragmentPagerAdapter {
    private final Context mContext;

    public PaginadorSobreMi(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return SobreMiManager.getInstance().getFragments().get(position);
    }

    @Override
    public int getCount() {
        return SobreMiManager.getInstance().getSize();
    }
}
