package com.br.comunicacaofragments.views;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.br.comunicacaofragments.R;
import com.br.comunicacaofragments.interfaces.Comunicador;
import com.br.comunicacaofragments.model.SistemaOperacional;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {

    public Comunicador comunicador;
    private Button btnIOS;
    private Button btnAndroid;

    public Button getBtnIOS() {
        return btnIOS;
    }

    public void setBtnIOS(Button btnIOS) {
        this.btnIOS = btnIOS;
    }

    public Button getBtnAndroid() {
        return btnAndroid;
    }

    public void setBtnAndroid(Button btnAndroid) {
        this.btnAndroid = btnAndroid;
    }

    public Comunicador getComunicador() {
        return comunicador;
    }

    public void setComunicador(Comunicador comunicador) {
        this.comunicador = comunicador;
    }

    public PrimeiroFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        public void initViews(View view) {
            btnAndroid = view.findViewById(R.id.android);
            btnAndroid = view.findViewById(R.id.ios);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        initViews(view);

        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criando um objeto
                SistemaOperacional android = new SistemaOperacional(R.drawable.android, "Android e melhor que IOS");

                //passando o paramentro criado acima
                comunicador.receberMensagem(android);
            }
        });

        btnIOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criando um objeto
                SistemaOperacional ios = new SistemaOperacional(R.drawable.ios, "IOS é top, android coisa de pobre.");

                //passando o paramentro criado acima
                comunicador.receberMensagem(ios);
            }
        });

        return view;
    }


}
