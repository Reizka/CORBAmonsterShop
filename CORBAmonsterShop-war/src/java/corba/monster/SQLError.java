package monster;


/**
* monster/SQLError.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monster.idl
* Thursday, 21 May 2015 16:44:47 o'clock KST
*/

public final class SQLError extends org.omg.CORBA.UserException
{
  public String message = null;

  public SQLError ()
  {
    super(SQLErrorHelper.id());
  } // ctor

  public SQLError (String _message)
  {
    super(SQLErrorHelper.id());
    message = _message;
  } // ctor


  public SQLError (String $reason, String _message)
  {
    super(SQLErrorHelper.id() + "  " + $reason);
    message = _message;
  } // ctor

} // class SQLError