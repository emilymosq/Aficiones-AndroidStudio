package com.emilymosq.misaficiones.data;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SobreMiManager {
    private static SobreMiManager instance;

    private final List<Fragment> fragmentosFijos;
    private final List<Fragment> fragmentosDinamicos;

    private SobreMiManager() {
        fragmentosFijos = new ArrayList<>();
        fragmentosDinamicos = new ArrayList<>();
    }

    public static SobreMiManager getInstance() {
        if (instance == null) {
            instance = new SobreMiManager();
        }
        return instance;
    }

    public void addFragmentFijo(Fragment fragment) {
        if (!fragmentosFijos.contains(fragment)) {
            fragmentosFijos.add(fragment);
        }
    }

    public void addFragmentDinamico(Fragment fragment) {
        if (!fragmentosDinamicos.contains(fragment)) {
            fragmentosDinamicos.add(fragment);
        }
    }

    public List<Fragment> getFragments() {
        List<Fragment> todos = new ArrayList<>(fragmentosFijos);
        todos.addAll(fragmentosDinamicos);
        return todos;
    }

    public int getSize() {
        return fragmentosFijos.size() + fragmentosDinamicos.size();
    }
}
