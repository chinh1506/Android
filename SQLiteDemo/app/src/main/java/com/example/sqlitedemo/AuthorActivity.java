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

public class AuthorActivity extends AppCompatActivity {
    EditText edtId;
    EditText edtName;
    EditText edtAddress;
    EditText edtEmail;
    Button btnSelect;
    Button btnSave;
    Button btnUpdate;
    GridView gridView;
    Button btnDelete;
    DBHelper dbHelper;
    List<Author> authors;
    List<String> strings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        anhxa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId(Integer.parseInt(edtId.getText().toString().trim()));
                author.setName(edtName.getText().toString().trim());
                author.setAddress(edtAddress.getText().toString().trim());
                author.setEmail(edtEmail.getText().toString().trim());
                if (dbHelper.insertAuthor(author) > 0) {
                    Toast.makeText(AuthorActivity.this, "saved", Toast.LENGTH_SHORT).show();
                    authors.add(author);
                    setAuthorAdapter(authors);
                } else {
                    Toast.makeText(AuthorActivity.this, "no save", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString().trim());
                int res = dbHelper.deleteAuthor(id);
                if (res > 0) {
                    Toast.makeText(AuthorActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                    for (Author au : authors) {
                        if(au.getId()==id){
                            authors.remove(authors.indexOf(au));
                        }
                    }
                    setAuthorAdapter(authors);
                } else {
                    Toast.makeText(AuthorActivity.this, "Không thể xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId(Integer.parseInt(edtId.getText().toString().trim()));
                author.setName(edtName.getText().toString().trim());
                author.setAddress(edtAddress.getText().toString().trim());
                author.setEmail(edtEmail.getText().toString().trim());
                int res = dbHelper.updateAuthor(author);
                if (res > 0) {
                    Toast.makeText(AuthorActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    authors.set(authors.indexOf(author), author);
                    setAuthorAdapter(authors);
                } else {
                    Toast.makeText(AuthorActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Author auth = authors.get(i / 4);
                edtId.setText(auth.getId() + "");
                edtName.setText(auth.getName());
                edtAddress.setText(auth.getAddress());
                edtEmail.setText(auth.getEmail());
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authors = new ArrayList<>();
                try {
                    int id = Integer.parseInt(edtId.getText().toString().trim());
                    Author author = dbHelper.getAuthorById(id);
                    if (author != null) {
                        authors = new ArrayList<>();
                        authors.add(author);
                    } else {
                        Toast.makeText(AuthorActivity.this, "No result", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    authors = dbHelper.getAllAuthor();
                }
                setAuthorAdapter(authors);

            }
        });

    }

    public void setAuthorAdapter(List<Author> authors) {
        strings = new ArrayList<>();
        for (Author author : authors) {
            strings.add(author.getId() + "");
            strings.add(author.getName());
            strings.add(author.getAddress());
            strings.add(author.getEmail());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);
    }

    public void anhxa() {
        dbHelper = new DBHelper(this);
        edtId = findViewById(R.id.edtId);
        edtAddress = findViewById(R.id.edtTitle);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtIdAuthor);
        btnSelect = findViewById(R.id.btnSelect);
        btnSave = findViewById(R.id.btnSave);
        btnUpdate = findViewById(R.id.btnUpdate);
        gridView = findViewById(R.id.grvAuthor);
        btnDelete = findViewById(R.id.btnDelete);
    }
}