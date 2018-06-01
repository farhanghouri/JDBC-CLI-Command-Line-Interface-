package m;

public interface QueryReceiver {
     public void selectQuery(String query);
     public void insertQuery(String query);
     public void updateQuery(String query);
     public void deleteQuery(String query);
}
