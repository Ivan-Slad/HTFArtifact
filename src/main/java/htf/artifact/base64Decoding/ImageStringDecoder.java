package htf.artifact.base64Decoding;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

@Component
public class ImageStringDecoder {

    public void decodeToImage(String imageString, String url) {
        BufferedImage image = null;
        byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            ImageIO.write(image, "png", new File(url));
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
