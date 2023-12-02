package com.example.appfirebaselogin

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.log


class LoginActivity : AppCompatActivity() {
    // Write a message to the database

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)

        btnRegistrarse.setOnClickListener(){
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }

        btnIngresar.setOnClickListener(){
            val txtUsuario = findViewById<EditText>(R.id.txtCorreoUsuario)
            val correo:String = txtUsuario.text.toString().trim()

            val txtPassword = findViewById<EditText>(R.id.txtPassword)
            val contrasena:String = txtPassword.text.toString().trim()

            if (correo.isNotEmpty() && contrasena.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(correo, contrasena).addOnCompleteListener() {
                    if (it.isSuccessful) {
                        // Mostrar un AlertDialog si todo esta bien
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("Bienvenido")
                        builder.setMessage("Gracias por utilizar nuestra app")
                        builder.setIcon(R.drawable.verificacion)
                        builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                            dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                            val intent = Intent(this, PrincipalActivity::class.java)
                            startActivity(intent)
                        }

                        val dialog = builder.create()
                        dialog.show()

                    } else {
                        // Mostrar un AlertDialog si algún error ocurrio
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("Error de Autenticacion")
                        builder.setMessage("Por favor, Verifica de nuevo")
                        builder.setIcon(R.drawable.cancelar)
                        builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                            dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                        }

                        val dialog = builder.create()
                        dialog.show()
                    }
                }
            }else{
                // Mostrar un AlertDialog si algún campo está vacío
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Campos vacíos")
                builder.setMessage("Por favor, completa todos los campos.")
                builder.setIcon(R.drawable.cancelar)
                builder.setPositiveButton("Aceptar") { dialog: DialogInterface, _ ->
                    dialog.dismiss() // Cierra el diálogo cuando se hace clic en el botón "Aceptar"
                }

                val dialog = builder.create()
                dialog.show()
            }
        }

    }
}