package br.com.digitalhouse.imc;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class telaPerfil extends AppCompatActivity {
    private TextView txtNome;
    private TextView txtIdade;
    private TextView txtAltura;
    private TextView txtPeso;
    private Button btnVamosLa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        txtNome = findViewById(R.id.textViewNome);
        txtIdade = findViewById(R.id.textViewIdade);
        txtAltura = findViewById(R.id.textViewAltura);
        txtPeso = findViewById(R.id.textViewPeso);
        btnVamosLa = findViewById(R.id.buttonVamosLa);


        Intent intent = getIntent();
        if(getIntent()!= null && intent.getExtras()!= null){

            Bundle bundle = intent.getExtras();

            String nome = bundle.getString("NOME");
            Integer idade = bundle.getInt("IDADE");
            float altura = bundle.getFloat("ALTURA");
            float peso = bundle.getFloat("PESO");

            txtNome.setText(nome);
            txtIdade.setText(idade);
            txtAltura.setText((int) altura);
            txtPeso.setText((int) peso);


        }else{
            Snackbar.make(txtNome, "Não há dados!", Snackbar.LENGTH_LONG).show();
        }

        btnVamosLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(telaPerfil.this, TelaResultado.class));

            }
        });

    }
}
