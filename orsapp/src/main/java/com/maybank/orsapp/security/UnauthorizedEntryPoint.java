/**
 * 
 */
package com.maybank.orsapp.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maybank.orsapp.dto.ResponseMessageDto;

/**
 * @author 80003905
 *
 */
@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7562997215577188693L;

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
    	ResponseMessageDto responseMessage = new ResponseMessageDto();
    	
    	responseMessage.setResponseCode("401");
    	responseMessage.setResponseMessage("UNAUTHORIZED_REQUEST");
    	response.setContentType("application/json;charset=UTF-8");
    	response.setStatus(401);
    	response.getWriter().write(objectMapper.writeValueAsString(responseMessage));
    	
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED_REQUEST");
		//throw new UnAuthorizedException("Unauthorized Request");
    }
    
}
