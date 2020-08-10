package com.example.contacts21.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contacts21.model.Contact
import com.example.contacts21.model.DBMethods

class ContactsViewModel(application: Application) : AndroidViewModel(application) {
    private val dbMethods by lazy {
        DBMethods()
    }

    fun insert(contact: Contact) {}

    fun update(contact: Contact) {}

    fun delete(contact: Contact) {}

    fun deleteAllContacts() {}

    // fun getSelectedContact() : Contact {}

   // fun getAllContacts() : List<Contact> {}

}