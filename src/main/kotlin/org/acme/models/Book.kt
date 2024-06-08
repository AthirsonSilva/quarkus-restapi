package org.acme.models

import org.acme.enums.BookGenre
import java.time.LocalDateTime

data class Book(
    var id: String? = null,
    var name: String = "",
    var description: String = "",
    var genre: BookGenre = BookGenre.NOT_SPECIFIED,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
) {
    constructor() : this(
        id = null,
        name = "",
        description = "",
        genre = BookGenre.NOT_SPECIFIED,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}