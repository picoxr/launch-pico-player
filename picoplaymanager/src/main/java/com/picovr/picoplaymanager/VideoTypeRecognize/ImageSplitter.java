package com.picovr.picoplaymanager.VideoTypeRecognize;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class ImageSplitter {

    public static List<Bitmap> splitHorizontal(Bitmap bitmap) {

        List<Bitmap> BitmapList = new ArrayList<Bitmap>(2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int pieceWidth = width / 2;
        int pieceHeight = height / 1;
        Bitmap firstbitmap = Bitmap.createBitmap(bitmap, 0, 0, pieceWidth,
                pieceHeight);
        Bitmap secondbitmap = Bitmap.createBitmap(bitmap, pieceWidth, 0,
                pieceWidth, pieceHeight);
        BitmapList.add(firstbitmap);
        BitmapList.add(secondbitmap);
        return BitmapList;
    }

    public static List<Bitmap> splitVertical(Bitmap bitmap) {

        List<Bitmap> BitmapList = new ArrayList<Bitmap>(2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int pieceWidth = width / 1;
        int pieceHeight = height / 2;
        Bitmap firstbitmap = Bitmap.createBitmap(bitmap, 0, 0, pieceWidth,
                pieceHeight);
        Bitmap secondbitmap = Bitmap.createBitmap(bitmap, 0, pieceHeight,
                pieceWidth, pieceHeight);
        BitmapList.add(firstbitmap);
        BitmapList.add(secondbitmap);

        return BitmapList;
    }
}
