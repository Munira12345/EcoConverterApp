package com.example.ecoconverterapp.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.ecoconverterapp.ui.theme.LightGreen
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcoScreen(navController: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenu(
                onHistoryClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate("history")
                },
                onResultsClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate("results")
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                EcoTopAppBar(
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            },
            containerColor = LightGreen
        ) { innerPadding ->

            // --- Your Existing UI ---
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Choose your file",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconWithText(icon = Icons.Filled.Image, text = "image(jpg)")
                        IconWithText(icon = Icons.Filled.TextSnippet, text = "word")
                        IconWithText(icon = Icons.Filled.PictureAsPdf, text = "pdf")
                        IconWithText(icon = Icons.Filled.Image, text = "image(png)")
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcoTopAppBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Eco Converter by Muni",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun DrawerMenu(
    onHistoryClick: () -> Unit,
    onResultsClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            "Menu",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "History",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clickable { onHistoryClick() }
        )

        Text(
            text = "Results",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clickable { onResultsClick() }
        )
    }
}

@Composable
fun IconWithText(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color(0xFF66BB6A),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EcoScreenPreview() {
    EcoScreen(navController = androidx.navigation.compose.rememberNavController())
}


