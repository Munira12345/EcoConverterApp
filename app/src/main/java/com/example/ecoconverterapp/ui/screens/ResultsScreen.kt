package com.example.ecoconverterapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecoconverterapp.ui.theme.EcoConverterAppTheme
import com.example.ecoconverterapp.ui.theme.LightGreen


@Composable
fun ResultsScreen(fileType: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier =Modifier.height(64.dp))
            Text(
                text = "your file is ready",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text =fileType,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color= Color.Black
            )

            Spacer(modifier = Modifier.height(64.dp))


            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = "Converted File",
                tint = Color(0xFF66BB6A),
                modifier = Modifier.size(120.dp)

            )
            Spacer(modifier =Modifier.weight(1f))


            Text(
                text = "Share to",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color= Color.Black

            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = "Facebook",
                    tint = Color.Black,
                    modifier = Modifier.size(48.dp)
                )
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = "Instagram",
                    tint = Color.Black,
                    modifier = Modifier.size(48.dp)
                )
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = "Whatsapp",
                    tint = Color.Black,
                    modifier = Modifier.size(48.dp)
                )
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = "Download",
                    tint = Color(0xFF66BB6A),
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ResultsScreenPreview() {
    EcoConverterAppTheme {
        ResultsScreen(fileType = "PNG")
    }
}



