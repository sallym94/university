package festival;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class backup {

	FileReader fr = new FileReader(fileName);
	BufferedReader br = new BufferedReader(fr);
	
	String sCurrentLine = br.readLine();
	int numOfSessions = new Integer(sCurrentLine);
	String source = "nothing";
	String v2 = "nothing";
	int session = 0;
	int count = 0;
	
	while ((sCurrentLine = br.readLine()) != null) {
		//System.out.println(sCurrentLine);
		Scanner scnr = new Scanner(sCurrentLine);
		count++;
		if (count == numOfSessions + 3){
			count = 1;
		}
		System.out.println("count: " + count);
		if (count == 1){
			source = sCurrentLine;
			System.out.println("source: " + source);
		}
					
		
		int tokenCount = 0;
		while (scnr.hasNext()){
			tokenCount++;
			String token = new String(scnr.next());
			
			if (count > 1){
				if (tokenCount == 1){
					session = new Integer(token);
				}
				if (tokenCount > 1){
					v2 = token;
					Service service = new Service(new Venue(source), new Venue(v2), session);
					System.out.println("Service about to be added: " + service);
			        timetable.addService(service);
				}
			}
			//System.out.println("token: " + token);
			
		}
		scnr.close();				
	}
	br.close();
}
