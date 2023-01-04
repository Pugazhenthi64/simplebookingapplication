package com.te.simplebookingsystem.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePage {

	private Integer status;
	private Boolean errMsg;
	private String message;
	private Object data;
}
