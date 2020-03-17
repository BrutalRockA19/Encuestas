package com.example.encuestasudelp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.encuestasudelp.util.EntityUser
import com.example.encuestasudelp.util.ListUsers
import com.example.encuestasudelp.util.ListUsers.Companion.listaUsers
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_registsro.*

class RegistroActivity : AppCompatActivity() {
    val misusuario = ListUsers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registsro)


        btnRegistro.setOnClickListener {

            val miusuario = EntityUser()

            if(edtNombreRegistro.text.toString().trim().isNotEmpty()){
                miusuario.nombre = edtNombreRegistro.text.toString()

                if(edtApellidoPaterno.text.toString().trim().isNotEmpty()){
                    miusuario.apellidoPaterno = edtApellidoPaterno.text.toString()

                    if(edtApellidoMaterno.text.toString().trim().isNotEmpty()){
                        miusuario.apellidoMaterno = edtApellidoMaterno.text.toString()



                            val selectedServicio = rdgGenero.checkedRadioButtonId
                            if (selectedServicio != -1) {
                                when (selectedServicio) {
                                    rdbMasculino.id -> {
                                        miusuario.genero = 1
                                    }
                                    rdbFemenino.id -> {
                                        miusuario.genero = 0
                                    }
                                }
                                val delegacionposition = spnDelegaciones.selectedItemPosition
                                if (delegacionposition > 0) {
                                    miusuario.delegacion = delegacionposition


                                    if(edtDireccion.text.toString().trim().isNotEmpty()) {
                                        miusuario.direccion = edtDireccion.text.toString()

                                        val edoCivil = spnEstadoCivil.selectedItemPosition
                                        if (edoCivil > 0) {
                                            miusuario.estadoCivil = edoCivil

                                            if(edtCorreo.text.toString().trim().isNotEmpty()){
                                                miusuario.correo = edtCorreo.text.toString()

                                                if(edtPasswordR.text.toString().trim().isNotEmpty()) {
                                                    miusuario.password = edtPasswordR.text.toString()
                                                    Toast.makeText(this@RegistroActivity,"Guardado",Toast.LENGTH_SHORT).show()
                                                    Log.d("tamañoLISTA",misusuario.agregarUsuario(miusuario).toString())
                                                    Log.d("CANTIDAD USER",listaUsers.size.toString())
                                                    Log.d("usuario", listaUsers[listaUsers.size-1].nombre)
                                                    Log.d("usuario", listaUsers[listaUsers.size-1].password)
                                                }else{
                                                    Snackbar.make(it, "Por favor ingrese contraseña", Snackbar.LENGTH_SHORT).show()
                                                }
                                            }else{
                                                Snackbar.make(it, "Por favor ingrese correo electrónico", Snackbar.LENGTH_SHORT).show()
                                            }
                                        }else{
                                            Snackbar.make(it, "Por favor seleccione estado civil", Snackbar.LENGTH_SHORT).show()
                                        }
                                    }else{
                                        Snackbar.make(it, "Por favor ingresa una dirección", Snackbar.LENGTH_SHORT).show()
                                    }
                                }else{
                                    Snackbar.make(it, "Por favor seleccione el genero", Snackbar.LENGTH_SHORT).show()
                                }
                            }else{
                                Snackbar.make(it, "Por favor seleccione la delegación", Snackbar.LENGTH_SHORT).show()
                            }
                        //tel
                    }else{
                        Snackbar.make(it, "Por favor ingresa el apellido materno", Snackbar.LENGTH_SHORT).show()
                    }
                }else{
                    Snackbar.make(it, "Por favor ingresa el apellido paterno", Snackbar.LENGTH_SHORT).show()
                }
            }else{
                Snackbar.make(it, "Por favor ingresa el nombre", Snackbar.LENGTH_SHORT).show()
            }
        }

    }



}