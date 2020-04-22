package br.com.brunoluizgr.jetpackcomposetutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import br.com.brunoluizgr.jetpackcomposetutorial.domain.Screen
import br.com.brunoluizgr.jetpackcomposetutorial.presentation.card.CardActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Root()
            }
        }
    }

    @Composable
    fun Root() {
        Column {
            Container(padding = EdgeInsets(0.dp, 56.dp, 0.dp, 56.dp)) {
                VerticalScroller {
                    Column(modifier = ExpandedWidth) {
                        for (screen in getScreenList()) {
                            ScreenView(screen = screen)
                        }
                    }
                }
            }
        }

        Column {
            TopBar()
        }
    }

    @Composable
    fun TopBar() {
        TopAppBar<String>(title = {
            Text(text = "Jetpack Compose")
        }, actionData = emptyList()) {

        }
    }

    @Composable
    fun ScreenView(screen: Screen) {
        Padding(padding = EdgeInsets(16.dp, 32.dp, 0.dp, 0.dp)) {
            Clickable(onClick = {
                startActivity(screen.intent)
            }) {
                Text(text = screen.title)
            }
        }
    }

    /**
     * Adicionar novas
     */
    fun getScreenList() = listOf(
        Screen("Card List Universe", CardActivity.newInstance(this)),
        Screen("Card Activity 2", CardActivity.newInstance(this)),
        Screen("Card Activity 3", CardActivity.newInstance(this)),
        Screen("Card Activity 4", CardActivity.newInstance(this))
    )


}




