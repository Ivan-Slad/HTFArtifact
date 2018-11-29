package htf.artifact.post;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class PostSolution {


    public String postSolved(String body, String code) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "text/plain");

        headers.setAll(map);

        String req_payload = body;

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://34.242.133.196:8080/solve")
                .queryParam("assignmentCode", code);

        ResponseEntity<String> response = new RestTemplate().postForEntity(uriBuilder.toUriString(), request, String.class);
        String responseString = response.getBody();
        return responseString;
    }
}

