package monster;


/**
* monster/MonsterPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monster.idl
* Thursday, 21 May 2015 16:44:47 o'clock KST
*/

public abstract class MonsterPOA extends org.omg.PortableServer.Servant
 implements monster.MonsterOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getAllMonster", new java.lang.Integer (0));
    _methods.put ("getMonster", new java.lang.Integer (1));
    _methods.put ("deleteMonster", new java.lang.Integer (2));
    _methods.put ("updateMonster", new java.lang.Integer (3));
    _methods.put ("createMonster", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // monster/Monster/getAllMonster
       {
         monster.MonsterInfo $result = null;
         $result = this.getAllMonster ();
         out = $rh.createReply();
         monster.MonsterInfoHelper.write (out, $result);
         break;
       }

       case 1:  // monster/Monster/getMonster
       {
         try {
           int id = in.read_long ();
           monster.MonsterInfo $result = null;
           $result = this.getMonster (id);
           out = $rh.createReply();
           monster.MonsterInfoHelper.write (out, $result);
         } catch (monster.SQLError $ex) {
           out = $rh.createExceptionReply ();
           monster.SQLErrorHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // monster/Monster/deleteMonster
       {
         try {
           int id = in.read_long ();
           monster.MonsterInfo $result = null;
           $result = this.deleteMonster (id);
           out = $rh.createReply();
           monster.MonsterInfoHelper.write (out, $result);
         } catch (monster.SQLError $ex) {
           out = $rh.createExceptionReply ();
           monster.SQLErrorHelper.write (out, $ex);
         }
         break;
       }

       case 3:  // monster/Monster/updateMonster
       {
         try {
           String name = in.read_wstring ();
           int id = in.read_long ();
           boolean owned = in.read_boolean ();
           String img = in.read_wstring ();
           int value = in.read_long ();
           int player_id = in.read_long ();
           monster.MonsterInfo $result = null;
           $result = this.updateMonster (name, id, owned, img, value, player_id);
           out = $rh.createReply();
           monster.MonsterInfoHelper.write (out, $result);
         } catch (monster.SQLError $ex) {
           out = $rh.createExceptionReply ();
           monster.SQLErrorHelper.write (out, $ex);
         }
         break;
       }

       case 4:  // monster/Monster/createMonster
       {
         String name = in.read_wstring ();
         int id = in.read_long ();
         boolean owned = in.read_boolean ();
         String img = in.read_wstring ();
         int value = in.read_long ();
         int player_id = in.read_long ();
         monster.MonsterInfo $result = null;
         $result = this.createMonster (name, id, owned, img, value, player_id);
         out = $rh.createReply();
         monster.MonsterInfoHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:monster/Monster:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Monster _this() 
  {
    return MonsterHelper.narrow(
    super._this_object());
  }

  public Monster _this(org.omg.CORBA.ORB orb) 
  {
    return MonsterHelper.narrow(
    super._this_object(orb));
  }


} // class MonsterPOA
