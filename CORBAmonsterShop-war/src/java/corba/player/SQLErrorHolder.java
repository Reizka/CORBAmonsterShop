package player;

/**
* player/SQLErrorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from player.idl
* Thursday, 21 May 2015 16:32:51 o'clock KST
*/

public final class SQLErrorHolder implements org.omg.CORBA.portable.Streamable
{
  public player.SQLError value = null;

  public SQLErrorHolder ()
  {
  }

  public SQLErrorHolder (player.SQLError initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = player.SQLErrorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    player.SQLErrorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return player.SQLErrorHelper.type ();
  }

}
