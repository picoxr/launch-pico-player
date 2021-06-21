using UnityEngine;
using System.Collections;

/// <summary>
/// Pico unity activity.
/// </summary>
public class PicoUnityActivity
{
	private static AndroidJavaObject picoUnityAcvity = null;
	private static AndroidJavaObject CurrentActivity ()
	{
		if (Application.platform == RuntimePlatform.Android) {
			string className = "com.picovr.picoplaymanager.PicovrPlayManagerActivity";
			if (picoUnityAcvity == null) {
				picoUnityAcvity = new AndroidJavaClass (className).GetStatic<AndroidJavaObject> ("unityActivity");
			}
		}

		return picoUnityAcvity;
	}

	public static bool CallObjectMethod (string name, params object[] args)
	{
        if (Application.platform != RuntimePlatform.Android)
        {
            return false;
        }
		if (CurrentActivity () == null) {
			Debug.LogWarning ("Object is null when calling method " + name);
			return false;
		}
		try {
			CurrentActivity ().Call (name, args);
			return true;
		} catch (AndroidJavaException e) {
			Debug.LogError ("Exception calling method " + name + ": " + e);
			return false;
		}
	}

	//add by Licky start
	public static bool CallObjectMethod<T> (ref T result, string name)
	{
        if (Application.platform != RuntimePlatform.Android)
        {
            return false;
        }
		if (CurrentActivity () == null) {
			Debug.LogWarning ("Object is null when calling method " + name);
			return false;
		}
		try {
			result = CurrentActivity ().Call<T> (name);
			return true;
		} catch (AndroidJavaException e) {
			Debug.LogError ("Exception calling method " + name + ": " + e);
			return false;
		}
	}
	//add by Licky end

	public static bool CallObjectMethod<T> (ref T result, string name,
	                                          params object[] args)
	{
		if (CurrentActivity () == null) {
			Debug.LogError ("Object is null when calling method " + name);
			return false;
		}
		try {
			result = CurrentActivity ().Call<T> (name, args);
			return true;
		} catch (AndroidJavaException e) {
			Debug.LogError ("Exception calling method " + name + ": " + e);
			return false;
		}
	}
	/// <summary>
	/// 获取指定的activity
	/// </summary>
	/// <param name="package_name">Activity所属于的包名</param>
	/// <param name="activity_name">Activity的名称</param>
	/// <returns>指定的activity句柄</returns>
	public static AndroidJavaObject GetActivity (string package_name, string activity_name)
	{
		return new AndroidJavaClass (package_name).GetStatic<AndroidJavaObject> (activity_name);
	}

}
