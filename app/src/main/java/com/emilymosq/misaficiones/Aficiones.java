package com.emilymosq.misaficiones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.emilymosq.misaficiones.data.SobreMiManager;
import com.emilymosq.misaficiones.databinding.ActivityAficionesBinding;
import com.emilymosq.misaficiones.ui.frmanager.Paginador;
import com.emilymosq.misaficiones.ui.frmanager.PaginadorSobreMi;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("DEBUG", "Binding inicializado");

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        ViewPager viewPager = binding.viewPager;

        if (id == R.id.favButton) {
            Fragment fragmentActual = ((Paginador) viewPager.getAdapter()).getItem(viewPager.getCurrentItem());
            if (fragmentActual != null) {
                SobreMiManager.getInstance().addFragmentDinamico(fragmentActual);
                String fragmentName = fragmentActual.getClass().getSimpleName();
                Toast.makeText(this,"Estas en el fragmento: " + fragmentName , Toast.LENGTH_SHORT).show();
            }

        } else if (id == R.id.aboutMeButton) {
            Intent intent = new Intent(Aficiones.this, SobreMi.class);
            startActivity(intent);
        } else if (id == R.id.myCodeButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}