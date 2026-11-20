package com.cloudminer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF0B1220)
private val Panel = Color(0xFF172338)
private val Gold = Color(0xFFF2B84B)
private val Muted = Color(0xFF9AA9BD)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CloudMinerApp() }
    }
}

@Composable
private fun CloudMinerApp() {
    var showSetup by remember { mutableStateOf(false) }
    var providerName by remember { mutableStateOf("") }
    var apiBase by remember { mutableStateOf("") }
    var apiKey by remember { mutableStateOf("") }

    MaterialTheme(colorScheme = darkColorScheme(
        primary = Gold, background = Navy, surface = Panel,
        onPrimary = Navy, onBackground = Color.White, onSurface = Color.White
    )) {
        Surface(Modifier.fillMaxSize(), color = Navy) {
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("CLOUD MINER", color = Gold, fontSize = 27.sp, fontWeight = FontWeight.Black)
                Text("داشبورد اتصال به استخراج ابری بیت‌کوین", color = Muted)
                Card(colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(18.dp)) {
                    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("وضعیت اتصال", color = Muted)
                        Text("متصل نیست", color = Gold, fontSize = 23.sp, fontWeight = FontWeight.Bold)
                        Text("هیچ استخراج یا درآمدی تا زمان اتصال و تأیید اطلاعات یک سرویس‌دهنده واقعی گزارش نمی‌شود.", color = Muted, lineHeight = 21.sp)
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    MetricCard("قدرت هش", "—", Modifier.weight(1f))
                    MetricCard("درآمد واقعی", "—", Modifier.weight(1f))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    MetricCard("استخراج امروز", "—", Modifier.weight(1f))
                    MetricCard("موجودی BTC", "—", Modifier.weight(1f))
                }
                Button(onClick = { showSetup = !showSetup }, modifier = Modifier.fillMaxWidth()) {
                    Text(if (showSetup) "بستن تنظیمات اتصال" else "تنظیم سرویس‌دهنده")
                }
                if (showSetup) {
                    Card(colors = CardDefaults.cardColors(containerColor = Panel)) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Text("اطلاعات API سرویس‌دهنده", fontWeight = FontWeight.Bold)
                            OutlinedTextField(providerName, { providerName = it }, label = { Text("نام سرویس‌دهنده") }, modifier = Modifier.fillMaxWidth())
                            OutlinedTextField(apiBase, { apiBase = it }, label = { Text("آدرس API") }, modifier = Modifier.fillMaxWidth())
                            OutlinedTextField(apiKey, { apiKey = it }, label = { Text("کلید API") }, modifier = Modifier.fillMaxWidth())
                            Text("ذخیره‌سازی و اتصال تا زمان پیاده‌سازی API رسمی سرویس‌دهنده غیرفعال است. کلید API را فعلاً وارد نکنید.", color = Muted, fontSize = 12.sp)
                        }
                    }
                }
                Card(colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(18.dp)) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("هشدار امنیتی", color = Gold, fontWeight = FontWeight.Bold)
                        Text("برای استخراج ابری واقعی معمولاً باید قرارداد معتبر و سرویس‌دهنده قابل‌راستی‌آزمایی داشته باشید. به برنامه‌هایی که قبل از برداشت پول می‌خواهند یا سود تضمینی وعده می‌دهند اعتماد نکنید.", color = Muted, lineHeight = 21.sp)
                    }
                }
                Text("نسخه 1.0.0 • داشبورد شفاف؛ بدون موجودی و هش‌ریت ساختگی", color = Muted, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun MetricCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier, colors = CardDefaults.cardColors(containerColor = Panel), shape = RoundedCornerShape(16.dp)) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, color = Muted, fontSize = 12.sp)
            Text(value, color = Gold, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}
