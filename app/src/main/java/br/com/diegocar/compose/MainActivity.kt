    package br.com.diegocar.compose


import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.diegocar.compose.ui.theme.ComposeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")
                    // MainScreenPreview()
                    MainScreen()

                }
            }
        }
    }
}

    @Composable
    fun ClickCounter(clicks: Int, onClick: () -> Unit){
        Column {
            Button(onClick = onClick){
                Text("Testando");
            }
        }
    }

    @Composable
    fun MainScreen() {
        var clicks by remember {mutableStateOf(0)}

        //RowsColumns()
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            ClickCounter(clicks = clicks){
                clicks++
            }

            HelloContent()
        }
    }


    @Composable //Estados
    fun HelloContent() {
        Column(modifier = Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }
            if (name.isNotEmpty()) {
                Text(
                    text = "Hello, $name!",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
        }
    }

    @Composable
    private fun RowsColumns() {
        DogCard(
            dog = Dog("Luna", "Chow Chow"),
            modifier = Modifier.background(Color.Green)
        )
        DogCard(
            dog = Dog("Orbs", "Caramelo"),
            modifier = Modifier.background(Color.Blue)
        )
    }

    data class Dog(
        val name: String,
        val breed: String,
    )

    @Composable
    fun DogCard(
        dog: Dog,
        modifier: Modifier = Modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_bus),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )

            Column{
                Text(text = dog.name)
                Text(text = dog.breed)
            }
        }
    }













    @Composable
    private fun TestingButton() {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFFFEB3B))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bus),
                contentDescription = null,
                tint = Color.Black
            )
            Text(
                text = "Confirmar",
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    @Composable
    private fun TestingColumns() {
        Column(
            Modifier
                .background(Color.Red)
                .fillMaxSize()
        ) {
            Text(
                text = "Hello world",
                maxLines = 3,
                fontStyle = FontStyle.Italic,
                style = TextStyle(
                    fontSize = 25.sp,
                    shadow = Shadow(
                        color = Color.White
                    ),
                    color = Color.Black
                ),
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth()
            )
            Text(
                text = "Outro qualquer coisa",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth()
            )
            Row {
                Text(text = "Text 3", modifier = Modifier.padding(end = 30.dp))
                Text(text = "Text 4")
            }
        }
    }

    @Preview
    @Composable
    fun MainScreenPreview(){
        MainScreen()
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}