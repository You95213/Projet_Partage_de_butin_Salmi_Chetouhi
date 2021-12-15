import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class File {

	
	public void readFile(String f) {
		
		
		try(BufferedReader br = new BufferedReader ( new FileReader(f))) {
			String ligne = null ;
			while (( ligne = br.readLine ()) != null ){
				//System.out.println(ligne);
				
				if(tokenizer(ligne).equals("pirate")) {
					System.out.println("pirate");
					
				}
				else if(tokenizer(ligne).equals("objet")) {
					System.out.println("objet");
				}
				else if(tokenizer(ligne).equals("deteste")) {
					System.out.println("deteste");
				}
				else if(tokenizer(ligne).equals("preferences")) {
					System.out.println("preferences");
				}
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("le fichier n'a pas été trouvé");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	
	public String tokenizer(String s) {
		
		StringTokenizer st = new StringTokenizer(s, "().");
		//System.out.println(st.nextToken());
		return st.nextToken();
	}
	
	//public void 
	
}
