package demo6;

import com.sun.scenario.effect.ImageData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 每张图片都对应一个下载线程
 *
 * @author liuruichao
 * @date 15/7/28 下午1:21
 */
public class Renderer {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    void renderPage(CharSequence source) throws InterruptedException, ExecutionException {
        List<FutureRenderer.ImageInfo> info = new ArrayList<>();
        CompletionService<FutureRenderer.ImageData> completionService =
                new ExecutorCompletionService<FutureRenderer.ImageData>(exec);
        for (final FutureRenderer.ImageInfo imageInfo : info) {
            completionService.submit(() -> {
                return imageInfo.downloadImage();
            });
        }

        reanderText();

        for (int t = 0, n = info.size(); t < n; t++) {
            Future<FutureRenderer.ImageData> f = completionService.take();
            FutureRenderer.ImageData imageData = f.get();
            renderImage(imageData);
        }
    }

    private void renderImage(FutureRenderer.ImageData imageData) {

    }

    private void reanderText() {
    }

    /**
     * 超过时间未获得广告页面则显示默认广告
     * @return
     */
    Ad getAd() {
        Ad DEFAULT_AD = new Ad();
        Future<Ad> f = exec.submit(() -> {
            Thread.sleep(5000);
            return new Ad();
        });
        Ad ad = null;
        try {
            // xxx 等待五秒
            ad = f.get(5,TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            ad = DEFAULT_AD;
            f.cancel(true);
        }
        return ad;
    }

    static class Ad {

    }
}
