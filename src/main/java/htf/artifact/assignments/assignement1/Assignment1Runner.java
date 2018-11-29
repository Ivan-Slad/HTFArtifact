package htf.artifact.assignments.assignement1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Assignment1Runner implements ApplicationRunner {

    private final SoapClient soapClient;

    public Assignment1Runner(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(soapClient.getResponse().getPartialUnlockCode());
    }
}
