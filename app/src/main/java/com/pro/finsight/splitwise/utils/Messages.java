package com.pro.finsight.splitwise.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class Messages {
    /**
     * Method to log the message.
     *
     * @param TAG:     the tag for the message.
     * @param message: the message to be logged.
     */
    public static void logMessage(@NotNull final String TAG, @NotNull final String message) {
        Log.v(TAG, message);
    }

    /**
     * Method to log the error message.
     *
     * @param TAG:     the TAG for the message.
     * @param message: The error Message.
     */
    public static void logErrorMessage(@NotNull final String TAG, @NotNull final String message) {
        Log.e(TAG, message);
    }

    /**
     * Method to show a short toast message.
     *
     * @param context: the context in which the toast should be shown.
     * @param message: the message to be displayed in the toast.
     */
    public static void toastShortMessage(@NotNull final Context context, @NotNull final String message) {
        Toast.makeText(context, "Sign-in failed", Toast.LENGTH_SHORT).show();
    }

    /**
     * Method to show a long toast message.
     *
     * @param context: the context in which the toast should be shown.
     * @param message: the message to be displayed in the toast.
     */
    public static void toastLongMessage(@NotNull final Context context, @NotNull final String message) {
        Toast.makeText(context, "Sign-in failed", Toast.LENGTH_LONG).show();
    }
}
