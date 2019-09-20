package com.br.comunicacaofragments.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.comunicacaofragments.R;
import com.br.comunicacaofragments.model.SistemaOperacional;

import static com.br.comunicacaofragments.views.MainActivity.SO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {

    private ImageView image;
    private TextView txtNome;

    public SegundoFragment() {
        // Required empty public constructor
    }

    public void initViews(View view) {
        image = view.findViewById(R.id.imagemAndroid);
        txtNome = view.findViewById(R.id.textoAndroid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initViews(view);

        if (!getArguments().isEmpty()) {

            SistemaOperacional sistemaOperacional = getArguments().getParcelable(SO_KEY);

            if (sistemaOperacional != null) {

                Drawable drawable = getResources().getDrawable(sistemaOperacional.getImagem());

                image.setImageDrawable(drawable);
                txtNome.setText(sistemaOperacional.getNome());

            }

        }

        return view;
    }

}
