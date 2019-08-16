package SQLRequests;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws Exception{

/*
Создаем подключение к БД и SQL запрос на создание таблицы
 */

        String url = "jdbc:h2:file:~/test";
        String userName = "sa";
        String password = "";


        String sqlCreateEmployee = "CREATE TABLE IF NOT EXISTS EMPLOYEE" +
                "(ID INT IDENTITY NOT NULL PRIMARY KEY, " +
                "NAME VARCHAR(100) NOT NULL," +
                "SUPERVISOR INT NULL, " +
                "BEGIN_DATE DATETIME NULL, " +
                "END_DATE DATETIME NULL, CONSTRAINT FK_SUPERVISOR FOREIGN KEY (SUPERVISOR) REFERENCES EMPLOYEE (ID))";


        Connection connection = DriverManager.getConnection(url, userName, password);

/*
Создаем таблицу
 */

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateEmployee)){
            preparedStatement.executeUpdate();

        }
/*
Выполняем первый запрос к таблице:
Выбор всех сотрудников, работавших в определенную дату
 */
         try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM EMPLOYEE WHERE (?) BETWEEN BEGIN_DATE AND END_DATE")){

            String checkTheDate = "'2015-10-05'";
            preparedStatement.setString(1, checkTheDate);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("NAME") + " " + resultSet.getInt("SUPERVISOR"));
            }

        }
       catch (SQLException e){
            e.printStackTrace();
        }
/*
Выполняем второй запрос к таблице:
Выбор всех сотрудников, работавших после определенной даты
 */
         try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE END_DATE >= (?)")){
             String checkTheDate = "'2015-10-05'";
             preparedStatement.setString(1, checkTheDate);
             ResultSet resultSet = preparedStatement.executeQuery();

             while (resultSet.next()){
                 System.out.println(resultSet.getString("NAME") + " " + resultSet.getInt("SUPERVISOR"));
             }
         }
/*
Создаем третий запрос к таблице:
Выбор сотрудника по имени с выводом информации о
его руководителе
 */
         try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE NAME = (?)")){
             String name = "Ivan";
             preparedStatement.setString(1, name);
             ResultSet resultSet = preparedStatement.executeQuery();
             resultSet.next();

             System.out.println(resultSet.getString("NAME") + " " +resultSet.getString("SUPERVISOR"));
         }
/*
Закрываем соединение с БД
 */
        if (connection != null)
        connection.close();
    }
}
