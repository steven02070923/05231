package com.example.myapplication

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.lang.Exception

class MainActivity : ComponentActivity() {
    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
        try {
            db = this.openOrCreateDatabase("mydb", MODE_PRIVATE, null)
            db.execSQL(
                "create table tblAMIGO(recID integer PRIMARY KEY autoincrement," +
                        "name text," +
                        "phone text )"
            )
        }catch (e: Exception){
            Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_LONG).show()
        }
        db.execSQL("insert into tblAMIGO(name,phone) values ('James','0922')")

    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}