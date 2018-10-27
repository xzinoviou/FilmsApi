package dao;

import model.User;

import java.sql.SQLException;

/**
 * Created by xzinoviou
 * 27/10/2018
 */
public class UserDao extends Dao {

    public UserDao(){
        super();
    }

    public User findUserById(Long id){

        User user = null;

        try{

            String query = "SELECT * FROM USER WHERE USER_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user = new User();

                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setKey(resultSet.getString(4));
                user.setFirstName(resultSet.getString(5));
                user.setLastName(resultSet.getString(6));

            }

            closeAll();

        }catch (SQLException e){
            e.printStackTrace();

        }

        return user;
    }

    public User findUserByCredentials(String email,String password){

        User user = null;

        try{

            String query = "SELECT * FROM USER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user = new User();

                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setKey(resultSet.getString(4));
                user.setFirstName(resultSet.getString(5));
                user.setLastName(resultSet.getString(6));

            }

            closeAll();

            }catch (SQLException e){
            e.printStackTrace();

        }

        return user;
    }

    public boolean isUserPresentInDB(String email,String password){

        boolean result = false;

        try{

            String query = "SELECT * FROM USER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                result = true;
            }

            closeAll();

        } catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }

}
