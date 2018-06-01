package m;

public class SelectQueryCommand implements Command{
	private QueryReceiver qr;
	
	public SelectQueryCommand(QueryReceiver qr){
    	this.qr = qr;
    }

	@Override
	public void execute(String query) {
		qr.selectQuery(query);
	}
    
}
