package com.opendroid.ai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.opendroid.ai.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsOfUseScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "УСЛОВИЯ ИСПОЛЬЗОВАНИЯ",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        fontSize = 20.sp,
                        letterSpacing = 2.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = TextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBackground)
            )
        },
        containerColor = DarkBackground
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // Header card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, BorderColor, RoundedCornerShape(12.dp)),
                    colors = CardDefaults.cardColors(containerColor = CardBackground)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Description,
                            contentDescription = "Terms",
                            tint = AccentCyan,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Условия использования",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = "Вступает в силу: май 2026 г.",
                                fontSize = 12.sp,
                                color = TextSecondary
                            )
                        }
                    }
                }
            }

            item {
                PolicySection(
                    title = "1. ПРИНЯТИЕ УСЛОВИЙ",
                    content = "By downloading, installing, or using OpenDroid (\"the App\"), you agree to be bound by these Terms of Use. " +
                            "If you do not agree to these terms, do not use the App.\n\n" +
                            "OpenDroid — это автономный искусственный помощник с открытым исходным кодом для Android. Эти условия регулируют использование вами Приложения и всех связанных с ним услуг."
                )
            }

            item {
                PolicySection(
                    title = "2. РАЗРЕШЕННОЕ ИСПОЛЬЗОВАНИЕ",
                    content = "You may use OpenDroid for personal, non-commercial purposes including:\n\n" +
                            "• Automating device tasks (messaging, calls, alarms, etc.)\n" +
                            "• Managing smart home devices\n" +
                            "• Searching the web and retrieving information\n" +
                            "• File management and device control\n" +
                            "• Voice-activated commands\n\n" +
                            "You agree NOT to use OpenDroid to:\n\n" +
                            "• Violate any laws or regulations\n" +
                            "• Harass, spam, or harm other individuals\n" +
                            "• Attempt to bypass device security or access unauthorized systems\n" +
                            "• Вредное вмешательство в работу других приложений."
                )
            }

            item {
                PolicySection(
                    title = "3. КЛЮЧИ API И СТОРОННИЕ УСЛУГИ",
                    content = "OpenDroid connects to third-party LLM providers (Google Gemini, OpenAI, Anthropic, etc.) using API keys you provide.\n\n" +
                            "• You are responsible for obtaining and managing your own API keys.\n" +
                            "• API key usage is subject to the respective provider's terms of service.\n" +
                            "• OpenDroid is not responsible for charges incurred through third-party API usage.\n" +
                            "• Ваши ключи API хранятся локально на вашем устройстве с использованием шифрования AES-256 и никогда не передаются на серверы OpenDroid."
                )
            }

            item {
                PolicySection(
                    title = "4. УСЛУГА ДОСТУПНОСТИ",
                    content = "OpenDroid uses Android's Accessibility Service to perform on-screen automations on your behalf. " +
                            "By enabling this service, you acknowledge that:\n\n" +
                            "• The service can interact with other apps on your device\n" +
                            "• It only acts when you explicitly give a command\n" +
                            "• You can disable it at any time from Android Settings\n" +
                            "• OpenDroid не использует эту службу для сбора или передачи данных."
                )
            }

            item {
                PolicySection(
                    title = "5. ОТКАЗ ОТ ГАРАНТИЙ",
                    content = "OpenDroid is provided \"AS IS\" without warranties of any kind, either express or implied.\n\n" +
                            "• We do not guarantee uninterrupted or error-free operation.\n" +
                            "• AI-generated responses may be inaccurate or incomplete.\n" +
                            "• Automated actions may not execute as intended in all scenarios.\n" +
                            "• Вы принимаете на себя все риски, связанные с использованием Приложения."
                )
            }

            item {
                PolicySection(
                    title = "6. ОГРАНИЧЕНИЕ ОТВЕТСТВЕННОСТИ",
                    content = "To the maximum extent permitted by law, the OpenDroid developers shall not be liable for any " +
                            "direct, indirect, incidental, special, or consequential damages arising from:\n\n" +
                            "• Use or inability to use the App\n" +
                            "• Unauthorized access to your data\n" +
                            "• Actions performed by the AI assistant\n" +
                            "• Сбои в работе сторонних служб или списание средств."
                )
            }

            item {
                PolicySection(
                    title = "7. ОТКРЫТЫЙ ИСТОЧНИК",
                    content = "OpenDroid is open-source software. You are free to view, modify, and distribute the source code " +
                            "в соответствии с условиями лицензии проекта. Вклады в проект приветствуются и регулируются руководящими принципами проекта."
                )
            }

            item {
                PolicySection(
                    title = "8. ИЗМЕНЕНИЯ В УСЛОВИЯХ",
                    content = "We may update these terms from time to time. Changes will be reflected in the App with an updated effective date. " +
                            "Продолжение использования OpenDroid после внесения изменений означает принятие обновленных условий."
                )
            }

            item {
                PolicySection(
                    title = "9. КОНТАКТЫ",
                    content = "Если у вас есть вопросы по настоящим Условиям использования, откройте вопрос в нашем репозитории GitHub (JMAN730/opendroid) или обратитесь к команде разработчиков в Discord."
                )
            }
        }
    }
}
