package com.pie.mvc.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Controller
public class BarCodeController {
    /** 定义二维码图片的宽度 */
    private static final int WIDTH = 200;
    /** 定义二维码图片的高度 */
    private static final int HEIGHT = 200;
    /** 定义LOGO图片的宽度 */
    private static final int LOGO_WIDTH = 50;
    /** 定义LOGO图片的高度 */
    private static final int LOGO_HEIGHT = 50;
    @GetMapping("/barcode")
    public void execute(
            @RequestParam(value = "url",required = false)String url,
            HttpServletResponse response) throws Exception {
        //判断二维码中url
        if (url==null || url.equals("")){
            url="http://www.baidu.com";
        }
        //定义map集合封装二维码配置信息
        Map<EncodeHintType, Object> hints = new HashMap<>();
        //定义二维码图片的内容编码格式
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        //设置二维码图片的上下左右间隙
        hints.put(EncodeHintType.MARGIN,1);
        //设置二维码的纠错级别
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        /*
         * 创建二维码字节转换对象
         * url                      二维码图片中的内容
         * BarcodeFormat.QR_CODE    二维码格式器
         * WIDTH                    生成二维码图片的宽度 
         * HEIGHT                   生成二维码图片的高度
         * hints                    生成二维码需要配置信息
         */
        BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        //获取二维码图片真正的宽度
        int matrixWidth = matrix.getWidth();
        int matrixHeight = matrix.getHeight();
        BufferedImage image = new BufferedImage(matrixWidth, matrixHeight, BufferedImage.TYPE_INT_RGB);
        for (int x = 0;x<matrixWidth;x++){
            for (int y = 0;y<matrixHeight;y++){
                int rgb = matrix.get(x,y)?0xFF1493 : 0xFFFFFF;
                image.setRGB(x,y,rgb);
            }
        }
        BufferedImage logo = ImageIO.read(new File(this.getClass().getResource("lc.jpg").getPath()));
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.drawImage(logo,(matrixWidth-LOGO_WIDTH)/2,(matrixHeight-LOGO_HEIGHT)/2,
                LOGO_WIDTH,LOGO_HEIGHT,null);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5.0f));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawRoundRect((matrixWidth-LOGO_WIDTH)/2,(matrixHeight-LOGO_HEIGHT)/2,
                LOGO_WIDTH,LOGO_HEIGHT,10,10);
        //输出二维码
        ImageIO.write(image,"png",response.getOutputStream());
    }
}
