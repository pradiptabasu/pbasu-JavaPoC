import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_To_CSV_parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String jsonString =
		// "{\"infile\": [{\"field1\": 11,\"field2\": 12,\"field3\": 13},{\"field1\": 21,\"field2\": 22,\"field3\": 23},{\"field1\": 31,\"field2\": 32,\"field3\": 33}]}";
		JSONObject output;

		String csvFile = "D:\\WorkSpace\\EclipseLunaOEPE\\IdentifyDataTypes\\sourceFiles\\Data_Dump.csv";
		BufferedReader br = null;
		String line = "";
		String dataline = "";
		String jsondata = "";
		String databeforejson = "";
		String dataafterjson = "";
		String cvsSplitBy = ",";
		Scanner s = new Scanner(System.in);
		Set<String> uniqueKeyListTreeSet = new TreeSet<String>();
		String[] DataArray = new String[20];
		String content = "";
		try {
			// output = new JSONObject(jsonString);
			// JSONArray docs = output.getJSONArray("infile");
			// File file = new File("/tmp2/fromJSON.csv");
			// String csv = CDL.toString(docs);
			// FileUtils.writeStringToFile(file, csv);

			br = new BufferedReader(new FileReader(csvFile));

			File outputfile = new File(
					"D:\\WorkSpace\\EclipseLunaOEPE\\IdentifyDataTypes\\destinationFile\\Data_Dump_parsed.csv");

			// if file doesnt exists, then create it
			if (!outputfile.exists()) {
				outputfile.createNewFile();
			}
			else
			{
				outputfile.delete();
				outputfile.createNewFile();
			}
			FileWriter fw = new FileWriter(outputfile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			if ((line = br.readLine()) != null) {
				// System.out.println("COLUMNS : ");
				// System.out.println(line);
				content = "IOT_ID,MESSAGE_TYPE,RECIVED_TIME,ISA,NoPowerOutput,category,description,format,generatorRotationSpeed,hubSpeed,nacelletemperature,pitchAngle,powerGeneration,severity,subject,towerViberation,towerVibration,windSpeed,GENERATED_TIME,MSG_ID";
				content = content + "\n";
				bw.write(content);
			}
			while ((line = br.readLine()) != null) {
				// String[] country = line.split(cvsSplitBy);
				// System.out.println("Country [code= " + country[4] +
				// " , name=" + country[5] + "]");

				dataline = "";
				dataline = dataline + line.trim();
				if ((line = br.readLine()) != null) {
					dataline = dataline + line.trim();
				}
				if ((line = br.readLine()) != null) {
					dataline = dataline + line.trim();
				}

				databeforejson = dataline.substring(0, dataline.indexOf("{"));

				String[] databeforejsonarray = databeforejson.split(cvsSplitBy);
				for (int i = 0; i < 4; i++) {
					// System.out.println(i);
					// System.out.println(databeforejsonarray[i]);
					DataArray[i] = databeforejsonarray[i];
				}

				jsondata = dataline.substring(dataline.indexOf("{"),
						dataline.indexOf("}") + 1);

				jsondata = jsondata.replace("\"\"", "\"");

				output = new JSONObject(jsondata);

				Iterator<?> keys = output.keys();

				while (keys.hasNext()) {
					String key = (String) keys.next();
					// uniqueKeyListTreeSet.add(key);
					switch (key) {
					case "NoPowerOutput":
						DataArray[4] = (String) output.get(key);
						break;
					case "category":
						DataArray[5] = (String) output.get(key);
						break;
					case "description":
						DataArray[6] = (String) output.get(key);
						break;
					case "format":
						DataArray[7] = (String) output.get(key);
						break;
					case "generatorRotationSpeed":
						DataArray[8] = (String) output.get(key);
						break;
					case "hubSpeed":
						DataArray[9] = (String) output.get(key);
						break;
					case "nacelletemperature":
						DataArray[10] = (String) output.get(key);
						break;
					case "pitchAngle":
						DataArray[11] = (String) output.get(key);
						break;
					case "powerGeneration":
						DataArray[12] = (String) output.get(key);
						break;
					case "severity":
						DataArray[13] = (String) output.get(key);
						break;
					case "subject":
						DataArray[14] = (String) output.get(key);
						break;
					case "towerViberation":
						DataArray[15] = (String) output.get(key);
						break;
					case "towerVibration":
						DataArray[16] = (String) output.get(key);
						break;
					case "windSpeed":
						DataArray[17] = (String) output.get(key);
						break;
					default:
						System.out.println("key not on list : " + key);
						throw new Exception();
					}
				}

				dataafterjson = dataline.substring(dataline.indexOf("}") + 2);

				String[] dataafterjsonarray = dataafterjson.split(cvsSplitBy);
				for (int i = 0; i < 2; i++) {
					// System.out.println(i);
					// System.out.println(dataafterjsonarray[i]);
					DataArray[18 + i] = dataafterjsonarray[i];
				}
				
				content = "";
				for(int i=0; i<20;i++)
				{
					//System.out.println( i + "   :   "+ DataArray[i]);
					if(DataArray[i] == null)
						DataArray[i] = "";
					if(i == 0)
					{	content = DataArray[i] + ",";
						DataArray[i]="";
						//System.out.println(content);
					}
					else if(i == 19)
					{
						content = content + DataArray[i];
						DataArray[i]="";
						//System.out.println(content);
					}
					else
					{
						content = content + DataArray[i] + ",";
						DataArray[i]="";
						//System.out.println(content);
					}
					//String input = s.nextLine();
				}
				content = content + "\n";
				//System.out.println("outside " + content);
				bw.write(content);

				//String input = s.nextLine();
			}

			bw.close();
			// System.out.println(uniqueKeyListTreeSet.size());
			// Iterator<String> itr = uniqueKeyListTreeSet.iterator();
			// while (itr.hasNext()) {
			// System.out.println(itr.next());
			// }

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io exception");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("parse exception");
			e.printStackTrace();
		}
	}

}
