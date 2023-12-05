package com.example.appfirebaselogin.Data.modelos

import android.icu.lang.UCharacter.NumericType
import com.google.gson.annotations.SerializedName

data class Perro(

    @SerializedName("id")
    val id:Int,

    @SerializedName("raza")
    val raza:String,

    @SerializedName("nombre")
    val nombre:String,

    @SerializedName("peso")
    val peso:NumericType,

    @SerializedName("tamanio")
    val tamanio:NumericType,

    @SerializedName("edad")
    val edad:Int,


    @SerializedName("idgenero")
    val idgenero:Int,

    @SerializedName("descripcion")
    val descripcion:String
)
