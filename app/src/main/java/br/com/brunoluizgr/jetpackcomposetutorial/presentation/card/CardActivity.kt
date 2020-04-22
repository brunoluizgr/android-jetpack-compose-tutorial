package br.com.brunoluizgr.jetpackcomposetutorial.presentation.card

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import br.com.brunoluizgr.jetpackcomposetutorial.R

class CardActivity : AppCompatActivity() {

    companion object {
        fun newInstance(origin: Context) = Intent(origin, CardActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Root()
            }
        }
    }

    @Preview
    @Composable
    fun Root() {
        FlexColumn {
            inflexible {
                TopBar()
            }
            expanded(flex = 1f) {
                VerticalScroller {
                    Column {
                        for (i in 1..10) {
                            CardView()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun TopBar() {
        TopAppBar<String>(title = {
            Text(text = "Cards")
        }, actionData = emptyList()) {

        }
    }

    @Composable
    fun CardView() {
        Padding(padding = 16.dp) {
            Card(shape = RoundedCornerShape(8.dp), elevation = 2.dp) {
                val image = +imageResource(R.drawable.universe)
                Column(modifier = Spacing(0.dp, 0.dp, 0.dp, 16.dp)) {
                    Container(expanded = true, height = 200.dp) {
                        Clip(shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)) {
                            DrawImage(image = image)
                        }
                    }

                    HeightSpacer(height = 8.dp)

                    Column(modifier = Spacing(16.dp, 0.dp, 0.dp, 0.dp)) {
                        Text(text = "The Universe", style = TextStyle(fontSize = 16.sp, color = Color.Black))
                        Text(text = "It`s very big !! ", style = TextStyle(fontSize = 12.sp, color = Color.Gray))
                    }
                }

            }
        }
    }
}