package recursojavamap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursoJavaMap {

    
    public static void main(String[] args)  {
        
        Scanner input = new Scanner(System.in);

		Map<String, Integer>  map = new HashMap<>();

		System.out.print("Digite o caminho do arquivo texto: ");
		String path = input.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String nome = fields[0];
				int votos = Integer.parseInt(fields[1]);
                                
                                
                                if (map.get(nome) == null){
                                    map.put(nome, votos);
                                }else {
                                   map.put(nome, votos + map.get(nome));
                                }
                                                                
                                
				line = br.readLine();
			}
			
			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		input.close();
	}

		
		
	
    }

