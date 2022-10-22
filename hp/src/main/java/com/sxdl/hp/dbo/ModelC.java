package com.sxdl.hp.dbo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.hp.entity.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ModelC {


    @JsonProperty("A")
    private HpVsch0AEntity A;
    @JsonProperty("B")
    private HpVsch0BEntity B;
    @JsonProperty("C")
    private List<HpVsch0CEntity> C;
    @JsonProperty("E")
    private List<HpVsch0EEntity> E;
    @JsonProperty("F")
    private HpfllowEntity F;
    @JsonProperty("H")
    private HpVsch0HEntity H;
    @JsonProperty("K")
    private HpVsch0KEntity K;
    @JsonProperty("S")
    private List<HpVsch0SEntity> S;
    @JsonProperty("NEW")
    private HpVsWt47CfnewEntity NEW;
    @JsonProperty("P")
    private Map<String,Object> P;
    @JsonProperty("SW")
    private HpVsch0FEntity SW;

    @JsonProperty("MID")
    private String MID;

}
