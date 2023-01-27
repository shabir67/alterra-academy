package com.websocket.gis.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.websocket.gis.entity.Location;

@Controller
public class CommunicationController {
    private static final Logger logger = LoggerFactory.getLogger(CommunicationController.class);
    public static Map<String, Location> latestLocationFeed = new HashMap<String, Location>();

    @MessageMapping("/saveLocation")
    @SendTo("/app/getData")
    public List<Location> saveLocation(@Payload Location bean, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", bean.getUser());
        logger.debug("\tUser:"+bean.getUser()+" >>> LocationBean:"+bean.toString());

        latestLocationFeed.put(bean.getUser(), bean);

        //converting map to list
        Collection<Location> values = latestLocationFeed.values();
        ArrayList<Location> listOfValues = new ArrayList<Location>(values);
        logger.info("\tPublicLocationFeed:"+listOfValues.toString());

        return listOfValues;
    }
}
