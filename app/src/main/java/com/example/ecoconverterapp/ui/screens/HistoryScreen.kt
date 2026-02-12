package com.example.ecoconverterapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecoconverterapp.ui.theme.EcoConverterAppTheme
import com.example.ecoconverterapp.ui.theme.LightGreen


// Data model
data class FileHistoryItem(
    val fileName: String,
    val date: String,
    val icon: ImageVector
)

// Dummy list
val dummyHistory = listOf(
    FileHistoryItem("Project_Report.pdf", "Dec 1, 2024", Icons.Default.PictureAsPdf),
    FileHistoryItem("Vacation_Photo.jpg", "Nov 28, 2024", Icons.Default.Image),
    FileHistoryItem("Meeting_Notes.docx", "Nov 25, 2024", Icons.Default.Description),
    FileHistoryItem("Recipe_Ideas.png", "Nov 20, 2024", Icons.Default.Image),
    FileHistoryItem("Financial_Summary.docx", "Nov 15, 2024", Icons.Default.Description),
    FileHistoryItem("Hiking_Map.pdf", "Nov 10, 2024", Icons.Default.PictureAsPdf),
)

@Composable
fun HistoryScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen.copy(alpha = 0.15f))
            .padding(horizontal = 20.dp),
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "File History",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your recently converted files",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(dummyHistory) { item ->
                    HistoryItemCard(item = item)
                }
            }
        }
    }
}

@Composable
fun HistoryItemCard(item: FileHistoryItem) {

    Surface(
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 6.dp,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Icon container
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = LightGreen.copy(alpha = 0.2f)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.fileName,
                    tint = Color(0xFF2E7D32),
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.fileName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.date,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    EcoConverterAppTheme {
        HistoryScreen()
    }
}
