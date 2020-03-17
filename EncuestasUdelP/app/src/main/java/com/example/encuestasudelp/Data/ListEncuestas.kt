package com.example.encuestasudelp.util

import android.util.Log

class ListEncuestas {

    companion object {
         val listaEncuesta = arrayListOf<EntityEncuesta>()
        private  val listString = arrayListOf<String>()
    }

    /*public fun agregarEncuesta(nombre:String,apellidoP:String,apellidoM:String,correo:String,genero:Int,viajado:Int,
                               frecuencia:Int,experiencia:Int,ejecutiva:Boolean,economica:Boolean,promo:Boolean,servicio:String,mejora:String,ofertas:Boolean){

        /* listaEncuesta.add(nombre)
         listaEncuesta.add(apellidoP)
         listaEncuesta.add(apellidoM)
         listaEncuesta.add(correo)
         listaEncuesta.add(genero.toString())
         listaEncuesta.add(viajado.toString())
         listaEncuesta.add(frecuencia.toString())
         listaEncuesta.add(experiencia.toString())
         listaEncuesta.add(ejecutiva.toString())
         listaEncuesta.add(economica.toString())
         listaEncuesta.add(servicio)
         listaEncuesta.add(mejora)
         listaEncuesta.add(ofertas.toString())*/

        val encuestaR = EntityEncuesta(nombre,apellidoP,apellidoM,correo,genero,viajado,frecuencia,experiencia,ejecutiva,economica,promo,servicio,mejora,ofertas)
        listaEncuesta.add(encuestaR)
        Log.d("encuestasUDELP","$encuestaR")
    } */

    public fun agregarEncuestaPRUEBA(encuestaR:EntityEncuesta): Int{

        //val encuestaR = EntityEncuesta(nombre,apellidoP,apellidoM,correo,genero,viajado,frecuencia,experiencia,ejecutiva,economica,promo,servicio,mejora,ofertas)
        listaEncuesta.add(encuestaR)

        Log.d("encuestasUDELP","$encuestaR")

        return listaEncuesta.size
    }

     public fun eliminarEncuesta(id: Int){
         listaEncuesta.removeAt(id)


     }
    public fun editarEncuestaPRUEBA(encuestaR:EntityEncuesta): Int{

        for((index,item)in listaEncuesta.withIndex())
        {
            if(item == listaEncuesta[index]){
                listaEncuesta.add(index, encuestaR)
                Log.d("encuestasUDELP","$encuestaR")
            }
        }
        return listaEncuesta.indexOf(encuestaR)
    }


     public fun editarEncuesta(id:Int,encuestaE:EntityEncuesta){
       /*  var encuestaEditada = EntityEncuesta()
            encuestaEditada = encuestaE
         listaEncuesta[id] =  encuestaEditada*/
         listaEncuesta.set(id,encuestaE)


         }



 /*
    public fun muestraEncuesta(){
        for((index,item) in listaEncuesta.withIndex()){
            Log.d("UDELP","$index $item")

        }
    }
*/


    public fun devuelveListEncuestaString(): Array<String> {
        listString.clear()
        for (entityEncuesta in listaEncuesta) {
            listString.add(entityEncuesta.nombre)

        }
        Log.d("Test", listString[0])
        Log.d("Ultimo", listString[listString.size -1])
        val elems = listString
        return elems.toTypedArray()

    }
    public fun devuelveListEncuesta(): Array<EntityEncuesta> {
        val elems = listaEncuesta
        return elems.toTypedArray()

    }


}