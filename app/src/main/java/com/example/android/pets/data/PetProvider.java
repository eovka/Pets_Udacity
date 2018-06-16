package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.example.android.pets.data.PetContract.*;

public class PetProvider extends ContentProvider {
    public static final String LOG_TAG = PetProvider.class.getSimpleName();
    private PetDbHelper dbHelper;
    private static final int PETS = 100;
    private static final int PET_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS, PETS);
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS + "/#", PET_ID);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new PetDbHelper(getContext());
        return true;
    }
    /** Perform the query for the given URI. Use the given projection, selection, selection arguments and sort order. */
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);

        switch (match) {
            case PETS:
                cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case PET_ID:
                selection = PetEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    /** Returns the MIME type of data for the content URI. */
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    /** Insert new data into the provider with the given ContentValues. */
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        return null;
    }

    /** Delete the data at the given selection and selection arguments. */
    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /** Updates the data at the given selection and selection arguments, with the new ContentValues.*/
    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
