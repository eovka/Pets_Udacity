package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class PetProvider extends ContentProvider {
    public static final String LOG_TAG = PetProvider.class.getSimpleName();
    private PetDbHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new PetDbHelper(getContext());
        return true;
    }
    /** Perform the query for the given URI. Use the given projection, selection, selection arguments and sort order. */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    /** Returns the MIME type of data for the content URI. */
    @Override
    public String getType(Uri uri) {
        return null;
    }

    /** Insert new data into the provider with the given ContentValues. */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    /** Delete the data at the given selection and selection arguments. */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /** Updates the data at the given selection and selection arguments, with the new ContentValues.*/
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
