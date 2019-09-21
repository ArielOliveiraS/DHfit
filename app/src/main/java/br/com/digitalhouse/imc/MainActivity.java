package br.com.digitalhouse.imc;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputAltura;
    private TextInputLayout inputIdade;
    private TextInputLayout inputPeso;
    private Button btnComecar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNome = findViewById(R.id.textInputLayoutNome);
        inputAltura = findViewById(R.id.textInputLayoutAltura);
        inputPeso = findViewById(R.id.textInputLayoutPeso);
        inputIdade = findViewById(R.id.textInputLayoutIdade);
        btnComecar = findViewById(R.id.buttonComecar);

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               String nome = inputNome.getEditText().getText().toString();
               Integer idade = Integer.parseInt(inputIdade.getEditText().toString());
               float altura = Integer.parseInt(inputAltura.getEditText().getText().toString());
               float peso = Integer.parseInt(inputPeso.getEditText().getText().toString());


               if(!nome.isEmpty() && idade != 0 && altura != 0 && peso!=0){
                   Intent intent = new Intent(MainActivity.this, telaPerfil.class );
                   Bundle bundle = new Bundle();
                   bundle.putString("NOME", nome);
                   bundle.putInt("IDADE", idade);
                   bundle.putFloat("ALTURA", altura);
                   bundle.putFloat("PESO", peso);
                   intent.putExtras(bundle);
                   startActivity(intent);
               }else{
                   inputNome.setError("Preencha o campo nome! ");
                   inputIdade.setError("Preencha o campo idade! ");
                   inputAltura.setError("Preencha o campo altura! ");
                   inputPeso.setError("Preencha o campo peso! ");
               }
            }
        });




    }
}
