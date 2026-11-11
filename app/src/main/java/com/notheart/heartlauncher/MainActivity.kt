package com.notheart.heartlauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.style.TextOverflow

private val Blue = Color(0xFF24559A)
private val BlueDark = Color(0xFF12396D)
private val Green = Color(0xFF60C84E)
private val Dark = Color(0xFF171C24)
private val White = Color(0xFFF8F8F8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =
            android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContent {
            MaterialTheme {
                HeartHome()
            }
        }
    }
}

@Composable
fun HeartHome() {
    var username by remember { mutableStateOf("NotHeartYT") }
    var version by remember { mutableStateOf("Fabric • 1.21.11") }
    var status by remember { mutableStateOf("Ready to play") }

    Box(Modifier.fillMaxSize()) {

        MinecraftBackground()

        // Top profile
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DarkButton("♟") {
                status = "Profile settings"
            }

            Spacer(Modifier.width(8.dp))

            Row(
                modifier = Modifier
                    .shadow(7.dp, RoundedCornerShape(5.dp))
                    .background(Dark)
                    .border(2.dp, Color(0xFF343C49))
                    .padding(horizontal = 13.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("👤", fontSize = 24.sp)
                Spacer(Modifier.width(9.dp))
                Column {
                    Text(
                        username,
                        color = White,
                        fontWeight = FontWeight.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        "Offline nickname",
                        color = Color.LightGray,
                        fontSize = 11.sp
                    )
                }
                Spacer(Modifier.width(12.dp))
                Text("⌄", color = White, fontSize = 20.sp)
            }

            Spacer(Modifier.width(8.dp))

            DarkButton("🎁") {
                status = "Rewards coming soon"
            }

            Spacer(Modifier.width(7.dp))

            DarkButton("⚙") {
                status = "Settings coming soon"
            }
        }

        // Left navigation
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            MenuTile(
                "SHOP",
                "Bonus waiting",
                Color(0xFF9C183C),
                "🎁"
            ) {
                status = "Shop coming soon"
            }

            MenuTile(
                "MY SKIN",
                "Customize player",
                Color(0xFF17639B),
                "👤"
            ) {
                status = "Skin manager coming soon"
            }

            MenuTile(
                "PLAY WITH FRIENDS",
                "Find your team",
                Color(0xFF347A38),
                "👥"
            ) {
                status = "Friends coming soon"
            }
        }

        // Center Minecraft character
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-5).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlayerAvatar()

            Text(
                username,
                color = White,
                fontWeight = FontWeight.Black,
                fontSize = 13.sp
            )
        }

        // Status chip
        Text(
            status,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 112.dp)
                .background(
                    Dark.copy(alpha = 0.8f),
                    RoundedCornerShape(5.dp)
                )
                .padding(horizontal = 12.dp, vertical = 5.dp),
            color = White,
            fontSize = 11.sp
        )

        // Bottom game controls
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Selected installation
            Column(
                modifier = Modifier
                    .weight(1.35f)
                    .shadow(9.dp, RoundedCornerShape(4.dp))
                    .background(Blue)
                    .border(4.dp, BlueDark)
                    .padding(13.dp)
            ) {
                Text(
                    "START HERE",
                    color = Color(0xFFB9CCE8),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.sp
                )

                Spacer(Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📦", fontSize = 29.sp)
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(
                            "Heart Optimization",
                            color = White,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            version,
                            color = Color(0xFFD5E4FA),
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(Modifier.width(12.dp))

            // Play area
            Column(
                modifier = Modifier.weight(0.95f),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Button(
                    onClick = {
                        status = "Minecraft runtime is not connected yet"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp)
                        .shadow(7.dp, RoundedCornerShape(3.dp)),
                    shape = RoundedCornerShape(3.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green,
                        contentColor = Color(0xFF102B12)
                    ),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    Icon(
                        Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "Play",
                        fontSize = 21.sp,
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
                        status = "Selected: $version"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(39.dp),
                    shape = RoundedCornerShape(3.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD477),
                        contentColor = Dark
                    )
                ) {
                    Text(
                        "📦  Change Version",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }

        // Help button
        Button(
            onClick = { status = "Heart Launcher Help" },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 15.dp, bottom = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Dark
            ),
            shape = RoundedCornerShape(3.dp)
        ) {
            Icon(Icons.Default.Help, contentDescription = null)
            Text("Help")
        }
    }
}

@Composable
fun MinecraftBackground() {
    Canvas(Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Sky
        drawRect(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0xFF0874B8),
                    Color(0xFF54A8D0),
                    Color(0xFFB0C9C9)
                )
            )
        )

        // Clouds
        val clouds = listOf(
            listOf(0.18f, 0.20f),
            listOf(0.45f, 0.13f),
            listOf(0.78f, 0.21f),
            listOf(0.92f, 0.12f)
        )

        clouds.forEach {
            val x = w * it[0]
            val y = h * it[1]

            drawRect(
                Color(0xFFDDE8E9),
                topLeft = androidx.compose.ui.geometry.Offset(x, y),
                size = androidx.compose.ui.geometry.Size(
                    w * 0.11f, h * 0.045f
                )
            )
            drawRect(
                Color(0xFFF0F3F1),
                topLeft = androidx.compose.ui.geometry.Offset(
                    x + w * 0.02f, y - h * 0.025f
                ),
                size = androidx.compose.ui.geometry.Size(
                    w * 0.065f, h * 0.035f
                )
            )
        }

        // Mountains
        val mountain = Path().apply {
            moveTo(0f, h * 0.68f)
            lineTo(w * 0.18f, h * 0.42f)
            lineTo(w * 0.30f, h * 0.65f)
            lineTo(w * 0.49f, h * 0.45f)
            lineTo(w * 0.68f, h * 0.67f)
            lineTo(w * 0.85f, h * 0.43f)
            lineTo(w, h * 0.62f)
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(mountain, Color(0xFF796F61))

        // Snow caps
        drawRect(
            Color(0xFFD5D0C3),
            topLeft = androidx.compose.ui.geometry.Offset(0f, h * 0.68f),
            size = androidx.compose.ui.geometry.Size(w, h * 0.08f)
        )

        // Foreground terrain
        drawRect(
            Color(0xFF536F3B),
            topLeft = androidx.compose.ui.geometry.Offset(0f, h * 0.79f),
            size = androidx.compose.ui.geometry.Size(w, h * 0.21f)
        )

        // Grass layer
        drawRect(
            Color(0xFF659747),
            topLeft = androidx.compose.ui.geometry.Offset(0f, h * 0.79f),
            size = androidx.compose.ui.geometry.Size(w, h * 0.025f)
        )

        // Block terrain details
        for (i in 0..17) {
            val x = i * w / 17f
            drawRect(
                Color(0xFF405D32),
                topLeft = androidx.compose.ui.geometry.Offset(
                    x, h * (0.84f + (i % 3) * 0.025f)
                ),
                size = androidx.compose.ui.geometry.Size(
                    w * 0.04f, h * 0.08f
                )
            )
        }
    }
}

@Composable
fun PlayerAvatar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Head
        Box(
            modifier = Modifier
                .size(78.dp)
                .shadow(7.dp)
                .background(Color(0xFF9A765E))
                .border(3.dp, Color(0xFF49372D))
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(21.dp)
                    .background(Color(0xFF51443B))
                    .align(Alignment.TopCenter)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    Modifier
                        .size(17.dp, 8.dp)
                        .background(Color.Black)
                )
                Box(
                    Modifier
                        .size(17.dp, 8.dp)
                        .background(Color.Black)
                )
            }
        }

        // Body and arms
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Box(
                Modifier
                    .padding(top = 8.dp)
                    .size(19.dp, 85.dp)
                    .background(Color(0xFFC49577))
            )

            Box(
                Modifier
                    .size(76.dp, 105.dp)
                    .background(Color(0xFFF0F0F0))
                    .border(3.dp, Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "H",
                    color = Color.Black,
                    fontSize = 39.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Box(
                Modifier
                    .padding(top = 8.dp)
                    .size(19.dp, 85.dp)
                    .background(Color(0xFFC49577))
            )
        }

        // Legs
        Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
            Box(
                Modifier
                    .size(36.dp, 52.dp)
                    .background(Color(0xFF242424))
            )
            Box(
                Modifier
                    .size(36.dp, 52.dp)
                    .background(Color(0xFF242424))
            )
        }
    }
}

@Composable
fun DarkButton(
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(43.dp)
            .shadow(5.dp, RoundedCornerShape(3.dp)),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Dark
        ),
        shape = RoundedCornerShape(3.dp)
    ) {
        Text(title, fontSize = 19.sp)
    }
}

@Composable
fun MenuTile(
    title: String,
    subtitle: String,
    color: Color,
    icon: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .shadow(7.dp, RoundedCornerShape(3.dp))
            .background(color)
            .border(3.dp, Color(0xFF20252B))
            .clickable { onClick() }
            .padding(10.dp)
    ) {
        Text(icon, fontSize = 22.sp)

        Text(
            title,
            color = White,
            fontWeight = FontWeight.Black,
            fontSize = 13.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            subtitle,
            color = Color.White.copy(alpha = 0.9f),
            fontSize = 10.sp
        )
    }
}
