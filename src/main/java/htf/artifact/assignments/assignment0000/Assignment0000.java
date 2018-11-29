package htf.artifact.assignments.assignment0000;


import htf.artifact.base64Decoding.ImageStringDecoder;
import htf.artifact.post.PostSolution;
import org.springframework.stereotype.Component;

@Component
public class Assignment0000 {

    private final ImageStringDecoder imageStringDecoder;
    private final PostSolution postSolution;

    public Assignment0000(ImageStringDecoder imageStringDecoder, PostSolution postSolution) {
        this.imageStringDecoder = imageStringDecoder;
        this.postSolution = postSolution;
    }

    public void decrypt() {
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
            } }
        String response = postSolution.postSolved(stringBuilder.toString(), "0000");
        imageStringDecoder.decodeToImage(response, "C://KdG/HTF/images/image0000.png");
    }



}
