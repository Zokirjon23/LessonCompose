package uz.lesson.lessoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.lesson.lessoncompose.ui.theme.LessonComposeTheme
import uz.lesson.lessoncompose.ui.theme.SplashScreen
import uz.lesson.lessoncompose.ui.theme.navigator.NavigationDispatcher
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigation : NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LessonComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigator(SplashScreen()){ navigate ->
                        LaunchedEffect(key1 = navigate){
                            navigation.dispatcher.onEach {
                                it.invoke(navigate)
                            }.collect()
                        }
                        CurrentScreen()
                    }

                }
            }
        }
    }


}

@Composable
fun Greeting(name: String) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

            }
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LessonComposeTheme {
        Greeting("Android")
    }
}
