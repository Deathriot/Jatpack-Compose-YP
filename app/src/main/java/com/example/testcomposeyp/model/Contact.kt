package com.example.testcomposeyp.model

import com.example.testcomposeyp.R


data class Contact(
    val name: String,
    val surname: String? = null,
    val familyName: String,
    val imageRes: Int? = null,
    val isFavorite: Boolean = false,
    val phone: String,
    val address: String,
    val email: String? = null,
) {
    companion object {
        fun mockVersion1(): Contact {
            return Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                isFavorite = true,
                phone = "+7 945 495 95 95",
                address = "г. Москва, 4-я улица Строителей, д.25 кв. 456",
                email = "test@mail.com",
                imageRes = R.drawable.test_image
            )
        }

        fun mockVersion2(): Contact {
            return Contact(
                name = "Евгений",
                familyName = "Лукашин",
                phone = "+7 945 495 95 95",
                address = "г. Москва, 4-я улица Строителей, д.25 кв. 456",
            )
        }
    }
}
