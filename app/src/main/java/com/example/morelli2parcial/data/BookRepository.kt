package com.example.morelli2parcial.data

class BookRepository {
    companion object{
        val listOfBooks = mutableListOf<Book>(
            Book("Matar a un ruiseñor", "Harper Lee"),
            Book("Sapiens: De animales a dioses", "Yuval Noah Harari"),
            Book("Dune", "Frank Herbert"),
            Book("El hobbit", "J.R.R. Tolkien"),
            Book("Cien años de soledad", "Gabriel García Márquez"),
            Book("Don Quijote de la Mancha", "Miguel de Cervantes Saavedra"),
            Book("La sombra del viento", "Carlos Ruiz Zafón"),
            Book("Rayuela", "Julio Cortázar"),
            Book("Crónica de una muerte anunciada", "Gabriel García Márquez"),
            Book("La casa de los espíritus", "Isabel Allende"),
            Book("Pedro Páramo", "Juan Rulfo"),
            Book("El amor en los tiempos del cólera", "Gabriel García Márquez"),
            Book("1984", "George Orwell"),
            Book("Rebelión en la granja", "George Orwell"),
            Book("El túnel", "Ernesto Sabato"),
            Book("El Aleph", "Jorge Luis Borges"),
            Book("Ficciones", "Jorge Luis Borges"),
            Book("El principito", "Antoine de Saint-Exupéry"),
            Book("El código Da Vinci", "Dan Brown"),
            Book("Orgullo y prejuicio", "Jane Austen"),
            Book("El alquimista", "Paulo Coelho"),
            Book("Memorias de una geisha", "Arthur Golden"),
            Book("Los pilares de la Tierra", "Ken Follett"),
            Book("El nombre del viento", "Patrick Rothfuss")
        )

        fun addBook(book: Book) {
            listOfBooks.add(book)
        }
    }
}