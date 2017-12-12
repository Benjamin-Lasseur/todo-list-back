package benjamin.todolistback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ValidationNoteException extends Exception {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 1L;

	public ValidationNoteException(String errorMsg) {
		super(errorMsg);
	}

	@ExceptionHandler(ValidationNoteException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleException(ValidationNoteException e) {
		return e.getMessage();
	}

}
