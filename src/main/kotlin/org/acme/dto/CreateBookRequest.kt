package org.acme.dto

import org.acme.enums.BookGenre

data class CreateBookRequest(
    var name: String = "",
    var description: String = "",
    var genre: BookGenre = BookGenre.NOT_SPECIFIED
)