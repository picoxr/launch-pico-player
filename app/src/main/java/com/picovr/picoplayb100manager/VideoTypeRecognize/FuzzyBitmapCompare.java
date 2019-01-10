package com.picovr.picoplayb100manager.VideoTypeRecognize;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.text.DecimalFormat;

public class FuzzyBitmapCompare {
    private static final String DIFFERENT_SIZE = "differentSize";
    //	private static final String RESULT_FORMAT = "00.0%";
    private static final String RESULT_FORMAT = "00.0%";

    public static String similarity(String url1, String url2) {
        Bitmap bm1 = BitmapFactory.decodeFile(url1);
        Bitmap bm2 = BitmapFactory.decodeFile(url2);
        return similarity(bm1, bm2);
    }

    public static String similarity(Bitmap bm1, Bitmap bm2) {
        final int bm1Width = bm1.getWidth();
        final int bm2Width = bm2.getWidth();
        final int bmHeight = bm1.getHeight();

        if (bmHeight != bm2.getHeight() || bm1Width != bm2Width)
            return DIFFERENT_SIZE;

        int[] pixels1 = new int[bm1Width];
        int[] pixels2 = new int[bm2Width];

        reset();
        for (int i = 0; i < bmHeight; i++) {
            bm1.getPixels(pixels1, 0, bm1Width, 0, i, bm1Width, 1);
            bm2.getPixels(pixels2, 0, bm2Width, 0, i, bm2Width, 1);

            comparePixels(pixels1, pixels2, bm1Width);
        }

        return percent(Count.sT, Count.sF + Count.sT);
    }

    private static void comparePixels(int[] pixels1, int[] pixels2,
                                      int length) {
        for (int i = 0; i < length; i++) {

            if (pixelsSimilary(pixels1[i], pixels2[i])) {
                Count.sT++;
            } else {
                Count.sF++;
            }
        }
    }

    private static boolean pixelsSimilary(int pixel1, int pixel2) {
        int red1 = ((pixel1 & 0x00FF0000) >> 16);
        int green1 = ((pixel1 & 0x0000FF00) >> 8);
        int blue1 = (pixel1 & 0x000000FF);
        Log.i("videitype", "pixel1:(" + red1 + "," + green1 + "," + blue1 + ")");
        int red2 = ((pixel2 & 0x00FF0000) >> 16);
        int green2 = ((pixel2 & 0x0000FF00) >> 8);
        int blue2 = (pixel2 & 0x000000FF);
        Log.i("videitype", "pixel2:(" + red2 + "," + green2 + "," + blue2 + ")");

        if (Math.abs(red1 - red2) < 10 && Math.abs(green1 - green2) < 10 && Math.abs(blue1 - blue2) < Constant.FUZZY_DIFFERENT_VALUE) {
            Log.i("videitype", "相似");
            return true;
        } else {
            return false;
        }
    }

    private static String percent(int divisor, int dividend) {
        final double value = divisor * 1.0 / dividend;
        DecimalFormat df = new DecimalFormat(RESULT_FORMAT);
        return df.format(value);
    }

    private static void reset() {
        Count.sT = 0;
        Count.sF = 0;
    }

    private static class Count {
        private static int sT;
        private static int sF;
    }
}
