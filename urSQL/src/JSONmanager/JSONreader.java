/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JSONmanager;

/**
 *
 * @author Erick
 */
/*
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONreader {
    
    public JSONreader(String path){
        
        JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("c:\\FileTests\\prueba.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String blog = (String) jsonObject.get("Blog");
			System.out.println(blog);

			String temas = (String) jsonObject.get("Temas");
			System.out.println(temas);
			
			long inicio = (Long) jsonObject.get("Inicio");
			System.out.println(inicio);

			JSONObject innerObject = (JSONObject) jsonObject.get("Posts");
			System.out.println(innerObject.toJSONString());
			
			// loop array
			JSONArray tags = (JSONArray) jsonObject.get("Tags");
			Iterator<String> iterator = tags.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (ParseException e) {
			//manejo de error
		}
    }
    
}*/
