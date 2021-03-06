package com.example;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {
    static final String AUTHORITY = "com.example";
    static final String CONTENT_PROVIDER = "contentprovider";
    static final String URL = "content://" + AUTHORITY + "/" + CONTENT_PROVIDER;

    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String PRODUCT_TABLE = "products";

    private SQLiteDatabase db;

    static final int ONE = 1;
    static final int ALL = 2;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PRODUCT_TABLE, ONE);
        uriMatcher.addURI(AUTHORITY, PRODUCT_TABLE + "/#", ALL);
    }
    private static HashMap<String ,String> PROJECTION_MAP;
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long numberRow= db.insert(PRODUCT_TABLE,"",values);
        if (numberRow>0){
            Uri uri1= ContentUris.withAppendedId(CONTENT_URI,numberRow);
            getContext().getContentResolver().notifyChange(uri1,null);
            return uri1;
        }
        throw new SQLException("fail to add a record into"+uri);
    }

    @Override
    public boolean onCreate() {
        Context context= getContext();
        DBHelper dbHelper= new DBHelper(context);
        db=dbHelper.getWritableDatabase();
        if(db== null)
            return false;
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder= new SQLiteQueryBuilder();
        queryBuilder.setTables(PRODUCT_TABLE);
        switch (uriMatcher.match(uri)){
            case ALL:
                queryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            case ONE:
                queryBuilder.appendWhere("id="+uri.getPathSegments().get(0));
        }
        Cursor cursor= queryBuilder.query(db, projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}