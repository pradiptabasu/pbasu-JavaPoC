package com.pradipta.https;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class HttpsClient {

	public static void main(String[] args) {
		new HttpsClient().testIt();
	}

	private void testIt() {

		//String https_url = "https://www.google.com/";
		
		String https_url = "https://oa9095.us.oracle.com:7102/ui/";
		
		URL url;
		
		try {
			
			/*
			 	System.setProperty("http.proxyHost", "myProxyServer.com");
				System.setProperty("http.proxyPort", "80");
				URL url=new URL("http://someserver/somepage");
				URLConnection uc = url.openConnection ();
				String encoded = new String(Base64.base64Encode(new String("username:password").getBytes()));
				uc.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
				uc.connect();
			*/
			
			//System.setProperty("http.proxyHost", "www-proxy.idc.oracle.com");
			//System.setProperty("http.proxyPort", "80");
			//System.getProperties().put("http.proxyUser", "someUserName");
			//System.getProperties().put("http.proxyPassword", "somePassword");
			//System.setProperty("java.net.useSystemProxies", "true");
			
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("www-proxy.idc.oracle.com", 80));
			
			url = new URL(https_url);
			
			SSLContext sc = SSLContext.getInstance("TLS");
			
			 sc.init(null, new TrustManager[]{new X509TrustManager() {
		            @Override
					public void checkClientTrusted(
							java.security.cert.X509Certificate[] chain,
							String authType)
							throws java.security.cert.CertificateException {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void checkServerTrusted(
							java.security.cert.X509Certificate[] chain,
							String authType)
							throws java.security.cert.CertificateException {
						// TODO Auto-generated method stub
						
					}

					@Override
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						// TODO Auto-generated method stub
						return null;
					}
		        }}, null);
			 
			HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
			};
			
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			//HttpsURLConnection con = (HttpsURLConnection) url.openConnection(proxy);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			// dumpl all cert info
			print_https_cert(con);

			// dump all the content
			print_content(con);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void print_https_cert(HttpsURLConnection con) {

		if (con != null) {

			try {

				System.out.println("Response Code : " + con.getResponseCode());
				System.out.println("Cipher Suite : " + con.getCipherSuite());
				System.out.println("\n");

				Certificate[] certs = con.getServerCertificates();
				for (Certificate cert : certs) {
					System.out.println("Cert Type : " + cert.getType());
					System.out.println("Cert Hash Code : " + cert.hashCode());
					System.out.println("Cert Public Key Algorithm : "
							+ cert.getPublicKey().getAlgorithm());
					System.out.println("Cert Public Key Format : "
							+ cert.getPublicKey().getFormat());
					System.out.println("\n");
				}

			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private void print_content(HttpsURLConnection con) {
		if (con != null) {

			try {

				System.out.println("****** Content of the URL ********");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream()));

				String input;

				while ((input = br.readLine()) != null) {
					System.out.println(input);
				}
				br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
