package de.klsssolution.gablerlog.presentation;

import de.klsssolution.gablerlog.model.Kunde;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@ManagedBean
@SessionScoped
public class SampleBean
    {
        private  List<Kunde> kundenliste = new ArrayList<Kunde>();

        public List<Kunde> getKundenliste() {
            return kundenliste;
        }

        public void setKundenliste(List<Kunde> kundenliste) {
            this.kundenliste = kundenliste;
        }
        /*
        public static void main(String[] args) throws ClassNotFoundException
        {
            // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC");

            Connection connection = null;
            try
            {
                // create a database connection
                connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                statement.executeUpdate("drop table if exists person");
                statement.executeUpdate("create table person (id integer, name string)");
                statement.executeUpdate("insert into person values(1, 'leo')");
                statement.executeUpdate("insert into person values(2, 'yui')");
                ResultSet rs = statement.executeQuery("select * from person");
                while(rs.next())
                {
                    Map<Integer, String> dbtest = new TreeMap<Integer, String>();
                    dbtest.put(rs.getInt(rs.getInt("id")),rs.getString("name"));
                    // read the result set
                    System.out.println("name = " + rs.getString("name"));
                    System.out.println("id = " + rs.getInt("id"));

                    setDbtest(dbtest);
                }
            }
            catch(SQLException e)
            {
                // if the error message is "out of memory",
                // it probably means no database file is found
                System.err.println(e.getMessage());
            }
            finally
            {
                try
                {
                    if(connection != null)
                        connection.close();
                }
                catch(SQLException e)
                {
                    // connection close failed.
                    System.err.println(e);
                }
            }
        }
*/



@PostConstruct
        public void databaseConnection() throws ClassNotFoundException
        {
            // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC");

            Connection connection = null;
            try
            {
                // create a database connection
                connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.

                //statement.executeUpdate("drop table if exists person");
                //statement.executeUpdate("create table person (id integer, name string)");
                statement.executeUpdate("insert into person values(1, 'leo')");
                statement.executeUpdate("insert into person values(2, 'yui')");
                ResultSet rs = statement.executeQuery("select * from person");

                List<Kunde> kundenliste = new ArrayList<Kunde>();
                while(rs.next())
                {


                    Kunde k = new Kunde();
                    k.setFirmenbezeichnung(rs.getString("name"));
                    k.setKundenId(rs.getInt("id"));

                   kundenliste.add(k);

                    // read the result set
                    System.out.println("name = " + rs.getString("name"));
                    System.out.println("id = " + rs.getInt("id"));
                }
                this.kundenliste = kundenliste;
            }
            catch(SQLException e)
            {
                // if the error message is "out of memory",
                // it probably means no database file is found
                System.err.println(e.getMessage());
            }
            finally
            {
                try
                {
                    if(connection != null)
                        connection.close();
                }
                catch(SQLException e)
                {
                    // connection close failed.
                    System.err.println(e);
                }
            }
        }



    }
