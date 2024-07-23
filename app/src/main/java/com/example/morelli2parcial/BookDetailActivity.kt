package com.example.morelli2parcial

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.morelli2parcial.data.Book
import com.example.morelli2parcial.data.BookRepository
import com.example.morelli2parcial.viewmodel.BookListViewModel

class BookDetailActivity : AppCompatActivity() {

    // Variables
    private lateinit var book: Book
    private lateinit var tvTitle: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvGenre: TextView
    private lateinit var tvSynopsis: TextView
    private lateinit var btnEdit: Button
    private lateinit var btnDelete: Button
    private lateinit var editView: LinearLayout
    private lateinit var etEditTitle: EditText
    private lateinit var etEditAuthor: EditText
    private lateinit var etEditGenre: EditText
    private lateinit var etEditSynopsis: EditText
    private lateinit var btnSave: Button
    private lateinit var btnDiscard: Button

    private lateinit var bookListViewModel: BookListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        // Initialize views
        tvTitle = findViewById(R.id.tv_detailTitle)
        tvAuthor = findViewById(R.id.tv_detailAuthor)
        tvGenre = findViewById(R.id.tv_detailGenre)
        tvSynopsis = findViewById(R.id.tv_detailSynopsis)
        btnEdit = findViewById(R.id.btn_edit)
        btnDelete = findViewById(R.id.btn_delete)
        editView = findViewById(R.id.editView)
        etEditTitle = findViewById(R.id.et_editTitle)
        etEditAuthor = findViewById(R.id.et_editAuthor)
        etEditGenre = findViewById(R.id.et_editGenre)
        etEditSynopsis = findViewById(R.id.et_editSynopsis)
        btnSave = findViewById(R.id.btn_save)
        btnDiscard = findViewById(R.id.btn_discard)

        bookListViewModel = BookListViewModel()

        // Get book from intent
        book = intent.getSerializableExtra("book") as? Book ?: return
        displayBookDetails()

        // Set click listeners for buttons
        btnEdit.setOnClickListener {
            toggleEditMode(true)
        }

        btnDelete.setOnClickListener {
            showDeleteConfirmationDialog(book)
        }

        btnSave.setOnClickListener {
            showSaveConfirmationDialog()
        }

        btnDiscard.setOnClickListener {
            toggleEditMode(false)
            hideKeyboard() // Hide keyboard as soon as discard button is clicked
        }
    }

    // Functions
    private fun displayBookDetails() {
        tvTitle.text = book.title
        tvAuthor.text = book.author
        tvGenre.text = book.genre
        tvSynopsis.text = book.synopsis
    }

    private fun toggleEditMode(isEditing: Boolean) {
        if (isEditing) {
            // Hide static texts view
            tvTitle.visibility = TextView.GONE
            tvAuthor.visibility = TextView.GONE
            tvGenre.visibility = TextView.GONE
            tvSynopsis.visibility = TextView.GONE
            btnEdit.visibility = Button.GONE
            btnDelete.visibility = Button.GONE

            // Show edit texts
            editView.visibility = LinearLayout.VISIBLE
            etEditTitle.setText(book.title)
            etEditAuthor.setText(book.author)
            etEditGenre.setText(book.genre)
            etEditSynopsis.setText(book.synopsis)
        } else {
            // Show static texts view
            tvTitle.visibility = TextView.VISIBLE
            tvAuthor.visibility = TextView.VISIBLE
            tvGenre.visibility = TextView.VISIBLE
            tvSynopsis.visibility = TextView.VISIBLE
            btnEdit.visibility = Button.VISIBLE
            btnDelete.visibility = Button.VISIBLE

            // Hide edit texts
            editView.visibility = LinearLayout.GONE
        }
    }

    private fun showSaveConfirmationDialog() {
        val changes = mutableListOf<String>()

        // Check for changes
        if (etEditTitle.text.toString() != book.title) {
            changes.add("el título \"${book.title}\" por \"${etEditTitle.text}\"")
        }
        if (etEditAuthor.text.toString() != book.author) {
            changes.add("el autor \"${book.author}\" por \"${etEditAuthor.text}\"")
        }
        if (etEditGenre.text.toString() != book.genre) {
            changes.add("El género \"${book.genre}\" por \"${etEditGenre.text}\"")
        }
        if (etEditSynopsis.text.toString() != book.synopsis) {
            changes.add("La sinopsis \"${book.synopsis}\" por \"${etEditSynopsis.text}\"")
        }

        if (changes.isEmpty()) {
            // No changes detected, save directly
            saveBookDetails()
            toggleEditMode(false)
            return
        }

        val message = "Has modificado " + changes.joinToString("\n") + "\n¿Deseas guardar los cambios?"

        // Show confirmation dialog
        val dialog = AlertDialog.Builder(this)
            .setTitle("Confirmación")
            .setMessage(message)
            .setPositiveButton("Guardar") { _, _ ->
                saveBookDetails()
                toggleEditMode(false)
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
    }

    private fun saveBookDetails() {
        // Update book details
        val updatedBook = book.copy(
            title = etEditTitle.text.toString(),
            author = etEditAuthor.text.toString(),
            genre = etEditGenre.text.toString(),
            synopsis = etEditSynopsis.text.toString()
        )
        // Save changes
        BookRepository.updateBook(updatedBook)
        book = updatedBook
        displayBookDetails()
        hideKeyboard() // Hide keyboard after saving
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    private fun showDeleteConfirmationDialog(book: Book?) {
        // Show confirmation dialog
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Estás seguro de que quieres eliminar este libro?")
            .setPositiveButton("Sí", DialogInterface.OnClickListener { dialog, id ->
                // Eliminar el libro
                book?.let {
                    bookListViewModel.deleteBook(it)
                    finish() // Close the activity after deletion is confirmed
                }
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                // User cancelled the deletion
                dialog.dismiss()
            })
        builder.create().show()
    }
}