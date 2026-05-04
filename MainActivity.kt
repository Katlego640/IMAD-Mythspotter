package com.example.mythspotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mythspotter.ui.theme.MythspotterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


                    MythspotterTheme {
                        // My variables for the assignment
                        var screen by remember { mutableStateOf("Welcome") }
                        var myScore by remember { mutableStateOf(0) }
                        var i by remember { mutableStateOf(0) } // using 'i' for the loop counter

                        // My 10 myths for the project
                        val myQuestions = listOf(
                            "Sugar makes kids hyper.",
                            "Goldfish only remember for 3 seconds.",
                            "Humans use 10% of their brain.",
                            "Bulls hate the color red.",
                            "Shaving makes hair grow back thicker.",
                            "Lightning never hits the same spot twice.",
                            "Cracking knuckles gives you arthritis.",
                            "Rice is the best way to fix a wet phone.",
                            "You can see the Great Wall from space.",
                            "Charging your phone overnight ruins the battery."
                        )

                        // All answers are false/myths for this set
                        val answers = listOf(
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false
                        )

                        Surface(modifier = Modifier.fillMaxSize()) {
                            when (screen) {
                                "Welcome" -> {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text("Mythspotter App")
                                        Button(onClick = { screen = "Quiz" }) {
                                            Text("Start")
                                        }
                                    }
                                }

                                "Quiz" -> {
                                    Column(
                                        modifier = Modifier.padding(15.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("Question ${i + 1} of 10")
                                        Spacer(modifier = Modifier.height(20.dp))
                                        Text(myQuestions[i])

                                        Row(modifier = Modifier.padding(top = 20.dp)) {
                                            Button(onClick = {
                                                if (answers[i] == true) {
                                                    myScore++
                                                }
                                                if (i < 9) {
                                                    i++
                                                } else {
                                                    screen = "Score"
                                                }
                                            }) { Text("True") }

                                            Spacer(modifier = Modifier.width(10.dp))

                                            Button(onClick = {
                                                if (answers[i] == false) {
                                                    myScore++
                                                }
                                                if (i < 9) {
                                                    i++
                                                } else {
                                                    screen = "Score"
                                                }
                                            }) { Text("False") }
                                        }
                                    }
                                }

                                "Score" -> {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text("You got $myScore / 10")
                                        if (myScore >= 7) {
                                            Text("Great job!")
                                        } else {
                                            Text("Keep practising!")
                                        }
                                        // Back button to satisfy the review/restart logic
                                        Button(onClick = {
                                            i = 0
                                            myScore = 0
                                            screen = "Welcome"
                                        }) { Text("Try Again") }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

