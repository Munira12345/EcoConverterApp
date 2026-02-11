package com.example.ecoconverterapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
            .background(LightGreen.copy(alpha = 0.15f)),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            shape = RoundedCornerShape(28.dp),
            color = Color.White,
            shadowElevation = 10.dp
        ) {

            Column(
                modifier = Modifier
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Title
                Text(
                    text = "File Ready 🎉",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Your file has been successfully converted",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(28.dp))

                // File Type Badge
                Surface(
                    shape = RoundedCornerShape(50),
                    color = LightGreen.copy(alpha = 0.2f)
                ) {
                    Text(
                        text = fileType.uppercase(),
                        modifier = Modifier.padding(
                            horizontal = 24.dp,
                            vertical = 8.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF2E7D32)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Download Button
                Button(
                    onClick = { /* TODO: download logic */ },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)

                ) {
                    Text(
                        text = "Download File",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                }

                Spacer(modifier = Modifier.height(16.dp))

                // Share Button
                OutlinedButton(
                    onClick = { /* TODO: share logic */ },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        text = "Share",
                        fontSize = 16.sp
                    )
                }
            }
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

