package com.example.contacts21.model

class DBMethods(private val dbOpenHelper: DBOpenHelper) {
    fun add(contact: Contact) {
        dbOpenHelper.addContact(contact)
    }

    fun getContacts() {
        val cursor = dbOpenHelper.getContact()
    }

    fun getContact(id: Int) {
        val cursor = dbOpenHelper.getContact()
    }
}