package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "BookManager", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table authors(id integer primary key,name text,address text,email text)");
        sqLiteDatabase.execSQL("create table books(id integer primary key" +
                ",title text" +
                ",author_id integer not null constraint author_id references authors(id) ON DELETE CASCADE ON UPDATE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists books");
        sqLiteDatabase.execSQL("drop table if exists authors");
        onCreate(sqLiteDatabase);
    }

    public int insertAuthor(Author author) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", author.getId() + "");
        contentValues.put("name", author.getName() + "");
        contentValues.put("address", author.getAddress() + "");
        contentValues.put("email", author.getEmail() + "");

        int res = (int) db.insert("authors", null, contentValues);
        db.close();
        return res;
    }

    public int insertBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", book.getId() + "");
        contentValues.put("title", book.getTitle());
        contentValues.put("author_id", book.getAuthorId() + "");
        int res = (int) db.insert("books", null, contentValues);
        db.close();
        return res;
    }

    public int updateAuthor(Author newAuthor) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", newAuthor.getName() + "");
        contentValues.put("address", newAuthor.getAddress() + "");
        contentValues.put("email", newAuthor.getEmail() + "");

        int res = db.update("authors", contentValues, "id=?", new String[]{newAuthor.getId() + ""});
        db.close();
        return res;
    }

    public int updateBook(Book b) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", b.getTitle() + "");
        contentValues.put("author_id", b.getAuthorId() + "");

        int res = db.update("books", contentValues, "id=?", new String[]{b.getId() + ""});
        db.close();
        return res;
    }

    public int deleteAuthor(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int res = db.delete("authors", "id=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    public int deleteBook(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int res = db.delete("books", "id=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    public List<Author> getAllAuthor() {
        List<Author> authors = new ArrayList<>();
        String sql = "select * from authors";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                authors.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
        }
        return authors;
    }

    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        String sql = "select * from books";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
        }
        return books;
    }

    public Author getAuthorById(int id) {
        Author author = null;
        String sql = "select * from authors where id=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{id + ""});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                author = (new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
        }
        db.close();
        return author;
    }

    public Book getBookById(int id) {
        Book book = null;
        String sql = "select * from books where id=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{id + ""});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                book = (new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
        }
        db.close();
        return book;
    }
}
