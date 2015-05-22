/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import monster.MonsterInfo;
import monster._MonsterStub;
import player.PlayerInfo;
import player.SQLError;

/**
 *
 * @author Renny
 */
public class MonsterImpl extends _MonsterStub{
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/monster_shop?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "renny12";

    public MonsterImpl() {
    }

    public MonsterInfo getMonster(int id){
        Connection conn = null;
        //Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement("select * from monster_details where id = ?");
            // phone = PK in player table
            ps.setInt(id, id);
            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                System.out.println("no player with this" + id + "ID");
            }

            return new MonsterInfo(rset.getString(1), rset.getInt(2), rset.getBoolean(3), rset.getString(4), rset.getInt(5), rset.getInt(6));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return null;

    }

    public MonsterInfo updateMonster(String name, int id, boolean owned, String img, int value, int playerId){
        try {
            Connection conn = null;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps
                    = conn.prepareStatement(""
                            + "set name=? "
                            + "set owned=? "
                            + "set img=? "
                            + "set value = ? "
                            + "set playerId= ? "
                            + "from monster_details "
                            + "where id = ?"
                    );
            ps.setString(1, name);
            ps.setBoolean(2, owned);
            ps.setString(3, img);
            ps.setInt(4, value);
            ps.setInt(5, playerId);
            ps.setInt(6, id);

            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("Error updating" + name);
            }

            return new MonsterInfo(rset.getString(1), rset.getInt(2), rset.getBoolean(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLError ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    public MonsterInfo createMonster(String name, int id, boolean owned, String img, int value, int playerId){
           try {
            Connection conn = null;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps
                    = conn.prepareStatement("insert into player "
                            + "(name,"
                            + "id,"
                            + "owned,"
                            + "img,"
                            + "value,"
                            + "playerId)"
                            + "values(?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.setBoolean(3, owned);
            ps.setString(4, img);
            ps.setInt(5, value);
            ps.setInt(6, playerId);

            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("Error updating" + name);
            }
            return new MonsterInfo(rset.getString(1), rset.getInt(2), rset.getBoolean(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
        } catch (ClassNotFoundException | SQLException | SQLError ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               
           } 
        return null;
    }
    
    public MonsterInfo deleteMonster(int id){
    
        try {
            Connection conn = null;

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement ps
                    = conn.prepareStatement("delete from monster_detail where id = ?");
            ps.setInt(1, id);
            ResultSet rset = ps.executeQuery();
            if (!rset.next()) {
                throw new SQLError("Error deleting" + id);
            }
            return new MonsterInfo(rset.getString(1), rset.getInt(2), rset.getBoolean(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
        } catch (ClassNotFoundException | SQLException | SQLError ex) {
            Logger.getLogger(PlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               
           } 
        return null;
    
    }
}
