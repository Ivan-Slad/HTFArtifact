package htf.artifact.assignments;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class assignment0 {
    public static void main(String[] args) {
        String toDecrypt = "Utk yzkv iruykx zu atruiqotm znk gxzolgiz";
        StringBuilder stringBuilder = new StringBuilder(toDecrypt);
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < toDecrypt.length(); i++) {
                if (stringBuilder.charAt(i) != ' ') {
                    if (stringBuilder.charAt(i) == 'a') {
                        stringBuilder.setCharAt(i, 'z');
                    } else {
                        stringBuilder.setCharAt(i, (char) (stringBuilder.charAt(i) - 1));
                    }
                }
            }
            System.out.println(stringBuilder.toString());
        }
        String response = PostDecrypted(stringBuilder.toString());

        BufferedImage image = decodeToImage(response);


    }


    private static String PostDecrypted(String decrypted) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "text/plain");



        headers.setAll(map);

        String req_payload = decrypted;

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://34.242.133.196:8080/solve")
                .queryParam("assignmentCode", "0000");

        ResponseEntity<String> response = new RestTemplate().postForEntity(uriBuilder.toUriString(), request, String.class);
        String responseString = response.getBody();
        return responseString;
    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            ImageIO.write(image, "png", new File("C://KDG/HTF/images/image0000.png"));
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
