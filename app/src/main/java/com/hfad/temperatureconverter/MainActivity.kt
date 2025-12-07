package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


// Активность расширяет Component Activity
// Component Activity - для определения базовой активности, которая использует для UI Compose
// AppCompatActivity наследник ComponentActivity
class MainActivity : ComponentActivity() {

    // Переопределяет onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        // Вызывает onCreate() в суперклассе
        super.onCreate(savedInstanceState)

        // Задает содержимое активности
        // Файл расширения для включения компонентов Compose в UI Activity
        setContent {

            // Выстраивание компонентов в столбец
            Column {
                Hello("friend")
                Hello("everyone")
            }
        }
    }
}


// Компонентная функция - компонент Compose
@Composable
fun Hello(name: String) {

    // Вывод текста - аналог TextView
    Text("Hello $name! Welcome to Jetpack Compose")
}


@Preview
@Composable
fun PreviewMainActivity() {
    Column {
        Hello("friend")
        Hello("everyone")
    }
}