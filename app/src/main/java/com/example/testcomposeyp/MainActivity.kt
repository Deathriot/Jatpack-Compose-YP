package com.example.testcomposeyp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcomposeyp.model.Contact


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactDetails(Contact.mockVersion1())
        }
    }

    @Preview(showSystemUi = true, name = "portrait")
    @Composable
    fun FullInfoContactPreview() {
        ContactDetails(Contact.mockVersion1())
    }

    @Preview(showSystemUi = true, name = "portrait")
    @Composable
    fun LessInfoContactPreview() {
        ContactDetails(Contact.mockVersion2())
    }

    @Composable
    fun ContactDetails(contact: Contact) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicture(contact)
                NameAndSurnameRow(contact)
                FamilyNameRow(contact)
                InfoRow(stringResource(R.string.phone), contact.phone)
                InfoRow(stringResource(R.string.address), contact.address)
                InfoRow(stringResource(R.string.email), contact.email)
            }
        }
    }

    @Composable
    fun ProfilePicture(contact: Contact) {
        if (contact.imageRes == null) {
            RoundInitials(contact.name, contact.familyName)
        } else {
            Image(
                modifier = Modifier
                    .size(48.dp),
                painter = painterResource(contact.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

        }
    }

    @Composable
    fun NameAndSurnameRow(contact: Contact) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text(
                modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.h6,
                text = contact.name
            )

            contact.surname?.let {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = contact.surname
                )
            }
        }
    }

    @Composable
    fun FamilyNameRow(contact: Contact) {
        Row(
            modifier = Modifier.padding(bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = MaterialTheme.typography.h5,
                text = contact.familyName,
            )
            if (contact.isFavorite) {
                Image(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(android.R.drawable.star_big_on),
                    contentDescription = null
                )
            }
        }
    }


    @Composable
    fun InfoRow(infoName: String, content: String?) {
        if (content == null) {
            return
        }

        Row(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .weight(1f),
                style = MaterialTheme.typography.body1,
                text = "${infoName}:"
            )
            Text(
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1,
                text = content
            )
        }
    }

    @Composable
    fun RoundInitials(name: String, familyName: String) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null
            )
            Text(
                text = "${name.take(1)}${familyName.take(1)}"
            )
        }
    }
}