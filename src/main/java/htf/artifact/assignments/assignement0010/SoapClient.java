package htf.artifact.assignments.assignement0010;

import java.util.*;

import htf.artifact.assignments.model.FibonacciOutcome;
import htf.artifact.assignments.model.FibonacciRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport{
    public final static int MAX =1000;

    public FibonacciOutcome getResponse(){
        Calculator calculator = new Calculator();
        FibonacciRequest request =new FibonacciRequest();

        request.setInput( MAX);
        List<Integer> responses = calculator.getFibonacci(MAX);

        request.getResponse().addAll( responses);

        FibonacciOutcome response = (FibonacciOutcome) getWebServiceTemplate().marshalSendAndReceive(
                "http://34.242.133.196:8080/ws",
                request,
                new SoapActionCallback("http://c4j.be/htf/fibonacci-web-service/FibonacciPort/fibonacci/fibonacciRequest"));
        return response;
   }
}
