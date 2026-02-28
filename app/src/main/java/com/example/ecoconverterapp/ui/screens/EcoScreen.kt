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
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.ecoconverterapp.ui.theme.LightGreen
import com.example.ecoconverterapp.ui.theme.Pink40
import com.example.ecoconverterapp.ui.theme.PurpleGrey40
import kotlinx.coroutines.launch
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcoScreen(navController: NavHostController, userName: String = "User") {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    // to improve the side menu next
    //
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
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            containerColor = LightGreen
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {



                //  pending implementation
                Text(
                    text = "Hi, $userName 👋",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                // ✨ Glowing Section
                GlowingCard()

                Spacer(modifier = Modifier.height(24.dp))

                // QUICK ACCESS title
                Text(
                    text = "Quick Access",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(12.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuickAccessLabel("Recent")
                    QuickAccessLabel("PDFs")
                    QuickAccessLabel("Word")
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Upload box
                UploadBox()
            }
        }
    }
}

@Composable
fun GlowingCard() {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = PurpleGrey40.copy(alpha = 0.4f),
        tonalElevation = 6.dp,
        shadowElevation = 12.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {

            // Search bar
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search your files...") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = buildAnnotatedString {
                    pushStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    append("Create an account")
                    pop()
                    append(" to access unlimited file conversions.")
                },
                fontSize = 14.sp,
                color = Color.Black.copy(alpha = 0.7f),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable {
                        // later: navigate to signup screen
                    }
            )

        }
    }
}
@Composable
fun QuickAccessLabel(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Black
    )
}
@Composable
fun UploadBox() {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        tonalElevation = 3.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { /* later: open file picker */ }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            //pending functionality
            Icon(
                imageVector = Icons.Default.ArrowUpward,
                contentDescription = "Upload",
                tint = LightGreen,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Click to upload",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "or drag & drop files",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcoTopAppBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Eco Converter App",
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


