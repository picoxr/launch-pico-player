package com.picovr.picoplayb100manager.VideoTypeRecognize;

public class Constant {

    /**
     * 识别算法中相似度的绝对值
     */
    public static final int ABSOLUTE_CRITICAL_VALUE = 35;
    /**
     * 识别算法中上下相似度和左右相似度的差值
     */
    public static final int RELATIVE_CRITICAL_VALUE = 20;
    /**
     * 默认的视频宽高比
     */
    public static final float DEFAULT_VIDEO_RADIO = 0.0f;
    /**
     * 模糊算法中像素值的模糊范围
     */
    public static final int FUZZY_DIFFERENT_VALUE = 15;
    /**
     * 默认的视频类型
     */
    public static final int DEFAULT_VIDEO_TYPE = MovieType.TYPE_2D;

    /**
     * 默认的视频类型来源
     */
    public static final int TYPE_SOURCE_DEFAULT = 0;
    /**
     * 视频类型通过视频名字获得
     */
    public static final int TYPE_SOURCE_NAME = 1;
    /**
     * 视频类型通过视频截图对比获得
     */
    public static final int TYPE_SOURCE_IMAGE_COMPARE = 2;
    /**
     * 视频类型由用户自己定义
     */
    public static final int TYPE_SOURCE_USER_DEFINE = 3;


}