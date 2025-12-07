package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text


// Активность расширяет Component Activity
// Component Activity - для определения базовой активности, которая использует для UI Compose
class MainActivity : ComponentActivity() {

    // Переопределяет onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        // Вызывает onCreate() в суперклассе
        super.onCreate(savedInstanceState)

        // Задает содержимое активности
        // Файл расширения для включения компонентов Compose в UI Activity
        setContent {

            // Вывод текста - аналог TextView
            Text("Hello friend! Welcome to Jetpack Compose.")
        }
    }
}