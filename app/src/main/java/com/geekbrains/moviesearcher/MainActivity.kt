package com.geekbrains.moviesearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchLine = findViewById<AppCompatEditText>(R.id.searchLine)
        val searchButton = findViewById<AppCompatButton>(R.id.searchButton)

        searchButton.setOnClickListener {
            startSearching(searchLine.text.toString().trim())
            searchLine.setText("")  // Очистка поисковой строки.
        }
    }

    // Метод обрабатывает поисковый запрос пользователя.
    private fun startSearching(searchText: String) {
        val answer = if (searchText != "") getString(R.string.onNotEmptyRequest, searchText)
        else getString(R.string.onEmptyRequest)
        Toast.makeText(this@MainActivity, answer, Toast.LENGTH_SHORT).show()
    }

}