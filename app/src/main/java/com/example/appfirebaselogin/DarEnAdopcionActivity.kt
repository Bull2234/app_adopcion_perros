package com.example.appfirebaselogin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DarEnAdopcionActivity : AppCompatActivity() {

    private lateinit var txtDate: EditText
    private val calendar: Calendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dar_en_adopcion)

        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.txtraza)
        val sexo = findViewById<AutoCompleteTextView>(R.id.txtsexo)

        // Definir opciones para el AutoCompleteTextView
        val opciones = arrayOf("Beagle", "Chihuahua", "Doberman", "Daneses", "Golden Retriever", "Husky siberiano", "Labrador", "Mestizo", "Pastor Alemán",
            "Pug", "Pit bull", "Pitbull Terrier", "Rottweiler", "Sabueso", "San Bernardo", "Yorkshire Terrier", "Abisinio", "AmeriCan Curl",
            "American Bobtail", "American Shorthair", "Angora Turco", "Azul Ruso", "Balinese", "Bengalí", "British Shorthair", "Burmilla",
            "Chartreux", "Cornish Rex", "Devon Rex", "Don Sphynx", "Egipcio Mau", "Exótico de Pelo Corto", "Fold Escocés",
            "Gatito Oriental", "Gato de la Selva", "Gato de Maine Coon", "Gato de Pelo Corto Americano", "Gato de Pelo Corto Británico",
            "Gato de Pelo Largo Británico", "Gato de Pelo Largo Americano", "Gato Persa", "Gato Ragdoll",
            "Gato Sagrado de Birmania", "Gato Siamés", "Gato Sokoke", "Gato Sphynx", "Gato Somali", "Gato Tonkinese", "Himalayés",
            "Manx", "Mau Egipcio", "Munchkin", "Nebelung", "Ocicat", "Oriental", "Persa",
            "Ragdoll", "Savannah", "Scottish Fold", "Selkirk Rex", "Sphynx", "Sokoke", "Siamés", "Siberiano", "Snowshoe",
            "Somali", "Tonkinese", "Turkish Angora", "Van Turco")

        // Crear un adaptador para las opciones
        val adaptador = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, opciones)

        // Configurar el AutoCompleteTextView con el adaptador
        autoCompleteTextView.setAdapter(adaptador)

        //////////////////////////////////////////opciones para sexo
        // Definir opciones para el AutoCompleteTextView
        val opcion = arrayOf("Hembra", "Macho")

        // Crear un adaptador para las opciones
        val adap = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, opcion)

        // Configurar el AutoCompleteTextView con el adaptador
        sexo.setAdapter(adap)

        /////////////////////////////////////OPCIONES TAMAÑO
        val tamano = findViewById<AutoCompleteTextView>(R.id.txtTamano)
        // Definir opciones para el AutoCompleteTextView
        val opc = arrayOf("Grande", "Mediano", "Pequeño")

        // Crear un adaptador para las opciones
        val Mostrar = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, opc)

        // Configurar el AutoCompleteTextView con el adaptador
        tamano.setAdapter(Mostrar)

        txtDate = findViewById(R.id.txtDate)

        // Mostrar el DatePickerDialog cuando se hace clic en el EditText
        txtDate.setOnClickListener {
            showDatePickerDialog()
        }

    }
    ///////calendario
    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                // Actualizar el campo de texto con la fecha seleccionada
                calendar.set(year, month, dayOfMonth)
                updateDateInEditText()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Configurar límites de fecha (opcional)
        // datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000

        datePickerDialog.show()
    }

    private fun updateDateInEditText() {
        val dateFormat = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
        txtDate.setText(simpleDateFormat.format(calendar.time))
    }

}