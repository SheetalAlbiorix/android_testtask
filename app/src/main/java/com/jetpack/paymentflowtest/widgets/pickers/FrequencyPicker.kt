package com.jetpack.paymentflowtest.widgets.pickers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.paymentflowtest.widgets.Selector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrequencyPicker(
    frequencies: List<String> = listOf("Weekly", "Monthly", "Yearly"),
    selectedFrequency: String,
    frequencySelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var frequency by remember { mutableStateOf(selectedFrequency) }

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
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Frequency",
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
                    frequencySelected(frequency)
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

        // Dynamic Features List
        frequencies.forEachIndexed { index, frequencyOption ->
            FeatureRow(
                label = frequencyOption,
                modifier = Modifier.clickable {
                    frequency = frequencyOption
                },
                isChecked = frequency == frequencyOption
            )

            // Add divider between items, but not after the last item
            if (index < frequencies.size - 1) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFFE3E6EB),
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

@Composable
fun FeatureRow(
    isChecked: Boolean = false,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    label: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF2F4F7))
                ) {
                    Icon(
                        it,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                            .padding(5.dp),
                        tint = Color(0xFF212121)
                    )
                }
            }
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF1C1E22),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            )
        }

        Box(
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Selector(isChecked = isChecked)
        }
    }
}