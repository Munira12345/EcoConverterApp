package com.example.ecoconverterapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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


// A data class to rep single item in our history list.
data class FileHistoryItem(
    val fileName: String,
    val date: String,
    val icon: ImageVector
)

// A dummy list of different files to appear here
val dummyHistory = listOf(
    FileHistoryItem("Project_Report.pdf", "Dec 1, 2024", Icons.Default.PictureAsPdf),
    FileHistoryItem("Vacation_Photo.jpg", "Nov 28, 2024", Icons.Default.Image),
    FileHistoryItem("Meeting_Notes.docx", "Nov 25, 2024", Icons.Default.Description),
    FileHistoryItem("Recipe_Ideas.png", "Nov 20, 2024", Icons.Default.Image),
    FileHistoryItem("Financial_Summary.docx", "Nov 15, 2024", Icons.Default.Description),
    FileHistoryItem("Hiking_Map.pdf", "Nov 10, 2024", Icons.Default.PictureAsPdf),
    FileHistoryItem("Client_Proposal.docx", "Nov 8, 2024", Icons.Default.Description),
    FileHistoryItem("Team_Photo.jpg", "Nov 5, 2024", Icons.Default.Image),
    FileHistoryItem("Tax_Documents.pdf", "Nov 1, 2024", Icons.Default.PictureAsPdf),
    FileHistoryItem("Personal_Essay.docx", "Oct 28, 2024", Icons.Default.Description),
    FileHistoryItem("Selfie.png", "Oct 25, 2024", Icons.Default.Image),
    FileHistoryItem("Training_Plan.pdf", "Oct 20, 2024", Icons.Default.PictureAsPdf),
    FileHistoryItem("Travel_Itinerary.docx", "Oct 15, 2024", Icons.Default.Description),
)


@Composable
fun HistoryScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "File History",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(dummyHistory) { item ->
                    HistoryItemRow(item = item)
                }
            }
        }
    }
}

@Composable
fun HistoryItemRow(item: FileHistoryItem) {
    // A single row for a history item
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                imageVector = item.icon,
                contentDescription = item.fileName,
                tint = Color(0xFF66BB6A),
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = item.fileName,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp)
            )
        }


        Text(
            text = item.date,
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Light
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    EcoConverterAppTheme {
        HistoryScreen()
    }
}
