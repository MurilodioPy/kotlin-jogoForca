package br.com.ads.jogoforca.model

import android.os.Parcel
import java.io.Serializable

data class Tema(val id: Int, val nome: String?, val listaPalavras: ArrayList<String>?, val imagem: Int) :
    Serializable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readInt()
    ) {
    }
}