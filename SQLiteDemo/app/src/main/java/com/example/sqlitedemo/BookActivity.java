package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    EditText edtId;
    EditText edtTitle;
    EditText edtAuthorId;
    Button btnSelect;
    Button btnSave;
    Button btnUpdate;
    GridView gridView;
    Button btnDelete;
    DBHelper dbHelper;
    List<Book> books= new ArrayList<>();
    List<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        anhxa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setId(Integer.parseInt(edtId.getText().toString().trim()));
                book.setTitle(edtTitle.getText().toString().trim());
                book.setAuthorId(Integer.parseInt(edtAuthorId.getText().toString().trim()));
                if (dbHelper.insertBook(book) > 0) {
                    Toast.makeText(BookActivity.this, "saved", Toast.LENGTH_SHORT).show();
                    setBookAdapter(books);
                } else {
                    Toast.makeText(BookActivity.this, "no save", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString().trim());
                int res = dbHelper.deleteBook(id);
                if (res > 0) {
                    Toast.makeText(BookActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                    for (Book b : books) {
                        if (b.getId() == id) {
                            books.remove(books.indexOf(b));
                        }
                    }
                    setBookAdapter(books);
                } else {
                    Toast.makeText(BookActivity.this, "Không thể xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setId(Integer.parseInt(edtId.getText().toString().trim()));
                book.setTitle(edtTitle.getText().toString().trim());
                book.setAuthorId(Integer.parseInt(edtAuthorId.getText().toString().trim()));

                int res = dbHelper.updateBook(book);
                if (res > 0) {
                    Toast.makeText(BookActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    books.set(books.indexOf(book), book);
                    setBookAdapter(books);
                } else {
                    Toast.makeText(BookActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book book = books.get(i / 3);
                edtId.setText(book.getId() + "");
                edtTitle.setText(book.getTitle());
                edtAuthorId.setText(book.getAuthorId()+"");
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                books = new ArrayList<>();
                try {
                    int id = Integer.parseInt(edtId.getText().toString().trim());
                    Book book = dbHelper.getBookById(id);
                    if (book != null) {
                        books = new ArrayList<>();
                        books.add(book);
                    } else {
                        Toast.makeText(BookActivity.this, "No result", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    books = dbHelper.getAllBook();
                }
                setBookAdapter(books);

            }
        });

    }

    public void setBookAdapter(List<Book> book) {
        strings = new ArrayList<>();
        for (Book b : books) {
            strings.add(b.getId() + "");
            strings.add(b.getTitle());
            strings.add(b.getAuthorId()+"");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);
    }

    public void anhxa() {
        dbHelper = new DBHelper(this);
        edtId = findViewById(R.id.edtId);
        edtTitle = findViewById(R.id.edtTitle);
        edtAuthorId = findViewById(R.id.edtIdAuthor);
        btnSelect = findViewById(R.id.btnSelect);
        btnSave = findViewById(R.id.btnSave);
        btnUpdate = findViewById(R.id.btnUpdate);
        gridView = findViewById(R.id.grvAuthor);
        btnDelete = findViewById(R.id.btnDelete);
    }
}