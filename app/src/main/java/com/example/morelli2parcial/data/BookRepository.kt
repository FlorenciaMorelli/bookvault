package com.example.morelli2parcial.data

class BookRepository {
    val listOfBooks = mutableListOf<Book>(
        Book(1, 1, "To Kill a Mockingbird", "Harper Lee"),
        Book(2, 2, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari"),
        Book(3, 3, "Dune", "Frank Herbert"),
        Book(4, 4, "The Hobbit", "J.R.R. Tolkien")
    )

    fun getBooks(genreId: Int): List<Book> = listOfBooks.filter { it.genreId == genreId }

    fun addBook(book: Book) {
        listOfBooks.add(book)
    }
}