import java.util.ArrayList;
import java.util.Iterator;

public class Innlegg {
	private String tekst;
	private ArrayList<String> tagged;
	private int forsteLedig = 0; // (mangler int her)

	Innlegg(String tekst) {
		this.tekst = tekst;
		tagged = new ArrayList<String>();
	}

	public boolean erTagget(String person) {
		return tagged.contains(person);
	}

	public boolean tag(String person) {
		if (erTagget(person)) {
			return false;
		} else {
			tagged.add(forsteLedig+1, person);
			forsteLedig++;
			return true;
		}
	}

	public ArrayList<String> vennerTagget(String[] venner) {
		ArrayList<String> vennerTagget = new ArrayList<String>();
		for (int i = 0; i < venner.length; i++) {
			if (tagged.contains(venner[i])) {
				vennerTagget.add(venner[i]);
			}
		}
		return vennerTagget;
	}

	public void skrivUt() {
		System.out.println(tekst);
		Iterator<String> I = tagged.iterator();
		while (I.hasNext()) {
			System.out.print("@" + I.next());
		}
	}

	public static void main(String[] args) {
		
		Innlegg i = new Innlegg("tekst");
		
		i.tag("test");
		i.tag("ee");
		
		i.skrivUt();
	}
}
