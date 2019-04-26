package com.picovr.picoplaymanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;

/**
 * 
 * @author lance.li
 *
 */
public class Externalstoragedirectory {

	private static String ExternalPath1;
	private static String ExternalPath2;

	/**
	 * get SD card path
	 */
	public static String getSDdir(Context mContext) {
		getMountedSDCardCount(mContext);
		return ExternalPath1;
	}

	private static int getMountedSDCardCount(Context context) {
		ExternalPath1 = null;
		ExternalPath2 = null;
		int readyCount = 0;
		StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
		if (storageManager == null)
			return 0;
		Method method;
		Object obj;
		try {
			method = storageManager.getClass().getMethod("getVolumePaths", (Class[]) null);
			obj = method.invoke(storageManager, (Object[]) null);

			String[] paths = (String[]) obj;
			if (paths == null)
				return 0;

			method = storageManager.getClass().getMethod("getVolumeState", new Class[] { String.class });
			for (String path : paths) {
				obj = method.invoke(storageManager, new Object[] { path });
				if (Environment.MEDIA_MOUNTED.equals(obj)) {
					readyCount++;
					if (2 == readyCount) {
						ExternalPath1 = path;
					}
					if (3 == readyCount) {
						ExternalPath2 = path;
					}
				}
			}
		} catch (NoSuchMethodException ex) {
			throw new RuntimeException(ex);
		} catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		} catch (InvocationTargetException ex) {
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				readyCount = 1;
			}
			Log.d("Test", ex.getMessage());
			return readyCount;
		}

		Log.d("Test", "mounted sdcard unmber: " + readyCount);
		return readyCount;
	}

	/**
	 * if method above doesn't work, try this.
	 */
	public static String getPath() {
		Runtime mRuntime = Runtime.getRuntime();
		try {
			Process mProcess = mRuntime.exec("ls /storage");
			BufferedReader mReader = new BufferedReader(new InputStreamReader(mProcess.getInputStream()));
			StringBuffer mRespBuff = new StringBuffer();
			char[] buff = new char[1024];
			int ch = 0;
			while ((ch = mReader.read(buff)) != -1) {
				mRespBuff.append(buff, 0, ch);
			}
			mReader.close();
			String[] result = mRespBuff.toString().trim().split("\n");
			for (String str : result) {
				if (str.equals("emulate") || str.equals("self"))
					continue;
				return str;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
