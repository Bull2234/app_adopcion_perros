package com.example.appfirebaselogin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistrarseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener(){

            val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
            val Correo = txtCorreo.text.toString().trim()

            val txtPassword1 = findViewById<EditText>(R.id.txtPassword1)
            val Password1 = txtPassword1.text.toString().trim()

            val txtPassword2 = findViewById<EditText>(R.id.txtPassword2)
            val Password2 = txtPassword2.text.toString().trim()

            if (Correo.isNotEmpty() && Password1.isNotEmpty() && Password2.isNotEmpty()) {

                if (Password1 != Password2){
                    // Mostrar un AlertDialog si algún campo está vacío
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Las Contraseñas No Coinciden")
                    builder.setMessage("Por favor, Verifica de nuevo")
                    builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                        dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                    }

                    val dialog = builder.create()
                    dialog.show()

                }else{
                    //aqui toca guardar todo
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(Correo, Password1).addOnCompleteListener() {
                        if (it.isSuccessful) {
                            // Mostrar un AlertDialog si todo esta bien
                            val builder = AlertDialog.Builder(this)
                            builder.setTitle("Datos Registrados")
                            builder.setMessage("Bienvenido")
                            builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                                dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            }

                            val dialog = builder.create()
                            dialog.show()

                        } else {
                            // Mostrar un AlertDialog si algún error ocurrio
                            val builder = AlertDialog.Builder(this)
                            builder.setTitle("Error de Autenticacion")
                            builder.setMessage("Por favor, Verifica de nuevo")
                            builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                                dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                            }

                            val dialog = builder.create()
                            dialog.show()
                        }
                    }
                }
            } else {
                // Mostrar un AlertDialog si algún campo está vacío
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Campos vacíos")
                builder.setMessage("Por favor, completa todos los campos.")
                builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                    dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                }

                val dialog = builder.create()
                dialog.show()
            }
        }
    }
}