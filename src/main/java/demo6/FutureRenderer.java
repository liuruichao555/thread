package demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 需要每下载一张图片展示一张图片
 *
 * @author liuruichao
 * @date 15/7/28 下午1:09
 */
public class FutureRenderer {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    void renderPage(CharSequence source) throws ExecutionException, InterruptedException {
        final List<ImageInfo> imageInfos = new ArrayList<>();

        Future<List<ImageData>> future = exec.submit(() -> {
            List<ImageData> result = new ArrayList<>();
            for (ImageInfo imageInfo : imageInfos) {
                result.add(imageInfo.downloadImage());
            }
            return result;
        });

        // 先绘制文本，同时请求网络图片
        reanderText();

        List<ImageData> result = future.get();
        for (ImageData imageData : result) {
            reanderImage(imageData);
        }
    }

    /**
     * 绘制图片
     * @param imageData
     */
    private void reanderImage(ImageData imageData) {
    }

    /**
     * 绘制文本
     */
    private void reanderText() {
    }

    static class ImageInfo {
        /**
         * 下载图片
         * @return
         */
        public ImageData downloadImage() {
            return null;
        }
    }
    static class ImageData {
    }
}
