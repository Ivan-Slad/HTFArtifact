package htf.artifact.assignments.assignement0010;

import htf.artifact.assignments.model.FibonacciOutcome;
import htf.artifact.base64Decoding.ImageStringDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Assignment0010Runner implements CommandLineRunner {

    private final SoapClient soapClient;

    private final ImageStringDecoder imageStringDecoder;

    private final String path;
    public Assignment0010Runner(SoapClient soapClient, ImageStringDecoder imageStringDecoder, @Value("images") String path) {
        this.soapClient = soapClient;
        this.imageStringDecoder = imageStringDecoder;
        this.path = path;
    }

    @Override
    public void run(String... args) throws Exception {
        FibonacciOutcome fibonacciOutcome = soapClient.getResponse();
        imageStringDecoder.decodeToImage(fibonacciOutcome.getPartialUnlockCode(), path+"/image0010");
    }
}
