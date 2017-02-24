package sift;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

/**
 * Test1
 *
 * @author liuruichao
 *         Created on 2016-03-30 13:17
 */
public class Test1 {
    public static void main(String[] args) {
        String filename = "/Users/liuruichao/Downloads/ali6823344368551397.jpg";
        IplImage image = cvLoadImage(filename);
        if (image != null) {
            cvSmooth(image, image);
            cvSaveImage(filename, image);
            cvReleaseImage(image);
        }
    }
}
