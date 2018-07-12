package br.com.aprendaSeleniumComThiago.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;



/**
 * Classe com metodos de apoio, que otimizam a codificacao das classes de pagina
 * 
 * @author thiago.freire
 * 
 */
public abstract class Utils {


	private static final SimpleDateFormat aFormat = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat hFormat = new SimpleDateFormat("HHmmss");


	public static String extrairStackTrace(Exception e) {
		StackTraceElement[] stack = e.getStackTrace();
		String exception = "";
		for (StackTraceElement s : stack) {
			exception = exception + s.toString() + "\n\t\t";
		}
		return exception;
	}

	
	
	static {
		disableSslVerification();
	}

	private static void disableSslVerification() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				
				public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
				}
				
				public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
				}
			} };
			
			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			
			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

	public static Boolean isConnectionHttps(String urlString) {
		if (urlString.regionMatches(0, "https", 0, 5)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para capturar screenshot
	 * 
	 * @param fileName
	 *            - Nome do arquivo
	 */
	/*public static void takeScreenshot(Boolean isError) {
		File scrFile = ((TakesScreenshot) CoreDriver.getDriver())
				.getScreenshotAs(OutputType.FILE);
		int nexID = 001;
		NumberFormat formatter = new DecimalFormat("000");
		nexID = Integer.parseInt(ConstantesTest.CONTADOR_SCREENSHOT);
		String folderDate = aFormat.format(Calendar.getInstance().getTime());
		String fileDate = hFormat.format(Calendar.getInstance().getTime());
		String evidencia = ConstantesTest.METHOD_NAME_TEST.concat("_") + fileDate + "_"+ formatter.format(nexID);
		if (isError) {
			evidencia = evidencia + "_ERRO";
		}
		try {
			String pastaImages = "Evidencias/"+ folderDate.concat("/").concat("/")
					.concat(ConstantesTest.METHOD_NAME_TEST).concat("/").concat(evidencia) + ".jpg";
					
			String pastaResultado = "resultadoTest/" + pastaImages;
					
			File fileDestino = new File(pastaResultado);
			FileUtils.copyFile(scrFile,fileDestino,true);
			nexID++;
			
			ConstantesTest.CONTADOR_SCREENSHOT = (formatter.format(nexID));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			fail("Erro ao tirar Screenshot");
		}
	}*/
	
	public static String formataDataHoraBancoddMMyyyy00_00_00(String dataBanco){
		
		String str = dataBanco;
		str = dataBanco.substring(0, dataBanco.length()-11);
		String data = str.replaceAll("-", "/");
		String[] s = data.split("/");
		String novaData = s[2]+"/"+s[1]+"/"+s[0];
		return novaData+dataBanco.substring(10, dataBanco.length()-2);
	}
	
	public static Date getData(){
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime();
	}
	
	public static String getDataAtual() {
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
			Calendar calendar = new GregorianCalendar();
			Date data = new Date();
			calendar.setTime(data);
			return formatDate.format(data);
		} catch (Exception e) {
			return null;
		}
	}
	
		public static void downloadPdfBrowser(String url,
            String diretorioParaSalvar) throws Exception {

        InputStream ins = null;
        OutputStream oos = null;
        Boolean isHttps = false;
        try {
            if (isConnectionHttps(url)) {
                isHttps = true;
            } else {
                isHttps = false;
            }
            URL myurl = new URL(url);

            disableSslVerification();
            if (isHttps) {
                HttpsURLConnection con;
                con = (HttpsURLConnection) myurl.openConnection();
                con.setRequestProperty("Cookie",StringUtils.join(CoreDriver.getDriver().manage().getCookies(), ";"));
                ins = con.getInputStream();
            } else {
                HttpURLConnection con;
                con = (HttpURLConnection) myurl.openConnection();
                con.setRequestProperty("Cookie",StringUtils.join(CoreDriver.getDriver().manage().getCookies(), ";"));
                ins = con.getInputStream();
            }

            int c = 0;
            // Checar se o diret�ios existem. Se n�o existirem, criar.
            File arquivo = new File(diretorioParaSalvar);
            String strDiretorio = arquivo.getAbsolutePath();
            int indexOf = strDiretorio.lastIndexOf('\\');
            if(indexOf == -1){
            	indexOf = strDiretorio.lastIndexOf('/');// Considerando SO linux. 
            }
            strDiretorio = strDiretorio.substring(0,indexOf);
            File fileDiretorio = new File(strDiretorio);
            if(!fileDiretorio.exists()){
            	fileDiretorio.mkdirs();  
            }
            oos = new FileOutputStream(diretorioParaSalvar);
            byte[] buf = new byte[8192];
            while ((c = ins.read(buf, 0, buf.length)) > 0) {
                oos.write(buf, 0, c);
                oos.flush();
            }
        } catch (IOException e) {
            throw new Exception(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static String diretorioEvidenciaPDF(String filename) {
		String scrFile = null;
		String folderDate = aFormat.format(Calendar.getInstance().getTime());
		String fileDate = hFormat.format(Calendar.getInstance().getTime());
		scrFile = "resultadoTest/Evidencias/"+ folderDate.concat("/")
				.concat("/").concat(ConstantesTest.METHOD_NAME_TEST).concat("/").concat(ConstantesTest.METHOD_NAME_TEST + "_" + fileDate+ ".pdf");
		return scrFile;
	}
}
