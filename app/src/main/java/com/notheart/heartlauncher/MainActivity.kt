package com.notheart.heartlauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF24569B)
private val Green = Color(0xFF5BC94B)
private val Dark = Color(0xFF17202B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                HeartLauncherHome()
            }
        }
    }
}

@Composable
fun HeartLauncherHome() {

    var version by remember {
        mutableStateOf("Fabric • 1.21.11")
    }

    var status by remember {
        mutableStateOf("Welcome to Heart Launcher!")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0876B8),
                        Color(0xFF55A9D1),
                        Color(0xFF8BAA82),
                        Color(0xFF344D32)
                    )
                )
            )
    ) {

        // Minecraft world ground
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(125.dp)
                .background(Color(0xFF526E3C))
        )

        // Top profile
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier
                    .background(Dark, RoundedCornerShape(5.dp))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White
                )

                Spacer(Modifier.width(8.dp))

                Column {
                    Text(
                        "NotHeartYT",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Offline nickname",
                        color = Color.LightGray,
                        fontSize = 11.sp
                    )
                }
            }

            Spacer(Modifier.width(8.dp))

            TopIcon(Icons.Default.CardGiftcard) {
                status = "Rewards coming soon!"
            }

            Spacer(Modifier.width(6.dp))

            TopIcon(Icons.Default.Settings) {
                status = "Settings coming soon!"
            }
        }

        // Left menu
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            MenuCard("SHOP", "Bonus waiting") {
                status = "Shop coming soon!"
            }

            MenuCard("MY SKIN", "Change appearance") {
                status = "Skin manager coming soon!"
            }

            MenuCard("PLAY WITH FRIENDS", "Multiplayer") {
                status = "Friends coming soon!"
            }
        }

        // Player placeholder
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 55.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(78.dp)
                    .background(Color(0xFF80624D))
                    .border(4.dp, Color(0xFF49382E)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "NH",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Box(
                modifier = Modifier
                    .size(width = 104.dp, height = 126.dp)
                    .background(Color.White)
                    .border(4.dp, Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "H",
                    color = Color.Black,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Text(
                "NOTHEARTYT",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        }

        // Bottom launcher controls
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(1.2f)
                    .background(Blue, RoundedCornerShape(5.dp))
                    .border(4.dp, Color(0xFF102F60))
                    .padding(13.dp)
            ) {

                Text(
                    "START HERE",
                    color = Color.LightGray,
                    fontSize = 11.sp
                )

                Text(
                    "Minecraft Java",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    version,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(0.9f),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {

                Button(
                    onClick = {
                        status =
                            "Minecraft runtime is not connected yet!"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Icon(
                        Icons.Default.PlayArrow,
                        contentDescription = null
                    )

                    Text(
                        "PLAY",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Black
                    )
                }

                Button(
                    onClick = {
                        version =
                            if (version.startsWith("Fabric")) {
                                "Vanilla • Latest"
                            } else {
                                "Fabric • 1.21.11"
                            }

                        status = "Version selected: $version"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD36C),
                        contentColor = Dark
                    )
                ) {
                    Text("Select Version")
                }
            }
        }

        Text(
            status,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(7.dp),
            color = Color.White,
            fontSize = 10.sp
        )
    }
}

@Composable
fun TopIcon(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(43.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Dark
        ),
        shape = RoundedCornerShape(5.dp)
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun MenuCard(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(158.dp)
            .height(70.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF205A86)
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                title,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp
            )

            Text(
                subtitle,
                color = Color.LightGray,
                fontSize = 10.sp
            )
        }
    }
}
