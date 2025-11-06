package com.jetpack.paymentflowtest.widgets.pickers

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.wheel_picker_compose.WheelDatePicker
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(
    currentDate: Date = Date(),
    onDateSelected: (Date) -> Unit,
    onDismiss: () -> Unit
) {
    val calendar = Calendar.getInstance().apply { time = currentDate }

    var selectedMonth by remember { mutableStateOf(calendar.get(Calendar.MONTH) + 1) }
    var selectedDay by remember { mutableStateOf(calendar.get(Calendar.DAY_OF_MONTH)) }
    var selectedYear by remember { mutableStateOf(calendar.get(Calendar.YEAR)) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .width(36.dp)
                    .height(5.dp)
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(2.5.dp))
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Start Date",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        color = Color(0xFF212121),
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        letterSpacing = 0.sp,
                        fontWeight = FontWeight.Medium,
                    ),
                    textAlign = TextAlign.Center
                )
                TextButton(
                    onClick = {
                        val resultCalendar = Calendar.getInstance()
                        resultCalendar.set(selectedYear, selectedMonth - 1, selectedDay)
                        onDateSelected(resultCalendar.time)
                        onDismiss()
                    },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        "Done",
                        color = Color(0xFF0066FF),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WheelDatePicker { snappedDate ->
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        selectedMonth = snappedDate.monthValue
                        selectedDay = snappedDate.dayOfMonth
                        selectedYear = snappedDate.year
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}