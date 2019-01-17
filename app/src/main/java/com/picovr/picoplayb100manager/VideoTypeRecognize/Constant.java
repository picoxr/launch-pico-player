package com.picovr.picoplayb100manager.VideoTypeRecognize;

public class Constant {

    /**
     * absolulte value in recognization algorithm
     */
    public static final int ABSOLUTE_CRITICAL_VALUE = 35;
    /**
     * the diffrence value of top-bottom and left-right value in recognizaition algorithm
     */
    public static final int RELATIVE_CRITICAL_VALUE = 20;
    /**
     * default video's aspect ratio
     */
    public static final float DEFAULT_VIDEO_RADIO = 0.0f;
    /**
     * fuzzy range of pixel value in fuzzy algorithm
     */
    public static final int FUZZY_DIFFERENT_VALUE = 15;
    /**
     * default video type
     */
    public static final int DEFAULT_VIDEO_TYPE = MovieType.TYPE_2D;

    /**
     * default video source
     */
    public static final int TYPE_SOURCE_DEFAULT = 0;
    /**
     * video type got by video name
     */
    public static final int TYPE_SOURCE_NAME = 1;
    /**
     * video type got by compare video screenshot
     */
    public static final int TYPE_SOURCE_IMAGE_COMPARE = 2;
    /**
     * custom video type
     */
    public static final int TYPE_SOURCE_USER_DEFINE = 3;


}
