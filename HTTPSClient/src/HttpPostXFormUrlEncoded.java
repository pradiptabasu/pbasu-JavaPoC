import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class HttpPostXFormUrlEncoded {

	String cookie;

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String excutePost(String targetURL, String urlParameters, String contentType) {
		URL url;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", contentType);
			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			if(this.getCookie() != null && this.getCookie().contains("connect.sid"))
			{
				connection.setRequestProperty("Cookie", this.getCookie()); 
			}
				
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 299) {
				System.out.println("response code is " + connection.getResponseCode());
			
				Map<String, List<String>> headerFields = connection.getHeaderFields();
		        Set<String> headerFieldsSet = headerFields.keySet();
		        Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
		        while (hearerFieldsIter.hasNext()) {
		             String headerFieldKey = hearerFieldsIter.next();
		             if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
		                 List<String> headerFieldValue = headerFields.get(headerFieldKey);
		                 //System.out.println(headerFieldValue);
		                 for (String headerValue : headerFieldValue) {
		                    //System.out.println("Cookie Found...");
		                    //System.out.println(headerValue);
		                    String[] fields = headerValue.split(";\\s*");
		                    String cookieValue = fields[0];
		                    String expires = null;
		                    String path = null;
		                    String domain = null;
		                    boolean secure = false;
		                     
		                    // Parse each field
		                    for (int j = 1; j < fields.length; j++) {
		                        if ("secure".equalsIgnoreCase(fields[j])) {
		                            secure = true;
		                        }
		                        else if (fields[j].indexOf('=') > 0) {
		                            String[] f = fields[j].split("=");
		                            if ("expires".equalsIgnoreCase(f[0])) {
		                                expires = f[1];
		                            }
		                            else if ("domain".equalsIgnoreCase(f[0])) {
		                                domain = f[1];
		                            }
		                            else if ("path".equalsIgnoreCase(f[0])) {
		                                path = f[1];
		                            }
		                        }
		                         
		                    }
		                     
		                    System.out.println("cookieValue:" + cookieValue);
		                    System.out.println("expires:" + expires);
		                    System.out.println("path:" + path);
		                    System.out.println("domain:" + domain);
		                    System.out.println("secure:" + secure);
		                    System.out.println("*****************************************");
		                    this.setCookie(cookieValue);
		    
		                 }
		            }
		        }
			}

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	public String excuteGet(String targetURL, String urlParameters) {
		URL url;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			if(this.getCookie() != null && this.getCookie().contains("connect.sid"))
			{
				connection.setRequestProperty("Cookie", this.getCookie()); 
			}
				
			connection.setUseCaches(false);
			//connection.setDoInput(true);
			connection.setDoOutput(true);

			if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 299) {
				System.out.println("response code is " + connection.getResponseCode());
			
				Map<String, List<String>> headerFields = connection.getHeaderFields();
		        Set<String> headerFieldsSet = headerFields.keySet();
		        Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
		        while (hearerFieldsIter.hasNext()) {
		             String headerFieldKey = hearerFieldsIter.next();
		             if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
		                 List<String> headerFieldValue = headerFields.get(headerFieldKey);
		                 //System.out.println(headerFieldValue);
		                 for (String headerValue : headerFieldValue) {
		                    //System.out.println("Cookie Found...");
		                    //System.out.println(headerValue);
		                    String[] fields = headerValue.split(";\\s*");
		                    String cookieValue = fields[0];
		                    String expires = null;
		                    String path = null;
		                    String domain = null;
		                    boolean secure = false;
		                     
		                    // Parse each field
		                    for (int j = 1; j < fields.length; j++) {
		                        if ("secure".equalsIgnoreCase(fields[j])) {
		                            secure = true;
		                        }
		                        else if (fields[j].indexOf('=') > 0) {
		                            String[] f = fields[j].split("=");
		                            if ("expires".equalsIgnoreCase(f[0])) {
		                                expires = f[1];
		                            }
		                            else if ("domain".equalsIgnoreCase(f[0])) {
		                                domain = f[1];
		                            }
		                            else if ("path".equalsIgnoreCase(f[0])) {
		                                path = f[1];
		                            }
		                        }
		                         
		                    }
		                     
		                    System.out.println("cookieValue:" + cookieValue);
		                    System.out.println("expires:" + expires);
		                    System.out.println("path:" + path);
		                    System.out.println("domain:" + domain);
		                    System.out.println("secure:" + secure);
		                    System.out.println("*****************************************");
		                    this.setCookie(cookieValue);
		    
		                 }
		            }
		        }
		        
				// Get Response
				InputStream is = connection.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				String line;
				StringBuffer response = new StringBuffer();
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
				return response.toString();
			}
			else {
				InputStream is = connection.getErrorStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				String line;
				StringBuffer response = new StringBuffer();
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
				return response.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String urlParameters = "username=" + URLEncoder.encode("pradipta", "UTF-8") + "&password=" + URLEncoder.encode("pradipta", "UTF-8");
		HttpPostXFormUrlEncoded obj1 = new HttpPostXFormUrlEncoded();
		String result = "";
		//result = obj1.excutePost("http://ec2-3-17-74-12.us-east-2.compute.amazonaws.com:3000/auth/login", urlParameters, "application/x-www-form-urlencoded");
		result = obj1.excuteGet("http://ec2-3-17-74-12.us-east-2.compute.amazonaws.com:3000/auth/testAPI", urlParameters);
		System.out.println(result);
	}

}

// if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
// br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
// } else {
// br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
// }

// JsonParser parser = new JsonParser();
// JsonObject o = parser.parse("{\"a\": \"A\"}").getAsJsonObject();

// String json = {"phonetype":"N95","cat":"WP"};
//
// try {
//
// JSONObject obj = new JSONObject(json);
//
// Log.d("My App", obj.toString());
//
// } catch (Throwable t) {
// Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
// }

// private static final String JSON_STRING =
// "{\"person\":{\"name\":\"A\",\"age\":30,\"children\":[{\"name\":\"B\",\"age\":5},"
// + "\"name\":\"C\",\"age\":7},{\"name\":\"D\",\"age\":9}]}}";
// JSONObject person = (new JSONObject(JSON_STRING)).getJSONObject("person");
// String name = person.getString("name");
// line1.setText("This person's name is " + name);
// line2.setText(name + " is " + person.getInt("age") + " years old.");
// line3.setText(name + " has " + person.getJSONArray("children").length() + "
// children.");
