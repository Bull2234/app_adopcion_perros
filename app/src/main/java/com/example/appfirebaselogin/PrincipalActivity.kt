package com.example.appfirebaselogin


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.protocol.client.Subscription
import com.spotify.protocol.types.PlayerState
import com.spotify.protocol.types.Track


class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val Btn1 = findViewById<ImageButton>(R.id.Btn1)//dar en adopcion
        val Btn2 = findViewById<ImageButton>(R.id.Btn2)//adoptar

        Btn1.setOnClickListener(){
            val intent = Intent(this, DarEnAdopcionActivity::class.java)
            startActivity(intent)
        }
        Btn2.setOnClickListener(){
            val intent = Intent(this, AdoptarActivity::class.java)
            startActivity(intent)
        }

    }

}