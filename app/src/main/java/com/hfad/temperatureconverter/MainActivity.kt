package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
            MainActivityContent()
        }
    }
}


// Компонентная функция - компонент Compose
/** Основное содержание активности */
@Composable
fun MainActivityContent() {

}


// Preview - предварительный просмотр компонентной функции
// Show Background - установка заднего фона, чтобы не был прозрачным
@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    MainActivityContent()
}