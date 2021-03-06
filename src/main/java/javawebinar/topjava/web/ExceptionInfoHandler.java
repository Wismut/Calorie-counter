package javawebinar.topjava.web;

import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.util.exception.ErrorInfo;
import javawebinar.topjava.util.exception.NotFoundException;
import javawebinar.topjava.util.exception.ValidationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


public class ExceptionInfoHandler {
	protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	@Order(Ordered.HIGHEST_PRECEDENCE)
	ErrorInfo handleError(HttpServletRequest req, NotFoundException e) {
		return LOG.getErrorInfo(req.getRequestURL(), e);
	}

	@ResponseStatus(value = HttpStatus.CONFLICT)  // 409
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	@Order(Ordered.HIGHEST_PRECEDENCE + 1)
	ErrorInfo conflict(HttpServletRequest req, DataIntegrityViolationException e) {
		return LOG.getErrorInfo(req.getRequestURL(), e);
	}

	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)  // 422
	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	@Order(Ordered.HIGHEST_PRECEDENCE + 2)
	ErrorInfo validationError(HttpServletRequest req, ValidationException e) {
		return LOG.getErrorInfo(req.getRequestURL(), e);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@Order(Ordered.LOWEST_PRECEDENCE)
	ErrorInfo handleError(HttpServletRequest req, Exception e) {
		return LOG.getErrorInfo(req.getRequestURL(), e);
	}
}
