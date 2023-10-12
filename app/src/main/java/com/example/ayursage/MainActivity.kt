package com.example.ayursage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ayursage.navigation.NavGraph
import com.example.ayursage.ui.theme.AyursageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AyursageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController:NavHostController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}

val actorsList = listOf(
    "Leonardo DiCaprio",
    "Chris Evans",
    "Brad Pitt",
    "Elizabeth Olsen",
    "Kate Winslet",
    "Tom Holland",
    "Joseph Gordon-Levitt",
    "Scarlett Johansson",
    "Anne Hathaway",
    "Meryl Streep",
    "Tom Hardy",
    "Tom Cruise",
    "Sandra Bullock",
    "Charlize Theron",
    "Dakota Johnson",
    "James Franco",
    "Paul Rudd",
    "Jennifer Lawrence",
    "Benedict Cumberbatch",
    "Hugh Jackman",
    "Tom Hiddleston",
    "Anna Kendrick",
    "Daniel Craig",
    "Shah Rukh Khan",
    "Will Smith",
    "George Clooney",
    "Liam Neeson",
    "Angelina Jolie",
    "Michael Fassbender",
    "Idris Elba",
    "Russell Crowe",
    "Ryan Gosling",
    "Ben Affleck",
    "Chris Hemsworth",
    "Margot Robbie",
    "Emma Stone",
    "Natalie Portman",
    "Tom Hanks",
    "Denzel Washington",
    "Mark Wahlberg",
    "Matt Damon",
    "Chris Pratt",
    "Samuel L. Jackson",
    "Johnny Depp",
    "Robert Downey Jr",
    "Christian Bale",
    "Matthew McConaughey",
    "Morgan Freeman",
    "Jake Gyllenhaal",
    "Jeremy Renner",
    "Dwayne Johnson",
    "Michael B. Jordan",
    "Mark Ruffalo",
    "Jesse Eisenberg",
    "Keanu Reeves",
)