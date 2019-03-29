package com.gordonez.corto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<Integer, Integer> contadores;
    private Button mButton;
    private EditText eCorreo, eUsuario;

    public static final String USUARIO = "usuario";
    public static final String CORREO = "correo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContadores();


//Crear un for loop, va a recorrer todos los ID, cuando encuentra el ID va a sumarle 1.
        for (Integer id : contadores.keySet()) {
            TextView text = findViewById(id);
            text.setOnClickListener(v -> {
                Integer contador = contadores.get(v.getId());
                contador++;
                ((TextView)v).setText(contador + "");
                contadores.put(v.getId(), contador);
            });
        }

        mButton = findViewById(R.id.bt_enviar);
        eCorreo = findViewById(R.id.et_correo);
        eUsuario = findViewById(R.id.et_user);


        mButton.setOnClickListener(v ->{

            String usuario = eUsuario.getText().toString();
            String correo = eCorreo.getText().toString();

            Intent mIntent = new Intent(MainActivity.this, Factura.class);

            mIntent.putExtra(USUARIO, usuario);
            mIntent.putExtra(CORREO, correo);

            startActivity(mIntent);

        });
    }


    // Guardar refencia de los ID y la cantidad de productos
    void initContadores() {
        contadores = new HashMap<Integer, Integer>();

        contadores.put(R.id.tv_display_p1, 0);
        contadores.put(R.id.tv_display_p2, 0);
        contadores.put(R.id.tv_display_p3, 0);
        contadores.put(R.id.tv_display_p4, 0);
        contadores.put(R.id.tv_display_p5, 0);
        contadores.put(R.id.tv_display_p6, 0);
        contadores.put(R.id.tv_display_p7, 0);
        contadores.put(R.id.tv_display_p8, 0);
        contadores.put(R.id.tv_display_p9, 0);

    }
}
