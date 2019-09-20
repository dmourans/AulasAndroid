package com.br.comunicacaofragments.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.br.comunicacaofragments.R;
import com.br.comunicacaofragments.interfaces.Comunicador;
import com.br.comunicacaofragments.model.SistemaOperacional;

public class MainActivity extends AppCompatActivity implements Comunicador {

    public static final String SO_KEY = "SO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.segundoFragment, new PrimeiroFragment());

    }

    @Override
    public void receberMensagem(SistemaOperacional sistemaOperacional) {
        setBundleToFragment(sistemaOperacional, SO_KEY);
    }

    private void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    private void setBundleToFragment(SistemaOperacional so, String CHAVE) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, so);

        Fragment segundoFragmento = new SegundoFragment();
        segundoFragmento.setArguments(bundle);

        replaceFragment(R.id.primeiroFragmento, segundoFragmento);
    }

}
