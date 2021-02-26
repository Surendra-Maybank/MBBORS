/**
 * 
 */
package com.maybank.orsapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maybank.orsapp.dto.ResponseMessageDto;

/**
 * @author SURENDRA
 *
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc) throws IOException, ServletException {
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	ResponseMessageDto responseMessage = new ResponseMessageDto();
    	
    	responseMessage.setResponseCode("403");
    	responseMessage.setResponseMessage("ACCESS_DENIED");
    	response.setContentType("application/json;charset=UTF-8");
    	response.setStatus(403);
    	response.getWriter().write(objectMapper.writeValueAsString(responseMessage));
        //response.sendError(HttpServletResponse.SC_FORBIDDEN, "ACCESS_DENIED");
    }

}
