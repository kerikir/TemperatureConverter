package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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



@Composable
fun Header(image: Int, description: String) {

    // Вывод избражения
    // painter - указывает какое изображение
    // content description - описание изображения для огр. возм.
    // modifier - дополнительные настройки компонента Compose
    // content scale - масштабирование изображения
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}



@Composable
fun TemperatureText(celsius: Int) {
    val fahrenheit = (celsius.toDouble() * 9/5) + 32
    Text("$celsius Celsius is $fahrenheit Fahrenheit")
}


/**
 * Кнопка для перевода температуры из Цельсия к шкале Фаренгейта
 * @param clicked Лямбда-выражение, которое выполняет кнопка при нажатии
 */
@Composable
fun ConvertButton(clicked: () -> Unit) {
    // Кнопка
    Button(onClick = clicked) {
        Text("Convert")
    }
}


@Composable
fun EnterTemperature(temperature: String, changed: (String) -> Unit) {

    // Поле для ввода
    /*
     value - начальная температура
     label - подсказка (hint)
     on value change - обработка изменения текста в EditText
     modifier - дополнительные настройки
     */
    TextField(
        value = temperature,
        label = { Text("Enter a temperature in Celsius") },
        onValueChange = changed,
        modifier = Modifier.fillMaxWidth()
    )
}


// Компонентная функция - компонент Compose
/** Основное содержание активности */
@Composable
fun MainActivityContent() {

    // Сохранение значения в памяти на время жизни компонента
    val celsius = remember { mutableStateOf(0) }
    val newCelsius = remember { mutableStateOf("") }

    // Выстраивание компонентов в столбец
    // Modifier - дополнительное поведение к компонентам
    // padding - внутренние отступы в dp
    // height - высота компонента в dp
    // fill max width - ширина компонента равна match_parent
    Column(modifier = Modifier.padding(16.dp)) {

        Header(R.drawable.sunrise, "sunrise image")

        EnterTemperature(newCelsius.value) {
            newCelsius.value = it
        }

        ConvertButton {
            newCelsius.value.toIntOrNull()?.let {
                celsius.value = it
            }
        }
        
        TemperatureText(celsius.value)
    }
}



// Preview - предварительный просмотр компонентной функции
// Show Background - установка заднего фона, чтобы не был прозрачным
@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    MainActivityContent()
}