package com.example.demo.model.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class RHDto extends BaseDto{

	@JsonIgnoreProperties("rh")
    private List<CongéDto> congés;

	@JsonIgnoreProperties("rh")
    private List<CandidatureDto> candidatures;

}
