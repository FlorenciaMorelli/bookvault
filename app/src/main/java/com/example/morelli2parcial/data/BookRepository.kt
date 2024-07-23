package com.example.morelli2parcial.data

class BookRepository {
    companion object{
        val listOfBooks = mutableListOf<Book>(
            Book("Matar a un ruiseñor", "Harper Lee", "Ficción", "La historia de Atticus Finch, un abogado en el sur de Estados Unidos que defiende a un hombre negro acusado injustamente de violar a una mujer blanca."),
            Book("Sapiens: De animales a dioses", "Yuval Noah Harari", "No ficción", "Un análisis de la historia de la humanidad desde los primeros Homo sapiens hasta la actualidad, explorando cómo hemos moldeado el mundo."),
            Book("Dune", "Frank Herbert", "Ciencia ficción", "La saga de la familia Atreides en el planeta desértico de Arrakis, abordando temas de política, religión, y ecología."),
            Book("El hobbit", "J.R.R. Tolkien", "Fantasía", "La aventura de Bilbo Baggins en la Tierra Media, antes de los eventos de 'El Señor de los Anillos'."),
            Book("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", "La historia de la familia Buendía en el pueblo ficticio de Macondo, explorando temas de amor, guerra, y el destino."),
            Book("Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", "Novela", "Las aventuras de un caballero loco, Don Quijote, y su fiel escudero Sancho Panza, en su búsqueda de justicia y aventuras."),
            Book("La sombra del viento", "Carlos Ruiz Zafón", "Misterio", "Un joven descubre un libro en un misterioso cementerio de libros olvidados, desatando una serie de eventos que revelan secretos oscuros."),
            Book("Rayuela", "Julio Cortázar", "Literatura experimental", "La historia de Horacio Oliveira y su relación con la mujer que ama, contada en una estructura narrativa innovadora y fragmentada."),
            Book("Crónica de una muerte anunciada", "Gabriel García Márquez", "Novela", "La historia de un asesinato anunciado y la investigación de los eventos que llevaron al trágico desenlace."),
            Book("La casa de los espíritus", "Isabel Allende", "Realismo mágico", "La historia de la familia Trueba en Chile, marcada por eventos sobrenaturales y la evolución social del país."),
            Book("Pedro Páramo", "Juan Rulfo", "Realismo mágico", "La historia de un hombre que viaja a un pueblo fantasmal para encontrar a su padre y descubre un lugar lleno de almas en pena."),
            Book("El amor en los tiempos del cólera", "Gabriel García Márquez", "Romance", "La historia de un amor persistente entre Florentino Ariza y Fermina Daza que se desarrolla a lo largo de más de medio siglo."),
            Book("1984", "George Orwell", "Distopía", "Una visión aterradora de un futuro totalitario donde el gobierno controla todos los aspectos de la vida y la verdad se convierte en una herramienta de represión."),
            Book("Rebelión en la granja", "George Orwell", "Sátira política", "Una alegoría sobre la revolución y la corrupción del poder a través de la historia de una granja donde los animales se rebelan contra sus opresores humanos."),
            Book("El túnel", "Ernesto Sabato", "Psicológico", "La historia de un pintor obsesivo que se sumerge en un espiral de paranoia y desesperación después de una serie de eventos perturbadores."),
            Book("El Aleph", "Jorge Luis Borges", "Fantasía", "Una colección de cuentos que exploran temas como la infinitud, el tiempo, y la realidad en el estilo característico de Borges."),
            Book("Ficciones", "Jorge Luis Borges", "Fantasía", "Otra colección de relatos cortos de Borges, que incluyen paradojas filosóficas y laberintos narrativos."),
            Book("El principito", "Antoine de Saint-Exupéry", "Fábula", "La historia de un pequeño príncipe que viaja a través del universo, conociendo diversos personajes y aprendiendo lecciones sobre la vida y el amor."),
            Book("El código Da Vinci", "Dan Brown", "Misterio", "Un thriller que sigue al profesor Robert Langdon en una búsqueda para resolver un misterio oculto en el arte y la religión."),
            Book("Orgullo y prejuicio", "Jane Austen", "Romance clásico", "La historia de Elizabeth Bennet y su compleja relación con el orgulloso Mr. Darcy en la Inglaterra del siglo XIX."),
            Book("El alquimista", "Paulo Coelho", "Fábula", "La historia de Santiago, un joven pastor que sigue sus sueños y busca un tesoro en el desierto, aprendiendo lecciones sobre la vida en el camino."),
            Book("Memorias de una geisha", "Arthur Golden", "Histórico", "La vida de una joven japonesa que se convierte en una famosa geisha durante y después de la Segunda Guerra Mundial."),
            Book("Los pilares de la Tierra", "Ken Follett", "Histórico", "Un épico relato sobre la construcción de una catedral en la Inglaterra medieval y las vidas entrelazadas de sus personajes."),
            Book("El nombre del viento", "Patrick Rothfuss", "Fantasía", "La primera parte de la saga de Kvothe, un joven talentoso que cuenta su vida desde su infancia hasta convertirse en una leyenda.")
        )

        fun addBook(book: Book) {
            listOfBooks.add(book)
        }

        fun updateBook(updatedBook: Book) {
            val index = listOfBooks.indexOfFirst { it.title == updatedBook.title }
            if (index != -1) {
                listOfBooks[index] = updatedBook
            }
        }

        fun deleteBook(title: String) {
            val index = listOfBooks.indexOfFirst { it.title == title }
            if (index != -1) {
                listOfBooks.removeAt(index)
            }
        }
    }
}
