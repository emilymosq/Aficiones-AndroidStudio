package com.emilymosq.misaficiones;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.emilymosq.misaficiones.data.SobreMiManager;
import com.emilymosq.misaficiones.databinding.ActivitySobremiBinding;
import com.emilymosq.misaficiones.fr.sobremi.Nombre;
import com.emilymosq.misaficiones.ui.frmanager.PaginadorSobreMi;
import com.google.android.material.tabs.TabLayout;

public class SobreMi extends AppCompatActivity {

    private ActivitySobremiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySobremiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SobreMiManager manager = SobreMiManager.getInstance();
        manager.addFragmentFijo(new Nombre());

        PaginadorSobreMi paginador = new PaginadorSobreMi(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }
}
