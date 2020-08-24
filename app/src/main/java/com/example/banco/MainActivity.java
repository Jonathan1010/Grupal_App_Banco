package com.example.banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {

    //Textos de entrada
    private EditText input1;
    private EditText input2;
    private EditText input3;
    //Texto
    private TextView txt1;
    private TextView txt2;
    private EditText txt7;
    //Check
    private RadioButton radiobtnMensual;
    private RadioButton radiobtnAnual;
    //botones
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button botonenviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba);
        //SET VIEWS
        //textoentrada
        input1  = (EditText) findViewById(R.id.inputUno);
        input2  = (EditText) findViewById(R.id.inputDos);
        input3  = (EditText) findViewById(R.id.inputTres);
       //textofijar
        txt1 = (TextView) findViewById(R.id.resultado1);
        txt2 = (TextView) findViewById(R.id.resultado2);
        txt7 = (EditText) findViewById(R.id.texto7);
        //radiobuton
        radiobtnMensual = (RadioButton) findViewById(R.id.radiobtnMensual);
        radiobtnAnual = (RadioButton) findViewById(R.id.radiobtnAnual);
        //boton calcular
        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(this);
        //boton borrar
        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(this);
        //boton atras
        boton3 = (Button) findViewById(R.id.boton3);
        boton3.setOnClickListener(this);
        //boton enviar
        botonenviar = (Button) findViewById(R.id.botonenviar);
        botonenviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //Interes Minimo
            double num = Double.valueOf(input2.getText().toString());
            double i = (num / 1200);
        //Tiempo en meses
            double tiempo = Double.valueOf(input3.getText().toString());
            //mensual
            double tmp = tiempo;
            //anual
            double t = tiempo * 12;
       //Importe
            double importe = Double.valueOf(input1.getText().toString());
            double c = importe;

            //Validar
            if(radiobtnAnual.isChecked() && radiobtnMensual.isChecked()){
                Toast.makeText(getApplicationContext(),"Error eliga solo meses o años" , Toast.LENGTH_LONG).show();
            }

            if(view == boton1){
                if (radiobtnMensual.isChecked()) {

            /*
            Para elevar un número a una
            potencia n en java usaremos el
            método Math. pow. Math. pow(a, b)
            donde a es la base y b el exponente
             */
                    double pago = (c*(Math.pow(1+i,tmp))*i)/(Math.pow(1+i,tmp)-1) ;
                    String resultado1 = String.valueOf(pago);
                    txt1.setText(resultado1);
                    //
                    double interes = (pago * tmp) - c;
                    String resultado2 = String.valueOf(interes);
                    txt2.setText(resultado2);

                } else {
                    radiobtnMensual.setChecked(false);

                }
                if(radiobtnAnual.isChecked()){
                        //
                        double pago2 = (c*(Math.pow(1+i,t))*i)/(Math.pow(1+i,t)-1) ;
                        String resultado1 = String.valueOf(pago2);
                        txt1.setText(resultado1);
                        //
                        double interes = (pago2 * t) - c;
                        String resultado2 = String.valueOf(interes);
                        txt2.setText(resultado2);

                    }else{
                    radiobtnAnual.setChecked(false);
                }
            }

            if(view == boton2){
                input1.setText("");
                input2.setText("");
                input3.setText("");

                txt1.setText("");
                txt2.setText("");
                txt7.setText("");

                radiobtnMensual.setChecked(false);
                radiobtnAnual.setChecked(false);
            }
            if(view == boton3){
                Intent siguiente = new Intent(this,MenuPrincipal.class);
                startActivity(siguiente);
            }

        if(view == botonenviar){
            txt7.setText("");
            Toast.makeText(getApplicationContext(),"Mensaje enviado" , Toast.LENGTH_LONG).show();

        }

        }
    }
