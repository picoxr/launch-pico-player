package com.picovr.picoplayb100manager.VideoTypeRecognize;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by goodman.ye on 2017/7/14.
 */

public class VideoTypeUtils {
	public static String TAG = "videotype";
	private static MediaMetadataRetriever retriever;

	/**
	 * 添加了模糊值的图片对比
	 *
	 * @param bitmap
	 * @return
	 */
	private static Float[] fuzzyCompareImage(Bitmap bitmap) {
		Bitmap zoomBimtap = zoomImage(bitmap, 8, 8);
		List<Bitmap> horizontalBitmaps = ImageSplitter
				.splitHorizontal(zoomBimtap);
		String horizontalSimilarity = FuzzyBitmapCompare
				.similarity(horizontalBitmaps.get(0), horizontalBitmaps.get(1));
		List<Bitmap> verticalBitmaps = ImageSplitter.splitVertical(zoomBimtap);
		String verticalSimilarity = FuzzyBitmapCompare
				.similarity(verticalBitmaps.get(0), verticalBitmaps.get(1));
		Log.i(TAG, "水平相似度：" + horizontalSimilarity + "***上下相似度："
				+ verticalSimilarity);
		float horizontalSimilarityFloat = Float.parseFloat(horizontalSimilarity
				.substring(0, horizontalSimilarity.length() - 1));
		float verticalSimilarityFloat = Float.parseFloat(verticalSimilarity
				.substring(0, verticalSimilarity.length() - 1));
		return new Float[] { horizontalSimilarityFloat,
				verticalSimilarityFloat };
	}

	/***
	 * 图片的缩放方法
	 *
	 * @param bgimage   ：源图片资源
	 * @param newWidth  ：缩放后宽度
	 * @param newHeight ：缩放后高度
	 * @return
	 */
	public static Bitmap zoomImage(Bitmap bgimage, double newWidth,
			double newHeight) {
		// 获取这个图片的宽和高
		float width = bgimage.getWidth();
		float height = bgimage.getHeight();
		// 创建操作图片用的matrix对象
		Matrix matrix = new Matrix();
		// 计算宽高缩放率
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 缩放图片动作
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
				(int) height, matrix, true);
		return bitmap;
	}

	public static int getVideoType(String videoPath) {
		// File video = new File(videoPath);
		retriever = new MediaMetadataRetriever();
		retriever.setDataSource(videoPath);
		int height = Integer.parseInt(retriever.extractMetadata(
				MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)); // 视频高度
		int width = Integer.parseInt(retriever.extractMetadata(
				MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)); // 视频宽度
		Log.d(TAG, "height:" + height + "***width:" + width);
		DecimalFormat df = new DecimalFormat("0.0");
		float radio = Float.parseFloat(df.format((float) width / height));
		Log.d(TAG, "radio = " + radio);
		Bitmap bitmap = retriever.getFrameAtTime();
		Float[] compareResultArray = fuzzyCompareImage(bitmap);
		int videoType = getType(radio, compareResultArray[0],
				compareResultArray[1]);
		return videoType;
	}

	/**
	 * 根据视频宽高比和切图对比结果，获取视频打开类型
	 * 返回的是视频类型的String值
	 *
	 * @param radio
	 * @param horizontalCompareResult
	 * @param verticalCompareResult
	 * @return
	 */
	public static int getType(Float radio, Float horizontalCompareResult,
			Float verticalCompareResult) {
		Log.i(TAG,
				"radio = " + radio + "**horizontalCompareResult = "
						+ horizontalCompareResult + "**verticalCompareResult = "
						+ verticalCompareResult);
		if (radio == 1) {
			if (verticalCompareResult > Constant.ABSOLUTE_CRITICAL_VALUE
					&& verticalCompareResult
							- horizontalCompareResult > Constant.RELATIVE_CRITICAL_VALUE) {
				//
				 return MovieType.TYPE_3D360_TB;
//				return "360°3D上下";
			} else {
				// 180°
				 return MovieType.TYPE_180;
//				return "180°";
			}
		}
		if (radio == 2) {
			if (horizontalCompareResult > Constant.ABSOLUTE_CRITICAL_VALUE
					&& horizontalCompareResult
							- verticalCompareResult > Constant.RELATIVE_CRITICAL_VALUE) {
				// 180°3D左右
				 return MovieType.TYPE_3D180_LR;
//				return "180°3D左右";
			} else if (verticalCompareResult > Constant.ABSOLUTE_CRITICAL_VALUE
					&& verticalCompareResult
							- horizontalCompareResult > Constant.RELATIVE_CRITICAL_VALUE) {
				// 360°3D上下;
				 return MovieType.TYPE_3D360_TB;
//				return "360°3D上下";
			} else {
				// 360
				 return MovieType.TYPE_360;
//				return "360°";
			}
		}
		if (radio == 4) {
			// 360°3D左右
			 return MovieType.TYPE_3D360_LR;
//			return "360°3D左右";
		}
		if (radio == 0.5) {
			// 180°3D上下
			 return MovieType.TYPE_3D180_TB;
//			return "180°3D上下";
		}
		if ((Math.abs(radio - 1.85) <= 0.5)
				&& verticalCompareResult > Constant.ABSOLUTE_CRITICAL_VALUE
				&& verticalCompareResult
						- horizontalCompareResult > Constant.RELATIVE_CRITICAL_VALUE) {
			// 360°3D上下;
			 return MovieType.TYPE_3D360_TB;
//			return "360°3D上下";
		}
		if (horizontalCompareResult > Constant.ABSOLUTE_CRITICAL_VALUE
				&& horizontalCompareResult
						- verticalCompareResult > Constant.RELATIVE_CRITICAL_VALUE) {
			// 3D左右
			 return MovieType.TYPE_3D_LR;
//			return "3D左右";
		}
		// return "2D";
		 return MovieType.TYPE_2D;
//		return "2D";
	}

}
