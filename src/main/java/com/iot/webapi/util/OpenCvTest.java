package com.iot.webapi.util;

import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.opencv.videoio.VideoWriter;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class OpenCvTest {
    public void capture_camera(){
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME);
    }
}
