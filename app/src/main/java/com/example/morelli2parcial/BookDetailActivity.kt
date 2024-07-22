package com.example.morelli2parcial

import android.content.Context
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

class BookDetailActivity : AppCompatActivity() {

    private lateinit var book: Book
    private lateinit var tvTitle: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvGenre: TextView
    private lateinit var tvSynopsis: TextView
    private lateinit var btnEdit: Button
    private lateinit var editView: LinearLayout
    private lateinit var etEditTitle: EditText
    private lateinit var etEditAuthor: EditText
    private lateinit var etEditGenre: EditText
    private lateinit var etEditSynopsis: EditText
    private lateinit var btnSave: Button
    private lateinit var btnDiscard: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        tvTitle = findViewById(R.id.tv_detailTitle)
        tvAuthor = findViewById(R.id.tv_detailAuthor)
        tvGenre = findViewById(R.id.tv_detailGenre)
        tvSynopsis = findViewById(R.id.tv_detailSynopsis)
        btnEdit = findViewById(R.id.btn_edit)
        editView = findViewById(R.id.editView)
        etEditTitle = findViewById(R.id.et_editTitle)
        etEditAuthor = findViewById(R.id.et_editAuthor)
        etEditGenre = findViewById(R.id.et_editGenre)
        etEditSynopsis = findViewById(R.id.et_editSynopsis)
        btnSave = findViewById(R.id.btn_save)
        btnDiscard = findViewById(R.id.btn_discard)

        book = intent.getSerializableExtra("book") as? Book ?: return
        displayBookDetails()

        btnEdit.setOnClickListener {
            toggleEditMode(true)
        }

        btnSave.setOnClickListener {
            showSaveConfirmationDialog()
        }

        btnDiscard.setOnClickListener {
            toggleEditMode(false)
            hideKeyboard() // Oculta el teclado después de descartar
        }
    }

    private fun displayBookDetails() {
        tvTitle.text = book.title
        tvAuthor.text = book.author
        tvGenre.text = book.genre
        tvSynopsis.text = book.synopsis
    }

    private fun toggleEditMode(isEditing: Boolean) {
        if (isEditing) {
            tvTitle.visibility = TextView.GONE
            tvAuthor.visibility = TextView.GONE
            tvGenre.visibility = TextView.GONE
            tvSynopsis.visibility = TextView.GONE
            btnEdit.visibility = Button.GONE

            editView.visibility = LinearLayout.VISIBLE
            etEditTitle.setText(book.title)
            etEditAuthor.setText(book.author)
            etEditGenre.setText(book.genre)
            etEditSynopsis.setText(book.synopsis)
        } else {
            tvTitle.visibility = TextView.VISIBLE
            tvAuthor.visibility = TextView.VISIBLE
            tvGenre.visibility = TextView.VISIBLE
            tvSynopsis.visibility = TextView.VISIBLE
            btnEdit.visibility = Button.VISIBLE

            editView.visibility = LinearLayout.GONE
        }
    }

    private fun showSaveConfirmationDialog() {
        val changes = mutableListOf<String>()

        if (etEditTitle.text.toString() != book.title) {
            changes.add("Título: ${book.title} -> ${etEditTitle.text}")
        }
        if (etEditAuthor.text.toString() != book.author) {
            changes.add("Autor: ${book.author} -> ${etEditAuthor.text}")
        }
        if (etEditGenre.text.toString() != book.genre) {
            changes.add("Género: ${book.genre} -> ${etEditGenre.text}")
        }
        if (etEditSynopsis.text.toString() != book.synopsis) {
            changes.add("Sinopsis: ${book.synopsis} -> ${etEditSynopsis.text}")
        }

        if (changes.isEmpty()) {
            // No changes detected, save directly
            saveBookDetails()
            toggleEditMode(false)
            return
        }

        val message = "Has modificado:\n" + changes.joinToString("\n") + "\n¿Deseas guardar?"

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
        val updatedBook = book.copy(
            title = etEditTitle.text.toString(),
            author = etEditAuthor.text.toString(),
            genre = etEditGenre.text.toString(),
            synopsis = etEditSynopsis.text.toString()
        )
        BookRepository.updateBook(updatedBook)
        book = updatedBook
        displayBookDetails()
        hideKeyboard() // Oculta el teclado después de guardar
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}