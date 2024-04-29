// SplashScreenActivity.kt
package com.example.projeto_streetartcei

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Delay para a tela de splash
        Handler().postDelayed({
            // Após o tempo de atraso, iniciar a atividade de login
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }

    companion object {
        // Tempo de atraso em milissegundos (3 segundos, por exemplo)
        private const val SPLASH_DELAY: Long = 3000
    }
}
