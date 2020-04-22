package br.com.brunoluizgr.jetpackcomposetutorial.presentation.card

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme

class CardActivity : AppCompatActivity() {

    companion object{
        fun newInstance(origin: Context) = Intent(origin, CardActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
               Greeting()
            }
        }
    }


    @Composable
    fun Greeting(){
        Text(text = "Card Activity")
    }
}