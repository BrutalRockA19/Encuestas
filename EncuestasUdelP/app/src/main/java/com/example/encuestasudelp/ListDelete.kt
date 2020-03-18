package com.example.encuestasudelp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.encuestasudelp.util.ListEncuestas
import kotlinx.android.synthetic.main.activity_misencuestas.*

class ListDelete : AppCompatActivity() {
    var ListaEncuestas = ListEncuestas()
    var Lista2 = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_delete)
        //  Lista2 = ListaEncuestas.devuelveListEncuestaString()
        if (ListaEncuestas.devuelveListEncuesta().size > 0) {
            val miAdaptador = ArrayAdapter<String>(
                this@ListDelete,
                android.R.layout.simple_list_item_1,
                ListaEncuestas.devuelveListEncuestaString()
            )

            ltvMisEncuestas.adapter = miAdaptador

            ltvMisEncuestas.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                val itemSeleccionado = adapterView.getItemAtPosition(position)
                Toast.makeText(
                    this@ListDelete,
                    "$position $id $itemSeleccionado",
                    Toast.LENGTH_SHORT
                ).show()
                miDialogo("Eliminar a $itemSeleccionado",id.toInt()).show()

            }
        }
    }
    //------Dialogo
    private fun miDialogo(texto:String , id:Int): AlertDialog {
        //CONTEXTO ES DONDE TE UBICAS
        val miAlerta = AlertDialog.Builder(this@ListDelete)
        miAlerta.setTitle("Estar seguro que deseas eliminar?").setMessage(texto)
        miAlerta.setPositiveButton("SI") { dialog, which ->
            ListaEncuestas.eliminarEncuesta(id)
            Toast.makeText(this@ListDelete, "Ok,  Eliminado ", Toast.LENGTH_SHORT)
                .show()
            finish();
            startActivity(intent);
        }

        miAlerta.setNegativeButton("NO") { dialog, which ->
            Toast.makeText(this@ListDelete, "clic en no .", Toast.LENGTH_SHORT).show()
        }
        return miAlerta.create()
    }



}