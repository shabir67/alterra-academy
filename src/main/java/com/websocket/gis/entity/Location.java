package com.websocket.gis.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {
    private String user;
    private String latitude;
    private String longitude;
    private String time;

}
