

public class Database  {
    private IDatabase iDatabase;

    public Database(IDatabase iDatabase) {
        this.iDatabase = iDatabase;
    }


    public String searchInDatabase(String text) throws ProductNotFoundException {
        String tmp = this.iDatabase.searchInDatabase(text);
        return tmp;
//        try {
//            String tmp = this.iDatabase.searchInDatabase(text);
//            return tmp;
//        }
//        catch (NotFoundException e){
//            System.out.println(e);
//            return null;
//        }
       // return "nnnn";
    }
}
