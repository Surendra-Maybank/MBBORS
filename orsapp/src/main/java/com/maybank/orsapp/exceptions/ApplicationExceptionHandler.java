/**
 * 
 */
package com.maybank.orsapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.maybank.orsapp.dto.ResponseMessageDto;

/**
 * @author 80003905
 *
 */

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseMessageDto> userNotFound(UserNotFoundException e){		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setResponseCode("01");
		responseMessageDto.setResponseMessage(e.getMessage());
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);		
	}
	
	@ExceptionHandler(UserAccountHandlingException.class)
	public ResponseEntity<ResponseMessageDto> userAccountHandling(UserAccountHandlingException e){		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setResponseCode("01");
		responseMessageDto.setResponseMessage(e.getMessage());
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);		
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ResponseMessageDto> badCredentialsException(BadCredentialsException e){		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setResponseCode("03");
		responseMessageDto.setResponseMessage(e.getMessage());
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);		
	}
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ResponseMessageDto> applicationException(Exception e){		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setResponseCode("99");
		responseMessageDto.setResponseMessage(e.getMessage());
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);		
	}
	
	@ExceptionHandler(RequestDataValidationException.class)
	public ResponseEntity<ResponseMessageDto> dataValidationException(Exception e){		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setResponseCode("02");
		responseMessageDto.setResponseMessage(e.getMessage());
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);		
	}
	
	@ExceptionHandler(UnAuthorizedException.class)
	public ResponseEntity<ResponseMessageDto> unAuthorizedException(Exception e){		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		responseMessageDto.setResponseCode("401");
		responseMessageDto.setResponseMessage(e.getMessage());
		return new ResponseEntity<>(responseMessageDto, HttpStatus.UNAUTHORIZED);		
	}

}
