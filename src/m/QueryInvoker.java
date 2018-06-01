package m;

public class QueryInvoker {
    private Command command;
    public QueryInvoker(Command command){
    	this.command = command;
    }
    public void execute(String query){
    	command.execute(query);
    }
}
