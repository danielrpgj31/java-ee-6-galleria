package info.galleria.service.ejb;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class ModifyPasswordException extends ApplicationException
{

	private static final long serialVersionUID = 1L;

	public ModifyPasswordException(String message)
	{
		super(message);
	}

	public ModifyPasswordException(Set<ConstraintViolation<?>> violations)
	{
		super(violations);
	}

}
