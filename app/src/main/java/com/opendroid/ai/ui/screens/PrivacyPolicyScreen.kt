package com.opendroid.ai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
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
fun PrivacyPolicyScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ПОЛИТИКА КОНФИДЕНЦИАЛЬНОСТИ",
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
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Privacy",
                            tint = AccentCyan,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Ваша конфиденциальность имеет значение",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = "Последнее обновление: август 2026 г.",
                                fontSize = 12.sp,
                                color = TextSecondary
                            )
                        }
                    }
                }
            }

            // Section: Overview
            item {
                PolicySection(
                    title = "1. ОБЗОР",
                    content = "OpenDroid is an autonomous AI assistant that runs entirely on your Android device. " +
                            "We are committed to protecting your privacy and ensuring transparency about how your data is handled. " +
                            "Эта политика объясняет, какие данные собирает OpenDroid, как они используются и ваши права в отношении этих данных."
                )
            }

            // Section: Data Collection
            item {
                PolicySection(
                    title = "2. СБОР ДАННЫХ",
                    content = "OpenDroid processes the following data locally on your device:\n\n" +
                            "• Voice commands and text queries you provide\n" +
                            "• Device state information (battery level, WiFi status, connectivity)\n" +
                            "• Contact names for resolving communication actions\n" +
                            "• Conversation history for context-aware responses\n" +
                            "• User preferences and semantic memory facts you share\n\n" +
                            "Все данные хранятся в локальной базе данных Room на вашем устройстве. Разработчики OpenDroid не собирают никаких данных."
                )
            }

            // Section: LLM Providers
            item {
                PolicySection(
                    title = "3. ТРЕТЬИЕ ПОСТАВЩИКИ LLM",
                    content = "OpenDroid sends your queries to the LLM provider you configure (e.g., Google Gemini, OpenAI, Anthropic, Groq, etc.) " +
                            "to generate responses and action plans. Each provider has its own privacy policy governing how they handle your data.\n\n" +
                            "• Your API keys are stored locally on your device and are never transmitted to OpenDroid servers.\n" +
                            "• Query data sent to LLM providers is subject to their respective privacy policies.\n" +
                            "• Вы можете в любой момент сменить поставщика или использовать локальные модели (Ollama), чтобы данные полностью хранились на устройстве."
                )
            }

            // Section: Permissions
            item {
                PolicySection(
                    title = "4. РАЗРЕШЕНИЯ УСТРОЙСТВА",
                    content = "OpenDroid requests the following permissions to function:\n\n" +
                            "• Microphone — For voice command input\n" +
                            "• Accessibility Service — For automating app interactions (WhatsApp, etc.)\n" +
                            "• Contacts — For resolving contact names to phone numbers\n" +
                            "• Phone — For placing calls\n" +
                            "• SMS — For sending text messages\n" +
                            "• Camera — For taking photos/flashlight control\n" +
                            "• Storage — For file management actions\n" +
                            "• Location — For weather and directions features\n\n" +
                            "Все разрешения являются необязательными. Функции, требующие непредоставленных разрешений, будут плавно ухудшаться или предлагать вам."
                )
            }

            // Section: Accessibility Service Declaration
            item {
                PolicySection(
                    title = "4б. УСЛУГА ДОСТУПНОСТИ",
                    content = "OpenDroid uses Android Accessibility Service to automate app interactions " +
                            "(such as sending WhatsApp messages) when you explicitly request it.\n\n" +
                            "The Accessibility Service:\n\n" +
                            "• Only activates when you enable it in Android Settings\n" +
                            "• Only acts when you give OpenDroid a command\n" +
                            "• Does NOT run in the background without your command\n" +
                            "• Does NOT read passwords or banking information\n" +
                            "• Does NOT record or log screen content passively\n" +
                            "• Does NOT collect, store, or transmit any data observed through the Accessibility Service to external servers\n\n" +
                            "The service is used solely to perform on-screen actions you request, such as tapping buttons or typing text in other apps. " +
                            "Вы можете отозвать доступ к Службе специальных возможностей в любое время в меню «Настройки Android» > «Специальные возможности» > OpenDroid."
                )
            }

            // Section: Data Storage
            item {
                PolicySection(
                    title = "5. ХРАНЕНИЕ И ХРАНЕНИЕ ДАННЫХ",
                    content = "• All conversation history, memory facts, and task logs are stored in a local SQLite database on your device.\n" +
                            "• Memory entries support time-to-live (TTL) and are automatically cleaned on expiration.\n" +
                            "• Execution history remains until you clear it from System Logs or uninstall the app.\n" +
                            "• Saving a completed task as a macro is an explicit user action; API keys, tokens, passwords, and recognized credentials are replaced with [REDACTED] before recording.\n" +
                            "• You can clear any memory type (Working, Episodic, Semantic, Procedural) from the Memory screen.\n" +
                            "• При удалении приложения все сохраненные данные удаляются без возможности восстановления."
                )
            }

            // Section: Data Sharing
            item {
                PolicySection(
                    title = "6. ОБМЕН ДАННЫМИ",
                    content = "OpenDroid does NOT:\n\n" +
                            "• Sell, rent, or share your personal data with third parties\n" +
                            "• Collect analytics, telemetry, or usage statistics\n" +
                            "• Transmit data to any server owned by the OpenDroid team\n" +
                            "• Display advertisements or use ad-tracking technologies\n\n" +
                            "Единственная внешняя передача данных происходит, когда ваши запросы отправляются настроенному вами провайдеру LLM."
                )
            }

            // Section: Security
            item {
                PolicySection(
                    title = "7. БЕЗОПАСНОСТЬ",
                    content = "• API keys are stored with Android Keystore AES-256-GCM encryption on your device.\n" +
                            "• Your profile name and birth date are encrypted the same way, with a separate device key.\n" +
                            "• Encryption keys never leave the device's hardware-backed keystore, so encrypted values cannot be read on another device or restored from a backup.\n" +
                            "• If a key is invalidated, the affected values are not recoverable and are never rewritten unencrypted; the app asks you to enter them again.\n" +
                            "• Ordinary non-personal settings, such as whether onboarding is complete, are stored unencrypted in app-private storage.\n" +
                            "• All LLM API communication uses HTTPS encryption.\n" +
                            "• The accessibility service only activates when explicitly enabled by you.\n" +
                            "• Деструктивные действия (перезагрузка устройства, удаление файлов) требуют подтверждения пользователя."
                )
            }

            // Section: Children
            item {
                PolicySection(
                    title = "8. КОНФИДЕНЦИАЛЬНОСТЬ ДЕТЕЙ",
                    content = "OpenDroid is not intended for use by children under 13 years of age. " +
                            "Мы сознательно не собираем информацию от детей."
                )
            }

            // Section: Changes
            item {
                PolicySection(
                    title = "9. ИЗМЕНЕНИЯ В НАСТОЯЩЕЙ ПОЛИТИКЕ",
                    content = "We may update this privacy policy from time to time. Any changes will be reflected in the app with an updated \"Last updated\" date. " +
                            "Продолжение использования OpenDroid после внесения изменений означает принятие обновленной политики."
                )
            }

            // Section: Contact
            item {
                PolicySection(
                    title = "10. КОНТАКТЫ",
                    content = "If you have questions about this privacy policy or OpenDroid's data practices, " +
                            "пожалуйста, откройте проблему в нашем репозитории GitHub (JMAN730/opendroid) или обратитесь к команде разработчиков в Discord."
                )
            }
        }
    }
}

@Composable
internal fun PolicySection(
    title: String,
    content: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, BorderColor, RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = CardBackground)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = AccentCyan
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = content,
                fontSize = 13.sp,
                color = TextPrimary,
                lineHeight = 20.sp
            )
        }
    }
}
