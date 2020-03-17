package com.example.encuestasudelp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encuestasudelp.util.EntityEncuesta
import com.example.encuestasudelp.util.ListEncuestas
import kotlinx.android.synthetic.main.activity_misencuestas.*

//mis encuestas
class SurveysActivity : AppCompatActivity() {

    var ListaEncuestas = ListEncuestas()
    var Lista2 = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misencuestas)
      //  Lista2 = ListaEncuestas.devuelveListEncuestaString()
        if(ListaEncuestas.devuelveListEncuesta().size>0){
        val miAdaptador = ArrayAdapter<String> (this@SurveysActivity, android.R.layout.simple_list_item_1,ListaEncuestas.devuelveListEncuestaString())

        ltvMisEncuestas.adapter=miAdaptador

        ltvMisEncuestas.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
            val itemSeleccionado = adapterView.getItemAtPosition(position)
            Toast.makeText(
                this@SurveysActivity,
                "$position $id $itemSeleccionado",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this@SurveysActivity, DetailActivity::class.java)
            intent.putExtra("ID", position.toString())
            startActivity(intent)
        }
        }





    }
}