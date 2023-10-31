package com.eQuor.backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class MobileInfoDto {
    String brand;

    String deviceName;
    String manufacturer;
    String yearClass;
    String modelName;
    String osBuildId;
    String osInternalBuildId;
    String osName;
    String osVersion;
    String supportedCpuArchitecture;
    String totalMemory;

    String imei;

}
