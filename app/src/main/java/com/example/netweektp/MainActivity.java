package com.example.netweektp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private ProgressDialog progressDialog;

    TextView lblDatos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);



        lblDatos = (TextView)findViewById(R.id.txtHelloWorld);

    }

    private void obtenerDatosJsonKDSoft() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando datos");
        progressDialog.show();

        String url = "https://api.androidhive.info/contacts/";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String mostrar= "";
                try{
                   // JSONArray jsonArray = response.getJSONArray("TestWEBAPI"); // aqui en el name va TestWEBAPI
                    JSONArray jsonArray = response.getJSONArray("contacts"); // aqui en el name va TestWEBAPI

                    for (int i= 0 ; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("name"); //aqui iria Nombre
                        String email = jsonObject.getString("email");


                        mostrar += "Nombre: " + name + "\n" + email + "\n \n" ;

                     //   Toast.makeText(MainActivity.this, "Nombre: " + name, Toast.LENGTH_SHORT).show();

                    }
                    lblDatos.setText("");
                    lblDatos.setText(mostrar);
                    progressDialog.dismiss();

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(getApplicationContext(), "Error en conexion", Toast.LENGTH_SHORT).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(getApplicationContext(), "Error de autenticacion", Toast.LENGTH_SHORT).show();

                } else if (error instanceof ServerError) {
                    Toast.makeText(getApplicationContext(), "Error de servidor", Toast.LENGTH_SHORT).show();

                } else if (error instanceof NetworkError) {
                    Toast.makeText(getApplicationContext(), "Error de red", Toast.LENGTH_SHORT).show();

                } else if (error instanceof ParseError) {
                    Toast.makeText(getApplicationContext(), "Error en el parse", Toast.LENGTH_SHORT).show();

                }

            }
        });
        queue.add(request);
    }

    public void click_button_play(View view) {
        obtenerDatosJsonKDSoft();
    }

    public void click_button_borrar(View view) {
        lblDatos.setText("Sin datos");

    }

    public void click_button_nuevo(View view) {
        Intent i = new Intent(this, nuevoLibro.class);
        startActivity(i);
    }
}
