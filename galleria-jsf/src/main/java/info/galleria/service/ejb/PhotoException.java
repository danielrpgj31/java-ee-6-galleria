package info.galleria.service.ejb;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class PhotoException extends Exception
{

	private static final long serialVersionUID = -2945405604872729926L;

	public PhotoException(String message)
	{
		super(message);
	}

	public PhotoException(Throwable cause)
	{
		super(cause);
	}

	public PhotoException(Set<ConstraintViolation<?>> violations)
	{
		super();
	}

}
