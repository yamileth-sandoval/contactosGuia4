package com.example.contactosguia4;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adaptador.AdaptadorContactos;
import Entidades.Contacto;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int ID_CONTACTOS=5;
    public static boolean imagen=true;
    ListView listaContactos;
    public static List<Contacto> lstContactos;
    @BindView(R.id.btnAgregar)
    FloatingActionButton btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this);

        lstContactos = new ArrayList<>();
        this.listaContactos=findViewById(R.id.listaContactos);
        this.btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregar:{
                Intent intent=new Intent(this, agregarContacto.class);
                startActivityForResult(intent,ID_CONTACTOS);
            }
            break;
        }
    }

    private void cargarLista(){
        this.listaContactos.setAdapter(new AdaptadorContactos(this,R.layout.plantilla_contactos,lstContactos));
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent datos){
        super.onActivityResult(RequestCode, ResultCode, datos);

        //Verificar que activity me esta dando una respuesta
        switch (RequestCode){
            case ID_CONTACTOS:
                if(ResultCode == RESULT_OK){
                    cargarLista();
                }
                break;
        }
    }
}
