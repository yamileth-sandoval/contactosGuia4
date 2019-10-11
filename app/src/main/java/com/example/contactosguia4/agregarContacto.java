package com.example.contactosguia4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static com.example.contactosguia4.MainActivity.lstContactos;
import static com.example.contactosguia4.MainActivity.imagen;
import Entidades.Contacto;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

public class agregarContacto extends AppCompatActivity implements View.OnClickListener {
    Contacto contacto;

    @BindView(R.id.edtNombre)
    @NotEmpty(messageId = R.string.ValidarNombre, order = 1)
    EditText edtNombre;

    @BindView(R.id.edtTel)
    @NotEmpty(messageId =R.string.ValidarTelefono, order = 2)
    @MinLength(value = 8, messageId = R.string.Tamanio,order=3)
    EditText edtTel;

    @BindView(R.id.edtOrg)
    @NotEmpty(messageId =R.string.ValidarOrganizacion, order = 4)
    EditText edtOrg;

    @BindView(R.id.btnGuardar)
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        ButterKnife.bind(this);

        this.contacto=new Contacto();
        btnGuardar.setOnClickListener(this);
    }


    public void clickMisDatos(View v){
        Intent datos=new Intent(this, misDatos.class);
        startActivity(datos);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGuardar:{
                if(FormValidator.validate(this, new SimpleErrorPopupCallback(this))){
                    contacto.setNombre(edtNombre.getText().toString());
                    contacto.setOrganizacion(edtOrg.getText().toString());
                    contacto.setTelefono(edtTel.getText().toString());
                    if(imagen){
                        contacto.setImg(R.drawable.contacto1);
                        imagen=false;
                    }else {
                        contacto.setImg(R.drawable.contacto2);
                        imagen=true;
                    }
                    lstContactos.add(contacto);
                    Intent mensajePadre=new Intent();
                    //mensajePadre.
                    setResult(RESULT_OK,mensajePadre);
                    finish();
                }
            }
            break;
        }
    }
}
