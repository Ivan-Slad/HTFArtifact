package htf.artifact.assignments.assignement0010;

import htf.artifact.assignments.model.FibonacciOutcome;
import htf.artifact.base64Decoding.ImageStringDecoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Assignment0010Runner implements CommandLineRunner {

    private final SoapClient soapClient;

    private final ImageStringDecoder imageStringDecoder;

    public Assignment0010Runner(SoapClient soapClient, ImageStringDecoder imageStringDecoder) {
        this.soapClient = soapClient;
        this.imageStringDecoder = imageStringDecoder;
    }

    @Override
    public void run(String... args) throws Exception {
        FibonacciOutcome fibonacciOutcome = soapClient.getResponse();
        imageStringDecoder.decodeToImage(fibonacciOutcome.getPartialUnlockCode(), "C://KdG/HTF/images/image0010.png");
    }
}
