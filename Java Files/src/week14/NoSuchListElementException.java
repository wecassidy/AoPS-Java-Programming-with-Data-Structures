package week14;

public class NoSuchListElementException extends IllegalArgumentException {
	public NoSuchListElementException()
	{
		super();
	}  
	public NoSuchListElementException(String mesg)
	{
		super(mesg);
	}
}