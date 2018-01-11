package com.iot.webapi.login.logic.impl

import com.iot.webapi.login.logic.ImageProcessing
import org.opencv.core.Core
import org.opencv.videoio.VideoCapture
import org.opencv.videoio.Videoio
import org.opencv.videoio.VideoWriter
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc


class ImageProcessingImpl : ImageProcessing{

    override fun imageProcess() {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME)
        var source_video: VideoCapture? = VideoCapture("test.mp4")

        if ( source_video == null){
            println("動画が読み込めません")
            System.exit( 0)
        }

        var video_writer: VideoWriter? = VideoWriter("test_gray.avi", VideoWriter.fourcc('M', 'J', 'P', 'G'), source_video.get( Videoio.CAP_PROP_FPS ), Size( 512.0, 384.0))
    }
}