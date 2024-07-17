package com.health.openin.view.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.health.openin.R
import com.health.openin.ui.theme.SupportColor1
import com.health.openin.ui.theme.SupportColor2

@Composable
fun Footer(
    phoneNumber: String,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val message = "Hey"

    Column (
        modifier = Modifier.padding(bottom = 70.dp)
    ){
        FullWidthBox(
            icon = painterResource(id = R.drawable.link),
            text = "View all Links",
            onClick = {
                onClick()
            }
        )
        SupportButton(
            color = SupportColor1,
            title = "Talk With Us",
            icon = painterResource(id = R.drawable.watsapp),
            onClick = {
                val uri = Uri.parse("smsto:$phoneNumber")
                val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
                    setPackage("com.whatsapp")
                    putExtra("sms_body", message)
                }
                context.startActivity(intent)
            }
        )
        SupportButton(
            color = SupportColor2,
            title = "Frequently Asked Questions",
            icon = painterResource(id = R.drawable.question),
            onClick = {

            }
        )
    }
}
