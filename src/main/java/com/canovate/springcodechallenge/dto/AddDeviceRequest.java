package com.canovate.springcodechallenge.dto;

import lombok.Data;

@Data
public class AddDeviceRequest {
    private String brand;
    private String model;
    private String os;
    private String osVersion;
}
