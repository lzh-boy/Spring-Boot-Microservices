package microservices.book.gamification.client;

import microservices.book.gamification.client.dto.MultiplicationResultAttempt;
import microservices.book.gamification.client.dto.MultiplicationResultAttemptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 3/1/2018.
 */

@Component
public class MultiplicationResultAttemptClientImpl implements MultiplicationResultAttemptClient {

    private final RestTemplate restTemplate;
    private final String multiplicationHost;

    @Autowired
    public MultiplicationResultAttemptClientImpl(RestTemplate restTemplate,@Value("${multiplicationHost}") String multiplicationHost) {
        this.restTemplate = restTemplate;
        this.multiplicationHost = multiplicationHost;
    }

    @Override
    public MultiplicationResultAttempt retrieveMultiplicationResultAttemptById(Long multiplicationId) {
       return restTemplate.getForObject(multiplicationHost + "/result" + multiplicationId, MultiplicationResultAttempt.class);
    }

}