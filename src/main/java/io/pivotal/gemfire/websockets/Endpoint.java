package io.pivotal.gemfire.websockets;

import io.pivotal.gemfire.domain.Envelope;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.security.PermitAll;

/**
 * Created by pivotal on 4/21/16.
 */
@Controller
public class Endpoint {

    @MessageMapping("/receive")
    @SendTo("/topic/acknowledgements")
    public String greeting(Envelope message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "hi";
    }

}
