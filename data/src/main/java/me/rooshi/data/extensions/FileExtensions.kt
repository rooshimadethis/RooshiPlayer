package me.rooshi.data.extensions

import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns

fun Uri.getFileName() : String {
    //val c: Cursor = getContentResolver().query(uri, null, null, null, null)
    //c.moveToFirst()
    //return c.getString(c.getColumnIndex(OpenableColumns.DISPLAY_NAME))
    return ""
}