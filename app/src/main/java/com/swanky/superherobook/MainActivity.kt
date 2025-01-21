package com.swanky.superherobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.swanky.superherobook.model.SuperHero
import com.swanky.superherobook.ui.theme.SuperHeroBookTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            SuperHeroBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "listScreen") {
                            composable("listScreen") {
                               SuperHeroList(superheros = getData(), navController = navController)
                            }
                            composable("detailScreen/{superHero}", arguments = listOf(
                                navArgument("superHero") {
                                    type = NavType.StringType
                                }
                            )) {
                                val superheroString = it.arguments?.getString("superHero")
                                val selectedSuperHero = Gson().fromJson(superheroString, SuperHero::class.java)
                                DetailScreen(superHero = selectedSuperHero)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getData(): List<SuperHero> {
        return listOf(
            SuperHero(
                name = "Superman",
                image = R.drawable.superman,
                description = "Man of Steel with superhuman strength and the ability to fly.",
                powerLevel = 95,
                team = "Justice League",
                abilities = listOf("Super Strength", "Flight", "Heat Vision", "X-Ray Vision"),
                originCity = "Metropolis",
                publisher = "DC",
                firstAppearanceYear = 1938
            ),
            SuperHero(
                name = "Iron Man",
                image = R.drawable.ironman,
                description = "Genius billionaire with a powerful suit of armor.",
                powerLevel = 90,
                team = "Avengers",
                abilities = listOf("Intelligence", "Flight", "Energy Beams"),
                originCity = "New York",
                publisher = "Marvel",
                firstAppearanceYear = 1963
            ),
            SuperHero(
                name = "Spider-Man",
                image = R.drawable.spiderman,
                description = "A young hero with spider-like abilities.",
                powerLevel = 85,
                team = "Avengers",
                abilities = listOf("Wall Crawling", "Spider Sense", "Web-Shooting"),
                originCity = "New York",
                publisher = "Marvel",
                firstAppearanceYear = 1962
            ),
            SuperHero(
                name = "Batman",
                image = R.drawable.batman,
                description = "The Dark Knight of Gotham City, a master detective and martial artist.",
                powerLevel = 85,
                team = "Justice League",
                abilities = listOf("Intelligence", "Martial Arts", "Stealth", "High-Tech Gadgets"),
                originCity = "Gotham City",
                publisher = "DC",
                firstAppearanceYear = 1939
            ),
            SuperHero(
                name = "Wonder Woman",
                image = R.drawable.wonderwoman,
                description = "Amazonian warrior princess with superhuman strength and combat skills.",
                powerLevel = 90,
                team = "Justice League",
                abilities = listOf(
                    "Super Strength",
                    "Lasso of Truth",
                    "Combat Skills",
                    "Immortality"
                ),
                originCity = "Themyscira",
                publisher = "DC",
                firstAppearanceYear = 1941
            ),
            SuperHero(
                name = "Hulk",
                image = R.drawable.hulk,
                description = "A scientist transformed into a green giant with unlimited strength.",
                powerLevel = 95,
                team = "Avengers",
                abilities = listOf("Super Strength", "Regeneration", "Durability"),
                originCity = "Dayton, Ohio",
                publisher = "Marvel",
                firstAppearanceYear = 1962
            ),
            SuperHero(
                name = "Thor",
                image = R.drawable.thor,
                description = "The Norse god of thunder, wielding the mighty hammer Mjölnir.",
                powerLevel = 95,
                team = "Avengers",
                abilities = listOf("Thunder Control", "Immortality", "Flight", "Super Strength"),
                originCity = "Asgard",
                publisher = "Marvel",
                firstAppearanceYear = 1962
            ),
            SuperHero(
                name = "Flash",
                image = R.drawable.flash,
                description = "The fastest man alive, capable of running at superhuman speeds.",
                powerLevel = 88,
                team = "Justice League",
                abilities = listOf("Super Speed", "Time Travel", "Phasing"),
                originCity = "Central City",
                publisher = "DC",
                firstAppearanceYear = 1940
            ),
            SuperHero(
                name = "Captain America",
                image = R.drawable.captain_america,
                description = "A super soldier and symbol of freedom, wielding an indestructible shield.",
                powerLevel = 85,
                team = "Avengers",
                abilities = listOf("Super Soldier Physique", "Shield Combat", "Tactics"),
                originCity = "Brooklyn, New York",
                publisher = "Marvel",
                firstAppearanceYear = 1941
            ),
            SuperHero(
                name = "Black Panther",
                image = R.drawable.black_panther,
                description = "King of Wakanda with enhanced abilities and a Vibranium suit.",
                powerLevel = 88,
                team = "Avengers",
                abilities = listOf(
                    "Enhanced Senses",
                    "Super Strength",
                    "Combat Skills",
                    "Vibranium Suit"
                ),
                originCity = "Wakanda",
                publisher = "Marvel",
                firstAppearanceYear = 1966
            ),
            SuperHero(
                name = "Doctor Strange",
                image = R.drawable.doctor_strange,
                description = "Master of the mystical arts and protector of Earth against magical threats.",
                powerLevel = 92,
                team = "Avengers",
                abilities = listOf("Magic", "Teleportation", "Time Manipulation"),
                originCity = "New York",
                publisher = "Marvel",
                firstAppearanceYear = 1963
            ),
            SuperHero(
                name = "Aquaman",
                image = R.drawable.aquaman,
                description = "King of Atlantis with control over sea life and superhuman abilities.",
                powerLevel = 85,
                team = "Justice League",
                abilities = listOf(
                    "Underwater Breathing",
                    "Super Strength",
                    "Animal Communication"
                ),
                originCity = "Atlantis",
                publisher = "DC",
                firstAppearanceYear = 1941
            ),
            SuperHero(
                name = "Wolverine",
                image = R.drawable.wolverine,
                description = "A mutant with regenerative healing and retractable claws.",
                powerLevel = 88,
                team = "X-Men",
                abilities = listOf("Regeneration", "Adamantium Claws", "Enhanced Senses"),
                originCity = "Alberta, Canada",
                publisher = "Marvel",
                firstAppearanceYear = 1974
            ),
            SuperHero(
                name = "Deadpool",
                image = R.drawable.deadpool,
                description = "A mercenary with a twisted sense of humor and incredible healing abilities.",
                powerLevel = 85,
                team = "X-Force",
                abilities = listOf("Regeneration", "Martial Arts", "Marksmanship"),
                originCity = "Canada",
                publisher = "Marvel",
                firstAppearanceYear = 1991
            ),
            SuperHero(
                name = "Ant-Man",
                image = R.drawable.antman,
                description = "A hero with the ability to shrink and grow using Pym Particles.",
                powerLevel = 80,
                team = "Avengers",
                abilities = listOf(
                    "Size Manipulation",
                    "Enhanced Strength (when small)",
                    "Insect Communication"
                ),
                originCity = "San Francisco",
                publisher = "Marvel",
                firstAppearanceYear = 1962
            ),
            SuperHero(
                name = "Shazam",
                image = R.drawable.shazam,
                description = "A young boy transformed into a magical hero with the wisdom of Solomon.",
                powerLevel = 90,
                team = "Justice League",
                abilities = listOf("Super Strength", "Flight", "Magic Lightning"),
                originCity = "Philadelphia",
                publisher = "DC",
                firstAppearanceYear = 1939
            ),
            SuperHero(
                name = "Scarlet Witch",
                image = R.drawable.scarlet_witch,
                description = "A powerful mutant with reality-altering powers and magical abilities.",
                powerLevel = 95,
                team = "Avengers",
                abilities = listOf("Reality Manipulation", "Magic", "Energy Blasts"),
                originCity = "Sokovia",
                publisher = "Marvel",
                firstAppearanceYear = 1964
            ),
            SuperHero(
                name = "Hawkeye",
                image = R.drawable.hawkeye,
                description = "A master archer and skilled marksman, fighting alongside the Avengers.",
                powerLevel = 75,
                team = "Avengers",
                abilities = listOf("Archery", "Marksmanship", "Hand-to-Hand Combat"),
                originCity = "Waverly, Iowa",
                publisher = "Marvel",
                firstAppearanceYear = 1964
            ),
            SuperHero(
                name = "Black Widow",
                image = R.drawable.black_widow,
                description = "A former spy turned hero, skilled in combat and espionage.",
                powerLevel = 80,
                team = "Avengers",
                abilities = listOf("Espionage", "Martial Arts", "Marksmanship"),
                originCity = "Volgograd, Russia",
                publisher = "Marvel",
                firstAppearanceYear = 1964
            ),
            SuperHero(
                name = "Joker",
                image = R.drawable.joker,
                description = "The Clown Prince of Crime, Batman's most iconic nemesis.",
                powerLevel = 75,
                team = "None",
                abilities = listOf("Mastermind", "Chemical Expertise", "Unpredictability"),
                originCity = "Gotham City",
                publisher = "DC",
                firstAppearanceYear = 1940
            ),
            SuperHero(
                name = "Venom",
                image = R.drawable.venom,
                description = "An alien symbiote that bonds with a host to become a powerful anti-hero.",
                powerLevel = 88,
                team = "None",
                abilities = listOf("Symbiote Abilities", "Super Strength", "Regeneration"),
                originCity = "New York",
                publisher = "Marvel",
                firstAppearanceYear = 1984
            )
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SuperHeroPreview() {
    SuperHeroBookTheme {

    }
}