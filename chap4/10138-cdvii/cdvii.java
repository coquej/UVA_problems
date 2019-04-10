import java.util.*;

class Ticket implements Comparable<Ticket>
{
	private String license;
	private String timestamp;
	private boolean exit;
	private int km;
	private int hora;


	public Ticket(String line){
		String [] parts = line.split("\\s+");

		license = parts[0];
		timestamp = parts[1];
		exit = parts[2].equals("exit");
		km = Integer.parseInt(parts[3]);
		hora = Integer.parseInt(timestamp.split(":")[2]);
	}


	public String getLicense(){ return license; }
	public String getTimestamp(){ return timestamp; }
	public int getKM(){ return km; }
	public int getHora(){ return hora; }

	public boolean isExit(){ return exit; }
	public boolean isInput(){ return !exit;	}

	public int compareTo(Ticket other){ return this.timestamp.compareTo(other.timestamp); }
	
	@Override
	public String toString(){
		return String.format("%-15s	%s 	%-10s	%6d\n", license, timestamp, exit ? "EXIT" : "ENTER", km);
	}

}



class CDVII
{
	private int [] fares;
	private ArrayList<Ticket> list;
	private Hashtable<String,Integer> bills;

	public CDVII(Scanner input)
	{
		fares = new int[24];
		list = new ArrayList<Ticket>();
		bills = new Hashtable<String,Integer>();

		for(int i=0; i < fares.length; i++) fares[i] = input.nextInt();
		input.nextLine();

		while(input.hasNext()){
			String line = input.nextLine().trim();

			if(line.length()>0) list.add(new Ticket(line));
			else break;
		}

		Collections.sort(list);
	}

	public void compute()
	{
		Hashtable<String,Ticket> entrances = new Hashtable<String,Ticket>();

		bills.clear();

		for(Ticket t :list){
			if(!bills.containsKey(t.getLicense())) bills.put(t.getLicense(),0);
			//if(!entrances.containsKey(t.getLicense())) entrances.put(t.getLicense(), null);
		}

		for(Ticket t:list)
		{
			if( t.isExit() )
			{
				Ticket entrance = entrances.get(t.getLicense());
				if( entrance != null){
					int coste = Math.abs(entrance.getKM()-t.getKM()) * fares[entrance.getHora()];
					bills.put(t.getLicense(), bills.get(t.getLicense()) + 100 + coste);
					entrances.remove(t.getLicense());
				}
			} else {
				entrances.put(t.getLicense(),t);
			}
		}
	}

	public void printResults()
	{
		ArrayList<String> licenses = Collections.list(bills.keys());

		Collections.sort(licenses);

		for(String license : licenses){
			float amount = bills.get(license) / 100.0F;
			if(amount>0.0) System.out.printf("%s $%.2f\n", license, amount+2);
		}
	}
}


class Main{
	public static void main(String [] args)
	{

		Scanner input = new Scanner(System.in).useLocale(Locale.US);

		int numCases = input.nextInt();

		while( --numCases >= 0 ){
			CDVII route = new CDVII(input);
			route.compute();
			route.printResults();
			if(numCases>0) System.out.println();
		}

	}
}