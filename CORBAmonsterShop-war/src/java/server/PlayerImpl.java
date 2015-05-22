package server;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import player.PlayerInfo;
import player.SQLError;
import player._PlayerStub;

public class PlayerImpl extends _PlayerStub {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/monster_shop?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "renny12";

    public PlayerImpl() {
    }

    public PlayerInfo getPlayer(int phone) throws SQLError {
        Connection conn = null;
        //Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement("select * from player where phone = ?");
            // phone = PK in player table
            ps.setInt(phone, phone);
            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("no player with this" + phone + "ID");
            }

            return new PlayerInfo(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            throw new SQLError(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new SQLError(ex.getMessage());
            }
        }

        return null;

    }

    public PlayerInfo updatePlayer(String name, int phone, String password, int calory_burned_total, int steps_taken, int exp, int weight, int monster_money, String email) throws SQLError {
        try {
            Connection conn = null;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps
                    = conn.prepareStatement(""
                            + "set name=? "
                            + "set password= ? "
                            + "set calory_burned_total=? "
                            + "set steps_taken=? "
                            + "set exp = ? "
                            + "set weight= ? "
                            + "set monster_money=? "
                            + "set email=?"
                            + "from player "
                            + "where phone = ?"
                    );
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setInt(3, calory_burned_total);
            ps.setInt(4, steps_taken);
            ps.setInt(5, exp);
            ps.setInt(6, weight);
            ps.setInt(7, monster_money);
            ps.setString(8, email);
            ps.setInt(9, phone);

            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("Error updating" + name);
            }

            return new PlayerInfo(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            throw new SQLError(ex.getMessage());
        } catch (SQLError ex) {
            throw new SQLError(ex.getMessage());
        }
        return null;
    }
    
    
    public PlayerInfo createPlayer(String name, int phone, String password, int calory_burned_total, int steps_taken, int exp, int weight, int monster_money, String email){
           try {
            Connection conn = null;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps
                    = conn.prepareStatement("insert into player "
                            + "(name,"
                            + "phone,"
                            + "password,"
                            + "calory_burned_total,"
                            + "steps_taken,"
                            + "exp,"
                            + "weight,"
                            + "monster_money,"
                            + "email)"
                            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, phone);
            ps.setString(3, password);
            ps.setInt(4, calory_burned_total);
            ps.setInt(5, steps_taken);
            ps.setInt(6, exp);
            ps.setInt(7, weight);
            ps.setInt(8, monster_money);
            ps.setString(9, email);

            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("Error updating" + name);
            }

            return new PlayerInfo(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLError ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               
           } 
        return null;
    }
    
    public PlayerInfo deletePlayer(int phone)throws SQLError{
    
        try {
            Connection conn = null;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps
                    = conn.prepareStatement("delete from player where phone = ?");
            ps.setInt(1, phone);
            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("Error deleting" + phone);
            }
            return new PlayerInfo(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getString(9));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLError ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               
           } 
        return null;
    
    }
}
